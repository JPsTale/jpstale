package org.jpstale.server.common.protocol.account;

/**
 * 禁言状态（对应 account.h 中 enum EMuteStatus : int）。
 */
public enum MuteStatus {
    Error(-1),
    NotMuted(0),
    Muted(1),
    PermaMute(2);

    private final int value;

    MuteStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MuteStatus fromValue(int value) {
        for (MuteStatus s : values()) {
            if (s.value == value) return s;
        }
        return Error;
    }
}
