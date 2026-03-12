package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketFuryArenaBossData : Packet。
 */

@Data
public class PacketFuryArenaBossData extends Packet {

    private StructFuryArenaBoss hp;  // StructFuryArenaBoss sHP

    @Override
    protected void readBody(ByteBuffer in) {
        if (hp == null) hp = new StructFuryArenaBoss(); hp.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (hp != null) hp.writeTo(out);
    }
}
