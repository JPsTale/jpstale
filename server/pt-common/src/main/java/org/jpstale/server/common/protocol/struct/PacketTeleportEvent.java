package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTeleportEvent : Packet。
 */

@Data
public class PacketTeleportEvent extends Packet {

    private int teleportEventId;  // int iTeleportEventID

    @Override
    protected void readBody(ByteBuffer in) {
        teleportEventId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(teleportEventId);
    }
}
