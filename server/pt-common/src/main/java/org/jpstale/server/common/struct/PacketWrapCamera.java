package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWrapCamera : Packet。
 */

@Data
public class PacketWrapCamera extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 24;

    private int map;  // int iMap  size: 4 bytes
    private int x;  // int iX  size: 4 bytes
    private int z;  // int iZ  size: 4 bytes
    private int turn;  // int iTurn  size: 4 bytes
    private int angle;  // int iAngle  size: 4 bytes
    private int zoom;  // int iZoom  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        map = in.getInt();
        x = in.getInt();
        z = in.getInt();
        turn = in.getInt();
        angle = in.getInt();
        zoom = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(map);
        out.putInt(x);
        out.putInt(z);
        out.putInt(turn);
        out.putInt(angle);
        out.putInt(zoom);
    }
}
