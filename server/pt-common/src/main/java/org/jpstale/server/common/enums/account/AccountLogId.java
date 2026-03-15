package org.jpstale.server.common.enums.account;

/**
 * 对应 C++ structaccount.h 中 ELogAccount（AccountLog 表的 log_id）。
 * iLogAccountBase = 500。
 */
public enum AccountLogId {
    LOGIN_SUCCESS(501),
    INCORRECT_ACCOUNT(502),
    INCORRECT_PASSWORD(503),
    BLOCKED_ACCOUNT(504),
    NOT_ACTIVATED_ACCOUNT(505),
    CHARACTER_SELECT_SEND(506),
    CHARACTER_CREATED(507),
    RECEIVED_POST_BOX(508),
    CHARACTER_DELETED(509),
    UNBLOCKED_ACCOUNT(510),
    CHARACTER_SAVE(511),
    UNUSED(512),
    TEMP_BAN_ACCOUNT(513),
    CHARACTER_QUEST_GOT(801),
    CHARACTER_QUEST_CANCEL(802),
    CHARACTER_QUEST_FINISHED(803),
    CHARACTER_QUEST_EXP(804),
    CHARACTER_EXP_LOSE(805),
    CHARACTER_LOAD(806);

    private final int value;

    AccountLogId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AccountLogId fromValue(int value) {
        for (AccountLogId e : values()) {
            if (e.value == value) return e;
        }
        return null;
    }
}
