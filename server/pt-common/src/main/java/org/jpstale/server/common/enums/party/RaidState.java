package org.jpstale.server.common.enums.party;

/**
 * 对应 C++ party.h 中 ERaidState，4 字节（int）。
 */
public enum RaidState {
    FAILED(-1),
    NONE(0),
    SUCCESS(1),
    FULL_RAID(2);

    private final int value;

    RaidState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RaidState fromValue(int value) {
        for (RaidState s : values()) {
            if (s.value == value) return s;
        }
        return NONE;
    }
}
