package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.ItemId;
import org.jpstale.server.common.enums.ItemTimerType;


/**
 * 对应 packets.h 中 struct PacketNewItemTimer : Packet。
 */

@Data
public class PacketNewItemTimer extends Packet {

    private ItemTimerType type;  // EItemTimerType iType
    private ItemId itemId;  // EItemID iItemID
    private int chk1;  // int iChk1
    private int chk2;  // int iChk2
    private int timeLeft;  // DWORD dwTimeLeft
    private int timeTotal;  // DWORD dwTimeTotal

    @Override
    protected void readBody(ByteBuffer in) {
        type = ItemTimerType.fromValue(in.getInt());
        itemId = ItemId.fromValue(in.getInt());
        chk1 = in.getInt();
        chk2 = in.getInt();
        timeLeft = in.getInt();
        timeTotal = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(type.getValue());
        out.putInt(itemId.getValue());
        out.putInt(chk1);
        out.putInt(chk2);
        out.putInt(timeLeft);
        out.putInt(timeTotal);
    }
}
