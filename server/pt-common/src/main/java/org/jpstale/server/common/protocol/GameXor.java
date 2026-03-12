package org.jpstale.server.common.protocol;

/**
 * XOR key for packet framing (align with PristonTale-EU shared/def.h GAME_XOR).
 * GAME_XOR = (((GAME_VERSION * 519 * 16510 * 14 + 595) % 180) + 20), GAME_VERSION=1309 → 75.
 */
public final class GameXor {
    private GameXor() {}

    public static final int GAME_VERSION = 1309;
    public static final byte XOR_KEY = (byte) ((((GAME_VERSION * 519 * 16510 * 14 + 595) % 180) + 20) & 0xFF);
}
