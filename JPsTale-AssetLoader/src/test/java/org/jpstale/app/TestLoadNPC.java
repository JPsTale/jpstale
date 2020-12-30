package org.jpstale.app;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.debug.SkeletonDebugger;
import com.jme3.system.AppSettings;

import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.smd.geom.AnimateModel;
import org.jpstale.assets.plugins.smd.geom.PAT3D;
import org.jpstale.assets.utils.AssetNameUtils;
import org.jpstale.assets.utils.ModelBuilder;

/**
 * 测试生成骨骼
 * 
 * @author yanmaoyuan
 *
 */
public class TestLoadNPC extends TestBase {

    @Override
    public void init() {

        String path = "char/npc/arad/arad.inx";
        float scale = 0.1f;

        Node npc = AssetFactory.loadCharacter(path);
        npc.scale(scale);
        rootNode.attachChild(npc);

        cam.setLocation(new Vector3f(0, 5, 10));
        flyCam.setMoveSpeed(10);
    }

    public static void main(String[] args) {
        AppSettings setting = new AppSettings(true);
        setting.setRenderer("JOGL");
        setting.setAudioRenderer("JOAL");

        TestLoadNPC app = new TestLoadNPC();
        app.setSettings(setting);
        app.start();
    }

}
