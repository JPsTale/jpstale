package org.jpstale.server.common.enums.packets;

/**
 * 伤害飘字类型（对应 packets.h 中 EDamageTextType）。
 */
public enum DamageTextType {
    Undefined(-1),
    None(0),
    Defense(1),
    Block(2),
    Evade(3),
    Unknown(4),
    Normal(5),
    Critical(6),
    /** 拾取金币 */
    Gold(7),
    Poison(8),
    Miss(9),
    PetAttack(10),
    /** 仅调试 */
    Flinch(11),
    Burning(12),
    Freezing(13),
    Stun(14),
    Distortion(15),
    Curse(16),
    Healing(17),
    Damage(18);

    private final int value;

    DamageTextType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DamageTextType fromValue(int value) {
        for (DamageTextType t : values()) {
            if (t.value == value) return t;
        }
        return Undefined;
    }
}
