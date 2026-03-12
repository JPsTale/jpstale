package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSellNPCShop : Packet。
 */

@Data
public class PacketSellNPCShop extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 20;

    private int item;  // Item sItem  size: 4 bytes
    private int[] seCode = new int[4];  // DWORD dwSeCode[4]  size: 16 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        item = in.getInt();
        for (int i = 0; i < seCode.length; i++) { seCode[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(item);
        for (int i = 0; i < seCode.length; i++) { out.putInt(seCode[i]); }
    }
}
