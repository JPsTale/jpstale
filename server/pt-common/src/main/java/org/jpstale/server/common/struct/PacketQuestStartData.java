package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketQuestStartData : Packet。
 */

@Data
public class PacketQuestStartData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 672;

    private int id;  // int iID  size: 4 bytes
    private String name;  // char szName[64]  size: 64 bytes
    private String shortDescription;  // char szShortDescription[256]  size: 256 bytes
    private String questGroupName;  // char szQuestGroupName[32]  size: 32 bytes
    private short questGroupNum;  // short sQuestGroupNum  size: 2 bytes
    private int type;  // int iType  size: 4 bytes
    private int levelMin;  // int iLevelMin  size: 4 bytes
    private int levelMax;  // int iLevelMax  size: 4 bytes
    private boolean initialLoad;  // BOOL bInitialLoad  size: 4 bytes
    private boolean time;  // BOOL bTime  size: 4 bytes
    private int timeLeft;  // DWORD dwTimeLeft  size: 4 bytes
    private int waitingTime;  // DWORD dwWaitingTime  size: 4 bytes
    private int timeTotal;  // DWORD dwTimeTotal  size: 4 bytes
    private short mapId;  // short sMapID  size: 2 bytes
    private short giverNpcId;  // short sGiverNpcID  size: 2 bytes
    private int areaType;  // int iAreaType  size: 4 bytes
    private int xmin;  // int iXMin  size: 4 bytes
    private int xmax;  // int iXMax  size: 4 bytes
    private int zmin;  // int iZMin  size: 4 bytes
    private int zmax;  // int iZMax  size: 4 bytes
    private int radius;  // int iRadius  size: 4 bytes
    private short mainQuestId;  // short sMainQuestID  size: 2 bytes
    private int party;  // int iParty  size: 4 bytes
    private boolean pvP;  // BOOL bPvP  size: 4 bytes
    private boolean multiple;  // BOOL bMultiple  size: 4 bytes
    private int[] monsterId = new int[5];  // int iaMonsterID[5]  size: 20 bytes
    private short[] monstersReq = new short[5];  // USHORT saMonstersReq[5]  size: 10 bytes
    private short[] monstersKilled = new short[5];  // USHORT saMonstersKilled[5]  size: 10 bytes
    private String[] monsterName = new String[5];  // char szaMonsterName[5][32]  size: 160 bytes
    private int[] itemId = new int[5];  // int iaItemID[5]  size: 20 bytes
    private short[] itemsReq = new short[5];  // USHORT saItemsReq[5]  size: 10 bytes
    private short[] itemsCollected = new short[5];  // USHORT saItemsCollected[5]  size: 10 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        id = in.getInt();
        name = readCString(in, 64);
        shortDescription = readCString(in, 256);
        questGroupName = readCString(in, 32);
        questGroupNum = in.getShort();
        type = in.getInt();
        levelMin = in.getInt();
        levelMax = in.getInt();
        initialLoad = in.getInt() != 0;
        time = in.getInt() != 0;
        timeLeft = in.getInt();
        waitingTime = in.getInt();
        timeTotal = in.getInt();
        mapId = in.getShort();
        giverNpcId = in.getShort();
        areaType = in.getInt();
        xmin = in.getInt();
        xmax = in.getInt();
        zmin = in.getInt();
        zmax = in.getInt();
        radius = in.getInt();
        mainQuestId = in.getShort();
        party = in.getInt();
        pvP = in.getInt() != 0;
        multiple = in.getInt() != 0;
        for (int i = 0; i < monsterId.length; i++) { monsterId[i] = in.getInt(); }
        for (int i = 0; i < monstersReq.length; i++) { monstersReq[i] = in.getShort(); }
        for (int i = 0; i < monstersKilled.length; i++) { monstersKilled[i] = in.getShort(); }
        for (int i = 0; i < 5; i++) { monsterName[i] = readCString(in, 32); }
        for (int i = 0; i < itemId.length; i++) { itemId[i] = in.getInt(); }
        for (int i = 0; i < itemsReq.length; i++) { itemsReq[i] = in.getShort(); }
        for (int i = 0; i < itemsCollected.length; i++) { itemsCollected[i] = in.getShort(); }
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(id);
        writeCString(out, name, 64);
        writeCString(out, shortDescription, 256);
        writeCString(out, questGroupName, 32);
        out.putShort(questGroupNum);
        out.putInt(type);
        out.putInt(levelMin);
        out.putInt(levelMax);
        out.putInt(initialLoad ? 1 : 0);
        out.putInt(time ? 1 : 0);
        out.putInt(timeLeft);
        out.putInt(waitingTime);
        out.putInt(timeTotal);
        out.putShort(mapId);
        out.putShort(giverNpcId);
        out.putInt(areaType);
        out.putInt(xmin);
        out.putInt(xmax);
        out.putInt(zmin);
        out.putInt(zmax);
        out.putInt(radius);
        out.putShort(mainQuestId);
        out.putInt(party);
        out.putInt(pvP ? 1 : 0);
        out.putInt(multiple ? 1 : 0);
        for (int i = 0; i < monsterId.length; i++) { out.putInt(monsterId[i]); }
        for (int i = 0; i < monstersReq.length; i++) { out.putShort(monstersReq[i]); }
        for (int i = 0; i < monstersKilled.length; i++) { out.putShort(monstersKilled[i]); }
        for (int i = 0; i < 5; i++) { writeCString(out, monsterName[i], 32); }
        for (int i = 0; i < itemId.length; i++) { out.putInt(itemId[i]); }
        for (int i = 0; i < itemsReq.length; i++) { out.putShort(itemsReq[i]); }
        for (int i = 0; i < itemsCollected.length; i++) { out.putShort(itemsCollected[i]); }
    }
}
