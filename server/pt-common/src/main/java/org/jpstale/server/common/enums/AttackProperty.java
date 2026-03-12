package org.jpstale.server.common.enums;

/**
 * 攻击属性（对应 packets.h 中 EAttackProperty）。
 */
public enum AttackProperty {
    Unknown(-1),
    Undefined(0),
    Organic(1),
    Earth(2),
    Fire(3),
    Ice(4),
    Lightning(5),
    Poison(6),
    Water(7),
    Wind(8),
    Holy(9),
    None(15);

    private final int value;

    AttackProperty(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AttackProperty fromValue(int value) {
        for (AttackProperty p : values()) {
            if (p.value == value) return p;
        }
        return Unknown;
    }
}
