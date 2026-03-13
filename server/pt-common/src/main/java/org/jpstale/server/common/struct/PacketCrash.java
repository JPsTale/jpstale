package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCrash : Packet。
 */

@Data
public class PacketCrash extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 84;

    private int exceptionCode;  // DWORD dwExceptionCode  size: 4 bytes
    private int exceptionFlags;  // DWORD dwExceptionFlags  size: 4 bytes
    private int pvExceptionAddress;  // PVOID pvExceptionAddress  size: 4 bytes
    private int ax;  // DWORD EAX  size: 4 bytes
    private int cx;  // DWORD ECX  size: 4 bytes
    private int dx;  // DWORD EDX  size: 4 bytes
    private int bx;  // DWORD EBX  size: 4 bytes
    private int sp;  // DWORD ESP  size: 4 bytes
    private int bp;  // DWORD EBP  size: 4 bytes
    private int si;  // DWORD ESI  size: 4 bytes
    private int di;  // DWORD EDI  size: 4 bytes
    private int ip;  // DWORD EIP  size: 4 bytes
    private int version;  // DWORD dwVersion  size: 4 bytes
    private String accountName;  // char szAccountName[32]  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
