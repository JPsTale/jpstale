package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketExtraUserInfo : Packet。
 */

@Data
public class PacketExtraUserInfo extends Packet {

    private int uniqueUserId;  // int iUniqueUserID
    private short bellatraSoloCrown;  // short sBellatraSoloCrown
    private short clanSodRanking;  // short iClanSodRanking
    private short forceOrbId;  // short iForceOrbId
    private boolean hideMeFromMiniMap;  // BOOL bHideMeFromMiniMap

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
