package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketDeleteCharacter : Packet。
 */

@Data
public class PacketDeleteCharacter extends Packet {

    private int unknown;  // int iUnknown
    private int code;  // int iCode
    private int unk;  // int iUnk
    private String userId;  // char szUserID[32]
    private String charname;  // char szCharname[32]

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
