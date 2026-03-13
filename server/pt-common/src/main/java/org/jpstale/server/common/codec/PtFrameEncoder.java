package org.jpstale.server.common.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * 出站 XOR 编码：与 {@link PtFrameDecoder} 解码对称。
 * 期望 msg 为“未 XOR”的完整 Packet ByteBuf。
 */
public class PtFrameEncoder extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (!(msg instanceof ByteBuf buf)) {
            super.write(ctx, msg, promise);
            return;
        }

        int readable = buf.readableBytes();
        if (readable < 2) {
            super.write(ctx, msg, promise);
            return;
        }

        int readerIndex = buf.readerIndex();
        byte[] data = new byte[readable];
        buf.getBytes(readerIndex, data);

        PtCodec.xorEncode(data, readable, GameXor.XOR_KEY);
        buf.setBytes(readerIndex, data);

        super.write(ctx, msg, promise);
    }
}

