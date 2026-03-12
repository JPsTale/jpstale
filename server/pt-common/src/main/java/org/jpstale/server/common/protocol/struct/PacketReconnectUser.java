package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketReconnectUser : Packet。
 */

@Data
public class PacketReconnectUser extends Packet {

    private int unk;  // int iUnk
    private int objectId;  // DWORD dwObjectID
    private String userId;  // char szUserID[32]

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
