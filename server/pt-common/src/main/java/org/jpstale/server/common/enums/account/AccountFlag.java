package org.jpstale.server.common.enums.account;

/**
 * 对应 C++ account.h 中 EAccountFlag，4 字节（int），按位或组合使用。
 */
public enum AccountFlag {
    NOT_EXIST(-1),
    INVALID(0),
    MULE(1),
    ACTIVATED(2),
    EVENT_GM(4),
    SUPPORTER(8),
    GAME_MASTER(16),
    ACCEPTED_LATEST_TOA(32),
    APPROVED(64),
    MUST_CONFIRM(128),
    GMIP_REQUIRED(256);

    private final int value;

    AccountFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AccountFlag fromValue(int value) {
        for (AccountFlag f : values()) {
            if (f.value == value) return f;
        }
        return INVALID;
    }
}
