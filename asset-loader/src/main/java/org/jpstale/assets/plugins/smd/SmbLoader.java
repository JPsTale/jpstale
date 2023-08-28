package org.jpstale.assets.plugins.smd;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;
import org.jpstale.assets.plugins.smd.geom.PAT3D;

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
public class SmbLoader implements AssetLoader {

    @Override
    public Object load(AssetInfo assetInfo) throws IOException {
        PAT3D skeleton = new PAT3D();
        skeleton.loadFile(new LittleEndien(assetInfo.openStream()));
        return skeleton;
    }


}
