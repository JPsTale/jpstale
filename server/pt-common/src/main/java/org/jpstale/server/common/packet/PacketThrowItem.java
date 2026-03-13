package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketThrowItem : Packet。
 */

@Data
public class PacketThrowItem extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1248;

    private Item item;  // Item sItem  size: 1220 bytes
    private Point3D position;  // Point3D sPosition  size: 12 bytes
    private int[] secCode = new int[4];  // DWORD dwSecCode[4]  size: 16 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (item == null) item = new Item(); item.readFrom(in);
        if (position == null) position = new Point3D(); position.readFrom(in);
        for (int i = 0; i < secCode.length; i++) { secCode[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (item != null) item.writeTo(out);
        if (position != null) position.writeTo(out);
        for (int i = 0; i < secCode.length; i++) { out.putInt(secCode[i]); }
    }
}
