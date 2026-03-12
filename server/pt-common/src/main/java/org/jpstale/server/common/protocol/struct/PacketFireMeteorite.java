package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketFireMeteorite : Packet。
 */

@Data
public class PacketFireMeteorite extends Packet {

    private Point3D begin;  // Point3D sBegin
    private Point3D end;  // Point3D sEnd
    private int delay;  // int iDelay
    private boolean smallMeteor;  // BOOL bSmallMeteor
    private int count;  // int iCount

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
