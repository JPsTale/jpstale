package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRankingListAllPlayer : Packet。
 */

@Data
public class PacketRankingListAllPlayer extends Packet {

    private int rankingType;  // int iRankingType
    private int count;  // int iCount
    private String[] characterName = new String[50];  // char szCharacterName[50][32]
    private int[] clazz = new int[50];  // int iClass[50]
    private int[] level = new int[50];  // int iLevel[50]
    private long[] experience = new long[50];  // uint64_t iExperience[50]

    @Override
    protected void readBody(ByteBuffer in) {
        rankingType = in.getInt();
        count = in.getInt();
        for (int i = 0; i < 50; i++) { characterName[i] = readCString(in, 32); }
        for (int i = 0; i < clazz.length; i++) { clazz[i] = in.getInt(); }
        for (int i = 0; i < level.length; i++) { level[i] = in.getInt(); }
        for (int i = 0; i < experience.length; i++) { experience[i] = in.getLong(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(rankingType);
        out.putInt(count);
        for (int i = 0; i < 50; i++) { writeCString(out, characterName[i], 32); }
        for (int i = 0; i < clazz.length; i++) { out.putInt(clazz[i]); }
        for (int i = 0; i < level.length; i++) { out.putInt(level[i]); }
        for (int i = 0; i < experience.length; i++) { out.putLong(experience[i]); }
    }
}
