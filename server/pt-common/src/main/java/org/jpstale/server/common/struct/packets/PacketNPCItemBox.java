package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.item.Item;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNPCItemBox : Packet。
 */

@Data
public class PacketNPCItemBox extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1408;

    private String itemName;  // char szItemName[32]  size: 32 bytes
    private String message;  // char szMessage[128]  size: 128 bytes
    private int itemId;  // int iItemID  size: 4 bytes
    private int specialization;  // int iSpecialization  size: 4 bytes
    private int[] reserved = new int[3];  // DWORD dwReserved[3]  size: 12 bytes
    private short weight;  // short sWeight  size: 2 bytes
    private short unknown;  // short sUnknown  size: 2 bytes
    private boolean item;  // BOOL bItem  size: 4 bytes
    private Item sItem;  // Item sItem  size: 1220 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        itemName = readCString(in, 32);
        message = readCString(in, 128);
        itemId = in.getInt();
        specialization = in.getInt();
        for (int i = 0; i < reserved.length; i++) { reserved[i] = in.getInt(); }
        weight = in.getShort();
        unknown = in.getShort();
        item = in.getInt() != 0;
        if (sItem == null) sItem = new Item(); sItem.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, itemName, 32);
        writeCString(out, message, 128);
        out.putInt(itemId);
        out.putInt(specialization);
        for (int i = 0; i < reserved.length; i++) { out.putInt(reserved[i]); }
        out.putShort(weight);
        out.putShort(unknown);
        out.putInt(item ? 1 : 0);
        if (sItem != null) sItem.writeTo(out);
    }
}
