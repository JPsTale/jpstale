package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRollDiceRanking : Packet。
 */

@Data
public class PacketRollDiceRanking extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 36;

    private String characterName;  // char szCharacterName[32]  size: 32 bytes
    private int number;  // UINT uNumber  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        characterName = readCString(in, 32);
        number = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, characterName, 32);
        out.putInt(number);
    }
}
