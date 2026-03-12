package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDeleteCharacter : Packet。
 */

@Data
public class PacketDeleteCharacter extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 76;

    private int unknown;  // int iUnknown  size: 4 bytes
    private int code;  // int iCode  size: 4 bytes
    private int unk;  // int iUnk  size: 4 bytes
    private String userId;  // char szUserID[32]  size: 32 bytes
    private String charname;  // char szCharname[32]  size: 32 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        unknown = in.getInt();
        code = in.getInt();
        unk = in.getInt();
        userId = readCString(in, 32);
        charname = readCString(in, 32);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(unknown);
        out.putInt(code);
        out.putInt(unk);
        writeCString(out, userId, 32);
        writeCString(out, charname, 32);
    }
}
