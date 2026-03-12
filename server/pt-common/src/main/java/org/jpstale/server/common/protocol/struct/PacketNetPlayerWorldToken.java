package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerWorldToken : Packet。
 */

@Data
public class PacketNetPlayerWorldToken extends Packet {

    private String token;  // char Token[65]
    private String tokenPass;  // char TokenPass[65]

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
