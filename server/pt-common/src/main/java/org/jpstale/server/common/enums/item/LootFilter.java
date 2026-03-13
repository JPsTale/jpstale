package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 ELootFilter : unsigned int，4 字节。位标志。
 */
public enum LootFilter {
    NONE(0x0),
    HP_POTION(0x0002),
    MP_POTION(0x0004),
    SP_POTION(0x0008),
    GOLD(0x0010),
    JEWELLERY(0x0020),
    GEAR(0x0040),
    SHELTOMS(0x0080),
    FORCE_ORBS(0x0100),
    CRYSTALS(0x0200),
    NON_SPEC_SHELTOMS(0x0400),
    NON_SPEC_JEWELLERY(0x0800),
    NON_SPEC_GEAR(0x1000),
    ALL(0x1FFE);

    private final int value;

    LootFilter(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LootFilter fromValue(int value) {
        for (LootFilter e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
