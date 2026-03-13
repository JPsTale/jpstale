package org.jpstale.server.common.enums.quest;

/**
 * 对应 C++ quest.h 中 enum class EQuestUserStatus，4 字节（int）。
 */
public enum QuestUserStatus {
    NOT_STARTED(0),
    IN_PROGRESS(1),
    EXPIRED(2),
    COMPLETED(3),
    DONE(4),
    ERROR(5);

    private final int value;

    QuestUserStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static QuestUserStatus fromValue(int value) {
        for (QuestUserStatus s : values()) {
            if (s.value == value) return s;
        }
        return ERROR;
    }
}
