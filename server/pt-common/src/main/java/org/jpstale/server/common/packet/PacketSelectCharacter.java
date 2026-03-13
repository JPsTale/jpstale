package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSelectCharacter : Packet。
 */

@Data
public class PacketSelectCharacter extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 44;

    private int reserved1;  // int dwReserved1  size: 4 bytes
    private int reserved2;  // int dwReserved2  size: 4 bytes
    private int reserved3;  // int dwReserved3  size: 4 bytes
    private String charName;  // char szCharName[32]  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        reserved1 = in.getInt();
        reserved2 = in.getInt();
        reserved3 = in.getInt();
        charName = readCString(in, 32);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(reserved1);
        out.putInt(reserved2);
        out.putInt(reserved3);
        writeCString(out, charName, 32);
    }
}
