package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 EItemRarity : char，1 字节。
 */
public enum ItemRarity {
    NONE(0),
    COMMON(1),
    UNCOMMON(2),
    RARE(3),
    EPIC(4),
    LEGENDARY(5);

    private final int value;

    ItemRarity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemRarity fromValue(byte value) {
        return fromValue(0xFF & value);
    }

    public static ItemRarity fromValue(int value) {
        for (ItemRarity r : values()) {
            if (r.value == value) return r;
        }
        return NONE;
    }
}
