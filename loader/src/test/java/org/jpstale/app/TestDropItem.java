package org.jpstale.app;

import org.jpstale.assets.AssetFactory;
import org.jpstale.constants.SceneConstants;
import org.jpstale.entity.item.Item;

import static org.jpstale.entity.item.ItemConstant.itemDataBase;

import com.jme3.material.RenderState.BlendMode;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.control.AbstractControl;
import com.jme3.ui.Picture;

public class TestDropItem extends TestBase {

    @Override
    public void init() {
        String dorpItem = "image/Sinimage/Items/DropItem/it%s.smd";
        String sinImage = "image/Sinimage/Items/%s/it%s.bmp";

        Item item = itemDataBase[21];

        String cat = "CA196";

        // 查找装备
        for (int cnt = 0; cnt < itemDataBase.length; cnt++) {
            if (itemDataBase[cnt].category.equalsIgnoreCase(cat)) {
                item = itemDataBase[cnt];
                System.out.println(cnt);
                break;
            }
        }

        Node node = AssetFactory.loadStageObj(String.format(dorpItem, item.dorpItem), false);
        node.scale(SceneConstants.scale);
        rootNode.attachChild(node);

        Picture picture = new Picture("sinImage");
        picture.setWidth(item.width);
        picture.setHeight(item.height);
        picture.setImage(assetManager, String.format(sinImage, item.folder, item.category), false);
        picture.getMaterial().getAdditionalRenderState().setBlendMode(BlendMode.Color);
        guiNode.attachChild(picture);

        // 居中
        float x = (cam.getWidth() - item.width) * 0.5f;
        float y = (cam.getHeight() - item.height) * 0.5f;
        picture.setLocalTranslation(x, y, 1);

        flyCam.setMoveSpeed(10f);
    }

    public static void main(String[] args) {
        new TestDropItem().start();
    }

}
