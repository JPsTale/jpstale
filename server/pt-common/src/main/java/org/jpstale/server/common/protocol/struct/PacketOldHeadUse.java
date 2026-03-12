package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketOldHeadUse : Packet。
 */

@Data
public class PacketOldHeadUse extends Packet {

    private String headModel;  // char szHeadModel[64]
    private boolean update;  // BOOL bUpdate

    @Override
    protected void readBody(ByteBuffer in) {
        headModel = readCString(in, 64);
        update = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, headModel, 64);
        out.putInt(update ? 1 : 0);
    }
}
