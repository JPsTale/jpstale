package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayData : Packet。
 */

@Data
public class PacketPlayData extends Packet {

    private int objectId;  // DWORD dwObjectID
    private int target;  // DWORD dwTarget
    private int playBuffCount;  // int iPlayBuffCount
    private int startPosition;  // int iStartPosition
    private short[] hp = new short[2];  // short sHp[2]
    private int autoCharCode;  // DWORD dwAutoCharCode
    private short mapId;  // short sMapID
    private short unk;  // short sUnk
    private final byte[] updateInfo = new byte[4];  // BYTE bUpdateInfo[4]
    private final byte[] eventInfo = new byte[4];  // BYTE bEventInfo[4]
    private CurMax mp;  // CurMax sMP
    private CurMax sp;  // CurMax sSP
    private boolean partyLeader;  // bool bPartyLeader
    private short secondMapId;  // short sSecondMapID
    private short[] speed = new short[2];  // short saSpeed[2]
    private IMinMax hplong;  // IMinMax sHPLong
    private short angleY;  // short sAngleY
    private short size;  // short sSize
    private int level;  // int iLevel
    private byte invisibleInMiniMap;  // BYTE bInvisibleInMiniMap
    private byte spare1;  // BYTE bSpare1
    private byte spare2;  // BYTE bSpare2
    private byte lootFilterEnabled;  // BYTE bLootFilterEnabled
    private int lootFilterFlag;  // int iLootFilterFlag
    private short equipmentMinLevel;  // short sEquipmentMinLevel
    private final byte[] padding = new byte[22];  // BYTE baPadding[22]

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
