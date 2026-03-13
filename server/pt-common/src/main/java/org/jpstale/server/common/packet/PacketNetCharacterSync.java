package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetCharacterSync : Packet。
 */

@Data
public class PacketNetCharacterSync extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 36;

    private int objectId;  // DWORD dwObjectID  size: 4 bytes
    private String charName;  // char szCharName[32]  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
