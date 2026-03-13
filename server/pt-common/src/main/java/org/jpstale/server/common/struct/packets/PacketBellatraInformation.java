package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBellatraInformation : Packet。
 */

@Data
public class PacketBellatraInformation extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int round;  // int iRound  size: 4 bytes
    private int type;  // int iType  size: 4 bytes
    private int unk;  // int iUnk  size: 4 bytes
    private int value;  // int iValue  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        round = in.getInt();
        type = in.getInt();
        unk = in.getInt();
        value = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(round);
        out.putInt(type);
        out.putInt(unk);
        out.putInt(value);
    }
}
