package org.jpstale.server.common.enums.unit;

/**
 * 对应 C++ unit.h 中 EActionPattern : int，4 字节。
 */
public enum ActionPattern {
    /** Main character */
    CLIENT_SELF(0),
    /** Monster */
    SERVER_MONSTER(5),
    /** Npc */
    SERVER_NPC(12),
    /** Other client unit */
    CLIENT_UNIT(99),
    CLIENT_TARGET(101);

    private final int value;

    ActionPattern(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ActionPattern fromValue(int value) {
        for (ActionPattern p : values()) {
            if (p.value == value) return p;
        }
        return CLIENT_SELF;
    }
}
