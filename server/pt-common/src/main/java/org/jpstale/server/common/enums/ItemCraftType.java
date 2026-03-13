package org.jpstale.server.common.enums;

/**
 * 对应 shared/item.h 中 enum EItemCraftType : int。size: 4 bytes
 */
public enum ItemCraftType {
    NPC(-1),
    NONE(0),
    MIXING(1),
    AGING(2),
    QUEST(3),
    EVENT(4),
    BOTTLE(5),
    BOTTLE_ELEMENT(6),
    QUEST_WEAPON(7),
    SPECIAL(8),
    TGF_KING_FURY(9),
    TGF_LORD_BABEL(10);

    private final int value;

    ItemCraftType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemCraftType fromValue(int value) {
        for (ItemCraftType e : values()) {
            if (e.value == value) return e;
        }
        return NPC;
    }
}
