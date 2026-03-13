package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketHalloweenEventStatus : Packet。
 */

@Data
public class PacketHalloweenEventStatus extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private boolean status;  // BOOL bStatus  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        status = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(status ? 1 : 0);
    }
}
