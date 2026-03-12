package org.jpstale.server.common.protocol;

/**
 * Login result codes (align with PristonTale-EU shared/account.h EAccountLogin).
 */
public final class AccountLoginResult {
    private AccountLoginResult() {}

    public static final int SUCCESS = 1;
    public static final int LOGIN_PENDING = 0;
    public static final int INCORRECT_NAME = -1;
    public static final int INCORRECT_PASSWORD = -2;
    public static final int BANNED = -3;
    public static final int ALREADY_LOGGED_IN = -4;
    public static final int IP_BANNED = -5;
    public static final int YOU_ARE_BANNED = -6;
    public static final int TRY_AGAIN = -7;
    public static final int MAINTENANCE = -8;
    public static final int ACCOUNT_NOT_ACTIVE = -16;
    public static final int WRONG_VERSION = -17;
    public static final int TEMP_BANNED = -18;
    public static final int ACCOUNT_NAME_NOT_FOUND = -19;
}
