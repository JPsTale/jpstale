package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketAttackRating : Packet。
 */

@Data
public class PacketAttackRating extends Packet {

    private int enemyId;  // int iEnemyID
    private int attackRating;  // int iAttackRating

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
