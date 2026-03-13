package org.jpstale.server.login.core;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.codec.PacketSender;
import org.jpstale.server.common.struct.socket.PacketPing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Java 版 PingServer。
 *
 * 主要逻辑来源：
 * - Server/server/packetserver.cpp 中 case PKTHDR_Ping 分支。
 */
@Component
public class PingServer {

    private static final Logger log = LoggerFactory.getLogger(PingServer.class);

    /**
     * 对应 C++:
     * case PKTHDR_Ping:
     *   ((PacketPing*)psPacket)->dwTick = GetTickCount();
     *   SENDPACKET(pcUser, psPacket, TRUE);
     *   // 以及后续部分的 CheatEngine 检测与日志逻辑。
     */
    public void handlePing(ChannelHandlerContext ctx, PacketPing packet) {
        // TODO: dwTime/dwTick 字段应与 C++ 一致，此处先简单更新 tick 并回包。
        packet.setTick((int) System.currentTimeMillis());

        if (log.isTraceEnabled()) {
            log.trace("handlePing {}", packet);
        }

        PacketSender.sendPacket(ctx, packet);

        // TODO: 对齐 C++ 中的 CheatEngineDetected 检测 + 日志 / 封禁逻辑。
    }
}

