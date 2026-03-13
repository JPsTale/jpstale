package org.jpstale.server.common.enums.account;

/**
 * 对应 C++ account.h 中 EAccountLogin，4 字节（int）。
 */
public enum AccountLogin {
    SUCCESS(1),                     // [Successful]
    LOGIN_PENDING(0),               // Login pending / Connecting failed
    INCORRECT_NAME(-1),             // Account does not exist in the selected world
    INCORRECT_PASSWORD(-2),         // Incorrect Password
    BANNED(-3),                     // Account is banned
    LOGGED_IN(-4),                  // Account is already logged in
    IP_BANNED(-5),                  // Your IP is banned
    YOU_ARE_BANNED(-6),             // Your IP is banned
    TRY_AGAIN(-7),                  // [Game will automatically retry]
    MAINTENANCE(-8),                // Server is in Maintenance
    ACCOUNT_NOT_ACTIVE(-16),        // Account not active, see User Management Panel
    WRONG_VERSION(-17),             // Version does not Match
    TEMP_BANNED(-18),               // Temporarily Banned
    ACCOUNT_NAME_NOT_FOUND(-19);    // Account name does not exist

    private final int value;

    AccountLogin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AccountLogin fromValue(int value) {
        for (AccountLogin e : values()) {
            if (e.value == value) return e;
        }
        return LOGIN_PENDING;
    }
}
