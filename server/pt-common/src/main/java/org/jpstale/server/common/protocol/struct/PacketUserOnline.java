package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUserOnline : Packet。
 */

@Data
public class PacketUserOnline extends Packet {

    private int type;  // int iType
    private int id;  // int iID
    private boolean online;  // BOOL bOnline
    private String name;  // char szName[32]

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
