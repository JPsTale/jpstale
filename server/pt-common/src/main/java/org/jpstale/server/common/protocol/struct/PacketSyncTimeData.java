package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSyncTimeData : Packet。
 */

@Data
public class PacketSyncTimeData extends Packet {

    private int netCount;  // DWORD dwNetCount
    private int time;  // DWORD dwTime
    private int unk;  // int iUnk
    private int unk1;  // int iUnk1

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
