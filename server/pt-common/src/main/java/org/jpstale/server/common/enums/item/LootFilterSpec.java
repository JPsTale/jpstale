package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 ELootFilterSpec : unsigned int，4 字节。位标志。
 */
public enum LootFilterSpec {
    NONE(0x0),
    NS(0x0002),
    FS(0x0004),
    MS(0x0008),
    AS(0x0010),
    PS(0x0020),
    ATA(0x0040),
    KS(0x0080),
    MGS(0x0100),
    PRS(0x0200),
    ASS(0x0400),
    SHA(0x0800);

    private final int value;

    LootFilterSpec(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LootFilterSpec fromValue(int value) {
        for (LootFilterSpec e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
