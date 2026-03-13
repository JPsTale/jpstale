package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPvPData : Packet。
 */

@Data
public class PacketPvPData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 20;

    private int pvpkills;  // int iPVPKills  size: 4 bytes
    private int pvpdeaths;  // int iPVPDeaths  size: 4 bytes
    private int pvpkillStreak;  // int iPVPKillStreak  size: 4 bytes
    private boolean kill;  // BOOL bKill  size: 4 bytes
    private int id;  // int iID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        pvpkills = in.getInt();
        pvpdeaths = in.getInt();
        pvpkillStreak = in.getInt();
        kill = in.getInt() != 0;
        id = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(pvpkills);
        out.putInt(pvpdeaths);
        out.putInt(pvpkillStreak);
        out.putInt(kill ? 1 : 0);
        out.putInt(id);
    }
}
