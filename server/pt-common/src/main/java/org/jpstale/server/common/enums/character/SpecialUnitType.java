package org.jpstale.server.common.enums.character;

/**
 * 对应 C++ character.h 中 ESpecialUnitType，4 字节（int）。
 */
public enum SpecialUnitType {
    NONE(0),
    QUEST_WOLVERINE(100);

    private final int value;

    SpecialUnitType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SpecialUnitType fromValue(int value) {
        for (SpecialUnitType t : values()) {
            if (t.value == value) return t;
        }
        return NONE;
    }
}
