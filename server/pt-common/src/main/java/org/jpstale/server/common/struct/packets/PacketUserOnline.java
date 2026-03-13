package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUserOnline : Packet。
 */

@Data
public class PacketUserOnline extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 44;

    private int type;  // int iType  size: 4 bytes
    private int id;  // int iID  size: 4 bytes
    private boolean online;  // BOOL bOnline  size: 4 bytes
    private String name;  // char szName[32]  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        type = in.getInt();
        id = in.getInt();
        online = in.getInt() != 0;
        name = readCString(in, 32);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(type);
        out.putInt(id);
        out.putInt(online ? 1 : 0);
        writeCString(out, name, 32);
    }
}
