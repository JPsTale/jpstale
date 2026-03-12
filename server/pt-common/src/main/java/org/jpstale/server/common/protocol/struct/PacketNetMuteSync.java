package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetMuteSync : Packet。
 */

@Data
public class PacketNetMuteSync extends Packet {

    private int objectId;  // DWORD dwObjectID
    private boolean muted;  // BOOL bMuted
    private int unMuteExpiryTime;  // DWORD dwUnMuteExpiryTime

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        muted = in.getInt() != 0;
        unMuteExpiryTime = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(muted ? 1 : 0);
        out.putInt(unMuteExpiryTime);
    }
}
