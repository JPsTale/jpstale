package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/** C++ Point2D: int iX, int iY. Total size: 8 bytes */
@Data
public final class Point2D {
    public static final int SIZE_OF = 8;

    private int x;  // int iX  size: 4 bytes
    private int y;  // int iY  size: 4 bytes

    public void readFrom(ByteBuffer in) {
        x = in.getInt();
        y = in.getInt();
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(x);
        out.putInt(y);
    }

    public int sizeOf() {
        return SIZE_OF;
    }
}
