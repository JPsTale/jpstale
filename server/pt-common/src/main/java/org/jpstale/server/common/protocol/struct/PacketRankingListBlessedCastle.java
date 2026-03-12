package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRankingListBlessedCastle : Packet。
 */

@Data
public class PacketRankingListBlessedCastle extends Packet {

    private String nameClan;  // char szNameClan[32]
    private String clanLeader;  // char szClanLeader[32]
    private int clanBlessIconId;  // int iClanBlessIconID

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
