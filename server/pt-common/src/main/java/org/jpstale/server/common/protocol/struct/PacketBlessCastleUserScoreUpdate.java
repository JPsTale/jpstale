package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBlessCastleUserScoreUpdate : Packet。
 */

@Data
public class PacketBlessCastleUserScoreUpdate extends Packet {

    private int userScore;  // int iUserScore
    private int mode;  // int iMode

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
