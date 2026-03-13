package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketEvasion : Packet。
 */

@Data
public class PacketEvasion extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int skillId;  // int iSkillID  size: 4 bytes
    private int unk;  // int iUnk  size: 4 bytes
    private int objectId;  // DWORD dwObjectID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        skillId = in.getInt();
        unk = in.getInt();
        objectId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(skillId);
        out.putInt(unk);
        out.putInt(objectId);
    }
}
