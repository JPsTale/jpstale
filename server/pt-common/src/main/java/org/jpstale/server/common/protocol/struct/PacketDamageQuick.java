package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDamageQuick : Packet。
 */

@Data
public class PacketDamageQuick extends Packet {

    private boolean percentile;  // BOOL bPercentile
    private boolean baseCurrentHp;  // BOOL bBaseCurrentHP
    private int damage;  // int iDamage
    private boolean pvp;  // BOOL bPVP

    @Override
    protected void readBody(ByteBuffer in) {
        percentile = in.getInt() != 0;
        baseCurrentHp = in.getInt() != 0;
        damage = in.getInt();
        pvp = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(percentile ? 1 : 0);
        out.putInt(baseCurrentHp ? 1 : 0);
        out.putInt(damage);
        out.putInt(pvp ? 1 : 0);
    }
}
