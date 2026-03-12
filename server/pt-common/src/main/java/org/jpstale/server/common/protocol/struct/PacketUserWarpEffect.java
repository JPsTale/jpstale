package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUserWarpEffect : Packet。
 */

@Data
public class PacketUserWarpEffect extends Packet {

    private int x;  // int iX
    private int id;  // int iID
    private int y;  // int iY
    private int z;  // int iZ

    @Override
    protected void readBody(ByteBuffer in) {
        x = in.getInt();
        id = in.getInt();
        y = in.getInt();
        z = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(x);
        out.putInt(id);
        out.putInt(y);
        out.putInt(z);
    }
}
