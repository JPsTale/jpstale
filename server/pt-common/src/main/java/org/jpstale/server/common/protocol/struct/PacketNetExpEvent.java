package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetExpEvent : Packet。
 */

@Data
public class PacketNetExpEvent extends Packet {

    private int percent;  // int iPercent

    @Override
    protected void readBody(ByteBuffer in) {
        percent = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(percent);
    }
}
