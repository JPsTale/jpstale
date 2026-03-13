package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketEventGirlResetResult : PacketEventGirlReset。
 */

@Data
public class PacketEventGirlResetResult extends PacketEventGirlReset {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private boolean result;  // BOOL bResult  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        super.readBody(in);
        result = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        super.writeBody(out);
        out.putInt(result ? 1 : 0);
    }
}
