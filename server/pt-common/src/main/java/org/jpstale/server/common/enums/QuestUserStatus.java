package org.jpstale.server.common.enums;

/**
 * 对应 shared/quest.h 中的 enum class EQuestUserStatus。
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
            if (s.value == value) {
                return s;
            }
        }
        return ERROR;
    }
}

