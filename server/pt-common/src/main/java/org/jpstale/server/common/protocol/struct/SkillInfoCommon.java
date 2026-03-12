package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct SkillInfoCommon（通用技能信息：id + 名称/文件名/图标/描述字符串）。
 */
@Data
public class SkillInfoCommon {
    private int skillId;           // int iSkillId
    private String skillName;       // char szSkillName[32]
    private String skillFileName;  // char szSkillFileName[32]
    private String skillIconName;  // char szSkillIconName[32]
    private String skillDescription; // char szSkillDescription[150]

    public void readFrom(ByteBuffer in) {
        skillId = in.getInt();
        skillName = Packet.readCString(in, 32);
        skillFileName = Packet.readCString(in, 32);
        skillIconName = Packet.readCString(in, 32);
        skillDescription = Packet.readCString(in, 150);
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(skillId);
        Packet.writeCString(out, skillName, 32);
        Packet.writeCString(out, skillFileName, 32);
        Packet.writeCString(out, skillIconName, 32);
        Packet.writeCString(out, skillDescription, 150);
    }
}
