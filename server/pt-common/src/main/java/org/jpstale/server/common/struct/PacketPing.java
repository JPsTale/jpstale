package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPing : Packet。
 */

@Data
public class PacketPing extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 9;

    private int time;  // DWORD dwTime  size: 4 bytes
    private int tick;  // DWORD dwTick  size: 4 bytes
    private boolean cheatEngineDetected;  // bool CheatEngineDetected  size: 1 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        time = in.getInt();
        tick = in.getInt();
        cheatEngineDetected = in.get() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(time);
        out.putInt(tick);
        out.put((byte)(cheatEngineDetected ? 1 : 0));
    }
}
