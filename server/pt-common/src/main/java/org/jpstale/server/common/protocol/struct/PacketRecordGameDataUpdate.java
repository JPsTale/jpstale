package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketRecordGameDataUpdate : Packet。
 */

@Data
public class PacketRecordGameDataUpdate extends Packet {

    private boolean update;  // BOOL bUpdate

    @Override
    protected void readBody(ByteBuffer in) {
        update = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(update ? 1 : 0);
    }
}
