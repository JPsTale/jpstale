package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestUpdateData : Packet。
 */

@Data
public class PacketQuestUpdateData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 56;

    private int id;  // int iID  size: 4 bytes
    private int timeLeft;  // DWORD dwTimeLeft  size: 4 bytes
    private short monsterCount;  // USHORT iMonsterCount  size: 2 bytes
    private short[] monstersKilled = new short[5];  // USHORT saMonstersKilled[5]  size: 10 bytes
    private short[] monstersReq = new short[5];  // USHORT saMonstersReq[5]  size: 10 bytes
    private short itemsCount;  // USHORT iItemsCount  size: 2 bytes
    private short[] itemsCollected = new short[5];  // USHORT saItemsCollected[5]  size: 10 bytes
    private short[] itemsReq = new short[5];  // USHORT saItemsReq[5]  size: 10 bytes
    private boolean finishedOtherRequirements;  // BOOL bFinishedOtherRequirements  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        timeLeft = in.getInt();
        monsterCount = in.getShort();
        for (int i = 0; i < monstersKilled.length; i++) { monstersKilled[i] = in.getShort(); }
        for (int i = 0; i < monstersReq.length; i++) { monstersReq[i] = in.getShort(); }
        itemsCount = in.getShort();
        for (int i = 0; i < itemsCollected.length; i++) { itemsCollected[i] = in.getShort(); }
        for (int i = 0; i < itemsReq.length; i++) { itemsReq[i] = in.getShort(); }
        finishedOtherRequirements = in.getInt() != 0;
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        out.putInt(timeLeft);
        out.putShort(monsterCount);
        for (int i = 0; i < monstersKilled.length; i++) { out.putShort(monstersKilled[i]); }
        for (int i = 0; i < monstersReq.length; i++) { out.putShort(monstersReq[i]); }
        out.putShort(itemsCount);
        for (int i = 0; i < itemsCollected.length; i++) { out.putShort(itemsCollected[i]); }
        for (int i = 0; i < itemsReq.length; i++) { out.putShort(itemsReq[i]); }
        out.putInt(finishedOtherRequirements ? 1 : 0);
    }
}
