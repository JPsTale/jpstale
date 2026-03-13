package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

import org.jpstale.server.common.enums.quest.QuestPartyType;
import org.jpstale.server.common.enums.quest.QuestType;

/**
 * 对应 shared/quest.h 中的 C++ struct QuestInformation，size = 92 bytes。
 */
@Data
public final class QuestInformation {

    public static final int SIZE_OF = 92;

    /** char name[40]; */
    private String name;

    /** char group[32]; */
    private String group;

    /** short groupNum; */
    private short groupNum;

    /** short questID; */
    private short questId;

    /** BOOL finished; */
    private boolean finished;

    /** BYTE minLevel; */
    private byte minLevel;

    /** BYTE maxLevel; */
    private byte maxLevel;

    /** short mapID; */
    private short mapId;

    /** short giverNpcID; */
    private short giverNpcId;

    /** short requiredQuestId; */
    private short requiredQuestId;

    /** short mainQuestId; */
    private short mainQuestId;

    /** EQuestPartyType partyMode; */
    private QuestPartyType partyMode;

    /** EQuestType questType; */
    private QuestType questType;

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        name = Packet.readCString(in, 40);
        group = Packet.readCString(in, 32);
        groupNum = in.getShort();
        questId = in.getShort();
        finished = in.getInt() != 0;
        minLevel = in.get();
        maxLevel = in.get();
        mapId = in.getShort();
        giverNpcId = in.getShort();
        requiredQuestId = in.getShort();
        mainQuestId = in.getShort();
        partyMode = QuestPartyType.fromValue(in.get() & 0xFF);
        questType = QuestType.fromValue(in.get() & 0xFF);
    }

    public void writeTo(ByteBuffer out) {
        Packet.writeCString(out, name, 40);
        Packet.writeCString(out, group, 32);
        out.putShort(groupNum);
        out.putShort(questId);
        out.putInt(finished ? 1 : 0);
        out.put(minLevel);
        out.put(maxLevel);
        out.putShort(mapId);
        out.putShort(giverNpcId);
        out.putShort(requiredQuestId);
        out.putShort(mainQuestId);
        out.put((byte) partyMode.getValue());
        out.put((byte) questType.getValue());
    }
}

