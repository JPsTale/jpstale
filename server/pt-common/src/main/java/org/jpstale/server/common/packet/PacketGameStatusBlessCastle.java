package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketGameStatusBlessCastle : PacketGameStatusBase。
 */

@Data
public class PacketGameStatusBlessCastle extends PacketGameStatusBase {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 32;

    private int num1;  // DWORD dwNum1  size: 4 bytes
    private int clanId1;  // int iClanID1  size: 4 bytes
    private int num3;  // DWORD dwNum3  size: 4 bytes
    private int num4;  // DWORD dwNum4  size: 4 bytes
    private short conRate;  // short sConRate  size: 2 bytes
    private short battlePoints;  // short sBattlePoints  size: 2 bytes
    private int num6;  // DWORD dwNum6  size: 4 bytes
    private int clanId2;  // int iClanID2  size: 4 bytes
    private int clanId3;  // int iClanID3  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        super.readBody(in);
        num1 = in.getInt();
        clanId1 = in.getInt();
        num3 = in.getInt();
        num4 = in.getInt();
        conRate = in.getShort();
        battlePoints = in.getShort();
        num6 = in.getInt();
        clanId2 = in.getInt();
        clanId3 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        super.writeBody(out);
        out.putInt(num1);
        out.putInt(clanId1);
        out.putInt(num3);
        out.putInt(num4);
        out.putShort(conRate);
        out.putShort(battlePoints);
        out.putInt(num6);
        out.putInt(clanId2);
        out.putInt(clanId3);
    }
}
