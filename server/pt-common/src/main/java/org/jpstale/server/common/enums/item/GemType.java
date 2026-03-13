package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 EGemType : unsigned char，1 字节。
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
