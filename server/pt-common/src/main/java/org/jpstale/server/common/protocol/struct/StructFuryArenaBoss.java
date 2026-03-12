package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 StructFuryArenaBoss：当前/最大 Boss HP。
 */
@Data
public final class StructFuryArenaBoss {
    private int currentBossHp;  // int iCurrentBossHP
    private int maxBossHp;      // int iMaxBossHP

    public void readFrom(ByteBuffer in) {
        currentBossHp = in.getInt();
        maxBossHp = in.getInt();
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(currentBossHp);
        out.putInt(maxBossHp);
    }
}
