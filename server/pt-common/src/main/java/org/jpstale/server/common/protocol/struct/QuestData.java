package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/quest.h 中 PacketDynamicQuestOpen 内部 struct QuestData。
 *
 * 当前只按 80 字节定长块处理（见脚本中的 STRUCT_BODY_SIZES），
 * 不展开具体字段，确保与 C++ 布局一致，供 PacketDynamicQuestOpen 内联使用。
 */
@Data
public final class QuestData {

    public static final int SIZE_OF = 80;

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

