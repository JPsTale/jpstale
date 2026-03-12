package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketStablePetActivePet : Packet。
 */

@Data
public class PacketStablePetActivePet extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 1;

    private byte petId;  // BYTE bPetID  size: 1 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        petId = in.get();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.put(petId);
    }
}
