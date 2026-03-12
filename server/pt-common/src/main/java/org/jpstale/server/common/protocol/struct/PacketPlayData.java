package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayData : Packet。
 */

@Data
public class PacketPlayData extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 99;

    private int objectId;  // DWORD dwObjectID  size: 4 bytes
    private int target;  // DWORD dwTarget  size: 4 bytes
    private int playBuffCount;  // int iPlayBuffCount  size: 4 bytes
    private int startPosition;  // int iStartPosition  size: 4 bytes
    private short[] hp = new short[2];  // short sHp[2]  size: 4 bytes
    private int autoCharCode;  // DWORD dwAutoCharCode  size: 4 bytes
    private short mapId;  // short sMapID  size: 2 bytes
    private short unk;  // short sUnk  size: 2 bytes
    private final byte[] updateInfo = new byte[4];  // BYTE bUpdateInfo[4]  size: 4 bytes
    private final byte[] eventInfo = new byte[4];  // BYTE bEventInfo[4]  size: 4 bytes
    private CurMax mp;  // CurMax sMP  size: 4 bytes
    private CurMax sp;  // CurMax sSP  size: 4 bytes
    private boolean partyLeader;  // bool bPartyLeader  size: 1 bytes
    private short secondMapId;  // short sSecondMapID  size: 2 bytes
    private short[] speed = new short[2];  // short saSpeed[2]  size: 4 bytes
    private IMinMax hplong;  // IMinMax sHPLong  size: 8 bytes
    private short angleY;  // short sAngleY  size: 2 bytes
    private short size;  // short sSize  size: 2 bytes
    private int level;  // int iLevel  size: 4 bytes
    private byte invisibleInMiniMap;  // BYTE bInvisibleInMiniMap  size: 1 bytes
    private byte spare1;  // BYTE bSpare1  size: 1 bytes
    private byte spare2;  // BYTE bSpare2  size: 1 bytes
    private byte lootFilterEnabled;  // BYTE bLootFilterEnabled  size: 1 bytes
    private int lootFilterFlag;  // int iLootFilterFlag  size: 4 bytes
    private short equipmentMinLevel;  // short sEquipmentMinLevel  size: 2 bytes
    private final byte[] padding = new byte[22];  // BYTE baPadding[22]  size: 22 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        objectId = in.getInt();
        target = in.getInt();
        playBuffCount = in.getInt();
        startPosition = in.getInt();
        for (int i = 0; i < hp.length; i++) { hp[i] = in.getShort(); }
        autoCharCode = in.getInt();
        mapId = in.getShort();
        unk = in.getShort();
        in.get(updateInfo);
        in.get(eventInfo);
        if (mp == null) mp = new CurMax(); mp.readFrom(in);
        if (sp == null) sp = new CurMax(); sp.readFrom(in);
        partyLeader = in.get() != 0;
        secondMapId = in.getShort();
        for (int i = 0; i < speed.length; i++) { speed[i] = in.getShort(); }
        if (hplong == null) hplong = new IMinMax(); hplong.readFrom(in);
        angleY = in.getShort();
        size = in.getShort();
        level = in.getInt();
        invisibleInMiniMap = in.get();
        spare1 = in.get();
        spare2 = in.get();
        lootFilterEnabled = in.get();
        lootFilterFlag = in.getInt();
        equipmentMinLevel = in.getShort();
        in.get(padding);
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(objectId);
        out.putInt(target);
        out.putInt(playBuffCount);
        out.putInt(startPosition);
        for (int i = 0; i < hp.length; i++) { out.putShort(hp[i]); }
        out.putInt(autoCharCode);
        out.putShort(mapId);
        out.putShort(unk);
        out.put(updateInfo);
        out.put(eventInfo);
        if (mp != null) mp.writeTo(out);
        if (sp != null) sp.writeTo(out);
        out.put((byte)(partyLeader ? 1 : 0));
        out.putShort(secondMapId);
        for (int i = 0; i < speed.length; i++) { out.putShort(speed[i]); }
        if (hplong != null) hplong.writeTo(out);
        out.putShort(angleY);
        out.putShort(size);
        out.putInt(level);
        out.put(invisibleInMiniMap);
        out.put(spare1);
        out.put(spare2);
        out.put(lootFilterEnabled);
        out.putInt(lootFilterFlag);
        out.putShort(equipmentMinLevel);
        out.put(padding);
    }
}
