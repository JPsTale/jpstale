package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDynamicQuestOpen : Packet。
 */

@Data
public class PacketDynamicQuestOpen extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 2312;

    private String imagePath;  // char szImagePath[260]  size: 260 bytes
    private String mainText;  // char szMainText[2048]  size: 2048 bytes
    private int questCount;  // int iQuestCount  size: 4 bytes
    private int[] questData = new int[0];  // QuestData saQuestData[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        imagePath = readCString(in, 260);
        mainText = readCString(in, 2048);
        questCount = in.getInt();
        for (int i = 0; i < questData.length; i++) { questData[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, imagePath, 260);
        writeCString(out, mainText, 2048);
        out.putInt(questCount);
        for (int i = 0; i < questData.length; i++) { out.putInt(questData[i]); }
    }
}
