package org.jpstale.server.common.enums.quest;

/**
 * 对应 C++ quest.h 中 EQuestStatus，4 字节（int）。
 */
public enum QuestStatus {
    NONE(0),
    KILLING(1),
    GET_ITEM(2),
    END_QUEST(3),
    FINISHED(2000),
    T5_QUEST1(2001);

    private final int value;

    QuestStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static QuestStatus fromValue(int value) {
        for (QuestStatus s : values()) {
            if (s.value == value) return s;
        }
        return NONE;
    }
}
