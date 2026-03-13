package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketLoseExperience : Packet。
 */

@Data
public class PacketLoseExperience extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 20;

    private long subExp;  // INT64 iSubExp  size: 8 bytes
    private int level;  // int iLevel  size: 4 bytes
    private int mapId;  // int iMapID  size: 4 bytes
    private boolean ressurectionItem;  // BOOL bRessurectionItem  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        subExp = in.getLong();
        level = in.getInt();
        mapId = in.getInt();
        ressurectionItem = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putLong(subExp);
        out.putInt(level);
        out.putInt(mapId);
        out.putInt(ressurectionItem ? 1 : 0);
    }
}
