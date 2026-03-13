package org.jpstale.server.common.enums.quest;

/**
 * 对应 C++ quest.h 中 enum class EQuestIcon : BYTE，1 字节。
 */
public enum QuestIcon {
    NONE(0),
    AVAILABLE(1),
    PROGRESS(2),
    COMPLETE(3),
    UNAVAILABLE(4),
    AVAILABLE_REPEATABLE(5),
    COMPLETE_REPEATABLE(6);

    private final int value;

    QuestIcon(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static QuestIcon fromValue(int value) {
        for (QuestIcon i : values()) {
            if (i.value == value) return i;
        }
        return NONE;
    }
}
