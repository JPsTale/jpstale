package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBellatraInformation : Packet。
 */

@Data
public class PacketBellatraInformation extends Packet {

    private int round;  // int iRound
    private int type;  // int iType
    private int unk;  // int iUnk
    private int value;  // int iValue

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
