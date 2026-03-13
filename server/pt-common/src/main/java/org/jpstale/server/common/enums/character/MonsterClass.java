package org.jpstale.server.common.enums.character;

/**
 * 对应 C++ character.h 中 enum class EMonsterClass : WORD，2 字节。
 */
public enum MonsterClass {
    NORMAL(0),
    BOSS(1),
    HAMMER(200),
    GHOST(300);

    private final int value;

    MonsterClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MonsterClass fromValue(int value) {
        for (MonsterClass c : values()) {
            if (c.value == value) return c;
        }
        return NORMAL;
    }
}
