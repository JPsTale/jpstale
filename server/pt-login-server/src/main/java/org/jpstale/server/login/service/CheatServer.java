package org.jpstale.server.login.service;

import io.netty.channel.ChannelHandlerContext;

/**
 * 登录服作弊相关接口。
 *
 * 对应 C++：
 * - Server/server/cheatserver.cpp
 * - Server/server/packetserver.cpp 中 PKTHDR_Client_Error / PKTHDR_Crash / PKTHDR_CrashData 等。
 */
public interface CheatServer {

    void handleClientError(ChannelHandlerContext ctx, Object packet);

    void handleCrash(ChannelHandlerContext ctx, Object packet);

    void handleCrashData(ChannelHandlerContext ctx, Object packet);

    void onLoginUserPacket(Object userSession);
}

