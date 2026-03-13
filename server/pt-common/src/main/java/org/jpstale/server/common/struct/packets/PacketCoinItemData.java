package org.jpstale.server.common.struct.packets;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketCoinItemData : Packet。
 */

@Data
public class PacketCoinItemData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 24;

    private int id;  // int iID  size: 4 bytes
    private int tabId;  // int iTabID  size: 4 bytes
    private int type;  // int iType  size: 4 bytes
    private boolean spec;  // BOOL bSpec  size: 4 bytes
    private boolean quantity;  // BOOL bQuantity  size: 4 bytes
    private int itemDefinition;  // DefinitionItem sItemDefinition  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        tabId = in.getInt();
        type = in.getInt();
        spec = in.getInt() != 0;
        quantity = in.getInt() != 0;
        itemDefinition = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(tabId);
        out.putInt(type);
        out.putInt(spec ? 1 : 0);
        out.putInt(quantity ? 1 : 0);
        out.putInt(itemDefinition);
    }
}
