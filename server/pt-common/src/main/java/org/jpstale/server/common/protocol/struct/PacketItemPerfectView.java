package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketItemPerfectView : Packet。
 */

@Data
public class PacketItemPerfectView extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 8;

    private int cItemData;  // ItemData cItemData  size: 4 bytes
    private int defenseOverride;  // int iDefenseOverride  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        cItemData = in.getInt();
        defenseOverride = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(cItemData);
        out.putInt(defenseOverride);
    }
}
