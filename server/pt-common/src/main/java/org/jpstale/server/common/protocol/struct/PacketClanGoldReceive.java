package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketClanGoldReceive : Packet。
 */

@Data
public class PacketClanGoldReceive extends Packet {

    private int goldSend;  // int iGoldSend
    private int gold;  // int iGold

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
