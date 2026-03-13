package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/party.h 中 struct PartyRaidMember，SIZE = 56 bytes（32 + 24）。
 */
@Data
public final class PartyRaidMember {

    public static final int SIZE_OF = 56;

    /** char szCharacterName[32]; size: 32 bytes */
    private String characterName;

    /** PartyRaidMemberData sData; size: 24 bytes */
    private PartyRaidMemberData data = new PartyRaidMemberData();

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        characterName = Packet.readCString(in, 32);
        data.readFrom(in);
    }

    public void writeTo(ByteBuffer out) {
        Packet.writeCString(out, characterName, 32);
        data.writeTo(out);
    }
}

