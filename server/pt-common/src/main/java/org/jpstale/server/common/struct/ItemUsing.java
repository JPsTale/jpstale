package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 ItemUsing：物品 ID + 表现数组 sPerformance[8]。
 */
@Data
public final class ItemUsing {
    public static final int SIZE_OF = 20;

    private int itemId;                    // int iItemID
    private final short[] performance = new short[8];  // short sPerformance[8]

    public void readFrom(ByteBuffer in) {
        itemId = in.getInt();
        for (int i = 0; i < performance.length; i++) {
            performance[i] = in.getShort();
        }
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(itemId);
        for (short p : performance) {
            out.putShort(p);
        }
    }
}
