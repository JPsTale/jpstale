package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketEventGirl : Packet。
 */

@Data
public class PacketEventGirl extends Packet {

    private boolean freeGold;  // BOOL bFreeGold

    @Override
    protected void readBody(ByteBuffer in) {
        freeGold = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(freeGold ? 1 : 0);
    }
}
