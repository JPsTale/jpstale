package org.jpstale.assets.plugins.smd;

import java.io.IOException;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import org.jpstale.assets.plugins.smd.geom.AnimateModel;

import com.jme3.asset.AssetInfo;
import com.jme3.asset.AssetLoader;
import com.jme3.util.LittleEndien;

/**
 * 精灵场景加载器
 * 
 * @author yanmaoyuan
 * 
 */
@Slf4j
public class InxLoader implements AssetLoader {

    @Override
    public Object load(AssetInfo assetInfo) throws IOException {
        AnimateModel modelInfo = new AnimateModel();
        modelInfo.loadData(new LittleEndien(assetInfo.openStream()));
        return modelInfo;
    }
}
