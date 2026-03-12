package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketAgingEvent : Packet。
 */

@Data
public class PacketAgingEvent extends Packet {

    private boolean freeAging;  // BOOL bFreeAging
    private boolean noBreak;  // BOOL bNoBreak
    private boolean halfPrice;  // BOOL bHalfPrice

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
