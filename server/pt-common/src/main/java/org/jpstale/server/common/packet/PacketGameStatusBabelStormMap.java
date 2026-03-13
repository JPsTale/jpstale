package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.map.MapId;


/**
 * 对应 packets.h 中 struct PacketGameStatusBabelStormMap : PacketGameStatusBase。
 */

@Data
public class PacketGameStatusBabelStormMap extends PacketGameStatusBase {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 4;

    private MapId babelStormMapId;  // EMapID eBabelStormMapID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        super.readBody(in);
        babelStormMapId = MapId.fromValue(in.getInt());
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        super.writeBody(out);
        out.putInt(babelStormMapId.getValue());
    }
}
