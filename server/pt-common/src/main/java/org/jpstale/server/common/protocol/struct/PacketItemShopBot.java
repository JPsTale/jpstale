package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketItemShopBot : Packet。
 */

@Data
public class PacketItemShopBot extends Packet {

    private int checkSum;  // int iCheckSum
    private int[] unk = new int[5];  // int iUnk[5]

    @Override
    protected void readBody(ByteBuffer in) {
        checkSum = in.getInt();
        for (int i = 0; i < unk.length; i++) { unk[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(checkSum);
        for (int i = 0; i < unk.length; i++) { out.putInt(unk[i]); }
    }
}
