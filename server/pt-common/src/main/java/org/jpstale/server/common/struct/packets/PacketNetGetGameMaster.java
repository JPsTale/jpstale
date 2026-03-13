package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetGetGameMaster : Packet。
 */

@Data
public class PacketNetGetGameMaster extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 40;

    private int objectId;  // UINT uObjectID  size: 4 bytes
    private int gameMasterLevel;  // int iGameMasterLevel  size: 4 bytes
    private String name;  // char szName[32]  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
