package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNPCClick : Packet。
 */

@Data
public class PacketNPCClick extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int tarObjectSerial;  // DWORD dwTarObjectSerial  size: 4 bytes
    private int npcid;  // int iNPCId  size: 4 bytes
    private int questData;  // int iQuestData  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        tarObjectSerial = in.getInt();
        npcid = in.getInt();
        questData = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(tarObjectSerial);
        out.putInt(npcid);
        out.putInt(questData);
    }
}
