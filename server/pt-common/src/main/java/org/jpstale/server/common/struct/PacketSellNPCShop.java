package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSellNPCShop : Packet。
 */

@Data
public class PacketSellNPCShop extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1236;

    private Item item;  // Item sItem  size: 1220 bytes
    private int[] seCode = new int[4];  // DWORD dwSeCode[4]  size: 16 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (item == null) item = new Item(); item.readFrom(in);
        for (int i = 0; i < seCode.length; i++) { seCode[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (item != null) item.writeTo(out);
        for (int i = 0; i < seCode.length; i++) { out.putInt(seCode[i]); }
    }
}
