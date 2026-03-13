package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSocketSystem : Packet。
 */

@Data
public class PacketSocketSystem extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8432;

    private ItemData itemData;  // ItemData sItemData  size: 1204 bytes
    private ItemData[] rune = new ItemData[5];  // ItemData sRune[5]  size: 6020 bytes
    private ItemData itemStone;  // ItemData sItemStone  size: 1204 bytes
    private int socketWorkType;  // int iSocketWorkType  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (itemData == null) itemData = new ItemData(); itemData.readFrom(in);
        for (int i = 0; i < rune.length; i++) { if (rune[i] == null) rune[i] = new ItemData(); rune[i].readFrom(in); }
        if (itemStone == null) itemStone = new ItemData(); itemStone.readFrom(in);
        socketWorkType = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (itemData != null) itemData.writeTo(out);
        for (int i = 0; i < rune.length; i++) { if (rune[i] != null) rune[i].writeTo(out); }
        if (itemStone != null) itemStone.writeTo(out);
        out.putInt(socketWorkType);
    }
}
