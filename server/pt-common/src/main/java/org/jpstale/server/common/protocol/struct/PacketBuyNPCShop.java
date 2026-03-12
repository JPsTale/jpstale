package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBuyNPCShop : Packet。
 */

@Data
public class PacketBuyNPCShop extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int itemData;  // ItemData sItemData  size: 4 bytes
    private int count;  // int iCount  size: 4 bytes
    private int uniqueId;  // int iUniqueID  size: 4 bytes
    private int npcid;  // int iNPCID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        itemData = in.getInt();
        count = in.getInt();
        uniqueId = in.getInt();
        npcid = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(itemData);
        out.putInt(count);
        out.putInt(uniqueId);
        out.putInt(npcid);
    }
}
