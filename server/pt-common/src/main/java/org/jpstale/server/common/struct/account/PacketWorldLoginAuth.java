package org.jpstale.server.common.struct.account;

import lombok.Data;
import org.jpstale.server.common.struct.Packet;

import java.nio.ByteBuffer;

/**
 * 对应 account.h 中 struct PacketWorldLoginAuth : Packet。
 */
@Data
public class PacketWorldLoginAuth extends Packet {
    private String token;     // char Token[65]
    private String tokenPass; // char TokenPass[65]

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
