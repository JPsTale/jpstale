package org.jpstale.server.common.enums;

/**
 * 对应 shared/item.h 中的 enum class EItemSource : unsigned char。
 */
public enum ItemSource {
    UNKNOWN(0),
    MONSTER_KILL(0x01),
    BOSS_KILL(0x02),
    PLAYER_THROWN(0x03),
    BELLATRA_KILL(0x04),
    BELLATRA_REWARD(0x05),
    PLAYER_TRADE(0x06),
    NPC_SHOP(0x07),
    PLAYER_SHOP(0x08),
    T5_QUEST(0x09),
    CHRISTMAS_EVENT(0x10),
    WANTED_WOLF_EVENT(0x11),
    WANTED_MORIPH_EVENT(0x12),
    EASTER_EVENT(0x13),
    PERFECT_VIEW(0x14),
    COIN_SHOP_PERFECT_ITEM(0x15),
    FURY_STONE(0x16),
    HALLOWEEN_EVENT(0x17),
    CLEAN_STONE(0x18),
    ITEM_BOX(0x19),
    MANUFACTURE_SWAP(0x20),
    RESPEC(0x21),
    QUEST_REWARD(0x22),
    QUEST_KILL(0x23),
    GAME_MASTER(0x24),
    MIXED_SOCKET(0x25),
    MIMIC_KILL(0x26),
    COIN_SHOP(0x27);

    private final int value;

    ItemSource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemSource fromValue(int value) {
        for (ItemSource s : values()) {
            if (s.value == value) {
                return s;
            }
        }
        return UNKNOWN;
    }
}

