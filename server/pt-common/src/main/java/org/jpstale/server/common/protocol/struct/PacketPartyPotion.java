package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPartyPotion : Packet。
 */

@Data
public class PacketPartyPotion extends Packet {

    private int mp;  // int iMP
    private int hp;  // int iHP
    private int stm;  // int iSTM
    private int unk;  // int iUnk

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
