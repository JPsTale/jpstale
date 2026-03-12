package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUpdatePetDataEx : Packet。
 */

@Data
public class PacketUpdatePetDataEx extends Packet {

    private int targetId;  // int iTargetID
    private int lastTargetId;  // int iLastTargetID

    @Override
    protected void readBody(ByteBuffer in) {
        targetId = in.getInt();
        lastTargetId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(targetId);
        out.putInt(lastTargetId);
    }
}
