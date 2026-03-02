package org.jpstale.gamedata.preview;

import com.jme3.animation.AnimControl;
import com.jme3.animation.AnimChannel;
import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.system.AppSettings;
import org.jpstale.assets.AssetFactory;

/**
 * 用于 gamedata-viewer 的 3D 模型预览（怪物/NPC 角色 + 骨骼动画）。
 * 在独立线程中运行，需先设置游戏根路径与模型路径。
 */
public class ModelPreviewApp extends SimpleApplication {

    private static final float SCALE = 0.1f;

    private final String gameRootPath;
    private final String characterPath;

    public ModelPreviewApp(String gameRootPath, String characterPath) {
        this.gameRootPath = gameRootPath;
        this.characterPath = characterPath;
        setShowSettings(false);
        AppSettings settings = new AppSettings(true);
        settings.setResolution(800, 600);
        settings.setTitle("3D 预览 - " + characterPath);
        setSettings(settings);
    }

    @Override
    public void simpleInitApp() {
        AssetFactory.setAssetManager(assetManager);
        if (gameRootPath != null && !gameRootPath.isEmpty()) {
            AssetFactory.setFolder(gameRootPath);
        }

        getViewPort().setBackgroundColor(new ColorRGBA(0.4f, 0.4f, 0.5f, 1f));

        AmbientLight ambient = new AmbientLight();
        ambient.setColor(ColorRGBA.White);
        rootNode.addLight(ambient);

        try {
            Spatial model = AssetFactory.loadCharacter(characterPath);
            if (model != null) {
                model.scale(SCALE);
                rootNode.attachChild(model);

                AnimControl ac = findAnimControl(model);
                if (ac != null) {
                    AnimChannel channel = ac.createChannel();
                    String animName = "Anim";
                    if (ac.getAnimationNames() != null && !ac.getAnimationNames().isEmpty()) {
                        animName = ac.getAnimationNames().iterator().next();
                    }
                    channel.setAnim(animName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cam.setLocation(new Vector3f(0, 5, 10));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
        flyCam.setMoveSpeed(8f);
    }

    private static AnimControl findAnimControl(Spatial spatial) {
        AnimControl ac = spatial.getControl(AnimControl.class);
        if (ac != null) return ac;
        if (spatial instanceof Node) {
            for (Spatial child : ((Node) spatial).getChildren()) {
                ac = findAnimControl(child);
                if (ac != null) return ac;
            }
        }
        return null;
    }
}
