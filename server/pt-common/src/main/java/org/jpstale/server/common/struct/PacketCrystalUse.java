package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCrystalUse : Packet。
 */

@Data
public class PacketCrystalUse extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int objectId;  // DWORD dwObjectID  size: 4 bytes
    private int itemId;  // DWORD dwItemID  size: 4 bytes
    private int time;  // DWORD dwTime  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        itemId = in.getInt();
        time = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(itemId);
        out.putInt(time);
    }
}
