package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetClan : Packet。
 */

@Data
public class PacketNetClan extends Packet {

    private int objectId;  // UINT uObjectID
    private int clan;  // DWORD dwClan

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        clan = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(clan);
    }
}
