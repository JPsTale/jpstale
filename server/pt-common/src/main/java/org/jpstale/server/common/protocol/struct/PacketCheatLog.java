package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCheatLog : Packet。
 */

@Data
public class PacketCheatLog extends Packet {

    private int unk;  // int iUnk
    private int logCode;  // int iLogCode
    private int oldCode1;  // int iOldCode1
    private int oldCode2;  // int iOldCode2
    private int exUnk;  // int iExUnk
    private int exLogCode;  // int iExLogCode
    private int code1;  // int iCode1
    private int code2;  // int iCode2

    @Override
    protected void readBody(ByteBuffer in) {
        unk = in.getInt();
        logCode = in.getInt();
        oldCode1 = in.getInt();
        oldCode2 = in.getInt();
        exUnk = in.getInt();
        exLogCode = in.getInt();
        code1 = in.getInt();
        code2 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(unk);
        out.putInt(logCode);
        out.putInt(oldCode1);
        out.putInt(oldCode2);
        out.putInt(exUnk);
        out.putInt(exLogCode);
        out.putInt(code1);
        out.putInt(code2);
    }
}
