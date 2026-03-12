package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCoinServiceBuy : Packet。
 */

@Data
public class PacketCoinServiceBuy extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int type;  // int iType  size: 4 bytes
    private int retCode;  // int iRetCode  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        type = in.getInt();
        retCode = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(type);
        out.putInt(retCode);
    }
}
