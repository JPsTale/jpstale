package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetGetExp : Packet。
 */

@Data
public class PacketNetGetExp extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private int objectId;  // UINT uObjectID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
    }
}
