package org.jpstale.server.common.enums.packets;

/**
 * 攻击状态/类型（对应 packets.h 中 EAttackState）。
 */
public enum AttackState {
    State_0_Normal(0),
    State_1_Knockback(1),
    State_2_Stun(2),
    State_3_Slow(3),
    State_4_LifeSteal(4),
    State_5_Spare(5),
    State_6_Extinction(6),
    State_7_Distortion(7),
    State_8_Cursed(8),
    State_9_DivineShield(9),
    State_100_Fire(100),
    State_101_Brain(101),
    State_103_DivineLightning(103),
    State_104_Water(104),
    State_105_Electricity(105),
    State_106_Poison(106),
    /** 技能攻击 (0x80) */
    State_128_Skill(128),
    State_201_PullIn(201),
    State_301_Charged(301);

    private final int value;

    AttackState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AttackState fromValue(int value) {
        for (AttackState s : values()) {
            if (s.value == value) return s;
        }
        return State_0_Normal;
    }
}
