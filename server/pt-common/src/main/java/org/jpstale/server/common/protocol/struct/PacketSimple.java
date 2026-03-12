package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSimple : Packet。
 */

@Data
public class PacketSimple extends Packet {

    private int unk;  // int iUnk
    private int unk2;  // int iUnk2
    private int unk3;  // int iUnk3
    private int unk4;  // int iUnk4

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
