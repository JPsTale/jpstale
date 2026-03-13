package org.jpstale.server.common.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.struct.packets.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 公共发包工具。
 *
 * 对齐 C++ 侧的 PACKETSERVER->Send / SENDPACKET 宏：
 * - C++ 实现位置：Server/server/packetserver.cpp - PacketServer::Send.
 * - 在 Java 侧统一封装 writeAndFlush，方便在一处加日志和调试。
 */
public final class PacketSender {

    private static final Logger log = LoggerFactory.getLogger(PacketSender.class);

    private PacketSender() {
    }

    /**
     * 发送封装好的 Packet 到当前连接。
     */
    public static void sendPacket(ChannelHandlerContext ctx, Packet packet) {
        if (log.isTraceEnabled()) {
            log.trace("send {} to {}", packet, ctx.channel().remoteAddress());
        }

        byte[] plain = packet.toWireBytes();
        ByteBuf out = ctx.alloc().buffer(plain.length).writeBytes(plain);
        ctx.writeAndFlush(out);
    }
}

