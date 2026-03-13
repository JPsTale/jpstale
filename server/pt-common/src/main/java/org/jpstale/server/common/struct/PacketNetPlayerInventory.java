package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerInventory : Packet。
 */

@Data
public class PacketNetPlayerInventory extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 3796;

    private int objectId;  // int ObjectID  size: 4 bytes
    private DropItemData[] intentoryItems = new DropItemData[316];  // DropItemData sIntentoryItems[316]  size: 3792 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
