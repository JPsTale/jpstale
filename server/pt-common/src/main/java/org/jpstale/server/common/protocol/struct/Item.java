package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/**
 * 对应 shared/item.h 中 struct Item（sITEMINFO），ITEMFIXES 配置。
 * 总长 0x4C4 字节；每字段注释 C++ 类型、命名及 size。
 */
@Data
public final class Item {

    public static final int SIZE_OF = 0x4C4; // 1220 bytes

    // ---------- Attributes (C++: dwSize, iChk1, dwVersion, dwTime, iChk2) ----------
    private int size;                 // DWORD dwSize  size: 4 bytes
    private int chk1;                 // ITEMCHECKSUM iChk1  size: 4 bytes
    private int version;              // DWORD dwVersion  size: 4 bytes
    private int time;                 // DWORD dwTime  size: 4 bytes
    private int chk2;                 // ITEMCHECKSUM iChk2  size: 4 bytes

    // ---------- Statistics ----------
    private CurMax integrity;        // CurMax sIntegrity  size: 4 bytes
    private ItemID itemId;            // ItemID sItemID  size: 4 bytes
    private String itemName;          // char szItemName[32]  size: 32 bytes
    private int weight;               // int iWeight  size: 4 bytes
    private int salePrice;            // int iSalePrice  size: 4 bytes
    private int index;                // int iIndex  size: 4 bytes
    private int potionCount;          // int iPotionCount  size: 4 bytes
    private short[] elementalDef;    // short saElementalDef[8]  size: 16 bytes
    private int sight;                // int iSight  size: 4 bytes
    private int unknown02;            // DWORD iUnknown02  size: 4 bytes
    private MinMax damage;            // MinMax sDamage  size: 4 bytes
    private int attackRange;          // int iAttackRange  size: 4 bytes
    private int attackSpeed;          // int iAttackSpeed  size: 4 bytes
    private int attackRating;         // int iAttackRating  size: 4 bytes
    private int critical;             // int iCritical  size: 4 bytes
    private float absorbRating;       // float fAbsorbRating  size: 4 bytes
    private int defenseRating;        // int iDefenseRating  size: 4 bytes
    private float blockRating;        // float fBlockRating  size: 4 bytes
    private float movementSpeed;      // float fMovementSpeed  size: 4 bytes
    private int potionStorage;        // int iPotionStorage  size: 4 bytes
    private float magicMastery;       // float fMagicMastery  size: 4 bytes
    private float mpRegen;            // float fMPRegen  size: 4 bytes
    private float hpRegen;            // float fHPRegen  size: 4 bytes
    private float spRegen;            // float fSPRegen  size: 4 bytes
    private float addHp;              // float fAddHP  size: 4 bytes
    private float addMp;              // float fAddMP  size: 4 bytes
    private float addSp;              // float fAddSP  size: 4 bytes
    private int level;                 // int iLevel  size: 4 bytes
    private int strength;             // int iStrength  size: 4 bytes
    private int spirit;               // int iSpirit  size: 4 bytes
    private int talent;               // int iTalent  size: 4 bytes
    private int agility;              // int iAgility  size: 4 bytes
    private int health;               // int iHealth  size: 4 bytes
    private MinMax mpRecovery;        // MinMax sMPRecovery  size: 4 bytes
    private MinMax hpRecovery;        // MinMax sHPRecovery  size: 4 bytes
    private MinMax spRecovery;        // MinMax sSPRecovery  size: 4 bytes
    private int gold;                 // int iGold  size: 4 bytes
    private int canNotUse;            // BOOL bCanNotUse  size: 4 bytes
    private int backupKey;            // DWORD iBackupKey  size: 4 bytes
    private int backupChk;            // DWORD iBackupChk  size: 4 bytes
    private short[] scaleBlink;       // short iScaleBlink[2]  size: 4 bytes
    private int itemUniqueId;         // int iItemUniqueID  size: 4 bytes
    private short[] effectBlink;      // short sEffectBlink[2]  size: 4 bytes
    private short[] effectColor;      // short sEffectColor[4]  size: 8 bytes
    private int disallowDrop;         // BOOL bDisallowDrop  size: 4 bytes
    private int specialization;      // int eSpecialization  size: 4 bytes
    private SpecItemData specData;    // SpecItemData sSpecData  size: 92 bytes
    private ItemFixData prefixData;   // ItemFixData sPrefixData  size: 58 bytes
    private ItemFixData suffixData;   // ItemFixData sSuffixData  size: 58 bytes
    private int craftType;            // EItemCraftType eCraftType  size: 4 bytes
    private int mixEffect;            // int eMixEffect  size: 4 bytes
    private short ageLevelOrMixColorId;   // union sAgeLevel/sMixColorId  size: 2 bytes
    private short maturingOrQuestMonId;    // union bMaturing/uQuestMonId  size: 2 bytes
    private UCurMax matureBar;        // UCurMax sMatureBar  size: 4 bytes
    private short[] itemAgingProtect;  // short sItemAgingProtect[2]  size: 4 bytes
    private short[] specialItemType;  // short sSpecialItemType[2]  size: 4 bytes
    private int createTime;          // DWORD tTime  size: 4 bytes
    private SocketItem[] socketData;  // SocketItem sSocketData[2]  size: 6 bytes
    private byte itemFlags;            // EItemFlag eItemFlags  size: 1 byte (8 bits)
    private byte itemLastSource;      // EItemSource eItemLastSource  size: 1 byte
    private byte itemOriginalSource;  // EItemSource eItemOriginalSource  size: 1 byte
    private byte[] padding;           // char cPadding[6]  size: 6 bytes
    private byte rarity;               // EItemRarity eRarity  size: 1 byte
    private int mixUniqueId1;         // int sMixUniqueID1  size: 4 bytes
    private CurMax questMonsters;     // CurMax sQuestMonsters  size: 4 bytes
    private int mixTypeName;          // EMixTypeName eMixTypeName  size: 4 bytes
    private int itemSpecialType;      // int iItemSpecialType  size: 4 bytes
    private int padding666;           // int iPadding666  size: 4 bytes

    /** 若前面字段总长小于 SIZE_OF，剩余字节放此处以保证往返字节数一致。 */
    private byte[] trailingPadding;

    public Item() {
        integrity = new CurMax();
        itemId = new ItemID();
        elementalDef = new short[8];
        damage = new MinMax();
        mpRecovery = new MinMax();
        hpRecovery = new MinMax();
        spRecovery = new MinMax();
        scaleBlink = new short[2];
        effectBlink = new short[2];
        effectColor = new short[4];
        specData = new SpecItemData();
        prefixData = new ItemFixData();
        suffixData = new ItemFixData();
        socketData = new SocketItem[] { new SocketItem(), new SocketItem() };
        questMonsters = new CurMax();
        padding = new byte[6];
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        int start = in.position();
        size = in.getInt();
        chk1 = in.getInt();
        version = in.getInt();
        time = in.getInt();
        chk2 = in.getInt();
        integrity.readFrom(in);
        itemId.readFrom(in);
        itemName = Packet.readCString(in, 32);
        weight = in.getInt();
        salePrice = in.getInt();
        index = in.getInt();
        potionCount = in.getInt();
        for (int i = 0; i < 8; i++) elementalDef[i] = in.getShort();
        sight = in.getInt();
        unknown02 = in.getInt();
        damage.readFrom(in);
        attackRange = in.getInt();
        attackSpeed = in.getInt();
        attackRating = in.getInt();
        critical = in.getInt();
        absorbRating = in.getFloat();
        defenseRating = in.getInt();
        blockRating = in.getFloat();
        movementSpeed = in.getFloat();
        potionStorage = in.getInt();
        magicMastery = in.getFloat();
        mpRegen = in.getFloat();
        hpRegen = in.getFloat();
        spRegen = in.getFloat();
        addHp = in.getFloat();
        addMp = in.getFloat();
        addSp = in.getFloat();
        level = in.getInt();
        strength = in.getInt();
        spirit = in.getInt();
        talent = in.getInt();
        agility = in.getInt();
        health = in.getInt();
        mpRecovery.readFrom(in);
        hpRecovery.readFrom(in);
        spRecovery.readFrom(in);
        gold = in.getInt();
        canNotUse = in.getInt();
        backupKey = in.getInt();
        backupChk = in.getInt();
        for (int i = 0; i < 2; i++) scaleBlink[i] = in.getShort();
        itemUniqueId = in.getInt();
        for (int i = 0; i < 2; i++) effectBlink[i] = in.getShort();
        for (int i = 0; i < 4; i++) effectColor[i] = in.getShort();
        disallowDrop = in.getInt();
        specialization = in.getInt();
        specData.readFrom(in);
        prefixData.readFrom(in);
        suffixData.readFrom(in);
        craftType = in.getInt();
        mixEffect = in.getInt();
        ageLevelOrMixColorId = in.getShort();
        maturingOrQuestMonId = in.getShort();
        matureBar.readFrom(in);
        for (int i = 0; i < 2; i++) itemAgingProtect[i] = in.getShort();
        for (int i = 0; i < 2; i++) specialItemType[i] = in.getShort();
        createTime = in.getInt();
        for (int i = 0; i < 2; i++) socketData[i].readFrom(in);
        itemFlags = in.get();
        itemLastSource = in.get();
        itemOriginalSource = in.get();
        in.get(padding);
        rarity = in.get();
        mixUniqueId1 = in.getInt();
        questMonsters.readFrom(in);
        mixTypeName = in.getInt();
        itemSpecialType = in.getInt();
        padding666 = in.getInt();
        int readSoFar = in.position() - start;
        int remaining = SIZE_OF - readSoFar;
        if (remaining > 0) {
            trailingPadding = new byte[remaining];
            in.get(trailingPadding);
        } else {
            trailingPadding = null;
        }
    }

    public void writeTo(ByteBuffer out) {
        int start = out.position();
        out.putInt(size);
        out.putInt(chk1);
        out.putInt(version);
        out.putInt(time);
        out.putInt(chk2);
        integrity.writeTo(out);
        itemId.writeTo(out);
        Packet.writeCString(out, itemName != null ? itemName : "", 32);
        out.putInt(weight);
        out.putInt(salePrice);
        out.putInt(index);
        out.putInt(potionCount);
        for (int i = 0; i < 8; i++) out.putShort(elementalDef[i]);
        out.putInt(sight);
        out.putInt(unknown02);
        damage.writeTo(out);
        out.putInt(attackRange);
        out.putInt(attackSpeed);
        out.putInt(attackRating);
        out.putInt(critical);
        out.putFloat(absorbRating);
        out.putInt(defenseRating);
        out.putFloat(blockRating);
        out.putFloat(movementSpeed);
        out.putInt(potionStorage);
        out.putFloat(magicMastery);
        out.putFloat(mpRegen);
        out.putFloat(hpRegen);
        out.putFloat(spRegen);
        out.putFloat(addHp);
        out.putFloat(addMp);
        out.putFloat(addSp);
        out.putInt(level);
        out.putInt(strength);
        out.putInt(spirit);
        out.putInt(talent);
        out.putInt(agility);
        out.putInt(health);
        mpRecovery.writeTo(out);
        hpRecovery.writeTo(out);
        spRecovery.writeTo(out);
        out.putInt(gold);
        out.putInt(canNotUse);
        out.putInt(backupKey);
        out.putInt(backupChk);
        for (int i = 0; i < 2; i++) out.putShort(scaleBlink[i]);
        out.putInt(itemUniqueId);
        for (int i = 0; i < 2; i++) out.putShort(effectBlink[i]);
        for (int i = 0; i < 4; i++) out.putShort(effectColor[i]);
        out.putInt(disallowDrop);
        out.putInt(specialization);
        specData.writeTo(out);
        prefixData.writeTo(out);
        suffixData.writeTo(out);
        out.putInt(craftType);
        out.putInt(mixEffect);
        out.putShort(ageLevelOrMixColorId);
        out.putShort(maturingOrQuestMonId);
        matureBar.writeTo(out);
        for (int i = 0; i < 2; i++) out.putShort(itemAgingProtect[i]);
        for (int i = 0; i < 2; i++) out.putShort(specialItemType[i]);
        out.putInt(createTime);
        for (int i = 0; i < 2; i++) socketData[i].writeTo(out);
        out.put(itemFlags);
        out.put(itemLastSource);
        out.put(itemOriginalSource);
        out.put(padding != null && padding.length >= 6 ? padding : new byte[6]);
        out.put(rarity);
        out.putInt(mixUniqueId1);
        questMonsters.writeTo(out);
        out.putInt(mixTypeName);
        out.putInt(itemSpecialType);
        out.putInt(padding666);
        if (trailingPadding != null && trailingPadding.length > 0) {
            out.put(trailingPadding);
        }
        while (out.position() - start < SIZE_OF) {
            out.put((byte) 0);
        }
    }
}
