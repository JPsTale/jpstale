package org.jpstale.server.common.protocol.account;

/**
 * 角色日志操作类型（对应 account.h 中 ECharacterLog）。
 */
public enum CharacterLog {
    Create(1),
    Delete(2),
    Update(3);

    private final int value;

    CharacterLog(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CharacterLog fromValue(int value) {
        for (CharacterLog e : values()) {
            if (e.value == value) return e;
        }
        return Create;
    }
}
