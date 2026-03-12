package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetGetGameMaster : Packet。
 */

@Data
public class PacketNetGetGameMaster extends Packet {

    private int objectId;  // UINT uObjectID
    private int gameMasterLevel;  // int iGameMasterLevel
    private String name;  // char szName[32]

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        gameMasterLevel = in.getInt();
        name = readCString(in, 32);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(gameMasterLevel);
        writeCString(out, name, 32);
    }
}
