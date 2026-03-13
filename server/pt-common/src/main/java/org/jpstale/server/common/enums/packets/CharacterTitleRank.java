package org.jpstale.server.common.enums.packets;

/**
 * 角色称号稀有度/等级（对应 packets.h 中 ECharacterTitleRank）。
 */
public enum CharacterTitleRank {
    White(0),
    Green(1),
    Blue(2),
    Purple(3),
    Orange(4),
    Teal(5);

    private final int value;

    CharacterTitleRank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CharacterTitleRank fromValue(int value) {
        for (CharacterTitleRank r : values()) {
            if (r.value == value) return r;
        }
        return White;
    }
}
