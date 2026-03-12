package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.IntegrityUpdate;


/**
 * 对应 packets.h 中 struct PacketUpdateIntegrity : Packet。
 */

@Data
public class PacketUpdateIntegrity extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1;

    private IntegrityUpdate update;  // EIntegrityUpdate eUpdate  size: 1 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        update = IntegrityUpdate.fromValue(in.get() & 0xFF);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.put((byte) update.getValue());
    }
}
