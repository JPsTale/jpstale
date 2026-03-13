package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDamageQuick : Packet。
 */

@Data
public class PacketDamageQuick extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private boolean percentile;  // BOOL bPercentile  size: 4 bytes
    private boolean baseCurrentHp;  // BOOL bBaseCurrentHP  size: 4 bytes
    private int damage;  // int iDamage  size: 4 bytes
    private boolean pvp;  // BOOL bPVP  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
