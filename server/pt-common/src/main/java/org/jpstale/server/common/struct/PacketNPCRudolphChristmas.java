package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNPCRudolphChristmas : Packet。
 */

@Data
public class PacketNPCRudolphChristmas extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int itemId;  // int iItemID  size: 4 bytes
    private int head;  // DWORD dwHead  size: 4 bytes
    private int checkSum;  // DWORD dwCheckSum  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
