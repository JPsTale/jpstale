package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 EWeaponClass（未指定底层类型，按 int），4 字节。
 */
public enum WeaponClass {
    NONE(0),
    MELEE(1),
    RANGED(2),
    MAGIC(3);

    private final int value;

    WeaponClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static WeaponClass fromValue(int value) {
        for (WeaponClass c : values()) {
            if (c.value == value) return c;
        }
        return NONE;
    }
}
