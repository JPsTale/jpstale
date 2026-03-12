package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetSendItemData : Packet。
 */

@Data
public class PacketNetSendItemData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 12;

    private int userId;  // ID dwUserID  size: 4 bytes
    private int itemId;  // int iItemID  size: 4 bytes
    private int itemSource;  // EItemSource eItemSource  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        userId = in.getInt();
        itemId = in.getInt();
        itemSource = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(userId);
        out.putInt(itemId);
        out.putInt(itemSource);
    }
}
