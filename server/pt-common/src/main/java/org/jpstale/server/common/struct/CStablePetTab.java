package org.jpstale.server.common.struct;

import lombok.Data;
import org.jpstale.server.common.struct.packets.Packet;

import java.nio.ByteBuffer;

/**
 * 对应 shared/CStable.h 中 struct CStablePetTab，SIZE = 222 bytes.
 */
@Data
public final class CStablePetTab {

    public static final int SIZE_OF = 222;

    /** char cPetNameOwner[32]; size: 32 bytes */
    private String ownerName;

    /** CStablePetStucture sCStablePetTab[5]; size: 5 * 38 = 190 bytes */
    private CStablePetStructure[] pets = new CStablePetStructure[5];

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        ownerName = Packet.readCString(in, 32);
        for (int i = 0; i < pets.length; i++) {
            if (pets[i] == null) {
                pets[i] = new CStablePetStructure();
            }
            pets[i].readFrom(in);
        }
    }

    public void writeTo(ByteBuffer out) {
        Packet.writeCString(out, ownerName, 32);
        for (int i = 0; i < pets.length; i++) {
            if (pets[i] != null) {
                pets[i].writeTo(out);
            } else {
                new CStablePetStructure().writeTo(out);
            }
        }
    }
}

