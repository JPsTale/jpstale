package org.jpstale.server.login.service;

import org.jpstale.server.common.enums.account.AccountLogin;

/**
 * 登录校验接口。无 DB 时使用 {@link StubAccountLoginService}（profile=no-db），返回 Success 使网络通。
 */
public interface AccountLoginServiceApi {
    /**
     * @return EAccountLogin：1=成功，0=等待，负值=错误（见 AccountLogin）
     */
    AccountLogin authenticate(String accountName, String passwordHash, int clientVersion);
}
