package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBlessCastleTopIndividual : Packet。
 */

@Data
public class PacketBlessCastleTopIndividual extends Packet {

    private String[] characterName = new String[3];  // char szCharacterName[3][32]
    private int[] clazz = new int[3];  // int iClass[3]
    private int[] damage = new int[3];  // int iDamage[3]
    private int mode;  // int iMode

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
