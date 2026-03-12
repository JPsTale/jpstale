package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketVersion : Packet。
 */

@Data
public class PacketVersion extends Packet {

    private boolean serverFull;  // BOOL bServerFull
    private int version;  // int iVersion
    private int unk2;  // int iUnk2

    @Override
    protected void readBody(ByteBuffer in) {
        serverFull = in.getInt() != 0;
        version = in.getInt();
        unk2 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(serverFull ? 1 : 0);
        out.putInt(version);
        out.putInt(unk2);
    }
}
