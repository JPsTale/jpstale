package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCrystalUse : Packet。
 */

@Data
public class PacketCrystalUse extends Packet {

    private int objectId;  // DWORD dwObjectID
    private int itemId;  // DWORD dwItemID
    private int time;  // DWORD dwTime

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
