package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUseSkillBase : Packet。
 */

@Data
public class PacketUseSkillBase extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 15;

    private int skillId;  // ESkillID iSkillID  size: 4 bytes
    private byte skillLevelBased;  // BYTE iSkillLevel1Based  size: 1 bytes
    private short timeLeftSec;  // short sTimeLeftSec  size: 2 bytes
    private int casterCharacterClass;  // ECharacterClass eCasterCharacterClass  size: 4 bytes
    private int lCasterId;  // ID lCasterID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        skillId = in.getInt();
        skillLevelBased = in.get();
        timeLeftSec = in.getShort();
        casterCharacterClass = in.getInt();
        lCasterId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(skillId);
        out.put(skillLevelBased);
        out.putShort(timeLeftSec);
        out.putInt(casterCharacterClass);
        out.putInt(lCasterId);
    }
}
