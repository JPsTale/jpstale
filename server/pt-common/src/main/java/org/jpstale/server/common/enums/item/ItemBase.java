package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 EItemBase : unsigned int，4 字节。
 */
public enum ItemBase {
    ANY(0xFFFFFFFF),
    NONE(0x00000000),
    WEAPON(0x01000000),
    DEFENSE(0x02000000),
    SHELTOM(0x03000000),
    POTION(0x04000000),
    CRYSTAL(0x05000000),
    CORE(0x06000000),
    QUEST1(0x07000000),
    PREMIUM(0x08000000),
    QUEST2(0x09000000),
    RECIPE(0x0A000000);

    private final int value;

    ItemBase(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemBase fromValue(int value) {
        for (ItemBase e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
