package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.SkillInfoCommon;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCommonSkillInfoContainer : Packet。
 */

@Data
public class PacketCommonSkillInfoContainer extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 6254;

    private int count;  // int iCount  size: 4 bytes
    private SkillInfoCommon[] data = new SkillInfoCommon[25];  // SkillInfoCommon saData[25]  size: 6250 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
