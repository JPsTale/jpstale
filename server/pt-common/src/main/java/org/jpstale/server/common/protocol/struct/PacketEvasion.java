package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketEvasion : Packet。
 */

@Data
public class PacketEvasion extends Packet {

    private int skillId;  // int iSkillID
    private int unk;  // int iUnk
    private int objectId;  // DWORD dwObjectID

    @Override
    protected void readBody(ByteBuffer in) {
        skillId = in.getInt();
        unk = in.getInt();
        objectId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(skillId);
        out.putInt(unk);
        out.putInt(objectId);
    }
}
