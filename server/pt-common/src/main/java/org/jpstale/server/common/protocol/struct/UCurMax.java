package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/** C++ UCurMax. Total size: 4 bytes */
@Data
public final class UCurMax {
    public static final int SIZE_OF = 4;

    private short cur;  // USHORT sCur  size: 2 bytes
    private short max;  // USHORT sMax  size: 2 bytes

    public void readFrom(ByteBuffer in) {
        cur = in.getShort();
        max = in.getShort();
    }

    public void writeTo(ByteBuffer out) {
        out.putShort(cur);
        out.putShort(max);
    }
}
