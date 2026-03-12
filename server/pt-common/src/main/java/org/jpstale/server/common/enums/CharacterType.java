package org.jpstale.server.common.enums;

/**
 * 角色类型（对应 packets.h 中 ECharacterType）。
 */
public enum CharacterType {
    /** 无/未定义 */
    None(0),
    /** NPC */
    NPC(0x00),
    /** 怪物 */
    Monster(0x01),
    /** 玩家 (smCHAR_STATE_PLAYER) */
    Player(0x80);

    private final int value;

    CharacterType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CharacterType fromValue(int value) {
        for (CharacterType t : values()) {
            if (t.value == value) return t;
        }
        return None;
    }
}
