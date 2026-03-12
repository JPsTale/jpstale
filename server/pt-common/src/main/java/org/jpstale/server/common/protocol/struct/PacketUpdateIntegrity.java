package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUpdateIntegrity : Packet。
 */

@Data
public class PacketUpdateIntegrity extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private int update;  // EIntegrityUpdate eUpdate  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        update = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(update);
    }
}
