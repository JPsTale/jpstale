package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSkillCancel : Packet。
 */

@Data
public class PacketSkillCancel extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int unk;  // int iUnk  size: 4 bytes
    private int playId;  // int iPlayID  size: 4 bytes
    private int unk2;  // int iUnk2  size: 4 bytes
    private int unk3;  // int iUnk3  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        unk = in.getInt();
        playId = in.getInt();
        unk2 = in.getInt();
        unk3 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(unk);
        out.putInt(playId);
        out.putInt(unk2);
        out.putInt(unk3);
    }
}
