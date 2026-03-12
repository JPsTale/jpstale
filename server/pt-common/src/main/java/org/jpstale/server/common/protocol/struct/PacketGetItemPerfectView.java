package org.jpstale.server.common.protocol.struct;

import lombok.Data;

import java.nio.ByteBuffer;
import org.jpstale.server.common.enums.ItemRarity;


/**
 * 对应 packets.h 中 struct PacketGetItemPerfectView : Packet。
 */

@Data
public class PacketGetItemPerfectView extends Packet {

    /** 本包体字节数（不含包头）. */
    public static final int SIZE_OF = 38;

    private int code;  // DWORD dwCode  size: 4 bytes
    private int itemSpec;  // int iItemSpec  size: 4 bytes
    private short ageLevel;  // short sAgeLevel  size: 2 bytes
    private int mixType;  // int iMixType  size: 4 bytes
    private short mixColor;  // USHORT sMixColor  size: 2 bytes
    private short uniqueMixId;  // short sUniqueMixId  size: 2 bytes
    private int mixEffect;  // int iMixEffect  size: 4 bytes
    private ItemRarity itemRarity;  // EItemRarity eItemRarity  size: 4 bytes
    private int prefixId;  // int iPrefixID  size: 4 bytes
    private int suffixId;  // int iSuffixID  size: 4 bytes
    private int defenseValue;  // int iDefenseValue  size: 4 bytes

    @Override
    public int sizeOf() {
        return super.sizeOf() + SIZE_OF;
    }

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
