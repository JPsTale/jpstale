package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.Point3D;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketMapSpawnMarkers : Packet。
 */

@Data
public class PacketMapSpawnMarkers extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 2404;

    private int count;  // int iCount  size: 4 bytes
    private Point3D[] markers = new Point3D[200];  // Point3D saMarkers[200]  size: 2400 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
        for (int i = 0; i < markers.length; i++) { if (markers[i] == null) markers[i] = new Point3D(); markers[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
        for (int i = 0; i < markers.length; i++) { if (markers[i] != null) markers[i].writeTo(out); }
    }
}
