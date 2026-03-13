package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerGold : Packet。
 */

@Data
public class PacketNetPlayerGold extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 24;

    private int objectId;  // int ObjectID  size: 4 bytes
    private int goldIn;  // int iGoldIn  size: 4 bytes
    private int goldOut;  // int iGoldOut  size: 4 bytes
    private int inventoryGold;  // int iInventoryGold  size: 4 bytes
    private int saveGold;  // int iSaveGold  size: 4 bytes
    private int characterDataIGold;  // int sCharacterData_iGold  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        goldIn = in.getInt();
        goldOut = in.getInt();
        inventoryGold = in.getInt();
        saveGold = in.getInt();
        characterDataIGold = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(goldIn);
        out.putInt(goldOut);
        out.putInt(inventoryGold);
        out.putInt(saveGold);
        out.putInt(characterDataIGold);
    }
}
