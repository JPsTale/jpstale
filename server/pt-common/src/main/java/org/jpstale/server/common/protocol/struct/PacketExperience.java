package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketExperience : Packet。
 */

@Data
public class PacketExperience extends Packet {

    private long addExp;  // INT64 iAddExp

    @Override
    protected void readBody(ByteBuffer in) {
        addExp = in.getLong();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putLong(addExp);
    }
}
