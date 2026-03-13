package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRankingListIndividualSod : Packet。
 */

@Data
public class PacketRankingListIndividualSod extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 360;

    private String[] sodplayer = new String[10];  // char szSODPlayer[10][32]  size: 320 bytes
    private int[] sodplayerPoints = new int[10];  // int iSODPlayerPoints[10]  size: 40 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        for (int i = 0; i < 10; i++) { sodplayer[i] = readCString(in, 32); }
        for (int i = 0; i < sodplayerPoints.length; i++) { sodplayerPoints[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        for (int i = 0; i < 10; i++) { writeCString(out, sodplayer[i], 32); }
        for (int i = 0; i < sodplayerPoints.length; i++) { out.putInt(sodplayerPoints[i]); }
    }
}
