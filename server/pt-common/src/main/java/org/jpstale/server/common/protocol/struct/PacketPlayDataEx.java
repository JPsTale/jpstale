package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayDataEx : Packet。
 */

@Data
public class PacketPlayDataEx extends Packet {

    private int[] levelSkill = new int[16];  // int iLevelSkill[16]
    private CharacterDataPacket characterData;  // CharacterDataPacket sCharacterData
    private int critical;  // int iCritical
    private int levelCharacter;  // int iLevelCharacter
    private boolean debugInfo;  // BOOL DebugInfo
    private boolean gameMaster;  // BOOL bGameMaster
    private String macAddr;  // char szMacAddr[20]
    private int serverId;  // DWORD dwServerID
    private int questLevelLog;  // DWORD dwQuestLevelLog
    private int gold;  // DWORD dwGold
    private int speed;  // DWORD dwSpeed
    private int bellatraCrown;  // int iBellatraCrown
    private int mapId;  // int iMapID
    private int serialHd;  // UINT uSerialHD
    private int userId;  // ID userID

    @Override
    protected void readBody(ByteBuffer in) {
        for (int i = 0; i < levelSkill.length; i++) { levelSkill[i] = in.getInt(); }
        if (characterData == null) characterData = new CharacterDataPacket(); characterData.readFrom(in);
        critical = in.getInt();
        levelCharacter = in.getInt();
        debugInfo = in.getInt() != 0;
        gameMaster = in.getInt() != 0;
        macAddr = readCString(in, 20);
        serverId = in.getInt();
        questLevelLog = in.getInt();
        gold = in.getInt();
        speed = in.getInt();
        bellatraCrown = in.getInt();
        mapId = in.getInt();
        serialHd = in.getInt();
        userId = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        for (int i = 0; i < levelSkill.length; i++) { out.putInt(levelSkill[i]); }
        if (characterData != null) characterData.writeTo(out);
        out.putInt(critical);
        out.putInt(levelCharacter);
        out.putInt(debugInfo ? 1 : 0);
        out.putInt(gameMaster ? 1 : 0);
        writeCString(out, macAddr, 20);
        out.putInt(serverId);
        out.putInt(questLevelLog);
        out.putInt(gold);
        out.putInt(speed);
        out.putInt(bellatraCrown);
        out.putInt(mapId);
        out.putInt(serialHd);
        out.putInt(userId);
    }
}
