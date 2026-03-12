package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSaveData : Packet。
 */

@Data
public class PacketSaveData extends Packet {

    private int count;  // int iCount
    private int total;  // int iTotal
    private int dataSize;  // int iDataSize
    private String data;  // char szData[8160]

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
