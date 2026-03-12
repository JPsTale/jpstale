package org.jpstale.server.common.enums;

/**
 * 攻城战模式（对应 packets.h 中 ESiegeWarMode）。
 */
public enum SiegeWarMode {
    Normal(0),
    TheConquest(1),
    TheMassacre(2);

    private final int value;

    SiegeWarMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SiegeWarMode fromValue(int value) {
        for (SiegeWarMode m : values()) {
            if (m.value == value) return m;
        }
        return Normal;
    }
}
