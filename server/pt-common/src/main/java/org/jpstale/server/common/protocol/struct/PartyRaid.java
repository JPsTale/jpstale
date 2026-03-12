package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/party.h 中 struct PartyRaid，SIZE ≈ 337 bytes（脚本中配置）。
 *
 * 当前实现将其内容视作不透明的定长字节块，仅保证网络协议布局正确。
 */
@Data
public final class PartyRaid {

    public static final int SIZE_OF = 337;

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

