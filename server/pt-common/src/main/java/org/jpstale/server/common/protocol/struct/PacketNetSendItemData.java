package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.ItemSource;


/**
 * 对应 packets.h 中 struct PacketNetSendItemData : Packet。
 */

@Data
public class PacketNetSendItemData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 9;

    private int userId;  // ID dwUserID  size: 4 bytes
    private int itemId;  // int iItemID  size: 4 bytes
    private ItemSource itemSource;  // EItemSource eItemSource  size: 1 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        userId = in.getInt();
        itemId = in.getInt();
        itemSource = ItemSource.fromValue(in.get() & 0xFF);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(userId);
        out.putInt(itemId);
        out.put((byte) itemSource.getValue());
    }
}
