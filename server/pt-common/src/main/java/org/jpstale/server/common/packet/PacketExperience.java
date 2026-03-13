package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketExperience : Packet。
 */

@Data
public class PacketExperience extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private long addExp;  // INT64 iAddExp  size: 8 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        addExp = in.getLong();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putLong(addExp);
    }
}
