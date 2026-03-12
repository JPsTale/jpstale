package org.jpstale.server.common.enums;

/**
 * 愤怒竞技场状态（对应 packets.h 中 EFuryArenaState）。
 */
public enum FuryArenaState {
    OpenNPC(0),
    RequestEnterArena(1),
    Enter(2),
    TeleportCT2(3),
    OpenNPCEntrance(4),
    Status(5),
    Exchange(6),
    EXP(7);

    private final int value;

    FuryArenaState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static FuryArenaState fromValue(int value) {
        FuryArenaState[] all = values();
        if (value >= 0 && value < all.length) return all[value];
        return OpenNPC;
    }
}
