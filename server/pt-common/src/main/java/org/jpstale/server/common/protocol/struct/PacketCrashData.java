package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCrashData : Packet。
 */

@Data
public class PacketCrashData extends Packet {

    private boolean first;  // BOOL bFirst
    private String accountName;  // char szAccountName[32]
    private int dataLen;  // int iDataLen
    private int tick;  // DWORD dwTick
    private final byte[] data = new byte[0];  // BYTE baData[0]

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
