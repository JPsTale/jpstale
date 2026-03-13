package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWindowList : Packet。
 */

@Data
public class PacketWindowList extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 3204;

    private int count;  // int iCount  size: 4 bytes
    private String[] windowName = new String[50];  // char szaWindowName[50][64]  size: 3200 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
        for (int i = 0; i < 50; i++) { windowName[i] = readCString(in, 64); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
        for (int i = 0; i < 50; i++) { writeCString(out, windowName[i], 64); }
    }
}
