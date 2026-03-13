package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct MapIndicator（地图指示类型 + 值/坐标/角度）。
 * C 端 enum class Type 按 int 传输。
 */
@Data
public final class MapIndicator {
    public static final int SIZE_OF = 20;

    private int value;        // int iValue
    private int type;         // Type eType (enum class -> int)
    private int compactPosX;  // int iCompactPosX
    private int compactPosZ;  // int iCompactPosZ
    private int angleY;       // int iAngleY

    public void readFrom(ByteBuffer in) {
        value = in.getInt();
        type = in.getInt();
        compactPosX = in.getInt();
        compactPosZ = in.getInt();
        angleY = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(value);
        out.putInt(type);
        out.putInt(compactPosX);
        out.putInt(compactPosZ);
        out.putInt(angleY);
    }
}
