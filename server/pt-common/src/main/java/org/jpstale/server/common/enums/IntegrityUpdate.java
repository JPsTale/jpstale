package org.jpstale.server.common.enums;

/**
 * 对应 shared/character.h 中 EIntegrityUpdate : BYTE。
 */
public enum IntegrityUpdate {
    NONE(0),
    KILLED_MONSTER(1),
    KILLED_USER(2);

    private final int value;

    IntegrityUpdate(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static IntegrityUpdate fromValue(int value) {
        for (IntegrityUpdate u : values()) {
            if (u.value == value) {
                return u;
            }
        }
        return NONE;
    }
}

