package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/** 与 C++ IMinMax 对应：iMin, iMax。 */
@Data
public final class IMinMax {
    public static final int SIZE_OF = 8;

    private int min;
    private int max;

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        min = in.getInt();
        max = in.getInt();
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(min);
        out.putInt(max);
    }
}
