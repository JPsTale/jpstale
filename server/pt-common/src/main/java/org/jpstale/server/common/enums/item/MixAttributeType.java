package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 EMixAttributeType（未指定底层类型，按 int），4 字节。位标志。
 */
public enum MixAttributeType {
    FIRE(1),
    ICE(2),
    LIGHTNING(4),
    POISON(8),
    ORGANIC(16),
    CRITICAL(32),
    ATTACK_RATING(64),
    DAMAGE_MIN(128),
    DAMAGE_MAX(256),
    ATTACK_SPEED(512),
    ABSORPTION(1024),
    DEFENSE(2048),
    BLOCK_RATING(4096),
    WALK_SPEED(8192),
    HP(16384),
    MP(32768),
    SP(65536),
    HP_REGEN(131072),
    MP_REGEN(262144),
    SP_REGEN(524288),
    POTION_STORAGE(1048576);

    private final int value;

    MixAttributeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MixAttributeType fromValue(int value) {
        for (MixAttributeType e : values()) {
            if (e.value == value) return e;
        }
        return FIRE;
    }
}
