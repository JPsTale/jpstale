package org.jpstale.server.common.enums.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 对应 C++ map.h 中 EMapID : int，4 字节。
 */
public enum MapId {
    INVALID(-1),
    ACASIA_FOREST(0),
    BAMBOO_FOREST(1),
    GARDEN_OF_FREEDOM(2),
    RICARTEN_TOWN(3),
    REFUGE_OF_THE_ANCIENTS(4),
    CASTLE_OF_THE_LOST(5),
    RUINEN_VILLAGE(6),
    CURSED_LAND(7),
    FORGOTTEN_LAND(8),
    NAVISKO_TOWN(9),
    OASIS(10),
    ANCIENTS_BATTLEFIELD(11),
    FORBIDDEN_LAND(12),
    ANCIENT_PRISON_F1(13),
    ANCIENT_PRISON_F2(14),
    ANCIENT_PRISON_F3(15),
    CHESS_ROOM(16),
    FOREST_OF_SPIRITS(17),
    LAND_OF_DUSK(18),
    VALLEY_OF_TRANQUILITY(19),
    ROAD_TO_THE_WIND(20),
    PILLAI_TOWN(21),
    CURSED_TEMPLE_F1(22),
    CURSED_TEMPLE_F2(23),
    MUSHROOM_CAVE(24),
    BEEHIVE_CAVE(25),
    DARK_SANCTUARY(26),
    RAILWAY_OF_CHAOS(27),
    HEART_OF_PERUM(28),
    EURA(29),
    BELLATRA(30),
    GALLUBIA_VALLEY(31),
    QUEST_ARENA(32),
    BLESS_CASTLE(33),
    GREEDY_LAKE(34),
    FROZEN_SANCTUARY(35),
    KELVEZU_LAIR(36),
    LAND_OF_CHAOS(37),
    LOST_TEMPLE(38),
    GHOST_CASTLE(39),
    ENDLESS_TOWER_F1(40),
    ENDLESS_TOWER_F2(41),
    CURSED_TEMPLE_F3(42),
    ENDLESS_TOWER_F3(43),
    ICE_MINE_F1(44),
    ATLANTIS(45),
    MYSTERY_FOREST1(46),
    MYSTERY_FOREST2(47),
    MYSTERY_FOREST3(48),
    BATTLE_TOWN(49),
    MYSTERY_DESERT3(50),
    MYSTERY_DESERT2(51),
    MYSTERY_DESERT1(52),
    FORGOTTEN_TEMPLE_F1(53),
    FORGOTTEN_TEMPLE_F2(54),
    ANCIENT_DUNGEON_F1(55),
    ANCIENT_DUNGEON_F2(56),
    ANCIENT_DUNGEON_F3(57),
    ANCIENT_WEAPON(58),
    SEA_OF_ABYSS1(59),
    T5_QUEST_ARENA(60),
    SECRET_LABORATORY(61),
    SEA_OF_ABYSS2(62),
    HEART_OF_FIRE(63),
    WIND_FOREST1(64),
    WIND_FOREST2(65),
    SECRET_LAB2(66);

    private final int value;

    private static final Map<Integer, MapId> BY_VALUE = new HashMap<>();

    static {
        for (MapId id : values()) {
            BY_VALUE.putIfAbsent(id.value, id);
        }
    }

    MapId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MapId fromValue(int value) {
        return BY_VALUE.getOrDefault(value, INVALID);
    }
}
