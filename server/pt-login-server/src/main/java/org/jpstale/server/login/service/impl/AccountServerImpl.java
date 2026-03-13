package org.jpstale.server.login.service.impl;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.server.common.enums.packets.PacketHeader;
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

import java.util.concurrent.ThreadLocalRandom;

/**
 * AccountServer 默认实现。
 *
 * 直接移植自原 core 包下的 AccountServer 类，后续可按 C++ accountserver.cpp 逐步替换硬编码逻辑。
 */
@Service
public class AccountServerImpl implements AccountServer {

    private static final Logger log = LoggerFactory.getLogger(AccountServerImpl.class);

    /** 与 C++ accountserver.cpp 一致：登录成功后生成 [1, 1000] 的随机 ticket，供选服/进游戏校验。 */
    private static int generateLoginTicket() {
        return ThreadLocalRandom.current().nextInt(1, 1001);
    }

    @Override
    public int processAccountLogin(ChannelHandlerContext ctx, PacketLoginUser login) {
        String userId = login.getUserId();
        String password = login.getPassword();
        log.info("userId:{}. password:{}", userId, password);

        // TODO: 版本校验应与 GameXor.GAME_VERSION 对齐，目前先简单通过。

        AccountLogin code;
        // 客户端哈希规则: SHA256(UPPERCASE(用户名)+":"+密码) 十六进制大写，见 GameCore.cpp
        // 6CCDEEF78D42BCA3BBACA378E9AB180801DF781434AE4709BA696905CB67F218 = SHA256("ADMIN:123456")
        if ("admin".equalsIgnoreCase(userId) && "6CCDEEF78D42BCA3BBACA378E9AB180801DF781434AE4709BA696905CB67F218".equals(password)) {
            code = AccountLogin.SUCCESS;
        } else {
            code = AccountLogin.INCORRECT_PASSWORD;
        }

        if (code == AccountLogin.SUCCESS) {
            int ticket = generateLoginTicket(); // C++: pcUserData->iTicket = Dice::RandomI(1, 1000)
            sendAccountLoginCode(ctx, code, "OK");
            sendUserInfo(ctx, userId);
            sendServerList(ctx, ticket);
        } else {
            sendAccountLoginCode(ctx, code, messageForLoginCode(code));
        }

        if (log.isTraceEnabled()) {
            log.trace("processAccountLogin result code={} for user={}", code, userId);
        }

        return code.getValue();
    }

    /**
     * 与 C++ account.h 注释一致的错误提示文案，写入 PacketAccountLoginCode.szMessage。
     * 注意：多数客户端（含原版 exe）仅根据 iCode 从本地字符串表显示固定文案（如 "Incorrect password"），
     * 不会使用服务端下发的 szMessage。若需自定义提示，需使用会绘制 0x04B0DFA0 内容的客户端构建。
     */
    private static String messageForLoginCode(AccountLogin code) {
        switch (code) {
            case INCORRECT_NAME:
            case ACCOUNT_NAME_NOT_FOUND:
                return "Account does not exist in the selected world";
            case INCORRECT_PASSWORD:
                return "Incorrect Password";
            case BANNED:
                return "Account is Banned";
            case LOGGED_IN:
                return "Account is already logged in";
            case IP_BANNED:
                return "Your IP is Banned";
            case YOU_ARE_BANNED:
                return "You are Banned";
            case TRY_AGAIN:
                return "Game will automatically retry";
            case MAINTENANCE:
                return "Server is in Maintenance";
            case ACCOUNT_NOT_ACTIVE:
                return "Account not active, see User Management Panel";
            case WRONG_VERSION:
                return "Version does not Match";
            case TEMP_BANNED:
                return "Temporarily Banned";
            default:
                return "Login failed";
        }
    }

    @Override
    public void sendAccountLoginCode(ChannelHandlerContext ctx, AccountLogin code, String message) {
        PacketAccountLoginCode packet = new PacketAccountLoginCode();
        packet.setPktHeader(PacketHeader.PKTHDR_AccountLoginCode);
        packet.setReserved(0);
        packet.setCode(code);
        // C++ 失败路径用 iFailCode=2（见 accountserver.cpp 1282 行），仅 LoginPending 用 1
        packet.setFailCode(code == AccountLogin.LOGIN_PENDING ? 1 : (code.getValue() < 0 ? 2 : 0));
        packet.setMessage(message != null ? message : "");

        if (log.isTraceEnabled()) {
            log.trace("sendAccountLoginCode {}", packet);
        }

        PacketSender.sendPacket(ctx, packet);
    }

    @Override
    public void sendUserInfo(ChannelHandlerContext ctx, String accountName) {
        PacketUserInfo packet = new PacketUserInfo();
        packet.setPktHeader(PacketHeader.PKTHDR_UserInfo);
        packet.setUserId(accountName != null ? accountName : "");
        packet.setCharCount(0);
        // TODO: 若后续对齐 C++ 中 TransCharInfo 结构，这里需要填充角色信息数组。

        PacketSender.sendPacket(ctx, packet);
    }

    @Override
    public void sendServerList(ChannelHandlerContext ctx, int ticket) {
        PacketServerList packet = new PacketServerList();
        packet.setPktHeader(PacketHeader.PKTHDR_ServerList);

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
        s0.setName("A Dedicated Java Server");
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

