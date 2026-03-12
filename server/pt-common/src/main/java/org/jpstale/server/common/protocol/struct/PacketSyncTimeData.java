package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSyncTimeData : Packet。
 */

@Data
public class PacketSyncTimeData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 16;

    private int netCount;  // DWORD dwNetCount  size: 4 bytes
    private int time;  // DWORD dwTime  size: 4 bytes
    private int unk;  // int iUnk  size: 4 bytes
    private int unk1;  // int iUnk1  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        netCount = in.getInt();
        time = in.getInt();
        unk = in.getInt();
        unk1 = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(netCount);
        out.putInt(time);
        out.putInt(unk);
        out.putInt(unk1);
    }
}
