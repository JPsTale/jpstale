package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PlayBuffer（单条 buff 位置/帧/角度等）。
 */
@Data
public final class PlayBuffer {
    public static final int SIZE_OF = 36;

    private int x;              // int iX
    private int y;              // int iY
    private int z;              // int iZ
    private int frame;          // DWORD dwFrame
    private final short[] angle = new short[4];   // short saAngle[4]
    private final short[] stickItems = new short[4]; // short sStickItems[4]
    private int targetSerial;   // DWORD dwTargetSerial

    public void readFrom(ByteBuffer in) {
        x = in.getInt();
        y = in.getInt();
        z = in.getInt();
        frame = in.getInt();
        for (int i = 0; i < angle.length; i++) angle[i] = in.getShort();
        for (int i = 0; i < stickItems.length; i++) stickItems[i] = in.getShort();
        targetSerial = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(x);
        out.putInt(y);
        out.putInt(z);
        out.putInt(frame);
        for (short a : angle) out.putShort(a);
        for (short s : stickItems) out.putShort(s);
        out.putInt(targetSerial);
    }
}
