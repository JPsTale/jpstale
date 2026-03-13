package org.jpstale.server.login.service.impl;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.login.service.CheatServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * CheatServer 默认实现。
 *
 * 直接移植自原 core.CheatServer，占位实现，方便后续按 C++ cheatserver.cpp 迁移。
 */
@Service
public class CheatServerImpl implements CheatServer {

    private static final Logger log = LoggerFactory.getLogger(CheatServerImpl.class);

    @Override
    public void handleClientError(ChannelHandlerContext ctx, Object packet) {
        // TODO: 使用具体的 PacketTransCommand 结构体。
        log.trace("handleClientError (TODO) packet={}", packet);
    }

    @Override
    public void handleCrash(ChannelHandlerContext ctx, Object packet) {
        // TODO: 使用具体的 PacketCrash 结构体。
        log.trace("handleCrash (TODO) packet={}", packet);
    }

    @Override
    public void handleCrashData(ChannelHandlerContext ctx, Object packet) {
        // TODO: 使用具体的 PacketCrashData 结构体。
        log.trace("handleCrashData (TODO) packet={}", packet);
    }

    @Override
    public void onLoginUserPacket(Object userSession) {
        // TODO: 使用具体的 UserSession / UserData 类型。
        log.trace("onLoginUserPacket (TODO) userSession={}", userSession);
    }
}

