package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCharacterCombatData : Packet。
 */

@Data
public class PacketCharacterCombatData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int defenseRating;  // int iDefenseRating  size: 4 bytes
    private short evadeChance;  // short sEvadeChance  size: 2 bytes
    private short blockChance;  // short sBlockChance  size: 2 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        defenseRating = in.getInt();
        evadeChance = in.getShort();
        blockChance = in.getShort();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(defenseRating);
        out.putShort(evadeChance);
        out.putShort(blockChance);
    }
}
