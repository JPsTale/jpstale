package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDeadCharacter : Packet。
 */

@Data
public class PacketDeadCharacter extends Packet {

    private int unk;  // int iUnk
    private int objectId;  // int dwObjectID

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
