package org.jpstale.server.login.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.jpstale.server.common.codec.GameXor;
import org.jpstale.server.common.codec.PtCodec;
import org.jpstale.server.common.packet.Packet;

import java.util.List;

/**
 * Decodes PT wire format: first 2 bytes (XOR'd) = length, then read (length-2) bytes and XOR from index 2 to end.
 * Outputs one ByteBuf per packet (length bytes, already XOR-decoded).
 */
public class PtFrameDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        if (in.readableBytes() < 2) return;

        int start = in.readerIndex();
        byte[] lenBuf = new byte[2];
        in.getBytes(start, lenBuf);
        PtCodec.xorDecode(lenBuf, 2, GameXor.XOR_KEY);
        short length = PtCodec.readLength(lenBuf);

        if (length < Packet.SIZE_OF || length > PtCodec.MAX_PACKET_SIZE) {
            ctx.close();
            return;
        }
        if (in.readableBytes() < length) return;

        byte[] packet = new byte[length];
        in.readBytes(packet);
        PtCodec.xorDecode(packet, length, GameXor.XOR_KEY);
        out.add(ctx.alloc().buffer(length).writeBytes(packet));
    }
}
