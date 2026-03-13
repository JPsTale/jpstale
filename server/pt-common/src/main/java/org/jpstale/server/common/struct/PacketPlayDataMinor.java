package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayDataMinor : Packet。
 */

@Data
public class PacketPlayDataMinor extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 32;

    private int objectId;  // DWORD dwObjectID  size: 4 bytes
    private int x;  // int iX  size: 4 bytes
    private int y;  // int iY  size: 4 bytes
    private int z;  // int iZ  size: 4 bytes
    private short[] angle = new short[4];  // short saAngle[4]  size: 8 bytes
    private int frame;  // DWORD dwFrame  size: 4 bytes
    private int autoCharCode;  // DWORD dwAutoCharCode  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
