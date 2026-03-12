package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketEventGirlReset : Packet。
 */

@Data
public class PacketEventGirlReset extends Packet {

    private byte resetType;  // BYTE bResetType
    private int[] reset = new int[5];  // BOOL baReset[5]
    private int totalCost;  // int iTotalCost

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
