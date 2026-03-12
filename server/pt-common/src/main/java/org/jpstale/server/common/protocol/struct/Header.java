package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 PacketServerList 内嵌的 struct Header。
 */
@Data
public final class Header {
    public static final int SIZE_OF = 36;

    private String serverName;   // char szServerName[16]
    private int time;            // DWORD dwTime
    private int ticket;          // int iTicket
    private int unknown;         // DWORD dwUnknown
    private int clanServerIndex; // int iClanServerIndex
    private int gameServers;     // int iGameServers

    public void readFrom(ByteBuffer in) {
        serverName = Packet.readCString(in, 16);
        time = in.getInt();
        ticket = in.getInt();
        unknown = in.getInt();
        clanServerIndex = in.getInt();
        gameServers = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        Packet.writeCString(out, serverName, 16);
        out.putInt(time);
        out.putInt(ticket);
        out.putInt(unknown);
        out.putInt(clanServerIndex);
        out.putInt(gameServers);
    }
}
