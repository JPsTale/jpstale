package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUpdatePetData : Packet。
 */

@Data
public class PacketUpdatePetData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private boolean autoAttack;  // BOOL bAutoAttack  size: 4 bytes
    private int skillId;  // int dwSkillID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        autoAttack = in.getInt() != 0;
        skillId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(autoAttack ? 1 : 0);
        out.putInt(skillId);
    }
}
