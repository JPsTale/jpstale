package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSkillBuffStatusContainer : Packet。
 */

@Data
public class PacketSkillBuffStatusContainer extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 406;

    private int targetId;  // ID iTargetID  size: 4 bytes
    private short count;  // USHORT sCount  size: 2 bytes
    private int[] buff = new int[100];  // PacketSkillBuffStatus saBuff[100]  size: 400 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        targetId = in.getInt();
        count = in.getShort();
        for (int i = 0; i < buff.length; i++) { buff[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(targetId);
        out.putShort(count);
        for (int i = 0; i < buff.length; i++) { out.putInt(buff[i]); }
    }
}
