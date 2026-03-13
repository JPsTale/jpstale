package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestWeaponMature : Packet。
 */

@Data
public class PacketQuestWeaponMature extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1220;

    private Item item;  // Item sItem  size: 1220 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (item == null) item = new Item(); item.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (item != null) item.writeTo(out);
    }
}
