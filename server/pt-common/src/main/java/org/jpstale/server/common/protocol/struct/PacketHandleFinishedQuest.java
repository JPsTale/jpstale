package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketHandleFinishedQuest : Packet。
 */

@Data
public class PacketHandleFinishedQuest extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 134;

    private int id;  // int iID  size: 4 bytes
    private String questName;  // char szQuestName[40]  size: 40 bytes
    private String questGroupName;  // char szQuestGroupName[32]  size: 32 bytes
    private int questPartyType;  // EQuestPartyType eQuestPartyType  size: 4 bytes
    private int type;  // EQuestType eType  size: 4 bytes
    private byte minLevel;  // BYTE iMinLevel  size: 1 bytes
    private byte maxLevel;  // BYTE iMaxLevel  size: 1 bytes
    private short giverNpcId;  // short sGiverNpcID  size: 2 bytes
    private short mapId;  // short sMapID  size: 2 bytes
    private short mainQuestId;  // short sMainQuestID  size: 2 bytes
    private short groupNum;  // short sGroupNum  size: 2 bytes
    private SystemTime startDate;  // SYSTEMTIME sStartDate  size: 16 bytes
    private SystemTime endDate;  // SYSTEMTIME sEndDate  size: 16 bytes
    private int[] extraReward = new int[0];  // EQuestExtraRewardType iaExtraReward[0]  size: 0 bytes
    private int[] extraRewardValue = new int[0];  // UINT iaExtraRewardValue[0]  size: 0 bytes
    private int asmQuestBit;  // EAsmQuestBit eAsmQuestBit  size: 4 bytes
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
        questPartyType = in.getInt();
        type = in.getInt();
        minLevel = in.get();
        maxLevel = in.get();
        giverNpcId = in.getShort();
        mapId = in.getShort();
        mainQuestId = in.getShort();
        groupNum = in.getShort();
        if (startDate == null) startDate = new SystemTime(); startDate.readFrom(in);
        if (endDate == null) endDate = new SystemTime(); endDate.readFrom(in);
        for (int i = 0; i < extraReward.length; i++) { extraReward[i] = in.getInt(); }
        for (int i = 0; i < extraRewardValue.length; i++) { extraRewardValue[i] = in.getInt(); }
        asmQuestBit = in.getInt();
        loginTime = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        writeCString(out, questName, 40);
        writeCString(out, questGroupName, 32);
        out.putInt(questPartyType);
        out.putInt(type);
        out.put(minLevel);
        out.put(maxLevel);
        out.putShort(giverNpcId);
        out.putShort(mapId);
        out.putShort(mainQuestId);
        out.putShort(groupNum);
        if (startDate != null) startDate.writeTo(out);
        if (endDate != null) endDate.writeTo(out);
        for (int i = 0; i < extraReward.length; i++) { out.putInt(extraReward[i]); }
        for (int i = 0; i < extraRewardValue.length; i++) { out.putInt(extraRewardValue[i]); }
        out.putInt(asmQuestBit);
        out.putInt(loginTime ? 1 : 0);
    }
}
