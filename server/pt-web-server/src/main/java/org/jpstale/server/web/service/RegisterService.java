package org.jpstale.server.web.service;

import org.jpstale.dao.userdb.entity.UserInfo;
import org.jpstale.dao.userdb.mapper.UserInfoMapper;
import org.jpstale.server.common.enums.account.AccountFlag;
import org.jpstale.server.common.enums.account.BanStatus;
import org.jpstale.server.web.dto.RegisterResponse;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Locale;

/**
 * 注册：写入 userdb.user_info，密码存储格式与 pt-login-server 一致：
 * SHA256(UPPERCASE(account)+":"+明文密码) 的十六进制大写。
 */
@Service
public class RegisterService {

    private final UserInfoMapper userInfoMapper;

    public RegisterService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public RegisterResponse register(String account, String email, String plainPassword) {
        String accountName = account.trim();
        String emailTrimmed = email != null ? email.trim() : "";
        if (accountName.isEmpty()) {
            return RegisterResponse.fail("账号不能为空");
        }
        if (emailTrimmed.isEmpty()) {
            return RegisterResponse.fail("邮箱不能为空");
        }
        if (userInfoMapper.selectOneByAccountName(accountName) != null) {
            return RegisterResponse.fail("账号已存在");
        }
        if (userInfoMapper.selectOneByEmail(emailTrimmed) != null) {
            return RegisterResponse.fail("该邮箱已被注册");
        }
        String passwordHash = hashPassword(accountName, plainPassword);
        UserInfo user = new UserInfo();
        user.setAccountName(accountName);
        user.setPassword(passwordHash);
        user.setRegisDay(Instant.now());
        user.setFlag(AccountFlag.ACTIVATED.getValue() | AccountFlag.SUPPORTER.getValue()
                | AccountFlag.ACCEPTED_LATEST_TOA.getValue() | AccountFlag.APPROVED.getValue()); // 114，与登录兼容
        user.setActive(1);
        user.setActiveCode("0");       // 与 SQL Server 原版一致
        user.setCoins(0);
        user.setEmail(emailTrimmed);
        user.setGameMasterType(0);
        user.setGameMasterLevel(0);
        user.setGameMasterMacAddress("0");  // 与 SQL Server 原版一致
        user.setCoinsTraded(0);
        user.setBanStatus(BanStatus.NOT_BANNED.getValue());
        user.setUnbanDate(null);
        user.setIsMuted(0);
        user.setMuteCount(0);
        user.setUnmuteDate(null);
        userInfoMapper.insert(user);
        return RegisterResponse.ok("注册成功");
    }

    /** 与 C++/登录一致：SHA256(UPPERCASE(account)+":"+plainPassword) 十六进制大写 */
    static String hashPassword(String account, String plainPassword) {
        String input = account.toUpperCase(Locale.ROOT) + ":" + plainPassword;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder(digest.length * 2);
            for (byte b : digest) {
                hex.append(String.format("%02X", b & 0xff));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not available", e);
        }
    }
}
