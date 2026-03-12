package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketGrandHealing : Packet。
 */

@Data
public class PacketGrandHealing extends Packet {

    private int healAmount;  // int iHealAmount
    private int skillLevel;  // int iSkillLevel
    private int range;  // int iRange
    private int casterId;  // int iCasterID

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
