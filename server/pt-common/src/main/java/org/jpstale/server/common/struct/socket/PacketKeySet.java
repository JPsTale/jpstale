package org.jpstale.server.common.struct.socket;

import lombok.Data;
import org.jpstale.server.common.struct.packets.Packet;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketKeySet : Packet。
 */

@Data
public class PacketKeySet extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 256;

    private final byte[] keySet = new byte[256];  // BYTE baKeySet[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        in.get(keySet);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.put(keySet);
    }
}
