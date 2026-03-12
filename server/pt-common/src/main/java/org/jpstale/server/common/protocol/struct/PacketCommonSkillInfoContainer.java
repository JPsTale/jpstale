package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCommonSkillInfoContainer : Packet。
 */

@Data
public class PacketCommonSkillInfoContainer extends Packet {

    private int count;  // int iCount
    private SkillInfoCommon[] data = new SkillInfoCommon[25];  // SkillInfoCommon saData[25]

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
        for (int i = 0; i < data.length; i++) { if (data[i] == null) data[i] = new SkillInfoCommon(); data[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
        for (int i = 0; i < data.length; i++) { if (data[i] != null) data[i].writeTo(out); }
    }
}
