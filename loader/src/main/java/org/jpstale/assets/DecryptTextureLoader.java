package org.jpstale.assets;

import com.jme3.asset.AssetInfo;
import com.jme3.asset.AssetKey;
import com.jme3.asset.TextureKey;
import com.jme3.asset.AssetLoadException;
import com.jme3.asset.AssetLoader;
import com.jme3.texture.Image;
import com.jme3.texture.plugins.AWTLoader;
import com.jme3.texture.plugins.TGALoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 加载 BMP/TGA 时若检测到游戏加密头（BMP 0x41 0x38、TGA 0x47 0x38），
 * 先解密前 14/18 字节再交给 AWTLoader/TGALoader，避免依赖预解密文件。
 */
public class DecryptTextureLoader implements AssetLoader {

    @Override
    public Object load(AssetInfo info) throws IOException {
        if (!(info.getKey() instanceof TextureKey)) {
            throw new IllegalArgumentException("Texture assets must be loaded using a TextureKey");
        }
        byte[] data = readAll(info.openStream());
        if (data.length == 0) {
            throw new AssetLoadException("Empty texture: " + info.getKey());
        }
        String ext = info.getKey().getExtension();
        if (ext == null) {
            ext = "";
        }
        ext = ext.toLowerCase();
        // 游戏加密：只改文件头
        if (data.length >= 14 && "bmp".equals(ext) && data[0] == 0x41 && data[1] == 0x38) {
            ImageDecoder.convertBMP(data, true);
        } else if (data.length >= 18 && "tga".equals(ext) && data[0] == 0x47 && data[1] == 0x38) {
            ImageDecoder.convertTGA(data, true);
        }
        ByteArrayAssetInfo decrypted = new ByteArrayAssetInfo(info.getManager(), info.getKey(), data);
        if ("bmp".equals(ext) || "gif".equals(ext) || "png".equals(ext) || "jpg".equals(ext) || "jpeg".equals(ext)) {
            AWTLoader awt = new AWTLoader();
            Image img = (Image) awt.load(decrypted);
            if (img == null) {
                throw new AssetLoadException("The given image cannot be loaded " + info.getKey());
            }
            return img;
        }
        if ("tga".equals(ext)) {
            TGALoader tga = new TGALoader();
            return tga.load(decrypted);
        }
        throw new AssetLoadException("Unsupported texture extension: " + ext);
    }

    private static byte[] readAll(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int n;
        while ((n = in.read(buf)) != -1) {
            out.write(buf, 0, n);
        }
        in.close();
        return out.toByteArray();
    }
}
