package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetIdentifier : Packet。
 */

@Data
public class PacketNetIdentifier extends Packet {

    private int serverId;  // int iServerID
    private int port;  // int iPort
    private int passwordNum;  // UINT uPasswordNUM

    @Override
    protected void readBody(ByteBuffer in) {
        serverId = in.getInt();
        port = in.getInt();
        passwordNum = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(serverId);
        out.putInt(port);
        out.putInt(passwordNum);
    }
}
