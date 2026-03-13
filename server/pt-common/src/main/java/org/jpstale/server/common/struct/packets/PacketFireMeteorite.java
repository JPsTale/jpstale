package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.Point3D;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketFireMeteorite : Packet。
 */

@Data
public class PacketFireMeteorite extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 36;

    private Point3D begin;  // Point3D sBegin  size: 12 bytes
    private Point3D end;  // Point3D sEnd  size: 12 bytes
    private int delay;  // int iDelay  size: 4 bytes
    private boolean smallMeteor;  // BOOL bSmallMeteor  size: 4 bytes
    private int count;  // int iCount  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (begin == null) begin = new Point3D(); begin.readFrom(in);
        if (end == null) end = new Point3D(); end.readFrom(in);
        delay = in.getInt();
        smallMeteor = in.getInt() != 0;
        count = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (begin != null) begin.writeTo(out);
        if (end != null) end.writeTo(out);
        out.putInt(delay);
        out.putInt(smallMeteor ? 1 : 0);
        out.putInt(count);
    }
}
