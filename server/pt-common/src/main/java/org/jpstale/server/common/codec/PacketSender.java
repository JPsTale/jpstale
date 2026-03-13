package org.jpstale.server.common.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.enums.packets.PacketHeader;
import org.jpstale.server.common.struct.packets.Packet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 公共发包工具。
 *
 * 对齐 C++ 侧的 PACKETSERVER->Send / SENDPACKET 宏：
 * - C++ 实现位置：Server/server/packetserver.cpp - PacketServer::Send.
 * - 在 Java 侧统一封装 writeAndFlush，方便在一处加日志和调试。
 */
public final class PacketSender {

    private static final Logger log = LoggerFactory.getLogger(PacketSender.class);

    /** 登录相关包：与 C++ 对比时可在日志中看前 N 字节的 hex。 */
    private static final int LOGIN_PACKET_HEX_DUMP_BYTES = 96;

    private PacketSender() {
    }

    /**
     * 发送封装好的 Packet 到当前连接。
     */
    public static void sendPacket(ChannelHandlerContext ctx, Packet packet) {
        log.info("send {} to {}", packet, ctx.channel().remoteAddress());

        byte[] plain = packet.toWireBytes();
        dumpLoginPacketHexIfNeeded(plain);
        ByteBuf out = ctx.alloc().buffer(plain.length).writeBytes(plain);
        ctx.writeAndFlush(out);
    }

    /** 对登录相关包输出前若干字节的 hex，便于与 C++ 服务端抓包对比。 */
    private static void dumpLoginPacketHexIfNeeded(byte[] data) {
        if (data == null || data.length < 8 || !log.isDebugEnabled()) return;
        int header = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt(4);
        int h = header;
        if (h != PacketHeader.PKTHDR_AccountLoginCode.getValue()
            && h != PacketHeader.PKTHDR_UserInfo.getValue()
            && h != PacketHeader.PKTHDR_ServerList.getValue()) return;
        int len = Math.min(data.length, LOGIN_PACKET_HEX_DUMP_BYTES);
        StringBuilder sb = new StringBuilder(len * 3);
        for (int i = 0; i < len; i++) {
            if (i > 0) sb.append(' ');
            sb.append(String.format("%02X", data[i] & 0xFF));
        }
        log.debug("login packet 0x{} hex (first {} bytes): {}", Integer.toHexString(h), len, sb);
    }
}

