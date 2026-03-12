package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSkillInfoContainer : Packet。
 */

@Data
public class PacketSkillInfoContainer extends Packet {

    private int characterClass;  // int iCharacterClass
    private int count;  // int iCount
    private SkillInfo[] skillInfo = new SkillInfo[16];  // SkillInfo saSkillInfo[16]

    @Override
    protected void readBody(ByteBuffer in) {
        characterClass = in.getInt();
        count = in.getInt();
        for (int i = 0; i < skillInfo.length; i++) { if (skillInfo[i] == null) skillInfo[i] = new SkillInfo(); skillInfo[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(characterClass);
        out.putInt(count);
        for (int i = 0; i < skillInfo.length; i++) { if (skillInfo[i] != null) skillInfo[i].writeTo(out); }
    }
}
