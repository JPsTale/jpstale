package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.ItemId;


/**
 * 对应 packets.h 中 struct PacketManufactureItem : Packet。
 */

@Data
public class PacketManufactureItem extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1280;

    private int uunknown;  // int iUunknown  size: 4 bytes
    private int result;  // int iResult  size: 4 bytes
    private ItemData itemData;  // ItemData sItemData  size: 1204 bytes
    private ItemId recipeId;  // EItemID iRecipeID  size: 4 bytes
    private ItemId[] runeId = new ItemId[3];  // EItemID iaRuneID[3]  size: 12 bytes
    private int recipeChk1;  // int iRecipeChk1  size: 4 bytes
    private int[] chk1 = new int[3];  // int iaChk1[3]  size: 12 bytes
    private int recipeChk2;  // int iRecipeChk2  size: 4 bytes
    private int[] chk2 = new int[3];  // int iaChk2[3]  size: 12 bytes
    private int index;  // int iIndex  size: 4 bytes
    private int gold;  // int iGold  size: 4 bytes
    private int exStoneItemCode;  // DWORD iExStoneItemCode  size: 4 bytes
    private int exStoneHead;  // DWORD iExStoneHead  size: 4 bytes
    private int exStoneCheckSum;  // DWORD iExStoneCheckSum  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        uunknown = in.getInt();
        result = in.getInt();
        if (itemData == null) itemData = new ItemData(); itemData.readFrom(in);
        recipeId = ItemId.fromValue(in.getInt());
        for (int i = 0; i < runeId.length; i++) { runeId[i] = ItemId.fromValue(in.getInt()); }
        recipeChk1 = in.getInt();
        for (int i = 0; i < chk1.length; i++) { chk1[i] = in.getInt(); }
        recipeChk2 = in.getInt();
        for (int i = 0; i < chk2.length; i++) { chk2[i] = in.getInt(); }
        index = in.getInt();
        gold = in.getInt();
        exStoneItemCode = in.getInt();
        exStoneHead = in.getInt();
        exStoneCheckSum = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(uunknown);
        out.putInt(result);
        if (itemData != null) itemData.writeTo(out);
        out.putInt(recipeId.getValue());
        for (int i = 0; i < runeId.length; i++) { out.putInt(runeId[i].getValue()); }
        out.putInt(recipeChk1);
        for (int i = 0; i < chk1.length; i++) { out.putInt(chk1[i]); }
        out.putInt(recipeChk2);
        for (int i = 0; i < chk2.length; i++) { out.putInt(chk2[i]); }
        out.putInt(index);
        out.putInt(gold);
        out.putInt(exStoneItemCode);
        out.putInt(exStoneHead);
        out.putInt(exStoneCheckSum);
    }
}
