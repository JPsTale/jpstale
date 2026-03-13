package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetIdentifier : Packet。
 */

@Data
public class PacketNetIdentifier extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int serverId;  // int iServerID  size: 4 bytes
    private int port;  // int iPort  size: 4 bytes
    private int passwordNum;  // UINT uPasswordNUM  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
