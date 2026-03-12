package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketClanGoldReceive : Packet。
 */

@Data
public class PacketClanGoldReceive extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int goldSend;  // int iGoldSend  size: 4 bytes
    private int gold;  // int iGold  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        goldSend = in.getInt();
        gold = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(goldSend);
        out.putInt(gold);
    }
}
