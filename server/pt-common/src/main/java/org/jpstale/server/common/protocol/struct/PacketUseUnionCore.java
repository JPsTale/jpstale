package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUseUnionCore : Packet。
 */

@Data
public class PacketUseUnionCore extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int item;  // Item sItem  size: 4 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        item = in.getInt();
        if (position == null) position = new Point3D(); position.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(item);
        if (position != null) position.writeTo(out);
    }
}
