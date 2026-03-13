package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSkillInfoContainer : Packet。
 */

@Data
public class PacketSkillInfoContainer extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 5032;

    private int characterClass;  // int iCharacterClass  size: 4 bytes
    private int count;  // int iCount  size: 4 bytes
    private SkillInfo[] skillInfo = new SkillInfo[16];  // SkillInfo saSkillInfo[16]  size: 5024 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
