package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuickHealthUpdate : Packet。
 */

@Data
public class PacketQuickHealthUpdate extends Packet {

    private int id;  // ID dwID
    private int hp;  // int sHP

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        hp = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(hp);
    }
}
