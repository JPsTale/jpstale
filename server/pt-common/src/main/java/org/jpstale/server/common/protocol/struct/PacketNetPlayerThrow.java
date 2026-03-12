package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerThrow : Packet。
 */

@Data
public class PacketNetPlayerThrow extends Packet {

    private int objectId;  // int ObjectID
    private DropItemData item;  // DropItemData Item
    private int gold;  // int Gold

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
