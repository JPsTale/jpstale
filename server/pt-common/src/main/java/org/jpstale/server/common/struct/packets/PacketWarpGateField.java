package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWarpGateField : Packet。
 */

@Data
public class PacketWarpGateField extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int z;  // int iZ  size: 4 bytes
    private int stage;  // int iStage  size: 4 bytes
    private int x;  // int iX  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        z = in.getInt();
        stage = in.getInt();
        x = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(z);
        out.putInt(stage);
        out.putInt(x);
    }
}
