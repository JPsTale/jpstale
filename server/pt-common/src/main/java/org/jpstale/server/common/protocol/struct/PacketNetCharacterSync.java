package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetCharacterSync : Packet。
 */

@Data
public class PacketNetCharacterSync extends Packet {

    private int objectId;  // DWORD dwObjectID
    private String charName;  // char szCharName[32]

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        charName = readCString(in, 32);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        writeCString(out, charName, 32);
    }
}
