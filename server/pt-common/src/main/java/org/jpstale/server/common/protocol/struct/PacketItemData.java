package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketItemData : Packet。
 */

@Data
public class PacketItemData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int itemIndex;  // int iItemIndex  size: 4 bytes
    private int item;  // ItemData sItem  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        itemIndex = in.getInt();
        item = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(itemIndex);
        out.putInt(item);
    }
}
