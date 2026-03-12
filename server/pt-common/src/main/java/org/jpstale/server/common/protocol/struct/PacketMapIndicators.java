package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketMapIndicators : Packet。
 */

@Data
public class PacketMapIndicators extends Packet {

    private int mapId;  // int iMapID
    private int count;  // int iCount
    private MapIndicator[] mapIndicators = new MapIndicator[30];  // MapIndicator mapIndicators[30]

    @Override
    protected void readBody(ByteBuffer in) {
        mapId = in.getInt();
        count = in.getInt();
        for (int i = 0; i < mapIndicators.length; i++) { if (mapIndicators[i] == null) mapIndicators[i] = new MapIndicator(); mapIndicators[i].readFrom(in); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(mapId);
        out.putInt(count);
        for (int i = 0; i < mapIndicators.length; i++) { if (mapIndicators[i] != null) mapIndicators[i].writeTo(out); }
    }
}
