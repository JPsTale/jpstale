package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketMixDescription : Packet。
 */

@Data
public class PacketMixDescription extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 150;

    private String mixDescription;  // char szMixDescription[150]  size: 150 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        mixDescription = readCString(in, 150);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, mixDescription, 150);
    }
}
