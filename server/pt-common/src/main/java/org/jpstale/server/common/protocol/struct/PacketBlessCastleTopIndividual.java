package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBlessCastleTopIndividual : Packet。
 */

@Data
public class PacketBlessCastleTopIndividual extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 124;

    private String[] characterName = new String[3];  // char szCharacterName[3][32]  size: 96 bytes
    private int[] clazz = new int[3];  // int iClass[3]  size: 12 bytes
    private int[] damage = new int[3];  // int iDamage[3]  size: 12 bytes
    private int mode;  // int iMode  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        for (int i = 0; i < 3; i++) { characterName[i] = readCString(in, 32); }
        for (int i = 0; i < clazz.length; i++) { clazz[i] = in.getInt(); }
        for (int i = 0; i < damage.length; i++) { damage[i] = in.getInt(); }
        mode = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        for (int i = 0; i < 3; i++) { writeCString(out, characterName[i], 32); }
        for (int i = 0; i < clazz.length; i++) { out.putInt(clazz[i]); }
        for (int i = 0; i < damage.length; i++) { out.putInt(damage[i]); }
        out.putInt(mode);
    }
}
