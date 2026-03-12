package org.jpstale.server.login.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.jpstale.server.common.protocol.GameXor;
import org.jpstale.server.common.protocol.PacketIds;
import org.jpstale.server.common.protocol.PtCodec;
import org.jpstale.server.common.protocol.struct.Packet;
import org.jpstale.server.common.protocol.account.PacketAccountLoginCode;
import org.jpstale.server.common.protocol.struct.PacketLoginUser;
import org.jpstale.server.login.service.AccountLoginServiceApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Handles decoded PT packets; dispatches PKTHDR_LoginUser to account login and sends PKTHDR_AccountLoginCode.
 */
public class PtLoginHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private static final Logger log = LoggerFactory.getLogger(PtLoginHandler.class);

    private final AccountLoginServiceApi accountLoginService;

    public PtLoginHandler(AccountLoginServiceApi accountLoginService) {
        this.accountLoginService = accountLoginService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {
        int readable = msg.readableBytes();
        if (readable < Packet.SIZE_OF) {
            return;
        }

        byte[] arr = new byte[readable];
        msg.readBytes(arr);
        int header = ByteBuffer.wrap(arr, 4, 4).order(ByteOrder.LITTLE_ENDIAN).getInt();

        if (header == PacketIds.PKTHDR_LoginUser) {
            ByteBuffer buf = ByteBuffer.wrap(arr).order(ByteOrder.LITTLE_ENDIAN);
            PacketLoginUser login = new PacketLoginUser();
            login.readFrom(buf);
            int code = accountLoginService.authenticate(login.getUserId(), login.getPassword(), login.getVersion());
            sendLoginCode(ctx, code);
        } else {
            log.debug("Unhandled packet header: 0x{}", Integer.toHexString(header));
        }
    }

    private void sendLoginCode(ChannelHandlerContext ctx, int code) {
        PacketAccountLoginCode p = new PacketAccountLoginCode();
        p.setPktHeader(PacketIds.PKTHDR_AccountLoginCode);
        p.setCode(code);
        p.setFailCode(1);
        p.setReserved(0);
        p.setMessage("");

        byte[] encoded = p.toWireBytes();
        PtCodec.xorEncode(encoded, encoded.length, GameXor.XOR_KEY);
        ctx.writeAndFlush(ctx.alloc().buffer(encoded.length).writeBytes(encoded));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.warn("Channel error", cause);
        ctx.close();
    }
}
