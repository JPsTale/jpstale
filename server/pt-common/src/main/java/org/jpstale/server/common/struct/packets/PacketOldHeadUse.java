package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketOldHeadUse : Packet。
 */

@Data
public class PacketOldHeadUse extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 68;

    private String headModel;  // char szHeadModel[64]  size: 64 bytes
    private boolean update;  // BOOL bUpdate  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
