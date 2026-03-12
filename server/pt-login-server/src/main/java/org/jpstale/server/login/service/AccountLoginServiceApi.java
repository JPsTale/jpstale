package org.jpstale.server.login.service;

/**
 * 登录校验接口，便于无 DB 时注入 stub 实现。
 */
public interface AccountLoginServiceApi {
    /**
     * @return EAccountLogin code: 1 = success, 0 = pending, negative = error.
     */
    int authenticate(String accountName, String passwordHash, int clientVersion);
}
