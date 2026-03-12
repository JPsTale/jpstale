package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPvPData : Packet。
 */

@Data
public class PacketPvPData extends Packet {

    private int pvpkills;  // int iPVPKills
    private int pvpdeaths;  // int iPVPDeaths
    private int pvpkillStreak;  // int iPVPKillStreak
    private boolean kill;  // BOOL bKill
    private int id;  // int iID

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
