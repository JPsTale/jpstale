package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUseSkillParty : PacketUseSkillBase。
 */

@Data
public class PacketUseSkillParty extends PacketUseSkillBase {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 68;

    private int userCount;  // int iUserCount  size: 4 bytes
    private int[] aiUserId = new int[16];  // ID aiUserID[16]  size: 64 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        super.readBody(in);
        userCount = in.getInt();
        for (int i = 0; i < aiUserId.length; i++) { aiUserId[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        super.writeBody(out);
        out.putInt(userCount);
        for (int i = 0; i < aiUserId.length; i++) { out.putInt(aiUserId[i]); }
    }
}
