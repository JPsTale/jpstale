package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct ChecksumFunction（校验和函数项：大小、地址、校验和）。
 */
@Data
public class ChecksumFunction {
    private int size;       // DWORD dwSize
    private int address;    // DWORD dwAddress
    private int checkSum;   // DWORD dwCheckSum

    public void readFrom(ByteBuffer in) {
        size = in.getInt();
        address = in.getInt();
        checkSum = in.getInt();
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(size);
        out.putInt(address);
        out.putInt(checkSum);
    }
}
