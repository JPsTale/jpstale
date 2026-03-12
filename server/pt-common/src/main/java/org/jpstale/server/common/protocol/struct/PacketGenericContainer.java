package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketGenericContainer : Packet。
 */

@Data
public class PacketGenericContainer extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int count;  // int iCount  size: 4 bytes
    private int iParam;  // int iParam  size: 4 bytes
    private final byte[] buffer = new byte[0];  // BYTE baBuffer[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
        iParam = in.getInt();
        in.get(buffer);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
        out.putInt(iParam);
        out.put(buffer);
    }
}
