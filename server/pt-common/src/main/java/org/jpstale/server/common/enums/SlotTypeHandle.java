package org.jpstale.server.common.enums;

/**
 * 对应 shared/item.h 中 ESlotTypeHandle。
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
            if (t.value == value) {
                return t;
            }
        }
        return GET;
    }
}

