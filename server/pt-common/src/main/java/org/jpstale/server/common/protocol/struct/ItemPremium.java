package org.jpstale.server.common.protocol.struct;

import lombok.Data;
import org.jpstale.server.common.enums.ItemTimerType;

import java.nio.ByteBuffer;

/**
 * 对应 premiumstruct.h 中 struct ItemPremium（道具计时类型 + 编码与时间）。
 */
@Data
public final class ItemPremium {
    public static final int SIZE_OF = 16;

    private int type;       // EItemTimerType eType (int)
    private int code;       // DWORD dwCode
    private int timeLeft;   // DWORD dwTimeLeft
    private int timeTotal;  // DWORD dwTimeTotal

    public void readFrom(ByteBuffer in) {
        type = in.getInt();
        code = in.getInt();
        timeLeft = in.getInt();
        timeTotal = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(type);
        out.putInt(code);
        out.putInt(timeLeft);
        out.putInt(timeTotal);
    }
}
