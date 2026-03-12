package org.jpstale.server.common.protocol.struct;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.nio.ByteBuffer;

/**
 * Login result from server (align with PristonTale-EU shared/packets.h struct PacketAccountLoginCode).
 * iCode: EAccountLogin (1=success, 0=pending, negative = error).
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PacketAccountLoginCode extends Packet {
    private int reserved;    // DWORD dwReserved
    private int code;        // int iCode (EAccountLogin)
    private int failCode;    // int iFailCode
    private String message;  // char[256] szMessage

    @Override
    protected void readBody(ByteBuffer in) {
        reserved = in.getInt();
        code = in.getInt();
        failCode = in.getInt();
        message = readCString(in, 256);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(reserved);
        out.putInt(code);
        out.putInt(failCode);
        writeCString(out, message, 256);
    }
}
