package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketGameStatusBase : Packet。
 */

@Data
public class PacketGameStatusBase extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int statusId;  // int iStatusID  size: 4 bytes
    private int lId;  // ID lID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        statusId = in.getInt();
        lId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(statusId);
        out.putInt(lId);
    }
}
