package org.jpstale.server.common.enums;

/**
 * 角色种族（对应 packets.h 中 ECharacterRace）。
 */
public enum CharacterRace {
    Tempskron(0),
    Morion(1);

    private final int value;

    CharacterRace(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static CharacterRace fromValue(int value) {
        for (CharacterRace r : values()) {
            if (r.value == value) return r;
        }
        return Tempskron;
    }
}
