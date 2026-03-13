package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSendUseUnionCore : Packet。
 */

@Data
public class PacketSendUseUnionCore extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 32;

    private int y;  // int iY  size: 4 bytes
    private int x;  // int iX  size: 4 bytes
    private int z;  // int iZ  size: 4 bytes
    private int mapId;  // int iMapID  size: 4 bytes
    private int itemHead;  // DWORD dwItemHead  size: 4 bytes
    private int itemId;  // DWORD dwItemID  size: 4 bytes
    private int itemChecksum;  // DWORD dwItemChecksum  size: 4 bytes
    private int unk;  // DWORD dwUnk  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        y = in.getInt();
        x = in.getInt();
        z = in.getInt();
        mapId = in.getInt();
        itemHead = in.getInt();
        itemId = in.getInt();
        itemChecksum = in.getInt();
        unk = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(y);
        out.putInt(x);
        out.putInt(z);
        out.putInt(mapId);
        out.putInt(itemHead);
        out.putInt(itemId);
        out.putInt(itemChecksum);
        out.putInt(unk);
    }
}
