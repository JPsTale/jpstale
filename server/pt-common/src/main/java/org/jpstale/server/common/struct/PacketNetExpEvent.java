package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetExpEvent : Packet。
 */

@Data
public class PacketNetExpEvent extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private int percent;  // int iPercent  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        percent = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(percent);
    }
}
