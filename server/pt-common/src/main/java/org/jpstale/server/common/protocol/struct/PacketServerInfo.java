package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketServerInfo : Packet。
 */

@Data
public class PacketServerInfo extends Packet {

    private int users;  // int iUsers
    private int maxUsers;  // int iMaxUsers
    private int bossTime;  // int iBossTime
    private int serverVersion;  // int iServerVersion
    private short siegeWarDay;  // short sSiegeWarDay
    private short siegeWarHour;  // short sSiegeWarHour
    private byte siegeWarType;  // BYTE bSiegeWarType
    private boolean gameMaster;  // BOOL bGameMaster
    private SystemTime serverTime;  // SYSTEMTIME sServerTime

    @Override
    protected void readBody(ByteBuffer in) {
        users = in.getInt();
        maxUsers = in.getInt();
        bossTime = in.getInt();
        serverVersion = in.getInt();
        siegeWarDay = in.getShort();
        siegeWarHour = in.getShort();
        siegeWarType = in.get();
        gameMaster = in.getInt() != 0;
        if (serverTime == null) serverTime = new SystemTime(); serverTime.readFrom(in);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(users);
        out.putInt(maxUsers);
        out.putInt(bossTime);
        out.putInt(serverVersion);
        out.putShort(siegeWarDay);
        out.putShort(siegeWarHour);
        out.put(siegeWarType);
        out.putInt(gameMaster ? 1 : 0);
        if (serverTime != null) serverTime.writeTo(out);
    }
}
