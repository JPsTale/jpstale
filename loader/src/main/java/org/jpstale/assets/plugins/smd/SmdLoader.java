package org.jpstale.assets.plugins.smd;

import java.io.IOException;
import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.smd.geom.PAT3D;
import org.jpstale.assets.plugins.smd.stage.Stage;

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
public class SmdLoader implements AssetLoader {

    private SmdKey key = null;

    @Override
    public Object load(AssetInfo assetInfo) throws IOException {
        // 确认用户使用了SmdKey
        if (!(assetInfo.getKey() instanceof SmdKey)) {
            log.warn("用户未使用SmdKey来加载模型:" + key.getName());
            throw new RuntimeException("请使用SmdKey来加载精灵的smd模型。");
        }

        this.key = (SmdKey) assetInfo.getKey();
        AssetFactory.setFolder(key.getFolder());

        /**
         * 若用户使用了SmdKey，就根据type来决定采用哪种方式来加载模型。
         */
        switch (key.type) {
        case STAGE3D: {// 直接返回STAGE3D对象
            Stage stage3D = new Stage();
            stage3D.loadFile(new LittleEndien(assetInfo.openStream()));
            return stage3D;
        }
        case PAT3D: {// 直接返回PAT3D对象
            PAT3D skeleton = new PAT3D();
            skeleton.loadFile(new LittleEndien(assetInfo.openStream()));
            return skeleton;
        }
        default:
            return null;
        }
    }


}
