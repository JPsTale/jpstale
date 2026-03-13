package org.jpstale.server.common.enums.unit;

/**
 * 对应 C++ unit.h 中 ECharacterGender，4 字节（int）。
 */
public enum CharacterGender {
    NONE(0),
    MALE(1),
    FEMALE(2);

    private final int value;

    CharacterGender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CharacterGender fromValue(int value) {
        for (CharacterGender g : values()) {
            if (g.value == value) return g;
        }
        return NONE;
    }
}
