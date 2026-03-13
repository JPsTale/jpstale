package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetForceOrbTime : Packet。
 */

@Data
public class PacketNetForceOrbTime extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int objectId;  // DWORD dwObjectID  size: 4 bytes
    private boolean update;  // BOOL bUpdate  size: 4 bytes
    private int time;  // DWORD dwTime  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        update = in.getInt() != 0;
        time = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(update ? 1 : 0);
        out.putInt(time);
    }
}
