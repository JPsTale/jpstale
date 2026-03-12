package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNPCRudolphChristmas : Packet。
 */

@Data
public class PacketNPCRudolphChristmas extends Packet {

    private int itemId;  // int iItemID
    private int head;  // DWORD dwHead
    private int checkSum;  // DWORD dwCheckSum

    @Override
    protected void readBody(ByteBuffer in) {
        itemId = in.getInt();
        head = in.getInt();
        checkSum = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(itemId);
        out.putInt(head);
        out.putInt(checkSum);
    }
}
