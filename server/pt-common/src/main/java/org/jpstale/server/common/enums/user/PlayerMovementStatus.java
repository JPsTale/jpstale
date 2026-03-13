package org.jpstale.server.common.enums.user;

/**
 * 对应 C++ user.h 中 enum class EPlayerMovementStatus : UINT，4 字节。
 */
public enum PlayerMovementStatus {
    MOVING(0),
    STANDING_1_SEC(1),
    STANDING_4_SEC(2),
    STANDING_8_SEC(3),
    AFK(4);

    private final int value;

    PlayerMovementStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PlayerMovementStatus fromValue(int value) {
        for (PlayerMovementStatus s : values()) {
            if (s.value == value) return s;
        }
        return MOVING;
    }
}
