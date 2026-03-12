package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDeleteFlagPoint : Packet。
 */

@Data
public class PacketDeleteFlagPoint extends Packet {

    private int x;  // int iX
    private int z;  // int iZ

    @Override
    protected void readBody(ByteBuffer in) {
        x = in.getInt();
        z = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(x);
        out.putInt(z);
    }
}
