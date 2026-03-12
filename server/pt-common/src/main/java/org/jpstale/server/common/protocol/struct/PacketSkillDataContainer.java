package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSkillDataContainer : Packet。
 */

@Data
public class PacketSkillDataContainer extends Packet {

    private int characterClass;  // int iCharacterClass
    private int count;  // int iCount
    private SkillArrayData[] skillArrayData = new SkillArrayData[150];  // SkillArrayData skillArrayData[150]

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
