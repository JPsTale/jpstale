package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;


/**
 * 对应 packets.h 中 struct PacketFuryArenaBossData : Packet。
 */

@Data
public class PacketFuryArenaBossData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private StructFuryArenaBoss hp;  // StructFuryArenaBoss sHP  size: 8 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (hp == null) hp = new StructFuryArenaBoss(); hp.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (hp != null) hp.writeTo(out);
    }
}
