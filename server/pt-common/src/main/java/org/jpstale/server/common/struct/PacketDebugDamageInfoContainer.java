package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDebugDamageInfoContainer : Packet。
 */

@Data
public class PacketDebugDamageInfoContainer extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 2;

    private short amount;  // USHORT sAmount  size: 2 bytes
    private final byte[] buffer = new byte[0];  // BYTE baBuffer[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
