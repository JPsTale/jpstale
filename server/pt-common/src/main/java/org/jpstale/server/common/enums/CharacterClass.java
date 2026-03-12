package org.jpstale.server.common.enums;

/**
 * 角色职业（对应 packets.h 中 ECharacterClass）。
 */
public enum CharacterClass {
    None(0),
    Fighter(1),
    Mechanician(2),
    Archer(3),
    Pikeman(4),
    Atalanta(5),
    Knight(6),
    Magician(7),
    Priestess(8),
    Assassin(9),
    Shaman(10);

    private final int value;

    CharacterClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CharacterClass fromValue(int value) {
        for (CharacterClass c : values()) {
            if (c.value == value) return c;
        }
        return None;
    }
}
