package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.packets.CharacterClass;
import org.jpstale.server.common.enums.skill.SkillId;


/**
 * 对应 packets.h 中 struct PacketUseSkillBase : Packet。
 */

@Data
public class PacketUseSkillBase extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 15;

    private SkillId skillId;  // ESkillID iSkillID  size: 4 bytes
    private byte skillLevelBased;  // BYTE iSkillLevel1Based  size: 1 bytes
    private short timeLeftSec;  // short sTimeLeftSec  size: 2 bytes
    private CharacterClass casterCharacterClass;  // ECharacterClass eCasterCharacterClass  size: 4 bytes
    private int casterId;  // ID lCasterID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        skillId = SkillId.fromValue(in.getInt());
        skillLevelBased = in.get();
        timeLeftSec = in.getShort();
        casterCharacterClass = CharacterClass.fromValue(in.getInt());
        casterId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(skillId.getValue());
        out.put(skillLevelBased);
        out.putShort(timeLeftSec);
        out.putInt(casterCharacterClass.getValue());
        out.putInt(casterId);
    }
}
