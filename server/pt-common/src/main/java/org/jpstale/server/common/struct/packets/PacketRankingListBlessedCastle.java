package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRankingListBlessedCastle : Packet。
 */

@Data
public class PacketRankingListBlessedCastle extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 68;

    private String nameClan;  // char szNameClan[32]  size: 32 bytes
    private String clanLeader;  // char szClanLeader[32]  size: 32 bytes
    private int clanBlessIconId;  // int iClanBlessIconID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        nameClan = readCString(in, 32);
        clanLeader = readCString(in, 32);
        clanBlessIconId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, nameClan, 32);
        writeCString(out, clanLeader, 32);
        out.putInt(clanBlessIconId);
    }
}
