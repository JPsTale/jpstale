package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketNetPlayerGold : Packet。
 */

@Data
public class PacketNetPlayerGold extends Packet {

    private int objectId;  // int ObjectID
    private int goldIn;  // int iGoldIn
    private int goldOut;  // int iGoldOut
    private int inventoryGold;  // int iInventoryGold
    private int saveGold;  // int iSaveGold
    private int characterDataIGold;  // int sCharacterData_iGold

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
