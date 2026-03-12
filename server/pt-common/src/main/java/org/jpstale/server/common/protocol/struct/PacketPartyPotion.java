package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPartyPotion : Packet。
 */

@Data
public class PacketPartyPotion extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int mp;  // int iMP  size: 4 bytes
    private int hp;  // int iHP  size: 4 bytes
    private int stm;  // int iSTM  size: 4 bytes
    private int unk;  // int iUnk  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        mp = in.getInt();
        hp = in.getInt();
        stm = in.getInt();
        unk = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(mp);
        out.putInt(hp);
        out.putInt(stm);
        out.putInt(unk);
    }
}
