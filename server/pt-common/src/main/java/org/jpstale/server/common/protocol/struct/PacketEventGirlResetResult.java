package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketEventGirlResetResult : PacketEventGirlReset。
 */

@Data
public class PacketEventGirlResetResult extends PacketEventGirlReset {

    private boolean result;  // BOOL bResult

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
