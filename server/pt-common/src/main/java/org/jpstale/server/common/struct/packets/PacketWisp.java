package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWisp : Packet。
 */

@Data
public class PacketWisp extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int time;  // int iTime  size: 4 bytes
    private int absorbPercent;  // int iAbsorbPercent  size: 4 bytes
    private int objectId;  // DWORD dwObjectID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
