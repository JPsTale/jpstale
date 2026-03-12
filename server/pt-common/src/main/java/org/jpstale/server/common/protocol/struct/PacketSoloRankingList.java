package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSoloRankingList : Packet。
 */

@Data
public class PacketSoloRankingList extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1448;

    private int rankingType;  // int iRankingType  size: 4 bytes
    private int count;  // int iCount  size: 4 bytes
    private String[] characterName = new String[30];  // char szCharacterName[30][32]  size: 960 bytes
    private int[] clazz = new int[30];  // int iClass[30]  size: 120 bytes
    private int[] level = new int[30];  // int iLevel[30]  size: 120 bytes
    private int[] kills = new int[30];  // int iKills[30]  size: 120 bytes
    private int[] score = new int[30];  // int iScore[30]  size: 120 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        rankingType = in.getInt();
        count = in.getInt();
        for (int i = 0; i < 30; i++) { characterName[i] = readCString(in, 32); }
        for (int i = 0; i < clazz.length; i++) { clazz[i] = in.getInt(); }
        for (int i = 0; i < level.length; i++) { level[i] = in.getInt(); }
        for (int i = 0; i < kills.length; i++) { kills[i] = in.getInt(); }
        for (int i = 0; i < score.length; i++) { score[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(rankingType);
        out.putInt(count);
        for (int i = 0; i < 30; i++) { writeCString(out, characterName[i], 32); }
        for (int i = 0; i < clazz.length; i++) { out.putInt(clazz[i]); }
        for (int i = 0; i < level.length; i++) { out.putInt(level[i]); }
        for (int i = 0; i < kills.length; i++) { out.putInt(kills[i]); }
        for (int i = 0; i < score.length; i++) { out.putInt(score[i]); }
    }
}
