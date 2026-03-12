package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestCancel : Packet。
 */

@Data
public class PacketQuestCancel extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private int questId;  // DWORD dwQuestID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        questId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(questId);
    }
}
