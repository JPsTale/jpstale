package org.jpstale.server.common.enums.packets;

/**
 * 怪物阵营/属性（对应 packets.h 中 EMonsterNature）。
 */
public enum MonsterNature {
    Neutral(0x80),
    Good(0x81),
    Evil(0x82);

    private final int value;

    MonsterNature(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MonsterNature fromValue(int value) {
        for (MonsterNature n : values()) {
            if (n.value == value) return n;
        }
        return Neutral;
    }
}
