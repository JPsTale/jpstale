package org.jpstale.assets;

import com.jme3.asset.AssetKey;
import com.jme3.asset.AssetManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 提供基于 byte[] 的 AssetInfo，每次 openStream() 返回新的流，便于解密后交给 JME 纹理加载器使用。
 */
public class ByteArrayAssetInfo extends com.jme3.asset.AssetInfo {

    private final byte[] data;

    public ByteArrayAssetInfo(AssetManager manager, AssetKey<?> key, byte[] data) {
        super(manager, key);
        this.data = data;
    }

    @Override
    public InputStream openStream() {
        return new ByteArrayInputStream(data);
    }
}
