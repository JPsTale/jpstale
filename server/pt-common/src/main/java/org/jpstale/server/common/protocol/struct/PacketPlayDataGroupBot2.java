package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayDataGroupBot2 : Packet。
 */

@Data
public class PacketPlayDataGroupBot2 extends Packet {

    private int playDataCount;  // int iPlayDataCount
    private int sendCode;  // DWORD dwSendCode
    private PacketPlayDataMinor playDataMinor;  // PacketPlayDataMinor sPlayDataMinor

    @Override
    protected void readBody(ByteBuffer in) {
        playDataCount = in.getInt();
        sendCode = in.getInt();
        if (playDataMinor == null) playDataMinor = new PacketPlayDataMinor(); playDataMinor.readBody(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(playDataCount);
        out.putInt(sendCode);
        if (playDataMinor != null) playDataMinor.writeBody(out);
    }
}
