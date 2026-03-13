package org.jpstale.server.login.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import jakarta.annotation.Resource;
import org.jpstale.server.common.codec.PacketIds;
import org.jpstale.server.common.enums.account.AccountLogin;
import org.jpstale.server.common.struct.account.PacketAccountLoginCode;
import org.jpstale.server.common.struct.packets.Packet;
import org.jpstale.server.common.struct.packets.PacketLoginUser;
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

        if (pktHeader == PacketIds.PKTHDR_LoginUser) {
            handleLoginUser(ctx, buf);
            return;
        }
        log.debug("Unhandled packet header: 0x{}", Integer.toHexString(pktHeader));
    }

    private void handleLoginUser(ChannelHandlerContext ctx, ByteBuffer buf) {
        PacketLoginUser login = new PacketLoginUser();
        login.readFrom(buf);

        AccountLogin code = accountLoginService.authenticate(
            login.getUserId(),
            login.getPassword(),
            login.getVersion()
        );

        PacketAccountLoginCode p = new PacketAccountLoginCode();
        p.setPktHeader(PacketIds.PKTHDR_AccountLoginCode);
        p.setCode(code);
        p.setFailCode(code.getValue() < 0 ? 1 : 0);
        p.setReserved(0);
        p.setMessage(code == AccountLogin.SUCCESS ? "OK" : (code == AccountLogin.WRONG_VERSION ? "Wrong version" : "Login failed"));
        sendPacket(ctx, p);
    }

    private void sendPacket(ChannelHandlerContext ctx, Packet p) {
        byte[] plainData = p.toWireBytes();
        ByteBuf out = ctx.alloc().buffer(plainData.length).writeBytes(plainData);
        ctx.writeAndFlush(out);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.warn("Channel error: {}", cause.getMessage());
        ctx.close();
    }
}
