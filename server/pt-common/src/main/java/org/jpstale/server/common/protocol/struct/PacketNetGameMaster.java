package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetGameMaster : Packet。
 */

@Data
public class PacketNetGameMaster extends Packet {

    private int objectId;  // UINT uObjectID
    private int gameMasterLevel;  // int iGameMasterLevel

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        gameMasterLevel = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(gameMasterLevel);
    }
}
