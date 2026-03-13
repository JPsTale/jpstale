package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 EItemSlotFlag : unsigned int，4 字节。位标志。
 */
public enum ItemSlotFlag {
    NONE(0),
    INVENTORY(1 << 0),
    LEFT_HAND(1 << 1),
    RIGHT_HAND(1 << 2),
    LEFT_RIGHT_HAND((1 << 2) | (1 << 1)),
    ARMOR(1 << 3),
    BOOTS(1 << 4),
    GAUNTLETS(1 << 5),
    RING_LEFT(1 << 6),
    RING_RIGHT(1 << 7),
    SHELTOM(1 << 8),
    AMULET(1 << 9),
    BRACELETS(1 << 11),
    POTION(1 << 13),
    COSTUME(1 << 14);

    private final int value;

    ItemSlotFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemSlotFlag fromValue(int value) {
        for (ItemSlotFlag e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
