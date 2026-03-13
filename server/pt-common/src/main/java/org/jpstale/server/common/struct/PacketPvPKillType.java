package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPvPKillType : Packet。
 */

@Data
public class PacketPvPKillType extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 76;

    private String killerName;  // char szKillerName[32]  size: 32 bytes
    private String victimName;  // char szVictimName[32]  size: 32 bytes
    private int killerClass;  // int iKillerClass  size: 4 bytes
    private int victimClass;  // int iVictimClass  size: 4 bytes
    private int killType;  // int iKillType  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        killerName = readCString(in, 32);
        victimName = readCString(in, 32);
        killerClass = in.getInt();
        victimClass = in.getInt();
        killType = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, killerName, 32);
        writeCString(out, victimName, 32);
        out.putInt(killerClass);
        out.putInt(victimClass);
        out.putInt(killType);
    }
}
