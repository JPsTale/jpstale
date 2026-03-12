package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/item.h 中 class ItemData。
 *
 * 该结构很大且字段众多，这里暂时按不透明块处理，
 * 仅保证与 C++ 端 Size 对齐，便于 Packet 中嵌套使用并保持 SIZE_OF 正确。
 */
@Data
public final class ItemData {

    // 依据 shared/item.h 尾部注释及实际结构大小估算，脚本中通过 STRUCT_BODY_SIZES 参与计算。
    // 这里采用与 Python 脚本中配置一致的值（若脚本中更新需同步）。
    public static final int SIZE_OF = 0x4B4; // 1204 bytes

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

