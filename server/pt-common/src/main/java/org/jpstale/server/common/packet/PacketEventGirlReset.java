package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketEventGirlReset : Packet。
 */

@Data
public class PacketEventGirlReset extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 25;

    private byte resetType;  // BYTE bResetType  size: 1 bytes
    private int[] reset = new int[5];  // BOOL baReset[5]  size: 20 bytes
    private int totalCost;  // int iTotalCost  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        resetType = in.get();
        for (int i = 0; i < reset.length; i++) { reset[i] = in.getInt(); }
        totalCost = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.put(resetType);
        for (int i = 0; i < reset.length; i++) { out.putInt(reset[i]); }
        out.putInt(totalCost);
    }
}
