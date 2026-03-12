package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketListUsingItem : Packet。
 */

@Data
public class PacketListUsingItem extends Packet {

    private int itemListCount;  // int iItemListCount
    private ItemUsing[] itemList = new ItemUsing[16];  // ItemUsing sItemList[16]

    @Override
    protected void readBody(ByteBuffer in) {
        itemListCount = in.getInt();
        for (int i = 0; i < itemList.length; i++) { if (itemList[i] == null) itemList[i] = new ItemUsing(); itemList[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(itemListCount);
        for (int i = 0; i < itemList.length; i++) { if (itemList[i] != null) itemList[i].writeTo(out); }
    }
}
