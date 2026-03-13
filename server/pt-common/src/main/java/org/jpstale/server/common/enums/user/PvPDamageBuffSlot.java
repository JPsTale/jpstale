package org.jpstale.server.common.enums.user;

/**
 * 对应 C++ user.h 中 enum class PvPDamageBuffSlot : uint8_t，1 字节。
 */
public enum PvPDamageBuffSlot {
    BURNING(0),
    POISON(1);

    private final int value;

    PvPDamageBuffSlot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PvPDamageBuffSlot fromValue(int value) {
        for (PvPDamageBuffSlot s : values()) {
            if (s.value == value) return s;
        }
        return BURNING;
    }
}
