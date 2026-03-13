package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/** C++ ItemID (sITEMINFO). Total size: 4 bytes */
@Data
public final class ItemID {
    public static final int SIZE_OF = 4;

    private byte idHigh;    // char iIDHigh  size: 1 byte
    private byte idLow;     // char iIDLow  size: 1 byte
    private short itemType; // short sItemType  size: 2 bytes

    public void readFrom(ByteBuffer in) {
        idHigh = in.get();
        idLow = in.get();
        itemType = in.getShort();
    }

    public void writeTo(ByteBuffer out) {
        out.put(idHigh);
        out.put(idLow);
        out.putShort(itemType);
    }

    public int toInt() {
        return ((idHigh & 0xFF) << 24) | ((idLow & 0xFF) << 16) | (itemType & 0xFFFF);
    }

    public void fromInt(int value) {
        idHigh = (byte) (value >> 24);
        idLow = (byte) (value >> 16);
        itemType = (short) value;
    }
}
