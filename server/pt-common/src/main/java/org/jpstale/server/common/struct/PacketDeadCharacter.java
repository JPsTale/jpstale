package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDeadCharacter : Packet。
 */

@Data
public class PacketDeadCharacter extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int unk;  // int iUnk  size: 4 bytes
    private int objectId;  // int dwObjectID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        unk = in.getInt();
        objectId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(unk);
        out.putInt(objectId);
    }
}
