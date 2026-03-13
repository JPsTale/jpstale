package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTeleportEvent : Packet。
 */

@Data
public class PacketTeleportEvent extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private int teleportEventId;  // int iTeleportEventID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        teleportEventId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(teleportEventId);
    }
}
