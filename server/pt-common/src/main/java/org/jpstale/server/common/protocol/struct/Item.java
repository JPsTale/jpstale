package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/item.h 中 struct Item（sITEMINFO）。
 *
 * 暂按不透明块处理，用于对齐网络协议。
 */
@Data
public final class Item {

    // 按 shared/item.h 结构大小及 Python 脚本配置保持一致。
    public static final int SIZE_OF = 0x4C4; // 1220 bytes

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

