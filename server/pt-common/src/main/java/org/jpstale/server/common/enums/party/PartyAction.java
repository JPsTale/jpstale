package org.jpstale.server.common.enums.party;

/**
 * 对应 C++ party.h 中 EPartyAction，4 字节（int）。
 */
public enum PartyAction {
    NONE(0),
    LEAVE(1),
    KICK(2),
    DELEGATE(3),
    DISBAND_PARTY(4),
    DISBAND_RAID(5),
    CHANGE_MODE(6);

    private final int value;

    PartyAction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PartyAction fromValue(int value) {
        for (PartyAction a : values()) {
            if (a.value == value) return a;
        }
        return NONE;
    }
}
