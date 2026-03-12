package org.jpstale.server.common.enums;

/**
 * 对应 shared/quest.h 中 enum class EQuestType : BYTE。
 */
public enum QuestType {
    NONE(0),
    SOLO_ONE_OFF(1),
    PARTY_ONE_OFF(2),
    DAILY(3),
    DAILY_MID_NIGHT(4),
    DAILY_WEEK(5),
    DAILY_MONTH(6),
    REPEATABLE(7),
    WEEKEND(8),
    WEEKEND_DAILY(9),
    WEEKEND_DAILY_MID_NIGHT(10),
    WEEKEND_REPEATABLE(11),
    WEEK_FRIDAY(12);

    private final int value;

    QuestType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static QuestType fromValue(int value) {
        for (QuestType t : values()) {
            if (t.value == value) {
                return t;
            }
        }
        return NONE;
    }
}

