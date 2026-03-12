package org.jpstale.server.common.enums;

/**
 * 职业标志位（对应 packets.h 中 EClassFlag）。
 */
public enum ClassFlag {
    Unknown(-1),
    None(0),
    Mechanician(1),
    Fighter(2),
    Pikeman(3),
    Archer(4),
    Knight(0x00010000),
    Atalanta(0x00020000),
    Priestess(0x00030000),
    Magician(0x00040000),
    Shaman(0x00050000),
    Assassin(0x00050100);

    private final int value;

    ClassFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ClassFlag fromValue(int value) {
        for (ClassFlag f : values()) {
            if (f.value == value) return f;
        }
        return Unknown;
    }
}
