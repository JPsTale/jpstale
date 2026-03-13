package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 enum class EMixColor : unsigned short，2 字节。
 */
public enum MixColor {
    NONE(0),
    CLASSIC(5),
    TRANSPARO(6),
    MURKY(7),
    DEVINE(8),
    CELESTO(9),
    MIRAGE(10),
    INFERNA(11),
    ENIGMA(12),
    BELLUM(13),
    OREDO(14);

    private final int value;

    MixColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MixColor fromValue(int value) {
        for (MixColor e : values()) {
            if (e.value == value) return e;
        }
        return NONE;
    }
}
