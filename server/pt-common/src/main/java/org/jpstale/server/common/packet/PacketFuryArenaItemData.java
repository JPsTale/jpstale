package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketFuryArenaItemData : Packet。
 */

@Data
public class PacketFuryArenaItemData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1204;

    private ItemData itemData;  // ItemData sItemData  size: 1204 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (itemData == null) itemData = new ItemData(); itemData.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (itemData != null) itemData.writeTo(out);
    }
}
