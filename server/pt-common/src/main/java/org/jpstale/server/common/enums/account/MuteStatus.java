package org.jpstale.server.common.enums.account;

/**
 * 对应 C++ account.h 中 EMuteStatus : int，4 字节。
 */
public enum MuteStatus {
    ERROR(-1),
    NOT_MUTED(0),
    MUTED(1),
    PERMA_MUTE(2);  // Permanent mute. Ouch.

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
        return ERROR;
    }
}
