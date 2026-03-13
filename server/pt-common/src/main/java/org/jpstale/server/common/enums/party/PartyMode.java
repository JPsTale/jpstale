package org.jpstale.server.common.enums.party;

/**
 * 对应 C++ party.h 中 EPartyMode，4 字节（int）。
 */
public enum PartyMode {
    NORMAL(0),
    HUNT(1);

    private final int value;

    PartyMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PartyMode fromValue(int value) {
        for (PartyMode m : values()) {
            if (m.value == value) return m;
        }
        return NORMAL;
    }
}
