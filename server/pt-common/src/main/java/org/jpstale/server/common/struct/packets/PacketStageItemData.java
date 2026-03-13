package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.StageItemData;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketStageItemData : Packet。
 */

@Data
public class PacketStageItemData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 3158;

    private boolean active;  // BOOL bActive  size: 4 bytes
    private int count;  // int iCount  size: 4 bytes
    private StageItemData[] items = new StageItemData[50];  // StageItemData saItems[50]  size: 3150 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
