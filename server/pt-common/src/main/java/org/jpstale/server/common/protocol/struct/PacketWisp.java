package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWisp : Packet。
 */

@Data
public class PacketWisp extends Packet {

    private int time;  // int iTime
    private int absorbPercent;  // int iAbsorbPercent
    private int objectId;  // DWORD dwObjectID

    @Override
    protected void readBody(ByteBuffer in) {
        time = in.getInt();
        absorbPercent = in.getInt();
        objectId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(time);
        out.putInt(absorbPercent);
        out.putInt(objectId);
    }
}
