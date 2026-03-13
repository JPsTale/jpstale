package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct SkillInfo（技能详情：名称/文件/图标/描述、等级、类型等）。
 */
@Data
public final class SkillInfo {
    public static final int SIZE_OF = 314;

    private int skillNum;           // int iSkillNum (1-based)
    private String skillName;       // char szSkillName[32]
    private String skillFileName;  // char szSkillFileName[32]
    private String skillIconName;  // char szSkillIconName[32]
    private String skillDescription; // char szSkillDescription[150]
    private int skillId;           // int iSkillId
    private byte skillReqLevel;    // BYTE iSkillReqLevel
    private byte skillType;        // BYTE iSkillType
    private int funcPointer;       // DWORD dwFuncPointer
    private int manaPointer;       // DWORD dwManaPointer
    private byte flinchChance;     // BYTE iFlinchChance
    private byte pushbackRange;    // BYTE iPushbackRange
    private short skillUseStaminaBase;     // short sSkillUseStaminaBase
    private short skillUseStaminaPerLevel; // short sSkillUseStaminaPerLevel
    private short skillMasteryBase;        // short sSkillMasteryBase
    private short skillMasteryPerLevel;    // short sSkillMasteryPerLevel
    private final int[] itemAllowedType = new int[8]; // int iaItemAllowedType[8]
    private float pvpScaling;      // float pvpScaling

    public void readFrom(ByteBuffer in) {
        skillNum = in.getInt();
        skillName = Packet.readCString(in, 32);
        skillFileName = Packet.readCString(in, 32);
        skillIconName = Packet.readCString(in, 32);
        skillDescription = Packet.readCString(in, 150);
        skillId = in.getInt();
        skillReqLevel = in.get();
        skillType = in.get();
        funcPointer = in.getInt();
        manaPointer = in.getInt();
        flinchChance = in.get();
        pushbackRange = in.get();
        skillUseStaminaBase = in.getShort();
        skillUseStaminaPerLevel = in.getShort();
        skillMasteryBase = in.getShort();
        skillMasteryPerLevel = in.getShort();
        for (int i = 0; i < itemAllowedType.length; i++) itemAllowedType[i] = in.getInt();
        pvpScaling = in.getFloat();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(skillNum);
        Packet.writeCString(out, skillName, 32);
        Packet.writeCString(out, skillFileName, 32);
        Packet.writeCString(out, skillIconName, 32);
        Packet.writeCString(out, skillDescription, 150);
        out.putInt(skillId);
        out.put(skillReqLevel);
        out.put(skillType);
        out.putInt(funcPointer);
        out.putInt(manaPointer);
        out.put(flinchChance);
        out.put(pushbackRange);
        out.putShort(skillUseStaminaBase);
        out.putShort(skillUseStaminaPerLevel);
        out.putShort(skillMasteryBase);
        out.putShort(skillMasteryPerLevel);
        for (int j : itemAllowedType) out.putInt(j);
        out.putFloat(pvpScaling);
    }
}
