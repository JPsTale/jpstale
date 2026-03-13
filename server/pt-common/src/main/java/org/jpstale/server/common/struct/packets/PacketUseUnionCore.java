package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.Point3D;
import org.jpstale.server.common.struct.item.Item;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUseUnionCore : Packet。
 */

@Data
public class PacketUseUnionCore extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1232;

    private Item item;  // Item sItem  size: 1220 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (item == null) item = new Item(); item.readFrom(in);
        if (position == null) position = new Point3D(); position.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (item != null) item.writeTo(out);
        if (position != null) position.writeTo(out);
    }
}
