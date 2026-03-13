package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketContainer : Packet。
 */

@Data
public class PacketContainer extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private int amount;  // int iAmount  size: 4 bytes
    private final byte[] buffer = new byte[0];  // BYTE baBuffer[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
