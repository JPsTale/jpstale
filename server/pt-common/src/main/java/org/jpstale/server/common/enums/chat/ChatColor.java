package org.jpstale.server.common.enums.chat;

/**
 * 对应 C++ chat.h 中 EChatColor，4 字节（int）。
 */
public enum ChatColor {
    ERROR(0),       // Red
    WHISPER(1),     // Blue
    BLUE(2),        // Blue
    GLOBAL(3),      // Purple
    PARTY(4),       // Green
    CLAN(5),        // Yellow (clan)
    TRADE(6),       // Whitish Cyan (trade)
    NOTICE(9),      // Purple
    CLAN_LEADER(10), // Orange (clan leader)
    NORMAL(11),     // Yellow (normal chat)
    RAID(12),       // Cyan
    COMMAND(13),    // JLM - Cheap solution to do what we want on client side
    GAME_MASTER(14), // For sending chat to all game-masters online
    WHITE(15);

    private final int value;

    ChatColor(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ChatColor fromValue(int value) {
        for (ChatColor c : values()) {
            if (c.value == value) return c;
        }
        return ERROR;
    }
}
