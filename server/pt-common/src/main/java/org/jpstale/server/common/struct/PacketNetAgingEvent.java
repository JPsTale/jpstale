package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetAgingEvent : Packet。
 */

@Data
public class PacketNetAgingEvent extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private boolean freeEnabled;  // BOOL FreeEnabled  size: 4 bytes
    private boolean noBreakEnabled;  // BOOL NoBreakEnabled  size: 4 bytes
    private boolean halfPrice;  // BOOL HalfPrice  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        freeEnabled = in.getInt() != 0;
        noBreakEnabled = in.getInt() != 0;
        halfPrice = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(freeEnabled ? 1 : 0);
        out.putInt(noBreakEnabled ? 1 : 0);
        out.putInt(halfPrice ? 1 : 0);
    }
}
