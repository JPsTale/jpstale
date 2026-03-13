package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBlessCastleUserScoreUpdate : Packet。
 */

@Data
public class PacketBlessCastleUserScoreUpdate extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int userScore;  // int iUserScore  size: 4 bytes
    private int mode;  // int iMode  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        userScore = in.getInt();
        mode = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(userScore);
        out.putInt(mode);
    }
}
