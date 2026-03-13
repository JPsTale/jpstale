package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.map.MapId;


/**
 * 对应 packets.h 中 struct PacketGameStatusPvPMap : PacketGameStatusBase。
 */

@Data
public class PacketGameStatusPvPMap extends PacketGameStatusBase {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private MapId pvpMapId;  // EMapID ePvPMapID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        super.readBody(in);
        pvpMapId = MapId.fromValue(in.getInt());
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        super.writeBody(out);
        out.putInt(pvpMapId.getValue());
    }
}
