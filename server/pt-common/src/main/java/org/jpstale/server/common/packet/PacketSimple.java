package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSimple : Packet。
 */

@Data
public class PacketSimple extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int unk;  // int iUnk  size: 4 bytes
    private int unk2;  // int iUnk2  size: 4 bytes
    private int unk3;  // int iUnk3  size: 4 bytes
    private int unk4;  // int iUnk4  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        unk = in.getInt();
        unk2 = in.getInt();
        unk3 = in.getInt();
        unk4 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(unk);
        out.putInt(unk2);
        out.putInt(unk3);
        out.putInt(unk4);
    }
}
