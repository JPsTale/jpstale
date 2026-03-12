package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestArenaTier5 : Packet。
 */

@Data
public class PacketQuestArenaTier5 extends Packet {

    private int type;  // int iType
    private int round;  // int iRound
    private int timeLeft;  // DWORD dwTimeLeft

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
