package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/** 与 C++ CurMax 对应：sCur, sMax (short)。 */
@Data
public final class CurMax {
    private short cur;// short	  sCur
    private short max;// short	  sMax

    public void readFrom(ByteBuffer in) {
        cur = in.getShort();
        max = in.getShort();
    }

    public void writeTo(ByteBuffer out) {
        out.putShort(cur);
        out.putShort(max);
    }
}
