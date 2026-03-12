package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetUsersOnline : Packet。
 */

@Data
public class PacketNetUsersOnline extends Packet {

    private int id;  // int iID
    private int usersOnline;  // int iUsersOnline

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        usersOnline = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(usersOnline);
    }
}
