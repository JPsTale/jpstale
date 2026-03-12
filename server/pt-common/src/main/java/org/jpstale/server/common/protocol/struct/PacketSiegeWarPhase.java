package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSiegeWarPhase : Packet。
 */

@Data
public class PacketSiegeWarPhase extends Packet {

    private int phaseId;  // int iPhaseID

    @Override
    protected void readBody(ByteBuffer in) {
        phaseId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(phaseId);
    }
}
