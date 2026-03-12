package org.jpstale.server.common.enums;

/**
 * 物品稀有度（对应 item.h 中 EItemRarity，packets.h 前向声明）。
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

    public static ItemRarity fromValue(int value) {
        for (ItemRarity r : values()) {
            if (r.value == value) return r;
        }
        return NONE;
    }
}
