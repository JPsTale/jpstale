package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCrashData : Packet。
 */

@Data
public class PacketCrashData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 44;

    private boolean first;  // BOOL bFirst  size: 4 bytes
    private String accountName;  // char szAccountName[32]  size: 32 bytes
    private int dataLen;  // int iDataLen  size: 4 bytes
    private int tick;  // DWORD dwTick  size: 4 bytes
    private final byte[] data = new byte[0];  // BYTE baData[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        first = in.getInt() != 0;
        accountName = readCString(in, 32);
        dataLen = in.getInt();
        tick = in.getInt();
        in.get(data);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(first ? 1 : 0);
        writeCString(out, accountName, 32);
        out.putInt(dataLen);
        out.putInt(tick);
        out.put(data);
    }
}
