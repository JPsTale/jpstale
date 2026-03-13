package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetExp : Packet。
 */

@Data
public class PacketNetExp extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int objectId;  // UINT uObjectID  size: 4 bytes
    private long exp;  // INT64 iExp  size: 8 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        exp = in.getLong();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putLong(exp);
    }
}
