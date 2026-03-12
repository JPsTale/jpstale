package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetAskPlayerData : Packet。
 */

@Data
public class PacketNetAskPlayerData extends Packet {

    private int objectId;  // int ObjectID

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
    }
}
