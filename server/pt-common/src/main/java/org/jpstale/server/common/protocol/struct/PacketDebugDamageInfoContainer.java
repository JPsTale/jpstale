package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDebugDamageInfoContainer : Packet。
 */

@Data
public class PacketDebugDamageInfoContainer extends Packet {

    private short amount;  // USHORT sAmount
    private final byte[] buffer = new byte[0];  // BYTE baBuffer[0]

    @Override
    protected void readBody(ByteBuffer in) {
        amount = in.getShort();
        in.get(buffer);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putShort(amount);
        out.put(buffer);
    }
}
