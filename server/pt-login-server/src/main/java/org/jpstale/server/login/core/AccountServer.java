package org.jpstale.server.login.core;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.codec.PacketIds;
import org.jpstale.server.common.codec.PacketSender;
import org.jpstale.server.common.enums.account.AccountLogin;
import org.jpstale.server.common.struct.account.PacketAccountLoginCode;
import org.jpstale.server.common.struct.packets.PacketLoginUser;
import org.jpstale.server.common.struct.packets.PacketServerList;
import org.jpstale.server.common.struct.packets.PacketUserInfo;
import org.jpstale.server.common.struct.packets.Header;
import org.jpstale.server.common.struct.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Java 版 AccountServer。
 *
 * 主要逻辑对应 C++：
 * - Server/server/accountserver.cpp
 * - Server/server/packetserver.cpp 中 PKTHDR_LoginUser / PKTHDR_SaveData 相关分支
 *
 * 当前阶段仅做最小硬编码实现以跑通网络协议：
 * - 不接数据库，账号/密码写死为 admin / 123456
 * - 登录成功后发送 AccountLoginCode + UserInfo(0 角色) + ServerList(1 条本地服务器)
 */
@Component
public class AccountServer {

    private static final Logger log = LoggerFactory.getLogger(AccountServer.class);

    /**
     * 对应 C++:
     * - ACCOUNTSERVER->PHAccountLogin(User* pcUser, PacketLoginUser* p)
     * - 由 PacketServer::AnalyzePacket 中 PKTHDR_LoginUser 分支调用。
     */
    public int processAccountLogin(ChannelHandlerContext ctx, PacketLoginUser login) {
        String userId = login.getUserId();
        String password = login.getPassword();

        // TODO: 版本校验应与 GameXor.GAME_VERSION 对齐，目前先简单通过。

        AccountLogin code;
        if ("admin".equalsIgnoreCase(userId) && "123456".equals(password)) {
            code = AccountLogin.SUCCESS;
        } else {
            code = AccountLogin.INCORRECT_PASSWORD;
        }

        if (code == AccountLogin.SUCCESS) {
            int ticket = 123; // TODO: 对齐 C++ 中 Set Random Ticket Number 的逻辑
            sendAccountLoginCode(ctx, code, "OK");
            sendUserInfo(ctx, userId);
            sendServerList(ctx, ticket);
        } else {
            sendAccountLoginCode(ctx, code, "Login failed");
        }

        if (log.isTraceEnabled()) {
            log.trace("processAccountLogin result code={} for user={}", code, userId);
        }

        return code.getValue();
    }

    /**
     * 对应 C++ 中构造 PacketAccountLoginCode 并发送的逻辑：
     * - accountserver.cpp 中多处 PKTHDR_AccountLoginCode 构造
     * - packetserver.cpp 中 LoginUser/版本不匹配时的返回。
     *
     * 这里使用 pt-common 中的 PacketAccountLoginCode 与 AccountLogin 枚举。
     */
    public void sendAccountLoginCode(ChannelHandlerContext ctx, AccountLogin code, String message) {
        PacketAccountLoginCode packet = new PacketAccountLoginCode();
        packet.setPktHeader(PacketIds.PKTHDR_AccountLoginCode);
        packet.setReserved(0);
        packet.setCode(code);
        packet.setFailCode(code.getValue() < 0 ? 1 : 0);
        packet.setMessage(message != null ? message : "");

        if (log.isTraceEnabled()) {
            log.trace("sendAccountLoginCode {}", packet);
        }

        PacketSender.sendPacket(ctx, packet);
    }

    /**
     * 对应 C++: PHUserInfo(UserData* pcUserData).
     * - 负责根据账号名构造 PacketUserInfo，内含角色列表。
     * - 当前阶段硬编码为 0 角色，仅保证协议兼容。
     */
    public void sendUserInfo(ChannelHandlerContext ctx, String accountName) {
        PacketUserInfo packet = new PacketUserInfo();
        packet.setPktHeader(PacketIds.PKTHDR_UserInfo);
        packet.setUserId(accountName != null ? accountName : "");
        packet.setCharCount(0);
        // TODO: 若后续对齐 C++ 中 TransCharInfo 结构，这里需要填充角色信息数组。

        PacketSender.sendPacket(ctx, packet);
    }

    /**
     * 对应 C++: PHServerList(SocketData* pcSocketData, int iTicket).
     * - 发送服务器列表给客户端。
     * - 当前阶段仅硬编码 1 条本地 GameServer 信息。
     */
    public void sendServerList(ChannelHandlerContext ctx, int ticket) {
        PacketServerList packet = new PacketServerList();
        packet.setPktHeader(PacketIds.PKTHDR_ServerList);

        Header header = new Header();
        header.setServerName("Local");
        header.setTime((int) (System.currentTimeMillis() / 1000L));
        header.setTicket(ticket);
        header.setUnknown(0);
        header.setClanServerIndex(0);
        header.setGameServers(1);
        packet.setHeader(header);

        Server[] servers = new Server[4];
        for (int i = 0; i < servers.length; i++) {
            servers[i] = new Server();
        }
        Server s0 = servers[0];
        s0.setName("Game1");
        // TODO: IP 和端口应从配置或数据库加载，此处先硬编码本地测试环境。
        s0.getIp()[0] = "127.0.0.1";
        s0.getPort()[0] = 8485;
        s0.getPort()[1] = 8485;
        s0.getPort()[2] = 8485;
        s0.getPort()[3] = 0;

        packet.setServers(servers);

        PacketSender.sendPacket(ctx, packet);
    }
}

