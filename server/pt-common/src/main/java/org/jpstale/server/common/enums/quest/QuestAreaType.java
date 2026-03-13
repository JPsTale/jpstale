package org.jpstale.server.common.enums.quest;

/**
 * 对应 C++ quest.h 中 EQuestAreaType，4 字节（int）。
 */
public enum QuestAreaType {
    NONE(0),
    BOUND(1),
    RADIUS(2);

    private final int value;

    QuestAreaType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static QuestAreaType fromValue(int value) {
        for (QuestAreaType t : values()) {
            if (t.value == value) return t;
        }
        return NONE;
    }
}
