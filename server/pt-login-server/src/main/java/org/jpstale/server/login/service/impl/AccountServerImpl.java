package org.jpstale.server.login.service.impl;

import io.netty.channel.ChannelHandlerContext;
import org.jpstale.dao.logdb.entity.AccountLog;
import org.jpstale.dao.logdb.mapper.AccountLogMapper;
import org.jpstale.dao.userdb.entity.UserInfo;
import org.jpstale.dao.userdb.mapper.UserInfoMapper;
import org.jpstale.server.common.enums.packets.PacketHeader;
import org.jpstale.server.common.codec.PacketSender;
import org.jpstale.server.common.enums.account.AccountFlag;
import org.jpstale.server.common.enums.account.AccountLogId;
import org.jpstale.server.common.enums.account.AccountLogin;
import org.jpstale.server.common.enums.account.BanStatus;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * AccountServer 实现，对齐 C++ accountserver.cpp 的 ProcessAccountLogin 流程，
 * 使用 pt-dao 的 UserInfoMapper / AccountLogMapper 访问数据库。
 * 账号标志、封禁状态、日志类型均使用 pt-common 的枚举。
 */
@Service
public class AccountServerImpl implements AccountServer {

    private static final Logger log = LoggerFactory.getLogger(AccountServerImpl.class);

    private final UserInfoMapper userInfoMapper;
    private final AccountLogMapper accountLogMapper;

    public AccountServerImpl(UserInfoMapper userInfoMapper, AccountLogMapper accountLogMapper) {
        this.userInfoMapper = userInfoMapper;
        this.accountLogMapper = accountLogMapper;
    }

    private static int generateLoginTicket() {
        return ThreadLocalRandom.current().nextInt(1, 1001);
    }

    @Override
    public int processAccountLogin(ChannelHandlerContext ctx, PacketLoginUser login) {
        String accountName = login.getUserId() != null ? login.getUserId().trim() : "";
        String password = login.getPassword() != null ? login.getPassword().trim() : "";
        String clientIp = getClientIp(ctx);

        log.info("accountLogin accountName=[{}] ip=[{}]", accountName, clientIp);

        AccountLogin code = AccountLogin.LOGIN_PENDING;

        // 1) 空账号 / 空密码（C++ ProcessAccountLogin 1007-1016）
        if (accountName.isEmpty()) {
            code = AccountLogin.INCORRECT_NAME;
        } else if (password.isEmpty()) {
            code = AccountLogin.INCORRECT_PASSWORD;
        }

        UserInfo userInfo = null;
        if (code == AccountLogin.LOGIN_PENDING) {
            userInfo = userInfoMapper.selectOneByAccountName(accountName);
            if (userInfo == null) {
                code = AccountLogin.INCORRECT_NAME;
            }
        }

        if (code == AccountLogin.LOGIN_PENDING) {
            int flag = userInfo.getFlag() != null ? userInfo.getFlag() : AccountFlag.NOT_EXIST.getValue();

            if (flag == AccountFlag.NOT_EXIST.getValue()) {
                code = AccountLogin.INCORRECT_NAME;
            } else if ((AccountFlag.ACTIVATED.getValue() & flag) == 0) {
                code = AccountLogin.ACCOUNT_NOT_ACTIVE;
            } else if ((AccountFlag.ACCEPTED_LATEST_TOA.getValue() & flag) == 0) {
                code = AccountLogin.ACCOUNT_NOT_ACTIVE;
            } else if ((AccountFlag.APPROVED.getValue() & flag) == 0) {
                code = AccountLogin.ACCOUNT_NOT_ACTIVE;
            } else if ((AccountFlag.MUST_CONFIRM.getValue() & flag) != 0) {
                code = AccountLogin.ACCOUNT_NOT_ACTIVE;
            }

            if (code == AccountLogin.LOGIN_PENDING) {
                BanStatus banStatus = BanStatus.fromValue(userInfo.getBanStatus() != null ? userInfo.getBanStatus() : BanStatus.NOT_BANNED.getValue());
                if (banStatus == BanStatus.BANNED) {
                    code = AccountLogin.BANNED;
                } else if (banStatus == BanStatus.TEMP_BANNED) {
                    LocalDateTime unbanDate = userInfo.getUnbanDate();
                    if (unbanDate != null && LocalDateTime.now().isBefore(unbanDate)) {
                        code = AccountLogin.TEMP_BANNED;
                    } else {
                        if (userInfo.getId() != null) {
                            userInfoMapper.updateUnbanById(userInfo.getId());
                        }
                    }
                }
            }

            if (code == AccountLogin.LOGIN_PENDING && userInfo.getIsMuted() != null && userInfo.getIsMuted() != 0) {
                LocalDateTime unmuteDate = userInfo.getUnmuteDate();
                if (unmuteDate != null && LocalDateTime.now().isBefore(unmuteDate)) {
                    // 仍处于禁言期，C++ 会设置 pcUser->bMuted，登录服仅放行
                } else {
                    if (userInfo.getId() != null) {
                        userInfoMapper.updateUnmuteById(userInfo.getId());
                    }
                }
            }

            if (code == AccountLogin.LOGIN_PENDING) {
                String dbPassword = userInfo.getPassword();
                if (dbPassword == null) {
                    dbPassword = "";
                }
                if (password.equals(dbPassword)) {
                    code = AccountLogin.SUCCESS;
                } else {
                    code = AccountLogin.INCORRECT_PASSWORD;
                }
            }
        }

        String message;
        AccountLogin sendCode = code;
        if (code == AccountLogin.BANNED || code == AccountLogin.TEMP_BANNED) {
            if (code == AccountLogin.TEMP_BANNED && userInfo.getUnbanDate() != null) {
                message = "Account is banned until " + userInfo.getUnbanDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")) + " GMT";
            } else {
                message = messageForLoginCode(AccountLogin.BANNED);
            }
            sendCode = AccountLogin.BANNED;
        } else {
            message = messageForLoginCode(code);
        }

        if (code == AccountLogin.SUCCESS) {
            sendAccountLoginCode(ctx, AccountLogin.SUCCESS, "OK");
            sendUserInfo(ctx, accountName);
            int ticket = generateLoginTicket();
            sendServerList(ctx, ticket);
            logAccountLogin(clientIp, accountName, AccountLogId.LOGIN_SUCCESS.getValue(), "Login Success", ctx);
        } else {
            int logId = code == AccountLogin.INCORRECT_NAME ? AccountLogId.INCORRECT_ACCOUNT.getValue()
                : code == AccountLogin.INCORRECT_PASSWORD ? AccountLogId.INCORRECT_PASSWORD.getValue()
                : AccountLogId.BLOCKED_ACCOUNT.getValue();
            logAccountLogin(clientIp, accountName, logId, message, ctx);
            sendAccountLoginCode(ctx, sendCode, message);
        }

        if (log.isTraceEnabled()) {
            log.trace("processAccountLogin result code={} for account={}", code, accountName);
        }
        return code.getValue();
    }

    private void logAccountLogin(String ip, String accountName, int logId, String description, ChannelHandlerContext ctx) {
        try {
            AccountLog logEntity = new AccountLog();
            logEntity.setIp(ip != null ? ip : "");
            logEntity.setAccountName(accountName != null ? accountName : "");
            logEntity.setLogId(logId);
            logEntity.setDescription(description != null ? description : "");
            logEntity.setServerId(1);
            accountLogMapper.insertAccountLog(logEntity);
        } catch (Exception e) {
            log.warn("insertAccountLog failed: {}", e.getMessage());
        }
    }

    private static String getClientIp(ChannelHandlerContext ctx) {
        if (ctx == null || ctx.channel() == null || ctx.channel().remoteAddress() == null) {
            return "";
        }
        return ctx.channel().remoteAddress().toString().replaceFirst("/", "");
    }

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
        // TODO: 从 CharacterInfoMapper 查该账号角色列表并填充 sCharacterData（对齐 C++ OnLoginSuccess）
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
        s0.getIp()[0] = "127.0.0.1";
        s0.getPort()[0] = 8485;
        s0.getPort()[1] = 8485;
        s0.getPort()[2] = 8485;
        s0.getPort()[3] = 0;
        packet.setServers(servers);
        PacketSender.sendPacket(ctx, packet);
    }
}
