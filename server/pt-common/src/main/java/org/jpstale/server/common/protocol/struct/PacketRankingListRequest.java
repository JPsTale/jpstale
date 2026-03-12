package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRankingListRequest : Packet。
 */

@Data
public class PacketRankingListRequest extends Packet {

    private short rankingType;  // short iRankingType

    @Override
    protected void readBody(ByteBuffer in) {
        rankingType = in.getShort();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putShort(rankingType);
    }
}
