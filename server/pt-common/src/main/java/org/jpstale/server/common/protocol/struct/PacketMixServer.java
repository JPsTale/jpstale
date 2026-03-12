package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketMixServer : Packet。
 */

@Data
public class PacketMixServer extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1376;

    private int docIndex;  // int iDocIndex  size: 4 bytes
    private int result;  // int iResult  size: 4 bytes
    private ItemData itemData;  // ItemData sItemData  size: 1204 bytes
    private int[] code = new int[12];  // DWORD dwCode[12]  size: 48 bytes
    private int[] head = new int[12];  // DWORD dwHead[12]  size: 48 bytes
    private int[] checkSum = new int[12];  // DWORD dwCheckSum[12]  size: 48 bytes
    private int index;  // int iIndex  size: 4 bytes
    private int gold;  // int iGold  size: 4 bytes
    private int stoneItemCode;  // DWORD dwStoneItemCode  size: 4 bytes
    private int stoneHead;  // DWORD dwStoneHead  size: 4 bytes
    private int stoneCheckSum;  // DWORD dwStoneCheckSum  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        docIndex = in.getInt();
        result = in.getInt();
        if (itemData == null) itemData = new ItemData(); itemData.readFrom(in);
        for (int i = 0; i < code.length; i++) { code[i] = in.getInt(); }
        for (int i = 0; i < head.length; i++) { head[i] = in.getInt(); }
        for (int i = 0; i < checkSum.length; i++) { checkSum[i] = in.getInt(); }
        index = in.getInt();
        gold = in.getInt();
        stoneItemCode = in.getInt();
        stoneHead = in.getInt();
        stoneCheckSum = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(docIndex);
        out.putInt(result);
        if (itemData != null) itemData.writeTo(out);
        for (int i = 0; i < code.length; i++) { out.putInt(code[i]); }
        for (int i = 0; i < head.length; i++) { out.putInt(head[i]); }
        for (int i = 0; i < checkSum.length; i++) { out.putInt(checkSum[i]); }
        out.putInt(index);
        out.putInt(gold);
        out.putInt(stoneItemCode);
        out.putInt(stoneHead);
        out.putInt(stoneCheckSum);
    }
}
