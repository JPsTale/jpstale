package org.jpstale.server.common.enums.map;

/**
 * 对应 C++ map.h 中 EMapType（未指定底层类型，按 int），4 字节。
 */
public enum MapType {
    TOWN(0x100),
    FOREST(0x200),
    DESERT(0x300),
    WASTELAND(0x400),
    DUNGEON(0x500),
    IRON(0x600),
    UNUSED_1(0x700),
    CHESS_ROOM(0x800),
    ICE(0x900),
    BLESS_CASTLE(0xA00),
    DISTORTED(0xB00),
    BATTLE_TOWN(0xC00);

    private final int value;

    MapType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MapType fromValue(int value) {
        for (MapType t : values()) {
            if (t.value == value) return t;
        }
        return TOWN;
    }
}
