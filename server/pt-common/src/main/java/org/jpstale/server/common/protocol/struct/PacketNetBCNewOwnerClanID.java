package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetBCNewOwnerClanID : Packet。
 */

@Data
public class PacketNetBCNewOwnerClanID extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int clanId1;  // int iClanID1  size: 4 bytes
    private int clanId2;  // int iClanID2  size: 4 bytes
    private int clanId3;  // int iClanID3  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
