package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetEvent : Packet。
 */

@Data
public class PacketNetEvent extends Packet {

    private boolean enabled;  // BOOL Enabled

    @Override
    protected void readBody(ByteBuffer in) {
        enabled = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(enabled ? 1 : 0);
    }
}
