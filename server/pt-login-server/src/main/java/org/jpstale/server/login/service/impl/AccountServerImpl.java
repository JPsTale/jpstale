package org.jpstale.server.login.service.impl;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.codec.PacketIds;
import org.jpstale.server.common.codec.PacketSender;
import org.jpstale.server.common.enums.account.AccountLogin;
import org.jpstale.server.common.struct.Server;
import org.jpstale.server.common.struct.account.PacketAccountLoginCode;
import org.jpstale.server.common.struct.packets.Header;
import org.jpstale.server.common.struct.packets.PacketLoginUser;
import org.jpstale.server.common.struct.packets.PacketServerList;
import org.jpstale.server.common.struct.packets.PacketUserInfo;
import org.jpstale.server.login.service.AccountServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * AccountServer 默认实现。
 *
 * 直接移植自原 core 包下的 AccountServer 类，后续可按 C++ accountserver.cpp 逐步替换硬编码逻辑。
 */
@Service
public class AccountServerImpl implements AccountServer {

    private static final Logger log = LoggerFactory.getLogger(AccountServerImpl.class);

    @Override
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

    @Override
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

    @Override
    public void sendUserInfo(ChannelHandlerContext ctx, String accountName) {
        PacketUserInfo packet = new PacketUserInfo();
        packet.setPktHeader(PacketIds.PKTHDR_UserInfo);
        packet.setUserId(accountName != null ? accountName : "");
        packet.setCharCount(0);
        // TODO: 若后续对齐 C++ 中 TransCharInfo 结构，这里需要填充角色信息数组。

        PacketSender.sendPacket(ctx, packet);
    }

    @Override
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

