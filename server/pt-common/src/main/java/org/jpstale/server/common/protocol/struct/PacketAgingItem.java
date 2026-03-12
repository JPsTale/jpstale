package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketAgingItem : Packet。
 */

@Data
public class PacketAgingItem extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 176;

    private int docIndex;  // int DocIndex  size: 4 bytes
    private int result;  // int Result  size: 4 bytes
    private int item;  // ItemData sItem  size: 4 bytes
    private int[] sheltomCode = new int[12];  // DWORD SheltomCode[12]  size: 48 bytes
    private int[] head = new int[12];  // DWORD Head[12]  size: 48 bytes
    private int[] checkSum = new int[12];  // DWORD CheckSum[12]  size: 48 bytes
    private int index;  // int Index  size: 4 bytes
    private int money;  // int Money  size: 4 bytes
    private int stoneItemCode;  // DWORD StoneItemCode  size: 4 bytes
    private int stoneHead;  // DWORD StoneHead  size: 4 bytes
    private int stoneCheckSum;  // DWORD StoneCheckSum  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        docIndex = in.getInt();
        result = in.getInt();
        item = in.getInt();
        for (int i = 0; i < sheltomCode.length; i++) { sheltomCode[i] = in.getInt(); }
        for (int i = 0; i < head.length; i++) { head[i] = in.getInt(); }
        for (int i = 0; i < checkSum.length; i++) { checkSum[i] = in.getInt(); }
        index = in.getInt();
        money = in.getInt();
        stoneItemCode = in.getInt();
        stoneHead = in.getInt();
        stoneCheckSum = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(docIndex);
        out.putInt(result);
        out.putInt(item);
        for (int i = 0; i < sheltomCode.length; i++) { out.putInt(sheltomCode[i]); }
        for (int i = 0; i < head.length; i++) { out.putInt(head[i]); }
        for (int i = 0; i < checkSum.length; i++) { out.putInt(checkSum[i]); }
        out.putInt(index);
        out.putInt(money);
        out.putInt(stoneItemCode);
        out.putInt(stoneHead);
        out.putInt(stoneCheckSum);
    }
}
