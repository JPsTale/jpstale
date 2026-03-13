package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetT5QuestData : Packet。
 */

@Data
public class PacketNetT5QuestData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int id;  // int iID  size: 4 bytes
    private int questId;  // UINT uQuestID  size: 4 bytes
    private short[] questValue = new short[2];  // USHORT sQuestValue[2]  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
