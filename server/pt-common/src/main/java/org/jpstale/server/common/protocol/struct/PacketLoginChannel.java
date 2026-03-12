package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketLoginChannel : Packet。
 */

@Data
public class PacketLoginChannel extends Packet {

    private String serverName;  // char szServerName[10]
    private int serverTime;  // DWORD dwServerTime
    private int clanTicket;  // int iClanTicket
    private int temp;  // DWORD dwTemp
    private int clanServerCount;  // int iClanServerCount
    private int serverCount;  // int iServerCount
    private TransServerInfo[] serverInfo = new TransServerInfo[4];  // _sTRANS_SERVER_INFO ServerInfo[4]

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
