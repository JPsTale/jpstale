package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.QuestType;


/**
 * 对应 packets.h 中 struct PacketSyncFinishedQuestData : Packet。
 */

@Data
public class PacketSyncFinishedQuestData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 25;

    private int userId;  // ID dwUserID  size: 4 bytes
    private int questId;  // int iQuestID  size: 4 bytes
    private QuestType questType;  // EQuestType eQuestType  size: 1 bytes
    private SystemTime dateFinished;  // SYSTEMTIME sDateFinished  size: 16 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        userId = in.getInt();
        questId = in.getInt();
        questType = QuestType.fromValue(in.get() & 0xFF);
        if (dateFinished == null) dateFinished = new SystemTime(); dateFinished.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(userId);
        out.putInt(questId);
        out.put((byte) questType.getValue());
        if (dateFinished != null) dateFinished.writeTo(out);
    }
}
