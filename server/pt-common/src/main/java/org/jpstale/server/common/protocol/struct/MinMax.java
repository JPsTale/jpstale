package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 common.h 中 struct MinMax（short 最小/最大值）。
 */
@Data
public final class MinMax {
    public static final int SIZE_OF = 4;

    private short min;  // short sMin
    private short max;  // short sMax

    public void readFrom(ByteBuffer in) {
        min = in.getShort();
        max = in.getShort();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putShort(min);
        out.putShort(max);
    }
}
