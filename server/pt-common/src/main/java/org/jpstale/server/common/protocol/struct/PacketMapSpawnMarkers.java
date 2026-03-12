package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketMapSpawnMarkers : Packet。
 */

@Data
public class PacketMapSpawnMarkers extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private int count;  // int iCount  size: 4 bytes
    private int[] markers = new int[0];  // Point3D saMarkers[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
        for (int i = 0; i < markers.length; i++) { markers[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
        for (int i = 0; i < markers.length; i++) { out.putInt(markers[i]); }
    }
}
