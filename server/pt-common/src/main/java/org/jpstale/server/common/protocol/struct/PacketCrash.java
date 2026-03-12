package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCrash : Packet。
 */

@Data
public class PacketCrash extends Packet {

    private int exceptionCode;  // DWORD dwExceptionCode
    private int exceptionFlags;  // DWORD dwExceptionFlags
    private int pvExceptionAddress;  // PVOID pvExceptionAddress
    private int ax;  // DWORD EAX
    private int cx;  // DWORD ECX
    private int dx;  // DWORD EDX
    private int bx;  // DWORD EBX
    private int sp;  // DWORD ESP
    private int bp;  // DWORD EBP
    private int si;  // DWORD ESI
    private int di;  // DWORD EDI
    private int ip;  // DWORD EIP
    private int version;  // DWORD dwVersion
    private String accountName;  // char szAccountName[32]

    @Override
    protected void readBody(ByteBuffer in) {
        exceptionCode = in.getInt();
        exceptionFlags = in.getInt();
        pvExceptionAddress = in.getInt();
        ax = in.getInt();
        cx = in.getInt();
        dx = in.getInt();
        bx = in.getInt();
        sp = in.getInt();
        bp = in.getInt();
        si = in.getInt();
        di = in.getInt();
        ip = in.getInt();
        version = in.getInt();
        accountName = readCString(in, 32);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(exceptionCode);
        out.putInt(exceptionFlags);
        out.putInt(pvExceptionAddress);
        out.putInt(ax);
        out.putInt(cx);
        out.putInt(dx);
        out.putInt(bx);
        out.putInt(sp);
        out.putInt(bp);
        out.putInt(si);
        out.putInt(di);
        out.putInt(ip);
        out.putInt(version);
        writeCString(out, accountName, 32);
    }
}
