package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 EItemSlot : int，4 字节。
 */
public enum ItemSlot {
    NONE(0),
    RIGHT_HAND(1),
    LEFT_HAND(2),
    ARMOR(3),
    AMULET(4),
    RING_RIGHT(5),
    RING_LEFT(6),
    SHELTOM(7),
    BRACELETS(8),
    GAUNTLETS(9),
    BOOTS(10),
    POTION_ONE(11),
    POTION_TWO(12),
    POTION_THREE(13),
    COSTUME(14);

    private final int value;

    ItemSlot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemSlot fromValue(int value) {
        for (ItemSlot e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
