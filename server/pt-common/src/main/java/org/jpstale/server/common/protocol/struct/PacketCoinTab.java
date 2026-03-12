package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCoinTab : Packet。
 */

@Data
public class PacketCoinTab extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private short packetNumber;  // short sPacketNumber  size: 2 bytes
    private short packetMax;  // short sPacketMax  size: 2 bytes
    private int id;  // int iID  size: 4 bytes
    private int items;  // int iItems  size: 4 bytes
    private Item[] aItems = new Item[0];  // Item aItems[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        packetNumber = in.getShort();
        packetMax = in.getShort();
        id = in.getInt();
        items = in.getInt();
        for (int i = 0; i < aItems.length; i++) { if (aItems[i] == null) aItems[i] = new Item(); aItems[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putShort(packetNumber);
        out.putShort(packetMax);
        out.putInt(id);
        out.putInt(items);
        for (int i = 0; i < aItems.length; i++) { if (aItems[i] != null) aItems[i].writeTo(out); }
    }
}
