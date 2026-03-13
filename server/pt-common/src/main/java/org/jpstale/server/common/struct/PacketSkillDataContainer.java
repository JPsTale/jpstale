package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSkillDataContainer : Packet。
 */

@Data
public class PacketSkillDataContainer extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 7208;

    private int characterClass;  // int iCharacterClass  size: 4 bytes
    private int count;  // int iCount  size: 4 bytes
    private SkillArrayData[] skillArrayData = new SkillArrayData[150];  // SkillArrayData skillArrayData[150]  size: 7200 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        characterClass = in.getInt();
        count = in.getInt();
        for (int i = 0; i < skillArrayData.length; i++) { if (skillArrayData[i] == null) skillArrayData[i] = new SkillArrayData(); skillArrayData[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(characterClass);
        out.putInt(count);
        for (int i = 0; i < skillArrayData.length; i++) { if (skillArrayData[i] != null) skillArrayData[i].writeTo(out); }
    }
}
