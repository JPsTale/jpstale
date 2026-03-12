package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPersonalBotShopData : Packet。
 */

@Data
public class PacketPersonalBotShopData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 396;

    private String message;  // char szMessage[256]  size: 256 bytes
    private int[] cItemData = new int[32];  // ItemData cItemData[32]  size: 128 bytes
    private int[] price = new int[0];  // int iPrice[0]  size: 0 bytes
    private int[] items = new int[3];  // int iaItems[3]  size: 12 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        message = readCString(in, 256);
        for (int i = 0; i < cItemData.length; i++) { cItemData[i] = in.getInt(); }
        for (int i = 0; i < price.length; i++) { price[i] = in.getInt(); }
        for (int i = 0; i < items.length; i++) { items[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, message, 256);
        for (int i = 0; i < cItemData.length; i++) { out.putInt(cItemData[i]); }
        for (int i = 0; i < price.length; i++) { out.putInt(price[i]); }
        for (int i = 0; i < items.length; i++) { out.putInt(items[i]); }
    }
}
