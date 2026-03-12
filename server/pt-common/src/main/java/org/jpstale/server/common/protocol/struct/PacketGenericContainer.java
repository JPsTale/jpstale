package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketGenericContainer : Packet。
 */

@Data
public class PacketGenericContainer extends Packet {

    private int count;  // int iCount
    private int iParam;  // int iParam
    private final byte[] buffer = new byte[0];  // BYTE baBuffer[0]

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
        iParam = in.getInt();
        in.get(buffer);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
        out.putInt(iParam);
        out.put(buffer);
    }
}
