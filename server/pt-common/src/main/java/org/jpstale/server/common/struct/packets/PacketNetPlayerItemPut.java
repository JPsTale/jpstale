package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerItemPut : Packet。
 */

@Data
public class PacketNetPlayerItemPut extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int objectId;  // int ObjectID  size: 4 bytes
    private int exceptedHash;  // int ExceptedHash  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        exceptedHash = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(exceptedHash);
    }
}
