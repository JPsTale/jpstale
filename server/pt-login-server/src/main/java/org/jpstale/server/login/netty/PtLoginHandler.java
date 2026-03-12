package org.jpstale.server.login.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import jakarta.annotation.Resource;
import org.jpstale.server.common.protocol.GameXor;
import org.jpstale.server.common.protocol.PacketIds;
import org.jpstale.server.common.protocol.PtCodec;
import org.jpstale.server.common.protocol.struct.Packet;
import org.jpstale.server.common.protocol.account.PacketAccountLoginCode;
import org.jpstale.server.common.protocol.struct.PacketLoginUser;
import org.jpstale.server.common.protocol.struct.PacketVersion;
import org.jpstale.server.login.api.CharacterServiceApi;
import org.jpstale.server.login.api.LoginSuccessServiceApi;
import org.jpstale.server.login.service.AccountLoginServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Login 服入站包处理：Version、LoginUser、SelectCharacter、DeleteCharacter、Ping 等。
 * 登录成功时发送 UserInfo + ServerList；失败时发送 AccountLoginCode。
 */
@Component
public class PtLoginHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private static final Logger log = LoggerFactory.getLogger(PtLoginHandler.class);

    @Resource
    private AccountLoginServiceApi accountLoginService;
    @Resource
    private LoginSuccessServiceApi loginSuccessService;
    @Resource
    private CharacterServiceApi characterService;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.debug("Client connected: {}", ctx.channel().remoteAddress());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.debug("Client disconnected: {}", ctx.channel().remoteAddress());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {
        int readable = msg.readableBytes();
        if (readable < Packet.SIZE_OF) {
            log.warn("Packet too short: {} bytes", readable);
            return;
        }

        byte[] arr = new byte[readable];
        msg.readBytes(arr);
        ByteBuffer buf = ByteBuffer.wrap(arr).order(ByteOrder.LITTLE_ENDIAN);
        int pktHeader = buf.getInt(4); // skip length(2)+encKeyIndex(1)+encrypted(1)

        if (pktHeader == PacketIds.PKTHDR_Version) {
            handleVersion(ctx, buf);
            return;
        }
        if (pktHeader == PacketIds.PKTHDR_LoginUser) {
            handleLoginUser(ctx, buf);
            return;
        }
        log.debug("Unhandled packet header: 0x{}", Integer.toHexString(pktHeader));
    }

    private void handleVersion(ChannelHandlerContext ctx, ByteBuffer buf) {
        PacketVersion req = new PacketVersion();
        req.readFrom(buf);
        log.debug("Version from client: {}", req.getVersion());

        PacketVersion resp = new PacketVersion();
        resp.setPktHeader(PacketIds.PKTHDR_Version);
        resp.setServerFull(false);
        resp.setVersion(GameXor.GAME_VERSION);
        resp.setUnk2(0);
        sendPacket(ctx, resp);
    }

    private void handleLoginUser(ChannelHandlerContext ctx, ByteBuffer buf) {
        PacketLoginUser login = new PacketLoginUser();
        login.readFrom(buf);

        int code = accountLoginService.authenticate(
            login.getUserId(),
            login.getPassword(),
            login.getVersion()
        );

        PacketAccountLoginCode p = new PacketAccountLoginCode();
        p.setPktHeader(PacketIds.PKTHDR_AccountLoginCode);
        p.setCode(code);
        p.setFailCode(code < 0 ? 1 : 0);
        p.setReserved(0);
        p.setMessage(code == 1 ? "OK" : (code == -17 ? "Wrong version" : "Login failed"));
        sendPacket(ctx, p);
    }

    /**
     * 序列化包并 XOR 编码后写出（与 PtFrameDecoder 解码对称）.
     */
    private void sendPacket(ChannelHandlerContext ctx, Packet p) {
        byte[] encoded = p.toWireBytes();
        PtCodec.xorEncode(encoded, encoded.length, GameXor.XOR_KEY);
        ByteBuf out = ctx.alloc().buffer(encoded.length).writeBytes(encoded);
        ctx.writeAndFlush(out);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.warn("Channel error: {}", cause.getMessage());
        ctx.close();
    }
}
