package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/party.h 中 struct PartyMember，SIZE = 63 bytes.
 */
@Data
public final class PartyMember {

    public static final int SIZE_OF = 63;

    /** char szCharacterName[32]; size: 32 bytes */
    private String characterName;

    /** char cCharacterClass; size: 1 bytes */
    private byte characterClass;

    /** int iClanID; size: 4 bytes */
    private int clanId;

    /** PartyMemberData sData; size: 26 bytes */
    private PartyMemberData data = new PartyMemberData();

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        characterName = Packet.readCString(in, 32);
        characterClass = in.get();
        clanId = in.getInt();
        if (data == null) {
            data = new PartyMemberData();
        }
        data.readFrom(in);
    }

    public void writeTo(ByteBuffer out) {
        Packet.writeCString(out, characterName, 32);
        out.put(characterClass);
        out.putInt(clanId);
        if (data != null) {
            data.writeTo(out);
        } else {
            new PartyMemberData().writeTo(out);
        }
    }
}

