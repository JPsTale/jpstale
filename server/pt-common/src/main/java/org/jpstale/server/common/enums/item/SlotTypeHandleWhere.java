package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 ESlotTypeHandleWhere，4 字节（int）。
 */
public enum SlotTypeHandleWhere {
    PERFECTIZE(0),
    SWAP(1);

    private final int value;

    SlotTypeHandleWhere(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SlotTypeHandleWhere fromValue(int value) {
        for (SlotTypeHandleWhere t : values()) {
            if (t.value == value) return t;
        }
        return PERFECTIZE;
    }
}
