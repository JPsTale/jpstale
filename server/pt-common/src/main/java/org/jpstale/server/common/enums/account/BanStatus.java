package org.jpstale.server.common.enums.account;

/**
 * 对应 C++ account.h 中 enum class EBanStatus，4 字节（int）。
 */
public enum BanStatus {
    ERROR(-1),
    NOT_BANNED(0),
    BANNED(1),
    TEMP_BANNED(2),
    BAN_EXPIRED(3);

    private final int value;

    BanStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BanStatus fromValue(int value) {
        for (BanStatus s : values()) {
            if (s.value == value) return s;
        }
        return ERROR;
    }
}
