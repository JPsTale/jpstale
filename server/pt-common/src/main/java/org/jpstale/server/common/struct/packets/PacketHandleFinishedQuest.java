package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.SystemTime;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.quest.AsmQuestBit;
import org.jpstale.server.common.enums.quest.QuestExtraRewardType;
import org.jpstale.server.common.enums.quest.QuestPartyType;
import org.jpstale.server.common.enums.quest.QuestType;


/**
 * 对应 packets.h 中 struct PacketHandleFinishedQuest : Packet。
 */

@Data
public class PacketHandleFinishedQuest extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 168;

    private int id;  // int iID  size: 4 bytes
    private String questName;  // char szQuestName[40]  size: 40 bytes
    private String questGroupName;  // char szQuestGroupName[32]  size: 32 bytes
    private QuestPartyType questPartyType;  // EQuestPartyType eQuestPartyType  size: 1 bytes
    private QuestType type;  // EQuestType eType  size: 1 bytes
    private byte minLevel;  // BYTE iMinLevel  size: 1 bytes
    private byte maxLevel;  // BYTE iMaxLevel  size: 1 bytes
    private short giverNpcId;  // short sGiverNpcID  size: 2 bytes
    private short mapId;  // short sMapID  size: 2 bytes
    private short mainQuestId;  // short sMainQuestID  size: 2 bytes
    private short groupNum;  // short sGroupNum  size: 2 bytes
    private SystemTime startDate;  // SYSTEMTIME sStartDate  size: 16 bytes
    private SystemTime endDate;  // SYSTEMTIME sEndDate  size: 16 bytes
    private QuestExtraRewardType[] extraReward = new QuestExtraRewardType[5];  // EQuestExtraRewardType iaExtraReward[5]  size: 20 bytes
    private int[] extraRewardValue = new int[5];  // UINT iaExtraRewardValue[5]  size: 20 bytes
    private AsmQuestBit asmQuestBit;  // EAsmQuestBit eAsmQuestBit  size: 4 bytes
    private boolean loginTime;  // BOOL bLoginTime  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        questName = readCString(in, 40);
        questGroupName = readCString(in, 32);
        questPartyType = QuestPartyType.fromValue(in.get() & 0xFF);
        type = QuestType.fromValue(in.get() & 0xFF);
        minLevel = in.get();
        maxLevel = in.get();
        giverNpcId = in.getShort();
        mapId = in.getShort();
        mainQuestId = in.getShort();
        groupNum = in.getShort();
        if (startDate == null) startDate = new SystemTime(); startDate.readFrom(in);
        if (endDate == null) endDate = new SystemTime(); endDate.readFrom(in);
        for (int i = 0; i < extraReward.length; i++) { extraReward[i] = QuestExtraRewardType.fromValue(in.getInt()); }
        for (int i = 0; i < extraRewardValue.length; i++) { extraRewardValue[i] = in.getInt(); }
        asmQuestBit = AsmQuestBit.fromValue(in.getInt());
        loginTime = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        writeCString(out, questName, 40);
        writeCString(out, questGroupName, 32);
        out.put((byte) questPartyType.getValue());
        out.put((byte) type.getValue());
        out.put(minLevel);
        out.put(maxLevel);
        out.putShort(giverNpcId);
        out.putShort(mapId);
        out.putShort(mainQuestId);
        out.putShort(groupNum);
        if (startDate != null) startDate.writeTo(out);
        if (endDate != null) endDate.writeTo(out);
        for (int i = 0; i < extraReward.length; i++) { out.putInt(extraReward[i].getValue()); }
        for (int i = 0; i < extraRewardValue.length; i++) { out.putInt(extraRewardValue[i]); }
        out.putInt(asmQuestBit.getValue());
        out.putInt(loginTime ? 1 : 0);
    }
}
