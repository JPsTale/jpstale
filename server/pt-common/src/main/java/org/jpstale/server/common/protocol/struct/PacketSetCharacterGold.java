package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSetCharacterGold : Packet。
 */

@Data
public class PacketSetCharacterGold extends Packet {

    private int gold;  // DWORD dwGold

    @Override
    protected void readBody(ByteBuffer in) {
        gold = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(gold);
    }
}
