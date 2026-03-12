package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUpdatePetData : Packet。
 */

@Data
public class PacketUpdatePetData extends Packet {

    private boolean autoAttack;  // BOOL bAutoAttack
    private int skillId;  // int dwSkillID

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
