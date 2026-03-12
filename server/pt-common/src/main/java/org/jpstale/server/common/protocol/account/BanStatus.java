package org.jpstale.server.common.protocol.account;

/**
 * 封禁状态（对应 account.h 中 enum class EBanStatus）。
 */
public enum BanStatus {
    Error(-1),
    NotBanned(0),
    Banned(1),
    TempBanned(2),
    BanExpired(3);

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
        return Error;
    }
}
