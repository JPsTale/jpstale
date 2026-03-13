package org.jpstale.server.common.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.jpstale.server.common.struct.packets.Packet;

import java.util.List;

/**
 * 解码 PT 线协议：前 2 字节（经 XOR）为长度，之后读取 (length-2) 字节并整体做 XOR。
 * 输出的 ByteBuf 已完成 XOR 解码，内容为完整 Packet（length 字节）。
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

