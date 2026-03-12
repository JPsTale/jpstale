package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct DropItemData。
 */
@Data
public final class DropItemData {
    private int itemId;   // int iItemID
    private int chk1;     // int iChk1
    private int chk2;     // DWORD iChk2

    public void readFrom(ByteBuffer in) {
        itemId = in.getInt();
        chk1 = in.getInt();
        chk2 = in.getInt();
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(itemId);
        out.putInt(chk1);
        out.putInt(chk2);
    }
}
