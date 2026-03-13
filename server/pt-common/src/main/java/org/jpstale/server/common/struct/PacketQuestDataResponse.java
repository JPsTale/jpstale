package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.quest.QuestExtraRewardType;


/**
 * 对应 packets.h 中 struct PacketQuestDataResponse : Packet。
 */

@Data
public class PacketQuestDataResponse extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12439;

    private int questId;  // int iQuestID  size: 4 bytes
    private String startText;  // char szStartText[64]  size: 64 bytes
    private String tipText;  // char szTipText[64]  size: 64 bytes
    private String endText;  // char szEndText[64]  size: 64 bytes
    private byte numOfReqMonsters;  // BYTE bNumOfReqMonsters  size: 1 bytes
    private short[] reqMonstersCounts = new short[0];  // USHORT saReqMonstersCounts[0]  size: 0 bytes
    private String[] reqMonsterNames = new String[0];  // char szaReqMonsterNames[0][32]  size: 0 bytes
    private byte numOfReqItems;  // BYTE bNumOfReqItems  size: 1 bytes
    private short[] reqItemsCounts = new short[0];  // USHORT saReqItemsCounts[0]  size: 0 bytes
    private int[] reqItemIds = new int[0];  // int iaReqItemIds[0]  size: 0 bytes
    private short mapId;  // short sMapID  size: 2 bytes
    private long expReward;  // INT64 iExpReward  size: 8 bytes
    private short extraRewardCount;  // short sExtraRewardCount  size: 2 bytes
    private QuestExtraRewardType[] extraRewardType = new QuestExtraRewardType[3];  // EQuestExtraRewardType sExtraRewardType[3]  size: 12 bytes
    private int[] extraRewardValue = new int[3];  // UINT uExtraRewardValue[3]  size: 12 bytes
    private boolean itemSelect;  // BOOL bItemSelect  size: 4 bytes
    private byte itemCount;  // BYTE bItemCount  size: 1 bytes
    private Item[] rewardItem = new Item[10];  // Item saRewardItem[10]  size: 12200 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        questId = in.getInt();
        startText = readCString(in, 64);
        tipText = readCString(in, 64);
        endText = readCString(in, 64);
        numOfReqMonsters = in.get();
        for (int i = 0; i < reqMonstersCounts.length; i++) { reqMonstersCounts[i] = in.getShort(); }
        for (int i = 0; i < 0; i++) { reqMonsterNames[i] = readCString(in, 32); }
        numOfReqItems = in.get();
        for (int i = 0; i < reqItemsCounts.length; i++) { reqItemsCounts[i] = in.getShort(); }
        for (int i = 0; i < reqItemIds.length; i++) { reqItemIds[i] = in.getInt(); }
        mapId = in.getShort();
        expReward = in.getLong();
        extraRewardCount = in.getShort();
        for (int i = 0; i < extraRewardType.length; i++) { extraRewardType[i] = QuestExtraRewardType.fromValue(in.getInt()); }
        for (int i = 0; i < extraRewardValue.length; i++) { extraRewardValue[i] = in.getInt(); }
        itemSelect = in.getInt() != 0;
        itemCount = in.get();
        for (int i = 0; i < rewardItem.length; i++) { if (rewardItem[i] == null) rewardItem[i] = new Item(); rewardItem[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(questId);
        writeCString(out, startText, 64);
        writeCString(out, tipText, 64);
        writeCString(out, endText, 64);
        out.put(numOfReqMonsters);
        for (int i = 0; i < reqMonstersCounts.length; i++) { out.putShort(reqMonstersCounts[i]); }
        for (int i = 0; i < 0; i++) { writeCString(out, reqMonsterNames[i], 32); }
        out.put(numOfReqItems);
        for (int i = 0; i < reqItemsCounts.length; i++) { out.putShort(reqItemsCounts[i]); }
        for (int i = 0; i < reqItemIds.length; i++) { out.putInt(reqItemIds[i]); }
        out.putShort(mapId);
        out.putLong(expReward);
        out.putShort(extraRewardCount);
        for (int i = 0; i < extraRewardType.length; i++) { out.putInt(extraRewardType[i].getValue()); }
        for (int i = 0; i < extraRewardValue.length; i++) { out.putInt(extraRewardValue[i]); }
        out.putInt(itemSelect ? 1 : 0);
        out.put(itemCount);
        for (int i = 0; i < rewardItem.length; i++) { if (rewardItem[i] != null) rewardItem[i].writeTo(out); }
    }
}
