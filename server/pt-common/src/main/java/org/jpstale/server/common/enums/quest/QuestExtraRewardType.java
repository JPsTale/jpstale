package org.jpstale.server.common.enums.quest;

/**
 * 对应 C++ quest.h 中 enum class EQuestExtraRewardType : int，4 字节。
 */
public enum QuestExtraRewardType {
    NONE(0),
    GOLD(1),
    WAREHOUSE_PAGE(2),
    EXP_POT_BUFF(3),
    THIRD_EYE_BUFF(4),
    HP_UP_BUFF(5),
    MP_UP_BUFF(6),
    STAT_POINT(7),
    SKILL_POINT(8),
    STAT_POINT_PER_LVL(9),
    DECREASE_DEATH_PENALTY(10),
    EXTRA_HEALTH(11),
    RANK_UP(12),
    QUEST_WEAPON(13),
    SIXTH_SENSE_BUFF(14);

    private final int value;

    QuestExtraRewardType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static QuestExtraRewardType fromValue(int value) {
        for (QuestExtraRewardType t : values()) {
            if (t.value == value) return t;
        }
        return NONE;
    }
}
