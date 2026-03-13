package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketActionParty : Packet。
 */

@Data
public class PacketActionParty extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int action;  // EPartyAction eAction  size: 4 bytes
    private int userId;  // int iUserID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        action = in.getInt();
        userId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(action);
        out.putInt(userId);
    }
}
