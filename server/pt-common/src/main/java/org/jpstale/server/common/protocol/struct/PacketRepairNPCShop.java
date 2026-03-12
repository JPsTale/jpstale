package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRepairNPCShop : Packet。
 */

@Data
public class PacketRepairNPCShop extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int money;  // int Money  size: 4 bytes
    private int itemData;  // ItemData sItemData  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        money = in.getInt();
        itemData = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(money);
        out.putInt(itemData);
    }
}
