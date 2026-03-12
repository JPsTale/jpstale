package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestMonsterName : Packet。
 */

@Data
public class PacketQuestMonsterName extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 34;

    private short monsterUniqueId;  // USHORT uMonsterUniqueID  size: 2 bytes
    private String monsterName;  // char szMonsterName[32]  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        monsterUniqueId = in.getShort();
        monsterName = readCString(in, 32);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putShort(monsterUniqueId);
        writeCString(out, monsterName, 32);
    }
}
