package org.jpstale.server.common.struct.party;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/party.h 中 struct PartyRaid，SIZE = 337 bytes.
 */
@Data
public final class PartyRaid {

    public static final int SIZE_OF = 337;

    /** char cRaidID; size: 1 bytes */
    private byte raidId;

    /** PartyRaidMember saMembers[6]; size: 6 * 56 = 336 bytes */
    private PartyRaidMember[] members = new PartyRaidMember[6];

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        raidId = in.get();
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) {
                members[i] = new PartyRaidMember();
            }
            members[i].readFrom(in);
        }
    }

    public void writeTo(ByteBuffer out) {
        out.put(raidId);
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null) {
                members[i].writeTo(out);
            } else {
                new PartyRaidMember().writeTo(out);
            }
        }
    }
}
