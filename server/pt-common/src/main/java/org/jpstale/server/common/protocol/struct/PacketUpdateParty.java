package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUpdateParty : Packet。
 */

@Data
public class PacketUpdateParty extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int cMembersCount;  // char cMembersCount  size: 4 bytes
    private int cPartyMode;  // char cPartyMode  size: 4 bytes
    private int[] members = new int[0];  // PartyMember saMembers[0]  size: 0 bytes
    private int cRaidCount;  // char cRaidCount  size: 4 bytes
    private int[] raid = new int[0];  // PartyRaid saRaid[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        cMembersCount = in.getInt();
        cPartyMode = in.getInt();
        for (int i = 0; i < members.length; i++) { members[i] = in.getInt(); }
        cRaidCount = in.getInt();
        for (int i = 0; i < raid.length; i++) { raid[i] = in.getInt(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(cMembersCount);
        out.putInt(cPartyMode);
        for (int i = 0; i < members.length; i++) { out.putInt(members[i]); }
        out.putInt(cRaidCount);
        for (int i = 0; i < raid.length; i++) { out.putInt(raid[i]); }
    }
}
