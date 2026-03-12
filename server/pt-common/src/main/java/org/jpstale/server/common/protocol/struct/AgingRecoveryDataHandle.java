package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/Coin.h 中的 struct AgingRecoveryDataHandle，SIZE = 56 bytes.
 *
 * 当前实现将其视为不透明的定长字节块，保持与 C 端完全一致的布局，
 * 便于内嵌到 Packet 中保证 SIZE_OF 正确；如需字段级访问，可在后续重构中细化。
 */
@Data
public final class AgingRecoveryDataHandle {

    public static final int SIZE_OF = 56;

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

