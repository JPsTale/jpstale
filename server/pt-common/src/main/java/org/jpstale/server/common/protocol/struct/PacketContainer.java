package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketContainer : Packet。
 */

@Data
public class PacketContainer extends Packet {

    private int amount;  // int iAmount
    private final byte[] buffer = new byte[0];  // BYTE baBuffer[0]

    @Override
    protected void readBody(ByteBuffer in) {
        amount = in.getInt();
        in.get(buffer);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(amount);
        out.put(buffer);
    }
}
