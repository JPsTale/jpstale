package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 ESocketType : unsigned char，1 字节。
 */
public enum SocketType {
    NONE(0),
    PRISMATIC(1),
    EMERALD(2),
    RUBY(3),
    AQUAMARINE(4),
    AMETHYST(5),
    TOPAZ(6);
    // SOCKETTYPE_Count = 7

    private final int value;

    SocketType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SocketType fromValue(int value) {
        for (SocketType e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
