package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketItem : Packet。
 */

@Data
public class PacketItem extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 28;

    private int x;  // int iX  size: 4 bytes
    private int y;  // int iY  size: 4 bytes
    private int z;  // int iZ  size: 4 bytes
    private int[] secCode = new int[4];  // DWORD dwSecCode[4]  size: 16 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        x = in.getInt();
        y = in.getInt();
        z = in.getInt();
        for (int i = 0; i < secCode.length; i++) { secCode[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(x);
        out.putInt(y);
        out.putInt(z);
        for (int i = 0; i < secCode.length; i++) { out.putInt(secCode[i]); }
    }
}
