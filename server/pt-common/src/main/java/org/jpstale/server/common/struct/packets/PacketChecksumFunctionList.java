package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketChecksumFunctionList : Packet。
 */

@Data
public class PacketChecksumFunctionList extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4801;

    private byte key;  // BYTE bKey  size: 1 bytes
    private ChecksumFunction[] checkSum = new ChecksumFunction[400];  // ChecksumFunction sCheckSum[400]  size: 4800 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        key = in.get();
        for (int i = 0; i < checkSum.length; i++) { if (checkSum[i] == null) checkSum[i] = new ChecksumFunction(); checkSum[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.put(key);
        for (int i = 0; i < checkSum.length; i++) { if (checkSum[i] != null) checkSum[i].writeTo(out); }
    }
}
