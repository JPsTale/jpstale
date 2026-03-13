package org.jpstale.server.common.enums.quest;

/**
 * 对应 C++ quest.h 中 EQuestDurationType，4 字节（int）。
 */
public enum QuestDurationType {
    NONE(0),
    RUNNING(1),
    AMOUNT(2);

    private final int value;

    QuestDurationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static QuestDurationType fromValue(int value) {
        for (QuestDurationType t : values()) {
            if (t.value == value) return t;
        }
        return NONE;
    }
}
