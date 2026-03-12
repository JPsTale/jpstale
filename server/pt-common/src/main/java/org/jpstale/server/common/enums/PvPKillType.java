package org.jpstale.server.common.enums;

/**
 * PvP 连杀类型（对应 packets.h 中 EPvPKillType）。
 */
public enum PvPKillType {
    None(0),
    DoubleKill(1),
    TripleKill(2),
    QuadraKill(3),
    PentaKill(4),
    Shutdown(5),
    Rampage(6),
    Unstoppable(7),
    COUNT(8);

    private final int value;

    PvPKillType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PvPKillType fromValue(int value) {
        for (PvPKillType t : values()) {
            if (t.value == value) return t;
        }
        return None;
    }
}
