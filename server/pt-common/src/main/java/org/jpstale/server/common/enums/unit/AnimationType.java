package org.jpstale.server.common.enums.unit;

/**
 * 对应 C++ unit.h 中 EAnimationType : int，4 字节。See character.h CHRMOTION_STATE_*.
 */
public enum AnimationType {
    NONE(0x0000),
    /** CHRMOTION_STATE_STAND */
    IDLE(0x0040),
    /** CHRMOTION_STATE_WALK */
    WALKING(0x0050),
    /** CHRMOTION_STATE_RUN */
    RUNNING(0x0060),
    SPRINT(0x0070),
    /** CHRMOTION_STATE_FALLDOWN */
    FALLING(0x0080),
    /** CHRMOTION_STATE_ATTACK */
    ATTACK(0x0100),
    /** CHRMOTION_STATE_DAMAGE */
    FLINCH(0x0110),
    /** CHRMOTION_STATE_DEAD */
    DIE(0x0120),
    /** CHRMOTION_STATE_EAT */
    POTION(0x0140),
    /** CHRMOTION_STATE_SKILL */
    SKILL(0x0150),
    /** CHRMOTION_STATE_FALLSTAND */
    FALL_LOW(0x0170),
    /** CHRMOTION_STATE_FALLDAMAGE */
    FALL_HIGH(0x0180),
    /** CHRMOTION_STATE_RESTART */
    REVIVE(0x0200),
    /** CHRMOTION_STATE_WARP */
    SPECIAL(0x0210),
    /** CHRMOTION_STATE_YAHOO */
    YAHOO(0x0220),
    TAUNT(0x0230),
    /** CHRMOTION_STATE_HAMMER (For sound classification only) */
    HAMMER(0x0300);

    private final int value;

    AnimationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AnimationType fromValue(int value) {
        for (AnimationType t : values()) {
            if (t.value == value) return t;
        }
        return NONE;
    }
}
