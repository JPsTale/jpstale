package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerInventory : Packet。
 */

@Data
public class PacketNetPlayerInventory extends Packet {

    private int objectId;  // int ObjectID
    private DropItemData[] intentoryItems = new DropItemData[316];  // DropItemData sIntentoryItems[316]

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        for (int i = 0; i < intentoryItems.length; i++) { if (intentoryItems[i] == null) intentoryItems[i] = new DropItemData(); intentoryItems[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        for (int i = 0; i < intentoryItems.length; i++) { if (intentoryItems[i] != null) intentoryItems[i].writeTo(out); }
    }
}
