package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/party.h 中 struct PartyRaidMemberData，SIZE = 24 bytes.
 *
 * 目前作为定长字节块处理，保持与 C 端布局一致。
 */
@Data
public final class PartyRaidMemberData {

    public static final int SIZE_OF = 24;

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

