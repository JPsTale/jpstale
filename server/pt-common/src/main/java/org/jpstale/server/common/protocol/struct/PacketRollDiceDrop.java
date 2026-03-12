package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.ItemId;


/**
 * 对应 packets.h 中 struct PacketRollDiceDrop : Packet。
 */

@Data
public class PacketRollDiceDrop extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int id;  // int iID  size: 4 bytes
    private ItemId itemId;  // EItemID eItemID  size: 4 bytes
    private boolean acceptItem;  // BOOL bAcceptItem  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        itemId = ItemId.fromValue(in.getInt());
        acceptItem = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(itemId.getValue());
        out.putInt(acceptItem ? 1 : 0);
    }
}
