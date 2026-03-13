package org.jpstale.server.login.service;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.struct.packets.PacketVersion;

/**
 * 登录服日志接口（只涵盖当前需要的部分）。
 *
 * 对应 C++：
 * - Server/server/logserver.cpp
 * - Server/server/packetserver.cpp 中 PKTHDR_LogCheat 分支。
 */
public interface LogServer {

    void onLogEx(ChannelHandlerContext ctx, Object user, PacketVersion packet);
    void onLogCheat(Object userSession, Object packet);
}

