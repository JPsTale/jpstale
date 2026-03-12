package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketHealing : Packet。
 */

@Data
public class PacketHealing extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int notUsed;  // int iNotUsed  size: 4 bytes
    private int healAmount;  // int iHealAmount  size: 4 bytes
    private int targetId;  // int iTargetID  size: 4 bytes
    private int casterId;  // int iCasterID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
