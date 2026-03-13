package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketGetItem : Packet。
 */

@Data
public class PacketGetItem extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int state;  // int iState  size: 4 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        state = in.getInt();
        if (position == null) position = new Point3D(); position.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(state);
        if (position != null) position.writeTo(out);
    }
}
