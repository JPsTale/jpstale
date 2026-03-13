package org.jpstale.server.common.enums.packets;

/**
 * 怪物类型（对应 packets.h 中 EMonsterType）。
 */
public enum MonsterType {
    Normal(0x00),
    Undead(0x90),
    Mutant(0x91),
    Demon(0x92),
    /** 无加成伤害，测试图等 */
    Netural(0x94),
    /** 召唤物 (smCHAR_MONSTER_SUMMON) */
    Summon(0xA0),
    /** 宠物 */
    Pet(0xA1);

    private final int value;

    MonsterType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MonsterType fromValue(int value) {
        for (MonsterType t : values()) {
            if (t.value == value) return t;
        }
        return Normal;
    }
}
