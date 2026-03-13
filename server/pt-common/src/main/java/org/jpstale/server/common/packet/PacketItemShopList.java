package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketItemShopList : Packet。
 */

@Data
public class PacketItemShopList extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 24;

    private int shopType;  // int iShopType  size: 4 bytes
    private int itemCount;  // int iItemCount  size: 4 bytes
    private int uniqueId;  // int iUniqueID  size: 4 bytes
    private int npcid;  // int iNPCID  size: 4 bytes
    private int[] unk001 = new int[2];  // int iUnk001[2]  size: 8 bytes
    private String buffer;  // char szBuffer[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        shopType = in.getInt();
        itemCount = in.getInt();
        uniqueId = in.getInt();
        npcid = in.getInt();
        for (int i = 0; i < unk001.length; i++) { unk001[i] = in.getInt(); }
        buffer = readCString(in, 0);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(shopType);
        out.putInt(itemCount);
        out.putInt(uniqueId);
        out.putInt(npcid);
        for (int i = 0; i < unk001.length; i++) { out.putInt(unk001[i]); }
        writeCString(out, buffer, 0);
    }
}
