package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketTradeCoinSet : Packet。
 */

@Data
public class PacketTradeCoinSet extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int id;  // int iID  size: 4 bytes
    private int coins;  // int iCoins  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        coins = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(coins);
    }
}
