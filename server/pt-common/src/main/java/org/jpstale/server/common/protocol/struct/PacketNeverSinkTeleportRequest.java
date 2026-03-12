package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNeverSinkTeleportRequest : Packet。
 */

@Data
public class PacketNeverSinkTeleportRequest extends Packet {

    private int fieldId;  // ID fieldID

    @Override
    protected void readBody(ByteBuffer in) {
        fieldId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(fieldId);
    }
}
