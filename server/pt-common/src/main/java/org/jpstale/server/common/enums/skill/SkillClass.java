package org.jpstale.server.common.enums.skill;

/**
 * 对应 C++ skill.h 中 enum class ESkillClass，4 字节（int）。
 */
public enum SkillClass {
    UNDEFINED(0),
    PASSIVE(1),
    ACTIVE(2),
    BUFF_SELF(3),
    BUFF_PARTY(4),
    SUMMON(5);

    private final int value;

    SkillClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SkillClass fromValue(int value) {
        for (SkillClass c : values()) {
            if (c.value == value) return c;
        }
        return UNDEFINED;
    }
}
