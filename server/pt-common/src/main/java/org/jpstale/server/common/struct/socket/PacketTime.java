package org.jpstale.server.common.struct.socket;

import lombok.Data;
import org.jpstale.server.common.struct.packets.Packet;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTime : Packet。
 */

@Data
public class PacketTime extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int time;  // DWORD dwTime  size: 4 bytes
    private int id;  // ID iID  size: 4 bytes
    private int reserved1;  // DWORD dwReserved1  size: 4 bytes
    private int reserved2;  // DWORD dwReserved2  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        time = in.getInt();
        id = in.getInt();
        reserved1 = in.getInt();
        reserved2 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(time);
        out.putInt(id);
        out.putInt(reserved1);
        out.putInt(reserved2);
    }
}
