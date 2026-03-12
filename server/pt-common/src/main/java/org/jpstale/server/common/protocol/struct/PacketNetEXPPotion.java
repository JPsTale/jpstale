package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetEXPPotion : Packet。
 */

@Data
public class PacketNetEXPPotion extends Packet {

    private int objectId;  // DWORD dwObjectID
    private int exppotion;  // int iEXPPotion

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        exppotion = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(exppotion);
    }
}
