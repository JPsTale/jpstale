package org.jpstale.gamedata.preview;

import com.jme3.anim.AnimComposer;
import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.simsilica.lemur.GuiGlobals;
import org.jpstale.assets.AssetFactory;
import org.jpstale.constants.SceneConstants;
import org.jpstale.entity.item.Item;
import org.jpstale.entity.item.ItemConstant;

/**
 * 嵌入在 Swing 中的 JME 预览应用：在主线程通过 createCanvas/startCanvas 创建 GL 上下文后，
 * 由 gamedata-viewer 复用同一 Canvas 显示怪物/NPC/道具模型。loadCharacter/loadItem 需通过 enqueue 在渲染线程调用。
 */
public class EmbeddedPreviewApp extends SimpleApplication {

    private static final float CHAR_SCALE = 0.1f;

    private final AmbientLight ambientLight = new AmbientLight();

    @Override
    public void simpleInitApp() {
        GuiGlobals.initialize(this);
        setPauseOnLostFocus(false);
        AssetFactory.setAssetManager(assetManager);
        getViewPort().setBackgroundColor(new ColorRGBA(0.4f, 0.4f, 0.5f, 1f));
        ambientLight.setColor(ColorRGBA.White);
        rootNode.addLight(ambientLight);
        flyCam.setDragToRotate(true);
        cam.setLocation(new Vector3f(0, 5, 10));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
        flyCam.setMoveSpeed(8f);
    }

    /**
     * 在渲染线程中加载角色模型（怪物/NPC）。由 MainFrame 通过 enqueue 调用。
     */
    public void loadCharacter(String gameRootPath, String characterPath) {
        if (gameRootPath != null && !gameRootPath.isEmpty()) {
            AssetFactory.setFolder(gameRootPath);
        }
        clearScene();
        detachPreviewState();
        try {
            Spatial model = AssetFactory.loadCharacter(characterPath);
            model.scale(CHAR_SCALE);
            rootNode.attachChild(model);
            AnimComposer composer = findAnimComposer(model);
            if (composer != null && !composer.getAnimClipsNames().isEmpty()) {
                composer.setCurrentAction(composer.getAnimClipsNames().iterator().next());
            }
            getStateManager().attach(new CharacterPreviewState(rootNode));
        } catch (Exception e) {
            e.printStackTrace();
        }
        cam.setLocation(new Vector3f(0, 5, 10));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
    }

    /**
     * 在渲染线程中加载道具掉落物模型。由 MainFrame 通过 enqueue 调用。
     */
    public void loadItem(String gameRootPath, long itemCode) {
        detachPreviewState();
        if (gameRootPath != null && !gameRootPath.isEmpty()) {
            AssetFactory.setFolder(gameRootPath);
        }
        clearScene();
        getViewPort().setBackgroundColor(new ColorRGBA(0.35f, 0.35f, 0.4f, 1f));
        Item item = findItemByCode(itemCode);
        if (item != null && item.dorpItem != null && !item.dorpItem.isEmpty()) {
            try {
                String path = "image/Sinimage/Items/DropItem/it" + item.dorpItem + ".smd";
                Spatial model = AssetFactory.loadStageObj(path, false);
                model.scale(SceneConstants.scale);
                rootNode.attachChild(model);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        cam.setLocation(new Vector3f(2, 2, 4));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
    }

    private void clearScene() {
        rootNode.detachAllChildren();
        rootNode.addLight(ambientLight);
        getViewPort().setBackgroundColor(new ColorRGBA(0.4f, 0.4f, 0.5f, 1f));
    }

    private void detachPreviewState() {
        CharacterPreviewState state = getStateManager().getState(CharacterPreviewState.class);
        if (state != null) getStateManager().detach(state);
    }

    private static AnimComposer findAnimComposer(Spatial spatial) {
        AnimComposer c = spatial.getControl(AnimComposer.class);
        if (c != null) return c;
        if (spatial instanceof Node) {
            for (Spatial child : ((Node) spatial).getChildren()) {
                c = findAnimComposer(child);
                if (c != null) return c;
            }
        }
        return null;
    }

    private static Item findItemByCode(long code) {
        for (Item it : ItemConstant.itemDataBase) {
            if (it == null) continue;
            if ((it.code & 0xFFFFFFFFL) == code) return it;
        }
        return null;
    }
}
