package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 EItemInvSound（未指定底层类型，按 int），4 字节。
 */
public enum ItemInvSound {
    NONE(0),
    AXE(1),
    CLAW(2),
    ARMOR(9);

    private final int value;

    ItemInvSound(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ItemInvSound fromValue(int value) {
        for (ItemInvSound e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
