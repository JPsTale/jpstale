package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 ESlotTypeHandle，4 字节（int）。
 */
public enum SlotTypeHandle {
    GET(0),
    PUT(1);

    private final int value;

    SlotTypeHandle(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SlotTypeHandle fromValue(int value) {
        for (SlotTypeHandle t : values()) {
            if (t.value == value) return t;
        }
        return GET;
    }
}
