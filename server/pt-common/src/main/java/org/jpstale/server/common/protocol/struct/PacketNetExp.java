package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetExp : Packet。
 */

@Data
public class PacketNetExp extends Packet {

    private int objectId;  // UINT uObjectID
    private long exp;  // INT64 iExp

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        exp = in.getLong();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putLong(exp);
    }
}
