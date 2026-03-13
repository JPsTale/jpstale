package org.jpstale.server.login.service;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.struct.socket.PacketPing;

/**
 * 登录服心跳处理接口。
 *
 * 对应 C++:
 * - Server/server/packetserver.cpp 中 case PKTHDR_Ping 分支。
 */
public interface PingServer {

    /**
     * 对应 C++ 中 PKTHDR_Ping 的处理。
     */
    void handlePing(ChannelHandlerContext ctx, PacketPing packet);
}

