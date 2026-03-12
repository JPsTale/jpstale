package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct SkillArrayData（技能 ID + 数组地址/索引 + union 值，线上按 int[10] 传输）。
 */
@Data
public final class SkillArrayData {
    public static final int SIZE_OF = 48;

    private int skillId;                    // int iSkillID
    private int skillArrayAddressOrIndex;   // DWORD dwSkillArrayAddressOrIndex
    private final int[] skillValues = new int[10]; // union: int iSkillValues[10] / float fSkillValues[10]

    public void readFrom(ByteBuffer in) {
        skillId = in.getInt();
        skillArrayAddressOrIndex = in.getInt();
        for (int i = 0; i < skillValues.length; i++) skillValues[i] = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(skillId);
        out.putInt(skillArrayAddressOrIndex);
        for (int v : skillValues) out.putInt(v);
    }

}
