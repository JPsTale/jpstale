package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.item.ItemData;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWingItem : Packet。
 */

@Data
public class PacketWingItem extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1376;

    private int docIndex;  // int DocIndex  size: 4 bytes
    private int result;  // int Result  size: 4 bytes
    private ItemData desCraftItem;  // ItemData DesCraftItem  size: 1204 bytes
    private int[] sheltomCode = new int[12];  // DWORD SheltomCode[12]  size: 48 bytes
    private int[] head = new int[12];  // DWORD Head[12]  size: 48 bytes
    private int[] checkSum = new int[12];  // DWORD CheckSum[12]  size: 48 bytes
    private int index;  // int Index  size: 4 bytes
    private int money;  // int Money  size: 4 bytes
    private int aStoneItemCode;  // DWORD A_StoneItemCode  size: 4 bytes
    private int aStoneHead;  // DWORD A_StoneHead  size: 4 bytes
    private int aStoneCheckSum;  // DWORD A_StoneCheckSum  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        docIndex = in.getInt();
        result = in.getInt();
        if (desCraftItem == null) desCraftItem = new ItemData(); desCraftItem.readFrom(in);
        for (int i = 0; i < sheltomCode.length; i++) { sheltomCode[i] = in.getInt(); }
        for (int i = 0; i < head.length; i++) { head[i] = in.getInt(); }
        for (int i = 0; i < checkSum.length; i++) { checkSum[i] = in.getInt(); }
        index = in.getInt();
        money = in.getInt();
        aStoneItemCode = in.getInt();
        aStoneHead = in.getInt();
        aStoneCheckSum = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(docIndex);
        out.putInt(result);
        if (desCraftItem != null) desCraftItem.writeTo(out);
        for (int i = 0; i < sheltomCode.length; i++) { out.putInt(sheltomCode[i]); }
        for (int i = 0; i < head.length; i++) { out.putInt(head[i]); }
        for (int i = 0; i < checkSum.length; i++) { out.putInt(checkSum[i]); }
        out.putInt(index);
        out.putInt(money);
        out.putInt(aStoneItemCode);
        out.putInt(aStoneHead);
        out.putInt(aStoneCheckSum);
    }
}
