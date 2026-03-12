package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.ItemRarity;


/**
 * 对应 packets.h 中 struct PacketGetItemPerfectView : Packet。
 */

@Data
public class PacketGetItemPerfectView extends Packet {

    private int code;  // DWORD dwCode
    private int itemSpec;  // int iItemSpec
    private short ageLevel;  // short sAgeLevel
    private int mixType;  // int iMixType
    private short mixColor;  // USHORT sMixColor
    private short uniqueMixId;  // short sUniqueMixId
    private int mixEffect;  // int iMixEffect
    private ItemRarity itemRarity;  // EItemRarity eItemRarity
    private int prefixId;  // int iPrefixID
    private int suffixId;  // int iSuffixID
    private int defenseValue;  // int iDefenseValue

    @Override
    protected void readBody(ByteBuffer in) {
        code = in.getInt();
        itemSpec = in.getInt();
        ageLevel = in.getShort();
        mixType = in.getInt();
        mixColor = in.getShort();
        uniqueMixId = in.getShort();
        mixEffect = in.getInt();
        itemRarity = ItemRarity.fromValue(in.getInt());
        prefixId = in.getInt();
        suffixId = in.getInt();
        defenseValue = in.getInt();
    }

    @Override
    protected void writeBody(ByteBuffer out) {
        out.putInt(code);
        out.putInt(itemSpec);
        out.putShort(ageLevel);
        out.putInt(mixType);
        out.putShort(mixColor);
        out.putShort(uniqueMixId);
        out.putInt(mixEffect);
        out.putInt(itemRarity.getValue());
        out.putInt(prefixId);
        out.putInt(suffixId);
        out.putInt(defenseValue);
    }
}
