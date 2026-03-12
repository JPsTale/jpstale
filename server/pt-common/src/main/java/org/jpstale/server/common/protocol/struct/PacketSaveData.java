package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSaveData : Packet。
 */

@Data
public class PacketSaveData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8172;

    private int count;  // int iCount  size: 4 bytes
    private int total;  // int iTotal  size: 4 bytes
    private int dataSize;  // int iDataSize  size: 4 bytes
    private String data;  // char szData[8160]  size: 8160 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
        total = in.getInt();
        dataSize = in.getInt();
        data = readCString(in, 8160);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
        out.putInt(total);
        out.putInt(dataSize);
        writeCString(out, data, 8160);
    }
}
