package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetMuteSync : Packet。
 */

@Data
public class PacketNetMuteSync extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int objectId;  // DWORD dwObjectID  size: 4 bytes
    private boolean muted;  // BOOL bMuted  size: 4 bytes
    private int unMuteExpiryTime;  // DWORD dwUnMuteExpiryTime  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
