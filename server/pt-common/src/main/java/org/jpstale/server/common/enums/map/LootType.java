package org.jpstale.server.common.enums.map;

/**
 * 对应 C++ map.h 中 enum class ELootType : int，4 字节。
 */
public enum LootType {
    UNKNOWN(-1),
    NONE(0),
    INITIAL(1),
    EXCLUSIVE(2);

    private final int value;

    LootType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LootType fromValue(int value) {
        for (LootType t : values()) {
            if (t.value == value) return t;
        }
        return UNKNOWN;
    }
}
