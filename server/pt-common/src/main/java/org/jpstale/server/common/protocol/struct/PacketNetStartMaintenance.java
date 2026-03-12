package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetStartMaintenance : Packet。
 */

@Data
public class PacketNetStartMaintenance extends Packet {

    private int seconds;  // int Seconds

    @Override
    protected void readBody(ByteBuffer in) {
        seconds = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(seconds);
    }
}
