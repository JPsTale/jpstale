package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PlayBufferData（count + 单条 PlayBuffer）。
 */
@Data
public final class PlayBufferData {
    public static final int SIZE_OF = 40;

    private int count;          // int iCount
    private PlayBuffer playBuff; // PlayBuffer sPlayBuff

    public void readFrom(ByteBuffer in) {
        count = in.getInt();
        if (playBuff == null) playBuff = new PlayBuffer();
        playBuff.readFrom(in);
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(count);
        if (playBuff != null) playBuff.writeTo(out);
    }
}
