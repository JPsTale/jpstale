package org.jpstale.server.common.enums.account;

/**
 * 对应 C++ account.h 中 ECharacterLog，4 字节（int）。
 */
public enum CharacterLog {
    CREATE(1),
    DELETE(2),
    UPDATE(3);

    private final int value;

    CharacterLog(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CharacterLog fromValue(int value) {
        for (CharacterLog e : values()) {
            if (e.value == value) return e;
        }
        return CREATE;
    }
}
