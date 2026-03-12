package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetBCNewOwnerClanID : Packet。
 */

@Data
public class PacketNetBCNewOwnerClanID extends Packet {

    private int clanId1;  // int iClanID1
    private int clanId2;  // int iClanID2
    private int clanId3;  // int iClanID3

    @Override
    protected void readBody(ByteBuffer in) {
        clanId1 = in.getInt();
        clanId2 = in.getInt();
        clanId3 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(clanId1);
        out.putInt(clanId2);
        out.putInt(clanId3);
    }
}
