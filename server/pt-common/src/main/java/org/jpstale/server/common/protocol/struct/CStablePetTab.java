package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/CStable.h 中 struct CStablePetTab，SIZE ≈ 222 bytes（脚本中配置）。
 *
 * 暂以不透明字节块形式存在，用于与 PacketStablePetTab 对应。
 */
@Data
public final class CStablePetTab {

    public static final int SIZE_OF = 222;

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

