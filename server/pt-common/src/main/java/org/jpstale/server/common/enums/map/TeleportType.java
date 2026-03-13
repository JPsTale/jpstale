package org.jpstale.server.common.enums.map;

/**
 * 对应 C++ map.h 中 ETeleportType : unsigned int，4 字节。
 */
public enum TeleportType {
    DIRECT(0),
    WARP(1),
    WARP_GATE(2);

    private final int value;

    TeleportType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TeleportType fromValue(int value) {
        for (TeleportType t : values()) {
            if (t.value == value) return t;
        }
        return DIRECT;
    }
}
