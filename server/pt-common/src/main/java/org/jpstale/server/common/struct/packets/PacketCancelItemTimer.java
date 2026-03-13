package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.item.ItemId;
import org.jpstale.server.common.enums.item.ItemTimerType;


/**
 * 对应 packets.h 中 struct PacketCancelItemTimer : Packet。
 */

@Data
public class PacketCancelItemTimer extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private ItemTimerType type;  // EItemTimerType iType  size: 4 bytes
    private ItemId itemId;  // EItemID iItemID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        type = ItemTimerType.fromValue(in.getInt());
        itemId = ItemId.fromValue(in.getInt());
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(type.getValue());
        out.putInt(itemId.getValue());
    }
}
