package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketAttackRating : Packet。
 */

@Data
public class PacketAttackRating extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int enemyId;  // int iEnemyID  size: 4 bytes
    private int attackRating;  // int iAttackRating  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        enemyId = in.getInt();
        attackRating = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(enemyId);
        out.putInt(attackRating);
    }
}
