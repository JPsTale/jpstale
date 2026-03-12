package org.jpstale.server.common.enums;

/**
 * 允许的职业专精标志位（对应 packets.h 中 EAllowedClassSpecFlag，位掩码）。
 */
public enum AllowedClassSpecFlag {

    None(0),
    Fighter(1),
    Mechanician(1 << 1),
    Archer(1 << 2),
    Pikeman(1 << 3),
    Assassin(1 << 4),
    Atalanta(1 << 8),
    Knight(1 << 9),
    Magician(1 << 10),
    Priestess(1 << 11),
    Shaman(1 << 12);

    private final int value;

    AllowedClassSpecFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AllowedClassSpecFlag fromValue(int value) {
        for (AllowedClassSpecFlag b : values()) {
            if (b.value == value) {
                return b;
            }
        }
        return None;
    }
}
