package org.jpstale.server.common.protocol.account;

import lombok.Data;
import org.jpstale.server.common.protocol.struct.Packet;

import java.nio.ByteBuffer;

/**
 * 对应 account.h 中 struct PacketWorldLoginToken : Packet。
 */
@Data
public class PacketWorldLoginToken extends Packet {
    private String tokenPass;  // char TokenPass[65]

    @Override
    protected void readBody(ByteBuffer in) {
        tokenPass = readCString(in, 65);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, tokenPass, 65);
    }
}
