package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

import org.jpstale.server.common.enums.StablePetRarity;

/**
 * 对应 shared/CStable.h 中 struct CStablePetStucture，SIZE = 38 bytes.
 */
@Data
public final class CStablePetStructure {

    public static final int SIZE_OF = 38;

    /** BYTE sPetId; size: 1 bytes */
    private byte petId;

    /** StablePetRarity sStablePetRarity; size: 1 bytes */
    private StablePetRarity rarity;

    /** char cPetName[32]; size: 32 bytes */
    private String petName;

    /** BOOL bActivePet; size: 4 bytes */
    private boolean activePet;

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        petId = in.get();
        rarity = StablePetRarity.fromValue(in.get() & 0xFF);
        petName = Packet.readCString(in, 32);
        activePet = in.getInt() != 0;
    }

    public void writeTo(ByteBuffer out) {
        out.put(petId);
        out.put((byte) rarity.getValue());
        Packet.writeCString(out, petName, 32);
        out.putInt(activePet ? 1 : 0);
    }
}

