package org.jpstale.server.common.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;
import org.jpstale.server.common.enums.packets.PacketHeader;
import org.jpstale.server.common.struct.packets.Packet;
import org.jpstale.server.common.struct.packets.PacketVersion;
import org.jpstale.server.common.struct.socket.PacketKeySet;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 通用加解密 Handler：
 * - 每个 Channel 一份 {@link PtCryptoState}，通过 Attribute 挂载；
 * - 入站（已过 PtFrameDecoder XOR 解码）：
 *   - 截获 KeySet 包（PKTHDR_KeySet），调用 PtCryptoState.receiveKeySet 并吞掉；
 *   - 若包体被标记为加密且已握手，则按 C++ DecryptPacket 还原明文；
 * - 出站（在 PtFrameEncoder 之前）：
 *   - 对除 KeySet 之外的包调用 C++ EncryptPacket 进行原地加密。
 */
@Slf4j
@ChannelHandler.Sharable
public class PtCryptoHandler extends ChannelDuplexHandler {

    public static final AttributeKey<PtCryptoState> STATE_KEY =
            AttributeKey.valueOf("ptCryptoState");

    /** 对应 C++ 的 SERVER_PORT，决定 SendKeySet / ReceiveKeySet 时的 obfuscator 字节。 */
    private final byte obfuscatorByte;

    public PtCryptoHandler(int serverPort) {
        this.obfuscatorByte = (byte) serverPort;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        PtCryptoState state = new PtCryptoState();
        ctx.channel().attr(STATE_KEY).set(state);

        //Send the Byte Encryption Set
        sendKeySet(ctx, state);

        // Send Version
        PacketVersion packetVersion = new PacketVersion();
        packetVersion.setEncKeyIndex((byte) 0);
        packetVersion.setEncrypted((byte) 0);
        packetVersion.setPktHeader(PacketHeader.PKTHDR_Version);
        packetVersion.setServerFull(false);
        packetVersion.setUnk2(0);
        packetVersion.setVersion(GameXor.GAME_VERSION);

        byte[] data = packetVersion.toWireBytes();
        ByteBuf out = ctx.alloc().buffer(data.length).writeBytes(data);
        ctx.writeAndFlush(out);

        ctx.fireChannelActive();
    }

    private void sendKeySet(ChannelHandlerContext ctx, PtCryptoState state) {

        // 1) 生成本端 keySet
        byte[] rawKeySet = state.generateKeySet();

        // C++: RandomI(0, 256) / RandomI(2, 256)
        byte encKeyIndex = (byte) (Math.random() * 256);
        byte encrypted   = (byte) (2 + (int)(Math.random() * 254));

        // 2) 组一个 KeySet 包（未 XOR，未 EncryptPacket）
        PacketKeySet packetKeySet = new PacketKeySet();
        packetKeySet.setEncKeyIndex(encKeyIndex);
        packetKeySet.setEncrypted(encrypted);
        packetKeySet.setPktHeader(PacketHeader.PKTHDR_KeySet);
        packetKeySet.setKeySet(rawKeySet);

        byte[] data = packetKeySet.toWireBytes();

        state.encodeKeySetForWire(data, obfuscatorByte);

        ByteBuf out = ctx.alloc().buffer(data.length).writeBytes(data);
        ctx.writeAndFlush(out);

        log.debug("Sent PacketKeySet to {}, keySetReady={}",
                ctx.channel().remoteAddress(), state.isKeySetReady());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if (!(msg instanceof ByteBuf buf)) {
            ctx.fireChannelRead(msg);
            return;
        }

        int readable = buf.readableBytes();
        if (readable < 8) {
            ctx.fireChannelRead(msg);
            return;
        }

        PtCryptoState state = ctx.channel().attr(STATE_KEY).get();
        if (state == null) {
            log.info("No KeySet found");
            ctx.fireChannelRead(msg);
            return;
        }

        int readerIndex = buf.readerIndex();
        byte[] data = new byte[readable];
        buf.getBytes(readerIndex, data);

        ByteBuffer headerBuf = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        short length = headerBuf.getShort(0);
        if (length < 8 || length > readable) {
            ctx.fireChannelRead(msg);
            return;
        }

        byte encrypted = data[3];
        int  header    = headerBuf.getInt(4);

        // 若对端也向本端发送 KeySet，则在此支持 ReceiveKeySet
        if (header == PacketHeader.PKTHDR_KeySet.getValue()) {
            byte obfForReceive;// 获取远端地址
            try {
                InetSocketAddress remote = (java.net.InetSocketAddress) ctx.channel().remoteAddress();
                int remotePort = remote.getPort();
                obfForReceive = (byte) remotePort; // 对应 C++ 客户端里的 (BYTE)iPort
            } catch (ClassCastException e) {
                obfForReceive = obfuscatorByte;
            }
            state.receiveKeySet(data, obfForReceive);
            log.debug("Received PacketKeySet from {}, keySetReady={}",
                      ctx.channel().remoteAddress(), state.isKeySetReady());
            buf.release();
            return;
        }

        // 普通入站包：如被标记为加密且已握手，则按 C++ 逻辑解密正文
        if (encrypted != 0) {
            if (state.isKeySetReady()) {
                state.decryptPacket(data);
                buf.setBytes(readerIndex, data);
            } else {
                log.warn("Received encrypted packet but keySet not ready, closing channel");
                buf.release();
                ctx.close();
                return;
            }
        }

        ctx.fireChannelRead(msg);
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (!(msg instanceof ByteBuf buf)) {
            super.write(ctx, msg, promise);
            return;
        }

        int readable = buf.readableBytes();
        if (readable < Packet.SIZE_OF) {
            log.info("packet size too small");
            super.write(ctx, msg, promise);
            return;
        }

        PtCryptoState state = ctx.channel().attr(STATE_KEY).get();
        if (state == null || !state.isKeySetReady()) {
            log.info("key set is not ready");
            super.write(ctx, msg, promise);
            return;
        }

        int readerIndex = buf.readerIndex();
        byte[] data = new byte[readable];
        buf.getBytes(readerIndex, data);

        ByteBuffer headerBuf = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        short length = headerBuf.getShort(0);
        if (length < 8 || length > readable) {
            log.warn("illegal length: {}", length);
            super.write(ctx, msg, promise);
            return;
        }

        int header = headerBuf.getInt(4);
        PacketHeader packetHeader = PacketHeader.fromValue(header);
        switch (packetHeader) {
            case PKTHDR_KeySet:
            case PKTHDR_Version:
            case PKTHDR_UserInfo:
            case PKTHDR_ServerList:
            case PKTHDR_AccountLoginCode:
                // 登录阶段响应包不加密，便于客户端直接解析并显示（含密码错误等提示）
                log.info("ignore encrypt packet: {}", header);
                super.write(ctx, msg, promise);
                return;
        }

        // 对非上述包做 C++ EncryptPacket 原地加密
        state.encryptPacket(data);
        buf.setBytes(readerIndex, data);

        super.write(ctx, msg, promise);
    }
}

