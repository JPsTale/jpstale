package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPingPong : Packet。
 */

@Data
public class PacketNetPingPong extends Packet {

    private int nothing;  // int iNothing

    @Override
    protected void readBody(ByteBuffer in) {
        nothing = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(nothing);
    }
}
