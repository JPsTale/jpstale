package org.jpstale.server.common.protocol.account;

/**
 * 登录结果码（对应 account.h 中 EAccountLogin）。
 */
public final class AccountLoginResult {
    private AccountLoginResult() {}

    public static final int Success             = 1;
    public static final int LoginPending        = 0;
    public static final int IncorrectName       = -1;
    public static final int IncorrectPassword   = -2;
    public static final int Banned              = -3;
    public static final int LoggedIn            = -4;
    public static final int IPBanned            = -5;
    public static final int YouAreBanned        = -6;
    public static final int TryAgain            = -7;
    public static final int Maintenance         = -8;
    public static final int AccountNotActive    = -16;
    public static final int WrongVersion        = -17;
    public static final int TempBanned          = -18;
    public static final int AccountNameNotFound = -19;
}
