package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCommandEx : Packet。
 */

@Data
public class PacketCommandEx extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 32;

    private int p2;  // int p2  size: 4 bytes
    private int p1;  // int p1  size: 4 bytes
    private int p3;  // int p3  size: 4 bytes
    private int p4;  // int p4  size: 4 bytes
    private int p6;  // int p6  size: 4 bytes
    private int p5;  // int p5  size: 4 bytes
    private int p7;  // int p7  size: 4 bytes
    private int p8;  // int p8  size: 4 bytes

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
        p6 = in.getInt();
        p5 = in.getInt();
        p7 = in.getInt();
        p8 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(p2);
        out.putInt(p1);
        out.putInt(p3);
        out.putInt(p4);
        out.putInt(p6);
        out.putInt(p5);
        out.putInt(p7);
        out.putInt(p8);
    }
}
