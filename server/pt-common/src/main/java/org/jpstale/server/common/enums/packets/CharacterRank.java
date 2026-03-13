package org.jpstale.server.common.enums.packets;

/**
 * 角色 rank（对应 packets.h 中 ECharacterRank）。
 */
public enum CharacterRank {
    Error(-1),
    Rank1(0),
    Rank2(1),
    Rank3(2),
    Rank4(3),
    Rank5(4),
    Rank6(5),
    Rank7(6),
    Rank8(7);

    private final int value;

    CharacterRank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CharacterRank fromValue(int value) {
        for (CharacterRank r : values()) {
            if (r.value == value) return r;
        }
        return Error;
    }
}
