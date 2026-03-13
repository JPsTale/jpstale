package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerWorldToken : Packet。
 */

@Data
public class PacketNetPlayerWorldToken extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 130;

    private String token;  // char Token[65]  size: 65 bytes
    private String tokenPass;  // char TokenPass[65]  size: 65 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        token = readCString(in, 65);
        tokenPass = readCString(in, 65);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, token, 65);
        writeCString(out, tokenPass, 65);
    }
}
