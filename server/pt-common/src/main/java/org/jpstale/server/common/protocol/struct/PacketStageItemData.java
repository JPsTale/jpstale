package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketStageItemData : Packet。
 */

@Data
public class PacketStageItemData extends Packet {

    private boolean active;  // BOOL bActive
    private int count;  // int iCount
    private StageItemData[] items = new StageItemData[50];  // StageItemData saItems[50]

    @Override
    protected void readBody(ByteBuffer in) {
        active = in.getInt() != 0;
        count = in.getInt();
        for (int i = 0; i < items.length; i++) { if (items[i] == null) items[i] = new StageItemData(); items[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(active ? 1 : 0);
        out.putInt(count);
        for (int i = 0; i < items.length; i++) { if (items[i] != null) items[i].writeTo(out); }
    }
}
