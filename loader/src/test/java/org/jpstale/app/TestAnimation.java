package org.jpstale.app;

import com.jme3.anim.AnimComposer;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import org.jpstale.assets.AssetFactory;

/**
 * 测试动画播放（使用 AnimComposer，迁移后无 Skeleton 故暂不显示骨骼线）
 *
 * @author yanmaoyuan
 *
 */
public class TestAnimation extends TestBase {

    @Override
    public void init() {

        float scale = 0.1f;

        //Node npc = AssetFactory.loadCharacter("char/monster/death_knight/death_knight.inx");
        Node npc = AssetFactory.loadCharacter("char/monster/hopy/hopy.inx");
        //Node npc = AssetFactory.loadCharacter("char/npc/arad/arad.inx");
        npc.scale(scale);
        rootNode.attachChild(npc);

        AnimComposer composer = findAnimComposer(npc);
        if (composer != null) {
            String first = composer.getAnimClipsNames().isEmpty() ? "Anim" : composer.getAnimClipsNames().iterator().next();
            composer.setCurrentAction(first);
        }
        cam.setLocation(new Vector3f(0, 5, 10));
    }

    private static AnimComposer findAnimComposer(Spatial s) {
        AnimComposer c = s.getControl(AnimComposer.class);
        if (c != null) return c;
        if (s instanceof Node) {
            for (Spatial child : ((Node) s).getChildren()) {
                c = findAnimComposer(child);
                if (c != null) return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new TestAnimation().start();

    }

}
