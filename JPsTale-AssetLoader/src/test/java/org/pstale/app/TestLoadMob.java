package org.pstale.app;

import org.pstale.assets.AssetFactory;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.Skeleton;
import com.jme3.app.SimpleApplication;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.scene.debug.SkeletonDebugger;
import com.jme3.scene.plugins.ase.AseKey;

public class TestLoadMob extends SimpleApplication {

    public static void main(String[] args) {
        TestLoadMob app = new TestLoadMob();
        app.setPauseOnLostFocus(false);
        app.start();
    }

    Node mob = null;
    Node bone = null;
    Node skin = null;
    Node skeletonDebug;

    @Override
    public void simpleInitApp() {

        AssetFactory.setAssetManager(assetManager);

        AmbientLight light = new AmbientLight();
        light.setColor(ColorRGBA.White);
        rootNode.addLight(light);

        // mob = (Node)assetManager.loadAsset(new AseKey("char/monster/chaoscara/chaoscara.ASE"));
        mob = (Node) assetManager.loadAsset(new AseKey("char/monster/death_knight/death_knight.ASE"));
        mob.scale(0.04f);
        rootNode.attachChild(mob);

        bone = (Node) mob.getChild("BONES");
        skin = (Node) mob.getChild("SKINS");

        initKeys();

        // Debug skeleton
        final AnimControl ac = mob.getControl(AnimControl.class);
        if (ac != null) {
            // add a skeleton debugger to make bones visible
            final Skeleton skel = ac.getSkeleton();
            skeletonDebug = new SkeletonDebugger("skeleton", skel);
            final Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            mat.setColor("Color", ColorRGBA.Green);
            mat.getAdditionalRenderState().setDepthTest(false);
            skeletonDebug.setMaterial(mat);
            mob.attachChild(skeletonDebug);

            AnimChannel channel = ac.createChannel();
            channel.setAnim("Anim");
        }

        stateManager.attach(new AxisAppState());
    }

    boolean isVisiavle = true;

    void initKeys() {
        inputManager.addMapping("Skin", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        inputManager.addMapping("Bone", new MouseButtonTrigger(MouseInput.BUTTON_RIGHT));
        inputManager.addMapping("SkeDebug", new MouseButtonTrigger(MouseInput.BUTTON_MIDDLE));

        inputManager.addListener(new ActionListener() {
            @Override
            public void onAction(String name, boolean isPressed, float tpf) {
                if (isPressed) {
                    if (name.equals("Bone")) {
                        if (mob.hasChild(bone)) {
                            mob.detachChild(bone);
                        } else {
                            mob.attachChild(bone);
                        }
                    }
                    if (name.equals("Skin")) {
                        if (mob.hasChild(skin)) {
                            mob.detachChild(skin);
                        } else {
                            mob.attachChild(skin);
                        }
                    }

                    if (name.equals("SkeDebug")) {
                        if (mob.hasChild(skeletonDebug)) {
                            mob.detachChild(skeletonDebug);
                        } else {
                            mob.attachChild(skeletonDebug);
                        }
                    }
                }
            }
        }, "Skin", "Bone", "SkeDebug");
    }

}
