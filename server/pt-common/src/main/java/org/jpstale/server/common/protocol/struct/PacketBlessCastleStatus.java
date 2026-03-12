package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketBlessCastleStatus : Packet。
 */

@Data
public class PacketBlessCastleStatus extends Packet {

    private BlessCastleStatusShort blessCastleStatus;  // BlessCastleStatusShort sBlessCastleStatus

    @Override
    protected void readBody(ByteBuffer in) {
        if (blessCastleStatus == null) blessCastleStatus = new BlessCastleStatusShort(); blessCastleStatus.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (blessCastleStatus != null) blessCastleStatus.writeTo(out);
    }
}
