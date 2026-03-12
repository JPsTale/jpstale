package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetForceOrbTime : Packet。
 */

@Data
public class PacketNetForceOrbTime extends Packet {

    private int objectId;  // DWORD dwObjectID
    private boolean update;  // BOOL bUpdate
    private int time;  // DWORD dwTime

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
