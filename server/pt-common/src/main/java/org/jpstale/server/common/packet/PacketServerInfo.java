package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketServerInfo : Packet。
 */

@Data
public class PacketServerInfo extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 41;

    private int users;  // int iUsers  size: 4 bytes
    private int maxUsers;  // int iMaxUsers  size: 4 bytes
    private int bossTime;  // int iBossTime  size: 4 bytes
    private int serverVersion;  // int iServerVersion  size: 4 bytes
    private short siegeWarDay;  // short sSiegeWarDay  size: 2 bytes
    private short siegeWarHour;  // short sSiegeWarHour  size: 2 bytes
    private byte siegeWarType;  // BYTE bSiegeWarType  size: 1 bytes
    private boolean gameMaster;  // BOOL bGameMaster  size: 4 bytes
    private SystemTime serverTime;  // SYSTEMTIME sServerTime  size: 16 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
