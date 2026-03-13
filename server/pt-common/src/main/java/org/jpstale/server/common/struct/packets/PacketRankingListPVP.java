package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRankingListPVP : Packet。
 */

@Data
public class PacketRankingListPVP extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 400;

    private String[] pvpcharName = new String[10];  // char szPVPCharName[10][32]  size: 320 bytes
    private int[] pvpkills = new int[10];  // int iPVPKills[10]  size: 40 bytes
    private int[] pvpdeaths = new int[10];  // int iPVPDeaths[10]  size: 40 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        for (int i = 0; i < 10; i++) { pvpcharName[i] = readCString(in, 32); }
        for (int i = 0; i < pvpkills.length; i++) { pvpkills[i] = in.getInt(); }
        for (int i = 0; i < pvpdeaths.length; i++) { pvpdeaths[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        for (int i = 0; i < 10; i++) { writeCString(out, pvpcharName[i], 32); }
        for (int i = 0; i < pvpkills.length; i++) { out.putInt(pvpkills[i]); }
        for (int i = 0; i < pvpdeaths.length; i++) { out.putInt(pvpdeaths[i]); }
    }
}
