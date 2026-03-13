package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 EMixEffect : unsigned int，4 字节。位标志。
 */
public enum MixEffect {
    NONE(0x00000000),
    FLAME(0x00000001),
    FROST(0x00000002),
    LIGHT(0x00000004),
    POISON(0x00000008),
    ORGANIC(0x00000010),
    CRITICAL(0x00000020),
    ATTACK_RATING(0x00000040),
    MIN_ATTACK_POWER(0x00000080),
    MAX_ATTACK_POWER(0x00000100),
    WEAPON_SPEED(0x00000200),
    ABSORB_RATING(0x00000400),
    DEFENSE_RATING(0x00000800),
    BLOCK(0x00001000),
    WALK_SPEED(0x00002000),
    HP(0x00004000),
    MP(0x00008000),
    SP(0x00010000),
    HP_REGEN(0x00020000),
    MP_REGEN(0x00040000),
    SP_REGEN(0x00080000),
    POTION_STORAGE(0x00100000);

    private final int value;

    MixEffect(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MixEffect fromValue(int value) {
        for (MixEffect e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
