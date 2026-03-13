package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;

/** C++ struct SpecItemData (ITEMFIXES: no iPadding99). Total size: 92 bytes */
@Data
public final class SpecItemData {
    public static final int SIZE_OF = 92;

    private float specAbsorbRating;           // float fSpecAbsorbRating  size: 4 bytes
    private int specDefenseRating;            // int iSpecDefenseRating  size: 4 bytes
    private float specMovementSpeed;          // float fSpecMovementSpeed  size: 4 bytes
    private float specBlockRating;            // float fSpecBlockRating  size: 4 bytes
    private int specAttackSpeed;              // int iSpecAttackSpeed  size: 4 bytes
    private int specCritical;                 // int iSpecCritical  size: 4 bytes
    private int specAttackRange;              // int iSpecAttackRange  size: 4 bytes
    private float specMagicMastery;            // float fSpecMagicMastery  size: 4 bytes
    private short[] specElementalDef = new short[8];   // short saSpecElementalDef[8]  size: 16 bytes
    private short[] specElementalAtkDiv = new short[8]; // short saSpecElementalAtkDiv[8]  size: 16 bytes
    private int specAddMPDiv;                 // int iSpecAddMPDiv  size: 4 bytes
    private int specAddHPDiv;                 // int iSpecAddHPDiv  size: 4 bytes
    private int specAttackRatingDiv;           // int iSpecAttackRatingDiv  size: 4 bytes
    private short specAttackPowerDivMin;      // short iSpecAttackPowerDivMin  size: 2 bytes
    private short specAttackPowerDiv;         // short iSpecAttackPowerDiv  size: 2 bytes
    private float specMPRegen;                 // float fSpecMPRegen  size: 4 bytes
    private float specHPRegen;                 // float fSpecHPRegen  size: 4 bytes
    private float specSPRegen;                 // float fSpecSPRegen  size: 4 bytes

    public void readFrom(ByteBuffer in) {
        specAbsorbRating = in.getFloat();
        specDefenseRating = in.getInt();
        specMovementSpeed = in.getFloat();
        specBlockRating = in.getFloat();
        specAttackSpeed = in.getInt();
        specCritical = in.getInt();
        specAttackRange = in.getInt();
        specMagicMastery = in.getFloat();
        for (int i = 0; i < 8; i++) specElementalDef[i] = in.getShort();
        for (int i = 0; i < 8; i++) specElementalAtkDiv[i] = in.getShort();
        specAddMPDiv = in.getInt();
        specAddHPDiv = in.getInt();
        specAttackRatingDiv = in.getInt();
        specAttackPowerDivMin = in.getShort();
        specAttackPowerDiv = in.getShort();
        specMPRegen = in.getFloat();
        specHPRegen = in.getFloat();
        specSPRegen = in.getFloat();
    }

    public void writeTo(ByteBuffer out) {
        out.putFloat(specAbsorbRating);
        out.putInt(specDefenseRating);
        out.putFloat(specMovementSpeed);
        out.putFloat(specBlockRating);
        out.putInt(specAttackSpeed);
        out.putInt(specCritical);
        out.putInt(specAttackRange);
        out.putFloat(specMagicMastery);
        for (int i = 0; i < 8; i++) out.putShort(specElementalDef[i]);
        for (int i = 0; i < 8; i++) out.putShort(specElementalAtkDiv[i]);
        out.putInt(specAddMPDiv);
        out.putInt(specAddHPDiv);
        out.putInt(specAttackRatingDiv);
        out.putShort(specAttackPowerDivMin);
        out.putShort(specAttackPowerDiv);
        out.putFloat(specMPRegen);
        out.putFloat(specHPRegen);
        out.putFloat(specSPRegen);
    }
}
