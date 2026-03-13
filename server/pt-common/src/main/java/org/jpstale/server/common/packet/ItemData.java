package org.jpstale.server.common.packet;

import lombok.Data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 对应 shared/item.h 中 class ItemData（struct sITEM）。
 * 总长 0x4B4 字节；前缀 256 字节为固定字段，后 948 字节为 item 载荷（与 C++ 内嵌 Item 协议截断一致）。
 * 字段命名按 Java 规范，注释保留 C++ 类型与原名。
 */
@Data
public final class ItemData {

    public static final int SIZE_OF = 0x4B4; // 1204 bytes
    private static final int PREFIX_SIZE = 256;
    private static final int ITEM_PAYLOAD_SIZE = SIZE_OF - PREFIX_SIZE; // 948

    // ---------- 基类/基础信息 ----------
    private ItemID baseItemId;           // ItemID sBaseItemID  size: 4 bytes
    private String baseName;             // char szBaseName[32]  size: 32 bytes
    private String inventoryName;       // char szInventoryName[16]  size: 16 bytes
    private int width;                   // int iWidth  size: 4 bytes
    private int height;                  // int iHeight  size: 4 bytes
    private String category;             // char szCategory[64]  size: 64 bytes
    private int itemSlotFlag;            // EItemSlotFlag iItemSlotFlag  size: 4 bytes
    private String modelName;            // char szModelName[64]  size: 64 bytes
    private int visibleItemType;         // EItemSlotFlag iVisibleItemType  size: 4 bytes
    private int invItemSound;            // EItemInvSound iInvItemSound  size: 4 bytes
    private int itemWpnDmg;             // int iItemWpnDmg  size: 4 bytes
    private int valid;                   // BOOL bValid  size: 4 bytes
    private Point2D position;            // Point2D sPosition  size: 8 bytes
    private Point2D placePosition;      // Point2D sPlacePosition  size: 8 bytes
    private int inventoryTexturePlaceholder;  // void* pcInventoryTexture  size: 4 bytes
    private int itemSlot;                // int iItemSlot  size: 4 bytes
    private int potionCount;             // int iPotionCount  size: 4 bytes
    private int notUse;                  // int iNotUse  size: 4 bytes
    private int salePrice;               // int iSalePrice  size: 4 bytes
    private Point2D oldPosition;         // Point2D sOldPosition  size: 8 bytes
    private int tempInventoryTexturePlaceholder;  // void* pcTempInventoryTexture  size: 4 bytes

    /** 内嵌物品协议数据，长度 948 字节（与 0x4B4 总长约定一致，非完整 Item 0x4C4）。 */
    private byte[] itemPayload;

    public ItemData() {
        baseItemId = new ItemID();
        position = new Point2D();
        placePosition = new Point2D();
        oldPosition = new Point2D();
        itemPayload = new byte[ITEM_PAYLOAD_SIZE];
    }

    public int sizeOf() {
        return SIZE_OF;
    }

    public void readFrom(ByteBuffer in) {
        baseItemId.readFrom(in);
        baseName = Packet.readCString(in, 32);
        inventoryName = Packet.readCString(in, 16);
        width = in.getInt();
        height = in.getInt();
        category = Packet.readCString(in, 64);
        itemSlotFlag = in.getInt();
        modelName = Packet.readCString(in, 64);
        visibleItemType = in.getInt();
        invItemSound = in.getInt();
        itemWpnDmg = in.getInt();
        valid = in.getInt();
        position.readFrom(in);
        placePosition.readFrom(in);
        inventoryTexturePlaceholder = in.getInt();
        itemSlot = in.getInt();
        potionCount = in.getInt();
        notUse = in.getInt();
        salePrice = in.getInt();
        oldPosition.readFrom(in);
        tempInventoryTexturePlaceholder = in.getInt();
        if (itemPayload == null || itemPayload.length != ITEM_PAYLOAD_SIZE) {
            itemPayload = new byte[ITEM_PAYLOAD_SIZE];
        }
        in.get(itemPayload);
    }

    public void writeTo(ByteBuffer out) {
        baseItemId.writeTo(out);
        Packet.writeCString(out, baseName != null ? baseName : "", 32);
        Packet.writeCString(out, inventoryName != null ? inventoryName : "", 16);
        out.putInt(width);
        out.putInt(height);
        Packet.writeCString(out, category != null ? category : "", 64);
        out.putInt(itemSlotFlag);
        Packet.writeCString(out, modelName != null ? modelName : "", 64);
        out.putInt(visibleItemType);
        out.putInt(invItemSound);
        out.putInt(itemWpnDmg);
        out.putInt(valid);
        position.writeTo(out);
        placePosition.writeTo(out);
        out.putInt(inventoryTexturePlaceholder);
        out.putInt(itemSlot);
        out.putInt(potionCount);
        out.putInt(notUse);
        out.putInt(salePrice);
        oldPosition.writeTo(out);
        out.putInt(tempInventoryTexturePlaceholder);
        if (itemPayload != null && itemPayload.length >= ITEM_PAYLOAD_SIZE) {
            out.put(itemPayload, 0, ITEM_PAYLOAD_SIZE);
        } else {
            for (int i = 0; i < ITEM_PAYLOAD_SIZE; i++) out.put((byte) 0);
        }
    }

    /**
     * 将内嵌载荷解析为 Item。载荷仅 948 字节，会补零至 0x4C4 后交给 Item 解析。
     */
    public void readItemFromPayload(Item item) {
        ByteBuffer buf = ByteBuffer.allocate(Item.SIZE_OF).order(ByteOrder.LITTLE_ENDIAN);
        if (itemPayload != null) {
            buf.put(itemPayload, 0, Math.min(itemPayload.length, Item.SIZE_OF));
        }
        buf.flip();
        item.readFrom(buf);
    }

    /**
     * 将 Item 写入内嵌载荷（取前 948 字节）。
     */
    public void writeItemToPayload(Item item) {
        if (itemPayload == null) itemPayload = new byte[ITEM_PAYLOAD_SIZE];
        ByteBuffer buf = ByteBuffer.allocate(Item.SIZE_OF).order(ByteOrder.LITTLE_ENDIAN);
        item.writeTo(buf);
        buf.flip();
        int copy = Math.min(ITEM_PAYLOAD_SIZE, buf.remaining());
        buf.get(itemPayload, 0, copy);
        for (int i = copy; i < ITEM_PAYLOAD_SIZE; i++) itemPayload[i] = 0;
    }
}
