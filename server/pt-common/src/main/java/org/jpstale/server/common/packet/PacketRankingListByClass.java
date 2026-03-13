package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRankingListByClass : Packet。
 */

@Data
public class PacketRankingListByClass extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1808;

    private int clazz;  // int iClass  size: 4 bytes
    private int count;  // int iCount  size: 4 bytes
    private String[] characterName = new String[50];  // char szCharacterName[50][32]  size: 1600 bytes
    private int[] level = new int[50];  // int iLevel[50]  size: 200 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        clazz = in.getInt();
        count = in.getInt();
        for (int i = 0; i < 50; i++) { characterName[i] = readCString(in, 32); }
        for (int i = 0; i < level.length; i++) { level[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(clazz);
        out.putInt(count);
        for (int i = 0; i < 50; i++) { writeCString(out, characterName[i], 32); }
        for (int i = 0; i < level.length; i++) { out.putInt(level[i]); }
    }
}
