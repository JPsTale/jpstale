package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUseSkillSingle : PacketUseSkillBase。
 */

@Data
public class PacketUseSkillSingle extends PacketUseSkillBase {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private int targetId;  // int lTargetID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        super.readBody(in);
        targetId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        super.writeBody(out);
        out.putInt(targetId);
    }
}
