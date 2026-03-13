package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketChat : Packet。
 */

@Data
public class PacketChat extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 128;

    private String chat;  // char szChat[128]  size: 128 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        chat = readCString(in, 128);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, chat, 128);
    }
}
