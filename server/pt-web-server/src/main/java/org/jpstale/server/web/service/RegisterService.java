package org.jpstale.server.web.service;

import org.jpstale.dao.userdb.entity.UserInfo;
import org.jpstale.dao.userdb.mapper.UserInfoMapper;
import org.jpstale.server.common.enums.account.AccountFlag;
import org.jpstale.server.common.enums.account.BanStatus;
import org.jpstale.server.web.dto.RegisterResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * 注册：写入 userdb.user_info。密码由前端按 SHA256(UPPERCASE(account)+":"+明文) 算出十六进制大写后传入，后端直接存库。
 */
@Service
public class RegisterService {

    private static final int PASSWORD_HEX_LENGTH = 64;

    private final UserInfoMapper userInfoMapper;

    public RegisterService(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public RegisterResponse register(String account, String email, String passwordHash) {
        String accountName = account.trim();
        String emailTrimmed = email != null ? email.trim() : "";
        if (accountName.isEmpty()) {
            return RegisterResponse.fail("账号不能为空");
        }
        if (emailTrimmed.isEmpty()) {
            return RegisterResponse.fail("邮箱不能为空");
        }
        if (passwordHash == null || passwordHash.length() != PASSWORD_HEX_LENGTH || !passwordHash.matches("[0-9A-Fa-f]{64}")) {
            return RegisterResponse.fail("密码格式无效");
        }
        if (userInfoMapper.selectOneByAccountName(accountName) != null) {
            return RegisterResponse.fail("账号已存在");
        }
        if (userInfoMapper.selectOneByEmail(emailTrimmed) != null) {
            return RegisterResponse.fail("该邮箱已被注册");
        }
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
}
