package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBlessCastleTopClanSync : Packet。
 */

@Data
public class PacketBlessCastleTopClanSync extends Packet {

    private int[] clanId = new int[3];  // int iaClanID[3]

    @Override
    protected void readBody(ByteBuffer in) {
        for (int i = 0; i < clanId.length; i++) { clanId[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        for (int i = 0; i < clanId.length; i++) { out.putInt(clanId[i]); }
    }
}
