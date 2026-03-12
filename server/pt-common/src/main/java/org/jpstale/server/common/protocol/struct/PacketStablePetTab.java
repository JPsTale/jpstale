package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketStablePetTab : Packet。
 */

@Data
public class PacketStablePetTab extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 226;

    private CStablePetTab cstablePetTab;  // CStablePetTab sCStablePetTab  size: 222 bytes
    private short packetNumber;  // short sPacketNumber  size: 2 bytes
    private short packetMax;  // short sPacketMax  size: 2 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        if (cstablePetTab == null) cstablePetTab = new CStablePetTab(); cstablePetTab.readFrom(in);
        packetNumber = in.getShort();
        packetMax = in.getShort();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        if (cstablePetTab != null) cstablePetTab.writeTo(out);
        out.putShort(packetNumber);
        out.putShort(packetMax);
    }
}
