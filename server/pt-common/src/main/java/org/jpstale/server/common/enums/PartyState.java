package org.jpstale.server.common.enums;

/**
 * 对应 shared/party.h 中 EPartyState。
 */
public enum PartyState {
    FAILED(-1),
    NONE(0),
    SUCCESS(1),
    ALREADY_PARTY(2),
    FULL_PARTY(3),
    REQUEST_INVITE(4);

    private final int value;

    PartyState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PartyState fromValue(int value) {
        for (PartyState s : values()) {
            if (s.value == value) {
                return s;
            }
        }
        return NONE;
    }
}

