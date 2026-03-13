package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRankingListClanSodList : Packet。
 */

@Data
public class PacketRankingListClanSodList extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 400;

    private String[] clanSodName = new String[10];  // char szClanSodName[10][32]  size: 320 bytes
    private int[] clanSodMemberCount = new int[10];  // int iClanSodMemberCount[10]  size: 40 bytes
    private int[] clanSodPoints = new int[10];  // int iClanSodPoints[10]  size: 40 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        for (int i = 0; i < 10; i++) { clanSodName[i] = readCString(in, 32); }
        for (int i = 0; i < clanSodMemberCount.length; i++) { clanSodMemberCount[i] = in.getInt(); }
        for (int i = 0; i < clanSodPoints.length; i++) { clanSodPoints[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        for (int i = 0; i < 10; i++) { writeCString(out, clanSodName[i], 32); }
        for (int i = 0; i < clanSodMemberCount.length; i++) { out.putInt(clanSodMemberCount[i]); }
        for (int i = 0; i < clanSodPoints.length; i++) { out.putInt(clanSodPoints[i]); }
    }
}
