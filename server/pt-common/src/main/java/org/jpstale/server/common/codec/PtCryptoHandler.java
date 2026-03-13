package org.jpstale.server.common.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.util.AttributeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 通用加解密 Handler：
 *
 * - 每个 Channel 一份 {@link PtCryptoState}，通过 Attribute 挂载；
 * - 入站（已过 PtFrameDecoder XOR 解码）：
 *   - 截获 KeySet 包（PKTHDR_KeySet），调用 PtCryptoState.receiveKeySet 并吞掉；
 *   - 若包体被标记为加密且已握手，则按 C++ DecryptPacket 还原明文；
 * - 出站（在 PtFrameEncoder 之前）：
 *   - 对除 KeySet 之外的包调用 C++ EncryptPacket 进行原地加密。
 */
@ChannelHandler.Sharable
public class PtCryptoHandler extends ChannelDuplexHandler {

    private static final Logger log = LoggerFactory.getLogger(PtCryptoHandler.class);

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

        // 1) 生成本端 keySet
        byte[] rawKeySet = state.generateKeySet();

        // 2) 组一个 KeySet 包（未 XOR，未 EncryptPacket）
        final int HEADER_SIZE = 8;
        final int BODY_SIZE   = 256;
        short length = (short) (HEADER_SIZE + BODY_SIZE);

        // C++: RandomI(0, 256) / RandomI(2, 256)
        byte encKeyIndex = (byte) (Math.random() * 256);
        byte encrypted   = (byte) (2 + (int)(Math.random() * 254));

        byte[] pkt = new byte[length];
        ByteBuffer buf = ByteBuffer.wrap(pkt).order(ByteOrder.LITTLE_ENDIAN);
        buf.putShort(0, length);
        pkt[2] = encKeyIndex;
        pkt[3] = encrypted;
        buf.putInt(4, PacketIds.PKTHDR_KeySet);

        System.arraycopy(rawKeySet, 0, pkt, HEADER_SIZE, BODY_SIZE);
        state.encodeKeySetForWire(pkt, obfuscatorByte);

        ByteBuf out = ctx.alloc().buffer(length).writeBytes(pkt);
        ctx.writeAndFlush(out);

        log.debug("Sent PacketKeySet to {}, keySetReady={}",
                  ctx.channel().remoteAddress(), state.isKeySetReady());

        ctx.fireChannelActive();
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
        if (header == PacketIds.PKTHDR_KeySet) {
            state.receiveKeySet(data, obfuscatorByte);
            log.debug("Received PacketKeySet from {}, keySetReady={}",
                      ctx.channel().remoteAddress(), state.isKeySetReady());
            buf.release();
            return;
        }

        // 普通入站包：如被标记为加密且已握手，则按 C++ 逻辑解密正文
        if (encrypted != 0 && state.isKeySetReady()) {
            state.decryptPacket(data);
            buf.setBytes(readerIndex, data);
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
        if (readable < 8) {
            super.write(ctx, msg, promise);
            return;
        }

        PtCryptoState state = ctx.channel().attr(STATE_KEY).get();
        if (state == null || !state.isKeySetReady()) {
            super.write(ctx, msg, promise);
            return;
        }

        int readerIndex = buf.readerIndex();
        byte[] data = new byte[readable];
        buf.getBytes(readerIndex, data);

        ByteBuffer headerBuf = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        short length = headerBuf.getShort(0);
        if (length < 8 || length > readable) {
            super.write(ctx, msg, promise);
            return;
        }

        int header = headerBuf.getInt(4);
        if (header == PacketIds.PKTHDR_KeySet) {
            // KeySet 包本身不再额外 EncryptPacket
            super.write(ctx, msg, promise);
            return;
        }

        // 对非 KeySet 包做 C++ EncryptPacket 原地加密
        state.encryptPacket(data);
        buf.setBytes(readerIndex, data);

        super.write(ctx, msg, promise);
    }
}

