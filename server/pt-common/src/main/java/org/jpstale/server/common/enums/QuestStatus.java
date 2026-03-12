package org.jpstale.server.common.enums;

/**
 * 对应 shared/quest.h 中的 EQuestStatus。
 */
public enum QuestStatus {
    NONE(0),
    KILLING(1),
    GET_ITEM(2),
    END_QUEST(3),
    FINISHED(2000),
    T5_QUEST1(2001); // 对应 QUESTSTATUSID_T5Quest1，值在 C++ 中为最后一个

    private final int value;

    QuestStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static QuestStatus fromValue(int value) {
        for (QuestStatus s : values()) {
            if (s.value == value) {
                return s;
            }
        }
        return NONE;
    }
}

