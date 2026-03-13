package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSync : Packet。
 */

@Data
public class PacketSync extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int reserved1;  // DWORD dwReserved1  size: 4 bytes
    private int time;  // DWORD dwTime  size: 4 bytes
    private int reserved2;  // DWORD dwReserved2  size: 4 bytes
    private int reserved3;  // DWORD dwReserved3  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        reserved1 = in.getInt();
        time = in.getInt();
        reserved2 = in.getInt();
        reserved3 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(reserved1);
        out.putInt(time);
        out.putInt(reserved2);
        out.putInt(reserved3);
    }
}
