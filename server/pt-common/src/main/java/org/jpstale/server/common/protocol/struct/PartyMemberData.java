package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/party.h 中 struct PartyMemberData，SIZE = 26 bytes.
 *
 * 目前按不透明字节块处理，只保证字节布局与 C 端一致，
 * 供 Packet 内联读写与 SIZE_OF 计算使用。
 */
@Data
public final class PartyMemberData {

    public static final int SIZE_OF = 26;

    private final byte[] data = new byte[SIZE_OF];

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        in.get(data);
    }

    public void writeTo(ByteBuffer out) {
        out.put(data);
    }
}

