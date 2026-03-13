package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct DropItemData。
 */
@Data
public final class DropItemData {
    public static final int SIZE_OF = 12;

    private int itemId;   // int iItemID
    private int chk1;     // int iChk1
    private int chk2;     // DWORD iChk2

    public void readFrom(ByteBuffer in) {
        itemId = in.getInt();
        chk1 = in.getInt();
        chk2 = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(itemId);
        out.putInt(chk1);
        out.putInt(chk2);
    }
}
