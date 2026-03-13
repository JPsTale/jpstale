package org.jpstale.server.login.service;

import org.jpstale.server.common.packet.account.AccountLoginResult;
import org.jpstale.server.common.codec.GameXor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * 无数据库时的登录校验：不查库，仅做格式/版本检查，通过则返回 Success，保证网络通。
 */
@Service
@Profile("no-db")
public class StubAccountLoginService implements AccountLoginServiceApi {

    private static final Logger log = LoggerFactory.getLogger(StubAccountLoginService.class);

    @Override
    public int authenticate(String accountName, String passwordHash, int clientVersion) {
        if (accountName == null || accountName.isBlank()) {
            return AccountLoginResult.IncorrectName;
        }
        if (clientVersion != GameXor.GAME_VERSION) {
            log.debug("Stub login version mismatch: client={}, server={}", clientVersion, GameXor.GAME_VERSION);
            return AccountLoginResult.WrongVersion;
        }
        log.debug("Stub login (no DB) OK: account={}", accountName);
        return AccountLoginResult.Success;
    }
}
