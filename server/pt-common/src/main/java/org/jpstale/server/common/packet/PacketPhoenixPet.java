package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.packets.PhoenixType;


/**
 * 对应 packets.h 中 struct PacketPhoenixPet : Packet。
 */

@Data
public class PacketPhoenixPet extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int elementType;  // int iElementType  size: 4 bytes
    private PhoenixType type;  // EPhoenixType eType  size: 4 bytes
    private int unk;  // int iUnk  size: 4 bytes
    private int mask;  // DWORD dwMask  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        elementType = in.getInt();
        type = PhoenixType.fromValue(in.getInt());
        unk = in.getInt();
        mask = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(elementType);
        out.putInt(type.getValue());
        out.putInt(unk);
        out.putInt(mask);
    }
}
