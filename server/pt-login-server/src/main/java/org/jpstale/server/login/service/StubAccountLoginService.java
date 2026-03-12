package org.jpstale.server.login.service;

import org.jpstale.server.common.protocol.AccountLoginResult;
import org.jpstale.server.common.protocol.GameXor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * 无数据库时的登录校验：仅做版本检查，其余一律返回 INCORRECT_PASSWORD（用于本地联调协议）。
 */
@Service
@Profile("no-db")
public class StubAccountLoginService implements AccountLoginServiceApi {

    private static final Logger log = LoggerFactory.getLogger(StubAccountLoginService.class);

    @Override
    public int authenticate(String accountName, String passwordHash, int clientVersion) {
        if (accountName == null || accountName.isBlank()) {
            return AccountLoginResult.INCORRECT_NAME;
        }
        if (clientVersion != GameXor.GAME_VERSION) {
            return AccountLoginResult.WRONG_VERSION;
        }
        log.debug("Stub login (no DB): account={}, version={}", accountName, clientVersion);
        return AccountLoginResult.INCORRECT_PASSWORD;
    }
}
