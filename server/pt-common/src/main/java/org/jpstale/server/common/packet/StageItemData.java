package org.jpstale.server.common.packet;

import lombok.Data;
import org.jpstale.server.common.enums.packets.ItemFlag;

import java.nio.ByteBuffer;

/**
 * 对应 packets.h 中 PacketStageItemData 内嵌的 struct StageItemData。
 */
@Data
public final class StageItemData {
    public static final int SIZE_OF = 63;

    private boolean active;   // BOOL bActive
    private int itemFlags;    // EItemFlag eItemFlags
    private byte rarity;      // BYTE eRarity
    private byte spare2;      // BYTE bSpare2
    private byte spare3;      // BYTE bSpare3
    private int itemId;       // int iItemID
    private int x;            // int iX
    private int y;            // int iY
    private int z;            // int iZ
    private String name;      // char szName[32]
    private int clazz;        // int iClass (lpStgArea)

    public void readFrom(ByteBuffer in) {
        active = in.getInt() != 0;
        itemFlags = in.getInt();
        rarity = in.get();
        spare2 = in.get();
        spare3 = in.get();
        itemId = in.getInt();
        x = in.getInt();
        y = in.getInt();
        z = in.getInt();
        name = Packet.readCString(in, 32);
        clazz = in.getInt();
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void writeTo(ByteBuffer out) {
        out.putInt(active ? 1 : 0);
        out.putInt(itemFlags);
        out.put(rarity);
        out.put(spare2);
        out.put(spare3);
        out.putInt(itemId);
        out.putInt(x);
        out.putInt(y);
        out.putInt(z);
        Packet.writeCString(out, name, 32);
        out.putInt(clazz);
    }

    /**
     * 以枚举形式获取物品标志位。
     */
    public ItemFlag getItemFlagsEnum() {
        return ItemFlag.fromValue(itemFlags);
    }

    /**
     * 以枚举形式设置物品标志位。
     */
    public void setItemFlagsEnum(ItemFlag flag) {
        this.itemFlags = flag != null ? flag.getValue() : 0;
    }
}
