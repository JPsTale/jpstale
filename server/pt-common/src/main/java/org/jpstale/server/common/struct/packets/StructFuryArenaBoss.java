package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 StructFuryArenaBoss：当前/最大 Boss HP。
 */
@Data
public final class StructFuryArenaBoss {
    public static final int SIZE_OF = 8;

    private int currentBossHp;  // int iCurrentBossHP
    private int maxBossHp;      // int iMaxBossHP

    public void readFrom(ByteBuffer in) {
        currentBossHp = in.getInt();
        maxBossHp = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(currentBossHp);
        out.putInt(maxBossHp);
    }
}
