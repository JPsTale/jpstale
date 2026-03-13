package org.jpstale.server.common.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 struct PacketSkillBuffStatus : Packet。
 */

@Data
public class PacketSkillBuffStatus extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 56;

    private int targetId;  // ID iTargetID  size: 4 bytes
    private short concealTimeLeft;  // USHORT uConcealTimeLeft  size: 2 bytes
    private byte concealLevelBased;  // BYTE bConcealLevel1Based  size: 1 bytes
    private short demonBaneTimeLeft;  // USHORT uDemonBaneTimeLeft  size: 2 bytes
    private byte demonBaneLevelBased;  // BYTE bDemonBaneLevel1Based  size: 1 bytes
    private short alasTimeLeft;  // USHORT uAlasTimeLeft  size: 2 bytes
    private byte alasLevelBased;  // BYTE bAlasLevel1Based  size: 1 bytes
    private short holyValorTimeLeft;  // USHORT uHolyValorTimeLeft  size: 2 bytes
    private byte holyValorLevelBased;  // BYTE bHolyValorLevel1Based  size: 1 bytes
    private short holyBodyTimeLeft;  // USHORT uHolyBodyTimeLeft  size: 2 bytes
    private byte holyBodyLevelBased;  // BYTE bHolyBodyLevel1Based  size: 1 bytes
    private short drasticSpiritTimeLeft;  // USHORT uDrasticSpiritTimeLeft  size: 2 bytes
    private byte drasticSpiritLevelBased;  // BYTE bDrasticSpiritLevel1Based  size: 1 bytes
    private short forceOfNatureTimeLeft;  // USHORT uForceOfNatureTimeLeft  size: 2 bytes
    private byte forceOfNatureLevelBased;  // BYTE bForceOfNatureLevel1Based  size: 1 bytes
    private short inpesTimeLeft;  // USHORT uInpesTimeLeft  size: 2 bytes
    private byte inpesLevelBased;  // BYTE bInpesLevel1Based  size: 1 bytes
    private short adventMigalTimeLeft;  // USHORT uAdventMigalTimeLeft  size: 2 bytes
    private byte adventMigalLevelBased;  // BYTE bAdventMigalLevel1Based  size: 1 bytes
    private short hallOfValhallaTimeLeft;  // USHORT uHallOfValhallaTimeLeft  size: 2 bytes
    private byte hallOfValhallaLevelBased;  // BYTE bHallOfValhallaLevel1Based  size: 1 bytes
    private short triumphOfValhallaTimeLeft;  // USHORT uTriumphOfValhallaTimeLeft  size: 2 bytes
    private byte triumphOfValhallaLevelBased;  // BYTE bTriumphOfValhallaLevel1Based  size: 1 bytes
    private short virtualLifeTimeLeft;  // USHORT uVirtualLifeTimeLeft  size: 2 bytes
    private byte virtualLifeLevelBased;  // BYTE bVirtualLifeLevel1Based  size: 1 bytes
    private short virtualRegenTimeLeft;  // USHORT uVirtualRegenTimeLeft  size: 2 bytes
    private byte virtualRegenLevelBased;  // BYTE bVirtualRegenLevel1Based  size: 1 bytes
    private short venomThornTimeLeft;  // USHORT uVenomThornTimeLeft  size: 2 bytes
    private byte venomLevelBased;  // BYTE bVenomLevel1Based  size: 1 bytes
    private short electricalOverloadTimeLeft;  // USHORT uElectricalOverloadTimeLeft  size: 2 bytes
    private byte electricalOverloadLevelBased;  // BYTE bElectricalOverloadLevel1Based  size: 1 bytes
    private short enchantTimeLeft;  // USHORT uEnchantTimeLeft  size: 2 bytes
    private byte enchantLevelBased;  // BYTE bEnchantLevel1Based  size: 1 bytes
    private int dataHash;  // UINT bDataHash  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

    @Override
    protected void readBody(ByteBuffer in) {
        targetId = in.getInt();
        concealTimeLeft = in.getShort();
        concealLevelBased = in.get();
        demonBaneTimeLeft = in.getShort();
        demonBaneLevelBased = in.get();
        alasTimeLeft = in.getShort();
        alasLevelBased = in.get();
        holyValorTimeLeft = in.getShort();
        holyValorLevelBased = in.get();
        holyBodyTimeLeft = in.getShort();
        holyBodyLevelBased = in.get();
        drasticSpiritTimeLeft = in.getShort();
        drasticSpiritLevelBased = in.get();
        forceOfNatureTimeLeft = in.getShort();
        forceOfNatureLevelBased = in.get();
        inpesTimeLeft = in.getShort();
        inpesLevelBased = in.get();
        adventMigalTimeLeft = in.getShort();
        adventMigalLevelBased = in.get();
        hallOfValhallaTimeLeft = in.getShort();
        hallOfValhallaLevelBased = in.get();
        triumphOfValhallaTimeLeft = in.getShort();
        triumphOfValhallaLevelBased = in.get();
        virtualLifeTimeLeft = in.getShort();
        virtualLifeLevelBased = in.get();
        virtualRegenTimeLeft = in.getShort();
        virtualRegenLevelBased = in.get();
        venomThornTimeLeft = in.getShort();
        venomLevelBased = in.get();
        electricalOverloadTimeLeft = in.getShort();
        electricalOverloadLevelBased = in.get();
        enchantTimeLeft = in.getShort();
        enchantLevelBased = in.get();
        dataHash = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(targetId);
        out.putShort(concealTimeLeft);
        out.put(concealLevelBased);
        out.putShort(demonBaneTimeLeft);
        out.put(demonBaneLevelBased);
        out.putShort(alasTimeLeft);
        out.put(alasLevelBased);
        out.putShort(holyValorTimeLeft);
        out.put(holyValorLevelBased);
        out.putShort(holyBodyTimeLeft);
        out.put(holyBodyLevelBased);
        out.putShort(drasticSpiritTimeLeft);
        out.put(drasticSpiritLevelBased);
        out.putShort(forceOfNatureTimeLeft);
        out.put(forceOfNatureLevelBased);
        out.putShort(inpesTimeLeft);
        out.put(inpesLevelBased);
        out.putShort(adventMigalTimeLeft);
        out.put(adventMigalLevelBased);
        out.putShort(hallOfValhallaTimeLeft);
        out.put(hallOfValhallaLevelBased);
        out.putShort(triumphOfValhallaTimeLeft);
        out.put(triumphOfValhallaLevelBased);
        out.putShort(virtualLifeTimeLeft);
        out.put(virtualLifeLevelBased);
        out.putShort(virtualRegenTimeLeft);
        out.put(virtualRegenLevelBased);
        out.putShort(venomThornTimeLeft);
        out.put(venomLevelBased);
        out.putShort(electricalOverloadTimeLeft);
        out.put(electricalOverloadLevelBased);
        out.putShort(enchantTimeLeft);
        out.put(enchantLevelBased);
        out.putInt(dataHash);
    }
}
