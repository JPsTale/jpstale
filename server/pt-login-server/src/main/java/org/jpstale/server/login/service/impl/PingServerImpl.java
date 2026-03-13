package org.jpstale.server.login.service.impl;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.codec.PacketSender;
import org.jpstale.server.common.struct.socket.PacketPing;
import org.jpstale.server.login.service.PingServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * PingServer 默认实现。
 *
 * 对齐 C++ packetserver.cpp 中 PKTHDR_Ping 分支。
 */
@Service
public class PingServerImpl implements PingServer {

    private static final Logger log = LoggerFactory.getLogger(PingServerImpl.class);

    @Override
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

