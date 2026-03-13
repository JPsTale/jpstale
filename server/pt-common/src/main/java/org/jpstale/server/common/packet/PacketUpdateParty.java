package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketUpdateParty : Packet。
 */

@Data
public class PacketUpdateParty extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 381;

    private byte membersCount;  // char cMembersCount  size: 1 bytes
    private byte partyMode;  // char cPartyMode  size: 1 bytes
    private PartyMember[] members = new PartyMember[6];  // PartyMember saMembers[6]  size: 378 bytes
    private byte raidCount;  // char cRaidCount  size: 1 bytes
    private PartyRaid[] raid = new PartyRaid[0];  // PartyRaid saRaid[0]  size: 0 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        membersCount = in.get();
        partyMode = in.get();
        for (int i = 0; i < members.length; i++) { if (members[i] == null) members[i] = new PartyMember(); members[i].readFrom(in); }
        raidCount = in.get();
        for (int i = 0; i < raid.length; i++) { if (raid[i] == null) raid[i] = new PartyRaid(); raid[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.put(membersCount);
        out.put(partyMode);
        for (int i = 0; i < members.length; i++) { if (members[i] != null) members[i].writeTo(out); }
        out.put(raidCount);
        for (int i = 0; i < raid.length; i++) { if (raid[i] != null) raid[i].writeTo(out); }
    }
}
