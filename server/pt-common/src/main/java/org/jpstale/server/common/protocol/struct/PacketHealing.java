package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketHealing : Packet。
 */

@Data
public class PacketHealing extends Packet {

    private int notUsed;  // int iNotUsed
    private int healAmount;  // int iHealAmount
    private int targetId;  // int iTargetID
    private int casterId;  // int iCasterID

    @Override
    protected void readBody(ByteBuffer in) {
        notUsed = in.getInt();
        healAmount = in.getInt();
        targetId = in.getInt();
        casterId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(notUsed);
        out.putInt(healAmount);
        out.putInt(targetId);
        out.putInt(casterId);
    }
}
