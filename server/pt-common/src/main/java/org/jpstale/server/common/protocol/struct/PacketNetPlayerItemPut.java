package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerItemPut : Packet。
 */

@Data
public class PacketNetPlayerItemPut extends Packet {

    private int objectId;  // int ObjectID
    private int exceptedHash;  // int ExceptedHash

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        exceptedHash = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(exceptedHash);
    }
}
