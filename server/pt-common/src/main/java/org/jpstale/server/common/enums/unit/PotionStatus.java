package org.jpstale.server.common.enums.unit;

/**
 * 对应 C++ unit.h 中 EPotionStatus : int，4 字节。
 */
public enum PotionStatus {
    HP(1),
    MP(2),
    SP(3),
    HP_MP_SP(4),
    ETHER_CORE(0x40);

    private final int value;

    PotionStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PotionStatus fromValue(int value) {
        for (PotionStatus s : values()) {
            if (s.value == value) return s;
        }
        return HP;
    }
}
