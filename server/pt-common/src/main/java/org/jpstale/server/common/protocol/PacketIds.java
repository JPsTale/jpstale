package org.jpstale.server.common.protocol;

/**
 * Packet header IDs (align with C++ / PristonTale-EU protocol).
 */
public final class PacketIds {
    private PacketIds() {}

    /** Login request (e.g. PKTHDR_LoginUser). */
    public static final int LOGIN_USER = 0x01;
    // Add more as needed from C++ headers
}
