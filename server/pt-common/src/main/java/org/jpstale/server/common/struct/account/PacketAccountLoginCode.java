package org.jpstale.server.common.struct.account;

import lombok.Data;
import org.jpstale.server.common.enums.account.AccountLogin;
import org.jpstale.server.common.struct.packets.Packet;

import java.nio.ByteBuffer;

/**
 * 对应 account.h 中 struct PacketAccountLoginCode : Packet。
 * iCode 为 EAccountLogin，见 {@link AccountLogin}。
 */
@Data
public class PacketAccountLoginCode extends Packet {
    private int reserved;   // DWORD dwReserved
    private AccountLogin code;      // EAccountLogin iCode
    private int failCode;  // int iFailCode
    private String message; // char szMessage[256]

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4 + 4 + 4 + 256;

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        reserved = in.getInt();
        code = AccountLogin.fromValue(in.getInt());
        failCode = in.getInt();
        message = readCString(in, 256);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(reserved);
        out.putInt(code.getValue());
        out.putInt(failCode);
        writeCString(out, message, 256);
    }
}
