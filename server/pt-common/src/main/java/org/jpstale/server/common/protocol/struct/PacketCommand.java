package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCommand : Packet。
 */

@Data
public class PacketCommand extends Packet {

    private int p2;  // int p2
    private int p1;  // int p1
    private int p3;  // int p3
    private int p4;  // int p4

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
