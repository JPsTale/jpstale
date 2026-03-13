package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuickHealthUpdate : Packet。
 */

@Data
public class PacketQuickHealthUpdate extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int id;  // ID dwID  size: 4 bytes
    private int hp;  // int sHP  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
