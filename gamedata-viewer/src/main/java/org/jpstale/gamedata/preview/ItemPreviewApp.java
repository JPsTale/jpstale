package org.jpstale.gamedata.preview;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.system.AppSettings;
import org.jpstale.assets.AssetFactory;
import org.jpstale.constants.SceneConstants;
import org.jpstale.entity.item.Item;
import org.jpstale.entity.item.ItemConstant;

/**
 * 道具 3D 模型预览（掉落物 SMD 模型），通过 ItemConstant 按物品代码查找 Item 后加载。
 */
public class ItemPreviewApp extends SimpleApplication {

    private final String gameRootPath;
    private final long itemCode;

    public ItemPreviewApp(String gameRootPath, long itemCode) {
        this.gameRootPath = gameRootPath;
        this.itemCode = itemCode;
        setShowSettings(false);
        AppSettings settings = new AppSettings(true);
        settings.setResolution(600, 500);
        settings.setTitle("道具3D预览 - 0x" + Long.toHexString(itemCode).toUpperCase());
        setSettings(settings);
    }

    @Override
    public void simpleInitApp() {
        AssetFactory.setAssetManager(assetManager);
        if (gameRootPath != null && !gameRootPath.isEmpty()) {
            AssetFactory.setFolder(gameRootPath);
        }

        getViewPort().setBackgroundColor(new ColorRGBA(0.35f, 0.35f, 0.4f, 1f));

        AmbientLight ambient = new AmbientLight();
        ambient.setColor(ColorRGBA.White);
        rootNode.addLight(ambient);

        Item item = findItemByCode(itemCode);
        if (item != null && item.dorpItem != null && !item.dorpItem.isEmpty()) {
            try {
                String path = "image/Sinimage/Items/DropItem/it" + item.dorpItem + ".smd";
                Spatial model = AssetFactory.loadStageObj(path, false);
                if (model != null) {
                    model.scale(SceneConstants.scale);
                    rootNode.attachChild(model);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        cam.setLocation(new Vector3f(2, 2, 4));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
        flyCam.setMoveSpeed(4f);
    }

    private static Item findItemByCode(long code) {
        for (Item it : ItemConstant.itemDataBase) {
            if (it == null) continue;
            if ((it.code & 0xFFFFFFFFL) == code) return it;
        }
        return null;
    }
}
