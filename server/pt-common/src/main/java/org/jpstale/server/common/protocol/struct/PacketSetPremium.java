package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSetPremium : Packet。
 */

@Data
public class PacketSetPremium extends Packet {

    private int code;  // DWORD dwCode

    @Override
    protected void readBody(ByteBuffer in) {
        code = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(code);
    }
}
