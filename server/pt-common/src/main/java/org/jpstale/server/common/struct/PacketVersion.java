package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketVersion : Packet。
 */

@Data
public class PacketVersion extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private boolean serverFull;  // BOOL bServerFull  size: 4 bytes
    private int version;  // int iVersion  size: 4 bytes
    private int unk2;  // int iUnk2  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
