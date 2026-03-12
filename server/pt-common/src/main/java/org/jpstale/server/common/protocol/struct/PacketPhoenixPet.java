package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.PhoenixType;


/**
 * 对应 packets.h 中 struct PacketPhoenixPet : Packet。
 */

@Data
public class PacketPhoenixPet extends Packet {

    private int elementType;  // int iElementType
    private PhoenixType type;  // EPhoenixType eType
    private int unk;  // int iUnk
    private int mask;  // DWORD dwMask

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
