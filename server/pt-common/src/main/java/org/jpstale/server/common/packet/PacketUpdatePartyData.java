package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUpdatePartyData : Packet。
 */

@Data
public class PacketUpdatePartyData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 158;

    private byte membersCount;  // char cMembersCount  size: 1 bytes
    private byte raidMembersCount;  // char cRaidMembersCount  size: 1 bytes
    private PartyMemberData[] members = new PartyMemberData[6];  // PartyMemberData saMembers[6]  size: 156 bytes
    private byte[][] raidMember = new byte[0][6];  // PartyRaidMemberData saRaidMember[0][6]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        membersCount = in.get();
        raidMembersCount = in.get();
        for (int i = 0; i < members.length; i++) { if (members[i] == null) members[i] = new PartyMemberData(); members[i].readFrom(in); }
        for (int i = 0; i < raidMember.length; i++) in.get(raidMember[i]);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.put(membersCount);
        out.put(raidMembersCount);
        for (int i = 0; i < members.length; i++) { if (members[i] != null) members[i].writeTo(out); }
        for (int i = 0; i < raidMember.length; i++) out.put(raidMember[i]);
    }
}
