package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/** 与 C++ CurMax 对应：sCur, sMax (short)。 */
@Data
public final class CurMax {
    public static final int SIZE_OF = 4;

    private short cur;// short	  sCur
    private short max;// short	  sMax

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        cur = in.getShort();
        max = in.getShort();
    }

    public void writeTo(ByteBuffer out) {
        out.putShort(cur);
        out.putShort(max);
    }
}
