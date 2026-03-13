package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayDataGroupBot2 : Packet。
 */

@Data
public class PacketPlayDataGroupBot2 extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 40;

    private int playDataCount;  // int iPlayDataCount  size: 4 bytes
    private int sendCode;  // DWORD dwSendCode  size: 4 bytes
    private PacketPlayDataMinor playDataMinor;  // PacketPlayDataMinor sPlayDataMinor  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
