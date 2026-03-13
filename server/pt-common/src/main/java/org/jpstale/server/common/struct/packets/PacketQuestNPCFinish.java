package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestNPCFinish : Packet。
 */

@Data
public class PacketQuestNPCFinish extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int id;  // int iID  size: 4 bytes
    private int itemIndex;  // int iItemIndex  size: 4 bytes
    private short[] weight = new short[2];  // short sWeight[2]  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        itemIndex = in.getInt();
        for (int i = 0; i < weight.length; i++) { weight[i] = in.getShort(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(itemIndex);
        for (int i = 0; i < weight.length; i++) { out.putShort(weight[i]); }
    }
}
