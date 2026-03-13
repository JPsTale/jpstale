package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketResetItem : Packet。
 */

@Data
public class PacketResetItem extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1228;

    private int docIndex;  // int iDocIndex  size: 4 bytes
    private int result;  // int iResult  size: 4 bytes
    private int index;  // int iIndex  size: 4 bytes
    private ItemData itemData;  // ItemData sItemData  size: 1204 bytes
    private int code;  // DWORD dwCode  size: 4 bytes
    private int head;  // DWORD dwHead  size: 4 bytes
    private int checkSum;  // DWORD dwCheckSum  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        docIndex = in.getInt();
        result = in.getInt();
        index = in.getInt();
        if (itemData == null) itemData = new ItemData(); itemData.readFrom(in);
        code = in.getInt();
        head = in.getInt();
        checkSum = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(docIndex);
        out.putInt(result);
        out.putInt(index);
        if (itemData != null) itemData.writeTo(out);
        out.putInt(code);
        out.putInt(head);
        out.putInt(checkSum);
    }
}
