package org.jpstale.server.common.enums;

/**
 * 对应 shared/item.h 中 enum EItemInvSound（未指定底层类型，按 int 处理）。size: 4 bytes
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
