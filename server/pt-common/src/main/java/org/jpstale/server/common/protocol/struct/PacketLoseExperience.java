package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketLoseExperience : Packet。
 */

@Data
public class PacketLoseExperience extends Packet {

    private long subExp;  // INT64 iSubExp
    private int level;  // int iLevel
    private int mapId;  // int iMapID
    private boolean ressurectionItem;  // BOOL bRessurectionItem

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
