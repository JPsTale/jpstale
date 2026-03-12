package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketReconnectUser : Packet。
 */

@Data
public class PacketReconnectUser extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 40;

    private int unk;  // int iUnk  size: 4 bytes
    private int objectId;  // DWORD dwObjectID  size: 4 bytes
    private String userId;  // char szUserID[32]  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        unk = in.getInt();
        objectId = in.getInt();
        userId = readCString(in, 32);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(unk);
        out.putInt(objectId);
        writeCString(out, userId, 32);
    }
}
