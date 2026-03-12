package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketStablePetTab : Packet。
 */

@Data
public class PacketStablePetTab extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int cstablePetTab;  // CStablePetTab sCStablePetTab  size: 4 bytes
    private short packetNumber;  // short sPacketNumber  size: 2 bytes
    private short packetMax;  // short sPacketMax  size: 2 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        cstablePetTab = in.getInt();
        packetNumber = in.getShort();
        packetMax = in.getShort();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(cstablePetTab);
        out.putShort(packetNumber);
        out.putShort(packetMax);
    }
}
