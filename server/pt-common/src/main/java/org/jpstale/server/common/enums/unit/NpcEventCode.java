package org.jpstale.server.common.enums.unit;

/**
 * 对应 C++ unit.h 中 ENPCEventCode : int，4 字节。
 */
public enum NpcEventCode {
    FORCE(200),
    SMELTING(2),
    MANUFACTURE(3),
    RESET_ITEM(4),
    COIN_SHOP(5),
    FURY_ARENA_NPC_TELEPORT_CT2(6),
    FURY_ARENA_NPC_ENTER(7),
    SOCKET_SYSTEM_NPC_DRILL(8),
    SOCKET_SYSTEM_NPC_STONE(9),
    EASTER_NPC(10),
    LARRY_QUESTS_NPC(11),
    IHIN_EVENT(12),
    MARINA_QUESTS_NPC(13),
    RUDOLPH_CHRISTMAS_NPC(14),
    MIX_GUILD(15),
    RANK_LIST(16),
    SOLO_RANK_LIST(17),
    WAREHOUSE(20),
    WAREHOUSE_SEASONAL(21);

    private final int value;

    NpcEventCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static NpcEventCode fromValue(int value) {
        for (NpcEventCode c : values()) {
            if (c.value == value) return c;
        }
        return FORCE;
    }
}
