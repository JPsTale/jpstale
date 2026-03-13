package org.jpstale.server.common.enums.unit;

/**
 * 对应 C++ unit.h 中 ENPCID : int，4 字节。
 */
public enum NpcId {
    EVENT_GIRL(1),
    ITEM_DISTRIBUTOR(2),
    WAREHOUSE_DO_NOT_USE(3),
    FORCE(4),
    CASTLE_CONTROL(5),
    AGING(6),
    SMELTING(7),
    CLAN_CONTROL(8),
    TELEPORT(9),
    SKILL_MASTER(10),
    MIXING(11),
    MANUFACTURING(12),
    WARP_GATE(13),
    BELLATRA(14),
    RESET_ITEM(15),
    COIN_SHOP(16),
    FURY_ARENA_NPC(17),
    FURY_ARENA_NPC_ENTER(18),
    SOCKET_SYSTEM_NPC_DRILL(19),
    SOCKET_SYSTEM_NPC_STONE(20),
    NPC_EASTER_EGG(21),
    LARRY_QUESTS(22),
    IHIN_EVENT(23),
    MARINA_QUESTS(24),
    RUDOLPH_CHRISTMAS(25),
    MIX_GUILD(26),
    RANK_LIST(27),
    SOLO_RANK_LIST(28),
    WAREHOUSE(30),
    WAREHOUSE_SEASONAL(31);

    private final int value;

    NpcId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static NpcId fromValue(int value) {
        for (NpcId id : values()) {
            if (id.value == value) return id;
        }
        return EVENT_GIRL;
    }
}
