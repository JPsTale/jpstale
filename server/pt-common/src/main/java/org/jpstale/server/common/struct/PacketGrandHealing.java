package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketGrandHealing : Packet。
 */

@Data
public class PacketGrandHealing extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int healAmount;  // int iHealAmount  size: 4 bytes
    private int skillLevel;  // int iSkillLevel  size: 4 bytes
    private int range;  // int iRange  size: 4 bytes
    private int casterId;  // int iCasterID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        healAmount = in.getInt();
        skillLevel = in.getInt();
        range = in.getInt();
        casterId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(healAmount);
        out.putInt(skillLevel);
        out.putInt(range);
        out.putInt(casterId);
    }
}
