package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketExtraUserInfo : Packet。
 */

@Data
public class PacketExtraUserInfo extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 14;

    private int uniqueUserId;  // int iUniqueUserID  size: 4 bytes
    private short bellatraSoloCrown;  // short sBellatraSoloCrown  size: 2 bytes
    private short clanSodRanking;  // short iClanSodRanking  size: 2 bytes
    private short forceOrbId;  // short iForceOrbId  size: 2 bytes
    private boolean hideMeFromMiniMap;  // BOOL bHideMeFromMiniMap  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        uniqueUserId = in.getInt();
        bellatraSoloCrown = in.getShort();
        clanSodRanking = in.getShort();
        forceOrbId = in.getShort();
        hideMeFromMiniMap = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(uniqueUserId);
        out.putShort(bellatraSoloCrown);
        out.putShort(clanSodRanking);
        out.putShort(forceOrbId);
        out.putInt(hideMeFromMiniMap ? 1 : 0);
    }
}
