package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRankingListIndividualSod : Packet。
 */

@Data
public class PacketRankingListIndividualSod extends Packet {

    private String[] sodplayer = new String[10];  // char szSODPlayer[10][32]
    private int[] sodplayerPoints = new int[10];  // int iSODPlayerPoints[10]

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
