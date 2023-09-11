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
import org.jpstale.constants.SceneConstants;

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
        Node npc = AssetFactory.loadCharacter(path);
        npc.scale(SceneConstants.scale);
        rootNode.attachChild(npc);

        cam.setLocation(new Vector3f(0, 5, 10));
        flyCam.setMoveSpeed(10);
    }

    public static void main(String[] args) {
        TestLoadNPC app = new TestLoadNPC();
        app.start();
    }

}
