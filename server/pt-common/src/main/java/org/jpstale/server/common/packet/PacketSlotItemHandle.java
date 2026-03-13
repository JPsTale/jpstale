package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.item.SlotTypeHandle;
import org.jpstale.server.common.enums.item.SlotTypeHandleWhere;


/**
 * 对应 packets.h 中 struct PacketSlotItemHandle : Packet。
 */

@Data
public class PacketSlotItemHandle extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 20;

    private SlotTypeHandle typeHandle;  // ESlotTypeHandle iTypeHandle  size: 4 bytes
    private SlotTypeHandleWhere typeWhere;  // ESlotTypeHandleWhere iTypeWhere  size: 4 bytes
    private int itemId;  // int iItemID  size: 4 bytes
    private int chk1;  // int iChk1  size: 4 bytes
    private int chk2;  // int iChk2  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        typeHandle = SlotTypeHandle.fromValue(in.getInt());
        typeWhere = SlotTypeHandleWhere.fromValue(in.getInt());
        itemId = in.getInt();
        chk1 = in.getInt();
        chk2 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(typeHandle.getValue());
        out.putInt(typeWhere.getValue());
        out.putInt(itemId);
        out.putInt(chk1);
        out.putInt(chk2);
    }
}
