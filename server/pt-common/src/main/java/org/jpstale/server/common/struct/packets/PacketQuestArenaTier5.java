package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestArenaTier5 : Packet。
 */

@Data
public class PacketQuestArenaTier5 extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int type;  // int iType  size: 4 bytes
    private int round;  // int iRound  size: 4 bytes
    private int timeLeft;  // DWORD dwTimeLeft  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        type = in.getInt();
        round = in.getInt();
        timeLeft = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(type);
        out.putInt(round);
        out.putInt(timeLeft);
    }
}
