package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSendUseUnionCore : Packet。
 */

@Data
public class PacketSendUseUnionCore extends Packet {

    private int y;  // int iY
    private int x;  // int iX
    private int z;  // int iZ
    private int mapId;  // int iMapID
    private int itemHead;  // DWORD dwItemHead
    private int itemId;  // DWORD dwItemID
    private int itemChecksum;  // DWORD dwItemChecksum
    private int unk;  // DWORD dwUnk

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
