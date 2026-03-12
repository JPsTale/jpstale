package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUpdatePartyData : Packet。
 */

@Data
public class PacketUpdatePartyData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int cMembersCount;  // char cMembersCount  size: 4 bytes
    private int cRaidMembersCount;  // char cRaidMembersCount  size: 4 bytes
    private int[] members = new int[0];  // PartyMemberData saMembers[0]  size: 0 bytes
    private byte[][] raidMember = new byte[0][0];  // PartyRaidMemberData saRaidMember[0][0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        cMembersCount = in.getInt();
        cRaidMembersCount = in.getInt();
        for (int i = 0; i < members.length; i++) { members[i] = in.getInt(); }
        for (int i = 0; i < raidMember.length; i++) in.get(raidMember[i]);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(cMembersCount);
        out.putInt(cRaidMembersCount);
        for (int i = 0; i < members.length; i++) { out.putInt(members[i]); }
        for (int i = 0; i < raidMember.length; i++) out.put(raidMember[i]);
    }
}
