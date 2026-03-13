package org.jpstale.server.login.service;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.enums.account.AccountLogin;
import org.jpstale.server.common.struct.packets.PacketLoginUser;

/**
 * 登录服账号相关接口。
 *
 * 对应 C++：
 * - Server/server/accountserver.cpp
 * - Server/server/packetserver.cpp 中 PKTHDR_LoginUser / PKTHDR_SaveData 相关分支。
 */
public interface AccountServer {

    /**
     * 对应 C++:
     * - ACCOUNTSERVER->PHAccountLogin(User* pcUser, PacketLoginUser* p)
     */
    int processAccountLogin(ChannelHandlerContext ctx, PacketLoginUser login);

    /**
     * 对应 C++ 中构造 PacketAccountLoginCode 并发送的逻辑。
     */
    void sendAccountLoginCode(ChannelHandlerContext ctx, AccountLogin code, String message);

    /**
     * 对应 C++: PHUserInfo(UserData* pcUserData).
     */
    void sendUserInfo(ChannelHandlerContext ctx, String accountName);

    /**
     * 对应 C++: PHServerList(SocketData* pcSocketData, int iTicket).
     */
    void sendServerList(ChannelHandlerContext ctx, int ticket);
}

