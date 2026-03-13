package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestNPCItemList : Packet。
 */

@Data
public class PacketQuestNPCItemList extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int id;  // int iID  size: 4 bytes
    private int index;  // int iIndex  size: 4 bytes
    private int quantity;  // int iQuantity  size: 4 bytes
    private boolean last;  // BOOL bLast  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        index = in.getInt();
        quantity = in.getInt();
        last = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(index);
        out.putInt(quantity);
        out.putInt(last ? 1 : 0);
    }
}
