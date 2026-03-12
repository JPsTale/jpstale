package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNPCClick : Packet。
 */

@Data
public class PacketNPCClick extends Packet {

    private int tarObjectSerial;  // DWORD dwTarObjectSerial
    private int npcid;  // int iNPCId
    private int questData;  // int iQuestData

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
