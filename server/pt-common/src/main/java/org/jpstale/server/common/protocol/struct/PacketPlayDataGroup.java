package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayDataGroup : Packet。
 */

@Data
public class PacketPlayDataGroup extends Packet {

    private int playDataCount;  // int iPlayDataCount
    private int sendCode;  // DWORD dwSendCode

    @Override
    protected void readBody(ByteBuffer in) {
        playDataCount = in.getInt();
        sendCode = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(playDataCount);
        out.putInt(sendCode);
    }
}
