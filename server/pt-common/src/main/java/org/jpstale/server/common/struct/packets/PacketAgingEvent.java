package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketAgingEvent : Packet。
 */

@Data
public class PacketAgingEvent extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private boolean freeAging;  // BOOL bFreeAging  size: 4 bytes
    private boolean noBreak;  // BOOL bNoBreak  size: 4 bytes
    private boolean halfPrice;  // BOOL bHalfPrice  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        freeAging = in.getInt() != 0;
        noBreak = in.getInt() != 0;
        halfPrice = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(freeAging ? 1 : 0);
        out.putInt(noBreak ? 1 : 0);
        out.putInt(halfPrice ? 1 : 0);
    }
}
