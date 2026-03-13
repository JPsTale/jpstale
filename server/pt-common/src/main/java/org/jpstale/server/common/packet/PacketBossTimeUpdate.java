package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBossTimeUpdate : Packet。
 */

@Data
public class PacketBossTimeUpdate extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 40;

    private String bossName;  // char szBossName[32]  size: 32 bytes
    private int time;  // DWORD dwTime  size: 4 bytes
    private int mapId;  // int iMapID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        bossName = readCString(in, 32);
        time = in.getInt();
        mapId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, bossName, 32);
        out.putInt(time);
        out.putInt(mapId);
    }
}
