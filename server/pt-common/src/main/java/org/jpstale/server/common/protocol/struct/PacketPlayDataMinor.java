package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayDataMinor : Packet。
 */

@Data
public class PacketPlayDataMinor extends Packet {

    private int objectId;  // DWORD dwObjectID
    private int x;  // int iX
    private int y;  // int iY
    private int z;  // int iZ
    private short[] angle = new short[4];  // short saAngle[4]
    private int frame;  // DWORD dwFrame
    private int autoCharCode;  // DWORD dwAutoCharCode

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        x = in.getInt();
        y = in.getInt();
        z = in.getInt();
        for (int i = 0; i < angle.length; i++) { angle[i] = in.getShort(); }
        frame = in.getInt();
        autoCharCode = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(x);
        out.putInt(y);
        out.putInt(z);
        for (int i = 0; i < angle.length; i++) { out.putShort(angle[i]); }
        out.putInt(frame);
        out.putInt(autoCharCode);
    }
}
