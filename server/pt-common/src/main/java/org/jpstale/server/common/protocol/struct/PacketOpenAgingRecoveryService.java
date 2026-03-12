package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketOpenAgingRecoveryService : Packet。
 */

@Data
public class PacketOpenAgingRecoveryService extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 572;

    private int count;  // int iCount  size: 4 bytes
    private AgingRecoveryDataHandle[] data = new AgingRecoveryDataHandle[10];  // AgingRecoveryDataHandle saData[10]  size: 560 bytes
    private short packetNumber;  // short sPacketNumber  size: 2 bytes
    private short packetMax;  // short sPacketMax  size: 2 bytes
    private int price;  // int iPrice  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        count = in.getInt();
        for (int i = 0; i < data.length; i++) { if (data[i] == null) data[i] = new AgingRecoveryDataHandle(); data[i].readFrom(in); }
        packetNumber = in.getShort();
        packetMax = in.getShort();
        price = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(count);
        for (int i = 0; i < data.length; i++) { if (data[i] != null) data[i].writeTo(out); }
        out.putShort(packetNumber);
        out.putShort(packetMax);
        out.putInt(price);
    }
}
