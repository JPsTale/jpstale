package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBlessCastleStatus : Packet。
 */

@Data
public class PacketBlessCastleStatus extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 56;

    private BlessCastleStatusShort blessCastleStatus;  // BlessCastleStatusShort sBlessCastleStatus  size: 56 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (blessCastleStatus == null) blessCastleStatus = new BlessCastleStatusShort(); blessCastleStatus.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (blessCastleStatus != null) blessCastleStatus.writeTo(out);
    }
}
