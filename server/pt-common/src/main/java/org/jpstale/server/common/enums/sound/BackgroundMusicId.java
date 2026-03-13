package org.jpstale.server.common.enums.sound;

/**
 * 对应 C++ sound.h 中 EBackgroundMusicID，4 字节（int）。
 */
public enum BackgroundMusicId {
    TRIGGERED(-1),
    DESERT(0),
    NAVISKO(1),
    RICARTEN(2),
    UNKNOWN1(3),
    FOREST(4),
    DUNGEON(5),
    PHILLAI(6),
    BELLATRA_123(7),
    BELLATRA_456(8),
    BELLATRA_78(9),
    DESERT_B(10),
    ICE(11),
    ATLANTIS(12),
    LOGIN(13),
    CHARACTER_SELECT(14),
    EURA(15),
    MYSTERY_FOREST(16),
    MYSTERY_DESERT(17),
    BATTLE(18),
    CHRISTMAS(19),
    QUEST_ARENA(20),
    BLESS_CASTLE(21),
    FURY_ARENA(22),
    SECRET_LABORATORY(23),
    HEART_OF_FIRE(24);

    private final int value;

    BackgroundMusicId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BackgroundMusicId fromValue(int value) {
        for (BackgroundMusicId id : values()) {
            if (id.value == value) return id;
        }
        return TRIGGERED;
    }
}
