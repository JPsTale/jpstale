package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerGoldDiff : Packet。
 */

@Data
public class PacketNetPlayerGoldDiff extends Packet {

    private int objectId;  // int ObjectID
    private int diff;  // int Diff

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        diff = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(diff);
    }
}
