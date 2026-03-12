package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRankingListRequest : Packet。
 */

@Data
public class PacketRankingListRequest extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 2;

    private short rankingType;  // short iRankingType  size: 2 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        rankingType = in.getShort();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putShort(rankingType);
    }
}
