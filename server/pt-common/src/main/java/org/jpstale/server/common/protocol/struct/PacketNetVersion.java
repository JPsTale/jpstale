package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetVersion : Packet。
 */

@Data
public class PacketNetVersion extends Packet {

    private int version;  // int iVersion

    @Override
    protected void readBody(ByteBuffer in) {
        version = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(version);
    }
}
