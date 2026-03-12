package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketHalloweenEventStatus : Packet。
 */

@Data
public class PacketHalloweenEventStatus extends Packet {

    private boolean status;  // BOOL bStatus

    @Override
    protected void readBody(ByteBuffer in) {
        status = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(status ? 1 : 0);
    }
}
