package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerThrow : Packet。
 */

@Data
public class PacketNetPlayerThrow extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 20;

    private int objectId;  // int ObjectID  size: 4 bytes
    private DropItemData item;  // DropItemData Item  size: 12 bytes
    private int gold;  // int Gold  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        if (item == null) item = new DropItemData(); item.readFrom(in);
        gold = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        if (item != null) item.writeTo(out);
        out.putInt(gold);
    }
}
