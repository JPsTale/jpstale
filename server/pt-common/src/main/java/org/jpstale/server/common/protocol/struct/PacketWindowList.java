package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWindowList : Packet。
 */

@Data
public class PacketWindowList extends Packet {

    private int count;  // int iCount
    private String[] aWindowName = new String[50];  // char szaWindowName[50][64]

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
        for (int i = 0; i < 50; i++) { aWindowName[i] = readCString(in, 64); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
        for (int i = 0; i < 50; i++) { writeCString(out, aWindowName[i], 64); }
    }
}
