package org.jpstale.server.common.enums.unit;

/**
 * 对应 C++ unit.h 中 EToolEquipModeTown : int，4 字节。
 */
public enum ToolEquipModeTown {
    /** Wearing Weapon as if in Battle */
    NONE(0),
    /** Wearing Weapon on the Back */
    BACK(1),
    /** Wearing Weapon on the Back for CrossBows */
    BACK_CROSS_BOW(2),
    /** Wearing Weapon on the Back for Bows */
    BACK_BOW(3);

    private final int value;

    ToolEquipModeTown(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ToolEquipModeTown fromValue(int value) {
        for (ToolEquipModeTown t : values()) {
            if (t.value == value) return t;
        }
        return NONE;
    }
}
