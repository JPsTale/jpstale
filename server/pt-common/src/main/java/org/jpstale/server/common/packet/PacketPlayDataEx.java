package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketPlayDataEx : Packet。
 */

@Data
public class PacketPlayDataEx extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 172;

    private int[] levelSkill = new int[16];  // int iLevelSkill[16]  size: 64 bytes
    private CharacterDataPacket characterData;  // CharacterDataPacket sCharacterData  size: 40 bytes
    private int critical;  // int iCritical  size: 4 bytes
    private int levelCharacter;  // int iLevelCharacter  size: 4 bytes
    private boolean debugInfo;  // BOOL DebugInfo  size: 4 bytes
    private boolean gameMaster;  // BOOL bGameMaster  size: 4 bytes
    private String macAddr;  // char szMacAddr[20]  size: 20 bytes
    private int serverId;  // DWORD dwServerID  size: 4 bytes
    private int questLevelLog;  // DWORD dwQuestLevelLog  size: 4 bytes
    private int gold;  // DWORD dwGold  size: 4 bytes
    private int speed;  // DWORD dwSpeed  size: 4 bytes
    private int bellatraCrown;  // int iBellatraCrown  size: 4 bytes
    private int mapId;  // int iMapID  size: 4 bytes
    private int serialHd;  // UINT uSerialHD  size: 4 bytes
    private int userId;  // ID userID  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
