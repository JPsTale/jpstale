package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayerTitleList : Packet。
 */

@Data
public class PacketPlayerTitleList extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 2;

    private short count;  // short iCount  size: 2 bytes
    private final byte[] data = new byte[0];  // BYTE baData[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getShort();
        in.get(data);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putShort(count);
        out.put(data);
    }
}
