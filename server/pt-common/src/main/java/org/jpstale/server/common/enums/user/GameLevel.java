package org.jpstale.server.common.enums.user;

/**
 * 对应 C++ user.h 中 EGameLevel，4 字节（int）。
 */
public enum GameLevel {
    NONE(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private final int value;

    GameLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GameLevel fromValue(int value) {
        for (GameLevel g : values()) {
            if (g.value == value) return g;
        }
        return NONE;
    }
}
