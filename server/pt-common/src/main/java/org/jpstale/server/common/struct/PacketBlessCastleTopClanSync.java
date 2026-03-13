package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBlessCastleTopClanSync : Packet。
 */

@Data
public class PacketBlessCastleTopClanSync extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int[] clanId = new int[3];  // int iaClanID[3]  size: 12 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        for (int i = 0; i < clanId.length; i++) { clanId[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        for (int i = 0; i < clanId.length; i++) { out.putInt(clanId[i]); }
    }
}
