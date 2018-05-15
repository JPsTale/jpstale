package org.pstale.app;

import org.pstale.assets.AssetFactory;
import org.pstale.assets.utils.AssetNameUtils;
import org.pstale.assets.utils.ModelBuilder;

import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.debug.SkeletonDebugger;
import com.jme3.scene.plugins.smd.geom.AnimateModel;
import com.jme3.scene.plugins.smd.geom.PAT3D;

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
        new TestLoadNPC().start();
    }

}
