package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBuyNPCShop : Packet。
 */

@Data
public class PacketBuyNPCShop extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1216;

    private ItemData itemData;  // ItemData sItemData  size: 1204 bytes
    private int count;  // int iCount  size: 4 bytes
    private int uniqueId;  // int iUniqueID  size: 4 bytes
    private int npcid;  // int iNPCID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (itemData == null) itemData = new ItemData(); itemData.readFrom(in);
        count = in.getInt();
        uniqueId = in.getInt();
        npcid = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (itemData != null) itemData.writeTo(out);
        out.putInt(count);
        out.putInt(uniqueId);
        out.putInt(npcid);
    }
}
