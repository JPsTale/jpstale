package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketItemPerfectView : Packet。
 */

@Data
public class PacketItemPerfectView extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1208;

    private ItemData itemData;  // ItemData cItemData  size: 1204 bytes
    private int defenseOverride;  // int iDefenseOverride  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (itemData == null) itemData = new ItemData(); itemData.readFrom(in);
        defenseOverride = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (itemData != null) itemData.writeTo(out);
        out.putInt(defenseOverride);
    }
}
