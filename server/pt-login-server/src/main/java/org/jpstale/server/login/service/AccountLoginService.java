package org.jpstale.server.login.service;

import org.jpstale.server.common.struct.account.AccountLoginResult;
import org.jpstale.server.common.codec.GameXor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Authenticates account against UserDB; password must match SHA256 hex stored in UserInfo.
 * 仅当未使用 no-db  profile 时生效。
 */
@Service
@Profile("!no-db")
public class AccountLoginService implements AccountLoginServiceApi {

    private static final Logger log = LoggerFactory.getLogger(AccountLoginService.class);

    private final JdbcTemplate jdbcTemplate;

    public AccountLoginService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int authenticate(String accountName, String passwordHash, int clientVersion) {
        if (accountName == null || accountName.isBlank()) {
            return AccountLoginResult.IncorrectName;
        }
        if (clientVersion != GameXor.GAME_VERSION) {
            return AccountLoginResult.WrongVersion;
        }

        try {
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                "SELECT password, banstatus, active FROM userinfo WHERE accountname = ?",
                accountName.trim()
            );
            if (rows.isEmpty()) {
                return AccountLoginResult.IncorrectName;
            }
            Map<String, Object> row = rows.get(0);
            String dbPassword = row.get("password") != null ? row.get("password").toString().trim() : "";
            Integer banStatus = row.get("banstatus") != null ? ((Number) row.get("banstatus")).intValue() : 0;
            Integer active = row.get("active") != null ? ((Number) row.get("active")).intValue() : 0;

            if (banStatus != null && banStatus != 0) {
                return AccountLoginResult.Banned;
            }
            if (active != null && active == 0) {
                return AccountLoginResult.AccountNotActive;
            }
            if (!passwordHash.equals(dbPassword)) {
                return AccountLoginResult.IncorrectPassword;
            }
            log.info("Login success: {}", accountName);
            return AccountLoginResult.Success;
        } catch (Exception e) {
            log.warn("Login DB error for {}", accountName, e);
            return AccountLoginResult.LoginPending;
        }
    }
}
