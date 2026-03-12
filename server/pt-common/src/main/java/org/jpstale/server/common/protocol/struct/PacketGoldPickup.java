package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketGoldPickup : Packet。
 */

@Data
public class PacketGoldPickup extends Packet {

    private int amount;  // int iAmount

    @Override
    protected void readBody(ByteBuffer in) {
        amount = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(amount);
    }
}
