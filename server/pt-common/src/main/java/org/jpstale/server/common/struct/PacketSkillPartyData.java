package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSkillPartyData : Packet。
 */

@Data
public class PacketSkillPartyData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 28;

    private int skillId;  // int iSkillID  size: 4 bytes
    private int level;  // int iLevel  size: 4 bytes
    private int param1;  // int iParam1  size: 4 bytes
    private int param2;  // int iParam2  size: 4 bytes
    private int param3;  // int iParam3  size: 4 bytes
    private int clazz;  // int iClass  size: 4 bytes
    private int count;  // int iCount  size: 4 bytes
    private int[] id = new int[0];  // int iaID[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        skillId = in.getInt();
        level = in.getInt();
        param1 = in.getInt();
        param2 = in.getInt();
        param3 = in.getInt();
        clazz = in.getInt();
        count = in.getInt();
        for (int i = 0; i < id.length; i++) { id[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(skillId);
        out.putInt(level);
        out.putInt(param1);
        out.putInt(param2);
        out.putInt(param3);
        out.putInt(clazz);
        out.putInt(count);
        for (int i = 0; i < id.length; i++) { out.putInt(id[i]); }
    }
}
