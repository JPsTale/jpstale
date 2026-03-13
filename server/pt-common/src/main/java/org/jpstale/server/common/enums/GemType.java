package org.jpstale.server.common.enums;

/**
 * 对应 shared/item.h 中 enum EGemType : unsigned char。size: 1 byte
 */
public enum GemType {
    NONE(0),
    TRIANGULAR(1),
    SQUARE(2),
    MARQUISE(3);

    private final int value;

    GemType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GemType fromValue(int value) {
        for (GemType e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
