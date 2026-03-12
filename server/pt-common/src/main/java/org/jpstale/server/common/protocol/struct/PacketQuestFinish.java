package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestFinish : Packet。
 */

@Data
public class PacketQuestFinish extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int questId;  // DWORD dwQuestID  size: 4 bytes
    private int questStatus;  // EQuestStatus eQuestStatus  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        questId = in.getInt();
        questStatus = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(questId);
        out.putInt(questStatus);
    }
}
