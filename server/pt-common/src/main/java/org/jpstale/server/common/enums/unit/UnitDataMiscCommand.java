package org.jpstale.server.common.enums.unit;

/**
 * 对应 C++ unit.h 中 EUnitDataMiscCommand : int，4 字节。
 */
public enum UnitDataMiscCommand {
    /** Player the skill animation effect on success mix / aging */
    SHOW_SUCCESS_AGING_OR_MIX_SKILL_ANIMATION(0);

    private final int value;

    UnitDataMiscCommand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UnitDataMiscCommand fromValue(int value) {
        for (UnitDataMiscCommand c : values()) {
            if (c.value == value) return c;
        }
        return SHOW_SUCCESS_AGING_OR_MIX_SKILL_ANIMATION;
    }
}
