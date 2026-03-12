package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBellatraCrown : Packet。
 */

@Data
public class PacketBellatraCrown extends Packet {

    private int bellatraCrown;  // int iBellatraCrown

    @Override
    protected void readBody(ByteBuffer in) {
        bellatraCrown = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(bellatraCrown);
    }
}
