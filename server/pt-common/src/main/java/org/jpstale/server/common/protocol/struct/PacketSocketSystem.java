package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSocketSystem : Packet。
 */

@Data
public class PacketSocketSystem extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 32;

    private int itemData;  // ItemData sItemData  size: 4 bytes
    private int[] rune = new int[5];  // ItemData sRune[5]  size: 20 bytes
    private int itemStone;  // ItemData sItemStone  size: 4 bytes
    private int socketWorkType;  // int iSocketWorkType  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        itemData = in.getInt();
        for (int i = 0; i < rune.length; i++) { rune[i] = in.getInt(); }
        itemStone = in.getInt();
        socketWorkType = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(itemData);
        for (int i = 0; i < rune.length; i++) { out.putInt(rune[i]); }
        out.putInt(itemStone);
        out.putInt(socketWorkType);
    }
}
