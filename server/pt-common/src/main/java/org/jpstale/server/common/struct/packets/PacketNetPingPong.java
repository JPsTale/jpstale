package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPingPong : Packet。
 */

@Data
public class PacketNetPingPong extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private int nothing;  // int iNothing  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        nothing = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(nothing);
    }
}
