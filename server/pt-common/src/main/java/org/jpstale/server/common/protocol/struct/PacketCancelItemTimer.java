package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.ItemId;
import org.jpstale.server.common.enums.ItemTimerType;


/**
 * 对应 packets.h 中 struct PacketCancelItemTimer : Packet。
 */

@Data
public class PacketCancelItemTimer extends Packet {

    private ItemTimerType type;  // EItemTimerType iType
    private ItemId itemId;  // EItemID iItemID

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
