package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPvPKillType : Packet。
 */

@Data
public class PacketPvPKillType extends Packet {

    private String killerName;  // char szKillerName[32]
    private String victimName;  // char szVictimName[32]
    private int killerClass;  // int iKillerClass
    private int victimClass;  // int iVictimClass
    private int killType;  // int iKillType

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
