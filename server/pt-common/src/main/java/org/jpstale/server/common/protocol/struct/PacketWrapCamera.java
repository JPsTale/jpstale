package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWrapCamera : Packet。
 */

@Data
public class PacketWrapCamera extends Packet {

    private int map;  // int iMap
    private int x;  // int iX
    private int z;  // int iZ
    private int turn;  // int iTurn
    private int angle;  // int iAngle
    private int zoom;  // int iZoom

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
