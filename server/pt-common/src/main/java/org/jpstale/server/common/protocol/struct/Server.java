package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 PacketServerList 内嵌的 struct Server。
 */
@Data
public final class Server {
    public static final int SIZE_OF = 108;

    private String name;              // char szName[32]
    private final String[] ip = new String[3];  // char szaIP[3][20]
    private final int[] port = new int[4];      // int iaPort[4]

    public void readFrom(ByteBuffer in) {
        name = Packet.readCString(in, 32);
        for (int i = 0; i < ip.length; i++) ip[i] = Packet.readCString(in, 20);
        for (int i = 0; i < port.length; i++) port[i] = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        Packet.writeCString(out, name, 32);
        for (int i = 0; i < ip.length; i++) Packet.writeCString(out, ip[i], 20);
        for (int p : port) out.putInt(p);
    }
}
