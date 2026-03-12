package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestNamesResponse : Packet。
 */

@Data
public class PacketQuestNamesResponse extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8104;

    private boolean initial;  // BOOL bInitial  size: 4 bytes
    private int questCount;  // int questCount  size: 4 bytes
    private QuestInformation[] questsInformation = new QuestInformation[88];  // QuestInformation questsInformation[88]  size: 8096 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        initial = in.getInt() != 0;
        questCount = in.getInt();
        for (int i = 0; i < questsInformation.length; i++) { if (questsInformation[i] == null) questsInformation[i] = new QuestInformation(); questsInformation[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(initial ? 1 : 0);
        out.putInt(questCount);
        for (int i = 0; i < questsInformation.length; i++) { if (questsInformation[i] != null) questsInformation[i].writeTo(out); }
    }
}
