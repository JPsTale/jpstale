package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.item.ItemId;
import org.jpstale.server.common.enums.item.ItemTimerType;


/**
 * 对应 packets.h 中 struct PacketNewItemTimer : Packet。
 */

@Data
public class PacketNewItemTimer extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 24;

    private ItemTimerType type;  // EItemTimerType iType  size: 4 bytes
    private ItemId itemId;  // EItemID iItemID  size: 4 bytes
    private int chk1;  // int iChk1  size: 4 bytes
    private int chk2;  // int iChk2  size: 4 bytes
    private int timeLeft;  // DWORD dwTimeLeft  size: 4 bytes
    private int timeTotal;  // DWORD dwTimeTotal  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
