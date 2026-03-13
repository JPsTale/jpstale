package org.jpstale.server.common.enums.item;

/**
 * 对应 C++ item.h 中 enum class EMixType : int，4 字节。
 */
public enum MixType {
    UNKNOWN(0),
    WEAPONS(1),
    ARMOUR_AND_ROBE(2),
    SHEILDS(3),
    ORBS(4),
    BRACELET(5),
    GAUNTLETS(6),
    BOOTS(7),
    AMULETS(8),
    RINGS(9);

    private final int value;

    MixType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MixType fromValue(int value) {
        for (MixType e : values()) {
            if (e.value == value) return e;
        }
        return UNKNOWN;
    }
}
