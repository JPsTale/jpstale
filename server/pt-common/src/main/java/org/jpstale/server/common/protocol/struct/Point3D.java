package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/** 与 C++ Point3D 对应：iX, iY, iZ，用于包体内联读写。 */
@Data
public final class Point3D {
    private int x;
    private int y;
    private int z;

    public void readFrom(ByteBuffer in) {
        x = in.getInt();
        y = in.getInt();
        z = in.getInt();
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(x);
        out.putInt(y);
        out.putInt(z);
    }
}
