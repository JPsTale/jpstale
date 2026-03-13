package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRecoverItem : Packet。
 */

@Data
public class PacketRecoverItem extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private int status;  // int iStatus  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        status = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(status);
    }
}
