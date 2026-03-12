package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCommandEx : Packet。
 */

@Data
public class PacketCommandEx extends Packet {

    private int p2;  // int p2
    private int p1;  // int p1
    private int p3;  // int p3
    private int p4;  // int p4
    private int p6;  // int p6
    private int p5;  // int p5
    private int p7;  // int p7
    private int p8;  // int p8

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
