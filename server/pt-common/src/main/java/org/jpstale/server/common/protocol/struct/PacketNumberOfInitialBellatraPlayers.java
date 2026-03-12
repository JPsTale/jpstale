package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNumberOfInitialBellatraPlayers : Packet。
 */

@Data
public class PacketNumberOfInitialBellatraPlayers extends Packet {

    private int count;  // int iCount

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
    }
}
