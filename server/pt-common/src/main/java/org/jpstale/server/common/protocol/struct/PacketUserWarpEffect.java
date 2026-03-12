package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUserWarpEffect : Packet。
 */

@Data
public class PacketUserWarpEffect extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int x;  // int iX  size: 4 bytes
    private int id;  // int iID  size: 4 bytes
    private int y;  // int iY  size: 4 bytes
    private int z;  // int iZ  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        x = in.getInt();
        id = in.getInt();
        y = in.getInt();
        z = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(x);
        out.putInt(id);
        out.putInt(y);
        out.putInt(z);
    }
}
