package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketChecksumFunctionList : Packet。
 */

@Data
public class PacketChecksumFunctionList extends Packet {

    private byte key;  // BYTE bKey
    private ChecksumFunction[] checkSum = new ChecksumFunction[400];  // ChecksumFunction sCheckSum[400]

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
