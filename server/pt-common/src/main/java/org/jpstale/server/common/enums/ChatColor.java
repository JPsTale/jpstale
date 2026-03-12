package org.jpstale.server.common.enums;

/**
 * 对应 shared/chat.h 中的 EChatColor。
 */
public enum ChatColor {
    ERROR(0),
    WHISPER(1),
    BLUE(2),
    GLOBAL(3),
    PARTY(4),
    CLAN(5),
    TRADE(6),
    NOTICE(9),
    CLAN_LEADER(10),
    NORMAL(11),
    RAID(12),
    COMMAND(13),
    GAME_MASTER(14),
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
            if (c.value == value) {
                return c;
            }
        }
        return ERROR;
    }
}

