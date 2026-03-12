package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketWarpGateField : Packet。
 */

@Data
public class PacketWarpGateField extends Packet {

    private int z;  // int iZ
    private int stage;  // int iStage
    private int x;  // int iX

    @Override
    protected void readBody(ByteBuffer in) {
        z = in.getInt();
        stage = in.getInt();
        x = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(z);
        out.putInt(stage);
        out.putInt(x);
    }
}
