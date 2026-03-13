package org.jpstale.server.common.struct.packets;

import lombok.Data;
import org.jpstale.server.common.struct.TransServerInfo;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketLoginChannel : Packet。
 */

@Data
public class PacketLoginChannel extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 462;

    private String serverName;  // char szServerName[10]  size: 10 bytes
    private int serverTime;  // DWORD dwServerTime  size: 4 bytes
    private int clanTicket;  // int iClanTicket  size: 4 bytes
    private int temp;  // DWORD dwTemp  size: 4 bytes
    private int clanServerCount;  // int iClanServerCount  size: 4 bytes
    private int serverCount;  // int iServerCount  size: 4 bytes
    private TransServerInfo[] serverInfo = new TransServerInfo[4];  // _sTRANS_SERVER_INFO ServerInfo[4]  size: 432 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        serverName = readCString(in, 10);
        serverTime = in.getInt();
        clanTicket = in.getInt();
        temp = in.getInt();
        clanServerCount = in.getInt();
        serverCount = in.getInt();
        for (int i = 0; i < serverInfo.length; i++) { if (serverInfo[i] == null) serverInfo[i] = new TransServerInfo(); serverInfo[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        writeCString(out, serverName, 10);
        out.putInt(serverTime);
        out.putInt(clanTicket);
        out.putInt(temp);
        out.putInt(clanServerCount);
        out.putInt(serverCount);
        for (int i = 0; i < serverInfo.length; i++) { if (serverInfo[i] != null) serverInfo[i].writeTo(out); }
    }
}
