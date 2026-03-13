package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

import org.jpstale.server.common.enums.quest.QuestType;
import org.jpstale.server.common.enums.quest.QuestUserStatus;

/**
 * 对应 shared/quest.h 中 PacketDynamicQuestOpen 内部 struct QuestData，SIZE = 80 bytes.
 */
@Data
public final class QuestData {

    public static final int SIZE_OF = 80;

    /** int iQuestID; size: 4 bytes */
    private int questId;

    /** char szQuestName[64]; size: 64 bytes */
    private String questName;

    /** IMinMax sRequiredLevel; size: 8 bytes */
    private IMinMax requiredLevel = new IMinMax();

    /** EQuestType eQuestType; size: 1 bytes */
    private QuestType questType;

    /** EQuestUserStatus eQuestUserStatus; size: 1 bytes */
    private QuestUserStatus questUserStatus;

    /** padding 保持总大小 80 字节; size: 2 bytes */
    private final byte[] padding = new byte[2];

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        questId = in.getInt();
        questName = Packet.readCString(in, 64);
        requiredLevel.readFrom(in);
        questType = QuestType.fromValue(in.get() & 0xFF);
        questUserStatus = QuestUserStatus.fromValue(in.get() & 0xFF);
        in.get(padding);
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(questId);
        Packet.writeCString(out, questName, 64);
        requiredLevel.writeTo(out);
        out.put((byte) questType.getValue());
        out.put((byte) questUserStatus.getValue());
        out.put(padding);
    }
}

