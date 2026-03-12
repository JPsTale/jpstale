package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSelectCharacter : Packet。
 */

@Data
public class PacketSelectCharacter extends Packet {

    private int reserved1;  // int dwReserved1
    private int reserved2;  // int dwReserved2
    private int reserved3;  // int dwReserved3
    private String charName;  // char szCharName[32]

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
