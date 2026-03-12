package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetT5QuestData : Packet。
 */

@Data
public class PacketNetT5QuestData extends Packet {

    private int id;  // int iID
    private int questId;  // UINT uQuestID
    private short[] questValue = new short[2];  // USHORT sQuestValue[2]

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        questId = in.getInt();
        for (int i = 0; i < questValue.length; i++) { questValue[i] = in.getShort(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(questId);
        for (int i = 0; i < questValue.length; i++) { out.putShort(questValue[i]); }
    }
}
