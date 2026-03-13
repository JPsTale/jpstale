package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetQuestUpdateDataPart : Packet。
 */

@Data
public class PacketNetQuestUpdateDataPart extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int userId;  // int iUserID  size: 4 bytes
    private boolean updateNpcQuestIcon;  // BOOL bUpdateNPCQuestIcon  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        userId = in.getInt();
        updateNpcQuestIcon = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(userId);
        out.putInt(updateNpcQuestIcon ? 1 : 0);
    }
}
