package org.jpstale.gamedata.preview;

import org.jpstale.assets.ImageDecoder;
import org.jpstale.entity.item.Item;
import org.jpstale.entity.item.ItemConstant;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * 从游戏资源目录加载道具图标 BMP（支持加密格式）。
 * 路径约定与 TestDropItem 一致：image/Sinimage/Items/{folder}/{category}.bmp
 */
public final class ItemIconLoader {

    private ItemIconLoader() {}

    /**
     * 按物品代码从 ItemConstant 查找 Item，再按 folder/category 加载图标。
     *
     * @param gameRootPath 游戏根目录（GameServer 的父目录）
     * @param itemCode     物品代码（与 ItemInfo.CODE / Item.code 对应）
     * @return 图标图像，未找到或加载失败时返回 null
     */
    public static BufferedImage loadIcon(String gameRootPath, long itemCode) {
        Item item = findItemByCode(itemCode);
        if (item == null || item.folder == null || item.category == null) return null;
        return loadIcon(gameRootPath, item.folder, item.category);
    }

    /**
     * 按 folder 与 category 加载图标 BMP。
     *
     * @param gameRootPath 游戏根目录
     * @param folder       Item.folder
     * @param category     Item.category
     * @return 图标图像，失败返回 null
     */
    public static BufferedImage loadIcon(String gameRootPath, String folder, String category) {
        if (gameRootPath == null || folder == null || category == null) return null;
        String path = gameRootPath + File.separator + "image" + File.separator + "Sinimage" + File.separator + "Items" + File.separator + folder + File.separator + category + ".bmp";
        File file = new File(path);
        if (!file.exists() || !file.isFile()) return null;
        try {
            byte[] data = Files.readAllBytes(file.toPath());
            if (data.length < 14) return null;
            // 游戏加密 BMP：头两字节为 0x41 0x38 时需解密前 14 字节
            if (data[0] == (byte) 0x41 && data[1] == (byte) 0x38) {
                byte[] header = new byte[14];
                System.arraycopy(data, 0, header, 0, 14);
                ImageDecoder.convertBMP(header, true);
                System.arraycopy(header, 0, data, 0, 14);
            }
            ByteArrayInputStream in = new ByteArrayInputStream(data);
            return ImageIO.read(in);
        } catch (IOException e) {
            return null;
        }
    }

    private static Item findItemByCode(long code) {
        for (Item it : ItemConstant.itemDataBase) {
            if (it == null) continue;
            if ((it.code & 0xFFFFFFFFL) == code) return it;
        }
        return null;
    }
}
