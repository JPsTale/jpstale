package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCommand : Packet。
 */

@Data
public class PacketCommand extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int p2;  // int p2  size: 4 bytes
    private int p1;  // int p1  size: 4 bytes
    private int p3;  // int p3  size: 4 bytes
    private int p4;  // int p4  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        p2 = in.getInt();
        p1 = in.getInt();
        p3 = in.getInt();
        p4 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(p2);
        out.putInt(p1);
        out.putInt(p3);
        out.putInt(p4);
    }
}
