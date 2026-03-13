package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 _sTRANS_SERVER_INFO：区服名、IP、端口等。
 */
@Data
public final class TransServerInfo {
    public static final int SIZE_OF = 108;

    private String serverName;   // char szServerName[0x20]
    private String serverIp1;    // char szServerIp1[0x14]
    private String serverIp2;    // char szServerIp2[0x14]
    private String serverIp3;    // char szServerIp3[0x14]
    private int serverPort1;     // DWORD dwServerPort1
    private int serverPort2;     // DWORD dwServerPort2
    private int serverPort3;     // DWORD dwServerPort3
    private int unknown;         // DWORD dwUnknown

    public void readFrom(ByteBuffer in) {
        serverName = Packet.readCString(in, 0x20);
        serverIp1 = Packet.readCString(in, 0x14);
        serverIp2 = Packet.readCString(in, 0x14);
        serverIp3 = Packet.readCString(in, 0x14);
        serverPort1 = in.getInt();
        serverPort2 = in.getInt();
        serverPort3 = in.getInt();
        unknown = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        Packet.writeCString(out, serverName, 0x20);
        Packet.writeCString(out, serverIp1, 0x14);
        Packet.writeCString(out, serverIp2, 0x14);
        Packet.writeCString(out, serverIp3, 0x14);
        out.putInt(serverPort1);
        out.putInt(serverPort2);
        out.putInt(serverPort3);
        out.putInt(unknown);
    }
}
