package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetAgingEvent : Packet。
 */

@Data
public class PacketNetAgingEvent extends Packet {

    private boolean freeEnabled;  // BOOL FreeEnabled
    private boolean noBreakEnabled;  // BOOL NoBreakEnabled
    private boolean halfPrice;  // BOOL HalfPrice

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
