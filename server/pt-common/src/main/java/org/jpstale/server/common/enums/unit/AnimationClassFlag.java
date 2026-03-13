package org.jpstale.server.common.enums.unit;

/**
 * 对应 C++ unit.h 中 EAnimationClassFlag : unsigned int，4 字节。
 */
public enum AnimationClassFlag {
    NONE(0),
    FIGHTER(0x0001),
    MECHANICIAN(0x0002),
    ARCHER(0x0004),
    PIKEMAN(0x0008),
    ATALANTA(0x0010),
    KNIGHT(0x0020),
    MAGICIAN(0x0040),
    PRIESTESS(0x0080),
    ASSASSIN(0x0100),
    SHAMAN(0x0200);

    private final int value;

    AnimationClassFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AnimationClassFlag fromValue(int value) {
        for (AnimationClassFlag f : values()) {
            if (f.value == value) return f;
        }
        return NONE;
    }
}
