package org.jpstale.app;


import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.smd.geom.PAT3D;
import org.jpstale.assets.utils.AnimationBuilder;
import org.jpstale.assets.utils.ModelBuilder;

import com.jme3.animation.AnimControl;
import com.jme3.animation.Animation;
import com.jme3.animation.Skeleton;
import com.jme3.animation.SkeletonControl;
import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.Spatial.CullHint;
import com.jme3.scene.debug.SkeletonDebugger;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * 测试动画播放速度
 * 用于对比原版和 jME3 版本的动画速度
 */
public class TestAnimationSpeed extends SimpleApplication implements ActionListener {

    private AnimControl animControl;
    private float currentSpeed = 1.0f;
    private String currentAnim = "Walk";
    private boolean showSkeleton = false;
    private SkeletonControl skeletonControl;
    private SkeletonDebugger skeletonDebugger;
    private BitmapText infoText;

    public static void main(String[] args) {
        TestAnimationSpeed app = new TestAnimationSpeed();
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Animation Speed Test");
        settings.setResolution(1024, 768);
        app.setSettings(settings);
        app.setShowSettings(false);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        viewPort.setBackgroundColor(new ColorRGBA(0.2f, 0.2f, 0.2f, 1.0f));

        // 设置光照
        AmbientLight ambient = new AmbientLight();
        ambient.setColor(ColorRGBA.White.mult(0.5f));
        rootNode.addLight(ambient);

        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-1, -2, -3).normalizeLocal());
        sun.setColor(ColorRGBA.White.mult(0.8f));
        rootNode.addLight(sun);

        // 相机位置
        cam.setLocation(new Vector3f(0, 2, 10));
        cam.lookAtDirection(new Vector3f(0, 0, -1), Vector3f.UNIT_Y);

        // 加载模型
        loadModel();

        // 添加简单的地面
        createGround();

        // 设置键盘输入
        setupKeys();

        // 添加 GUI 控制提示
        addControlHints();

        // 创建信息文本
        createUI();
    }

    private void loadModel() {
        try {
            // 初始化 AssetFactory
            AssetFactory.setAssetManager(assetManager);

            // 加载 SMD 模型文件
            // 需要根据实际路径修改
            String modelPath = "assets/monster/00001/00001";
            PAT3D pat3d = AssetFactory.loadSmd(modelPath);

            if (pat3d == null) {
                System.err.println("无法加载模型: " + modelPath);
                // 创建一个测试用的骨骼
                createTestSkeleton();
                return;
            }

            // 创建模型
            Node model = ModelBuilder.buildModel(pat3d, "TestModel");
            rootNode.attachChild(model);

            // 获取动画控制器
            animControl = model.getControl(AnimControl.class);
            skeletonControl = model.getControl(SkeletonControl.class);

            if (animControl != null) {
                // 动画监听器已移除，jME3 可能不支持

                // 添加骨骼调试器
                if (skeletonControl != null && skeletonControl.getSkeleton() != null) {
                    skeletonDebugger = new SkeletonDebugger("skeleton", skeletonControl.getSkeleton());
                    skeletonDebugger.setMaterial(assetManager.loadMaterial("Common/Materials/VertexColor.j3md"));
                    skeletonDebugger.setCullHint(showSkeleton ?
                        com.jme3.scene.Spatial.CullHint.Never :
                        com.jme3.scene.Spatial.CullHint.Always);
                    model.attachChild(skeletonDebugger);
                }

                // 播放行走动画
                playAnimation(currentAnim);
            }

        } catch (Exception e) {
            e.printStackTrace();
            createTestSkeleton();
        }
    }

    private void createTestSkeleton() {
        // 创建一个简单的测试骨骼
        Node testModel = new Node("TestModel");

        // 创建一个简单的骨骼（仅用于测试）
        Skeleton skeleton = createSimpleSkeleton();
        AnimControl animControl = new AnimControl(skeleton);
        testModel.addControl(animControl);
        testModel.addControl(new SkeletonControl(skeleton));

        // 创建测试动画
        createTestAnimation(animControl);

        rootNode.attachChild(testModel);
        this.animControl = animControl;

        // 播放动画
        playAnimation(currentAnim);
    }

    private Skeleton createSimpleSkeleton() {
        // 这里应该创建一个简单的骨架用于测试
        // 简化起见，返回 null
        return null;
    }

    private void createTestAnimation(AnimControl control) {
        // 这里应该创建测试动画
        // 简化起见，跳过实际创建
    }

    private void createGround() {
        Material groundMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        groundMat.setColor("Color", new ColorRGBA(0.3f, 0.3f, 0.3f, 1.0f));

        // 创建地面
        Box groundBox = new Box(20, 0.1f, 20);
        Geometry ground = new Geometry("Ground", groundBox);
        ground.setMaterial(groundMat);
        ground.setLocalTranslation(0, -0.5f, 0);
        rootNode.attachChild(ground);

        // 添加网格线作为参考
        Material lineMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        lineMat.setColor("Color", ColorRGBA.Gray);

        for (int i = -20; i <= 20; i += 5) {
            // X方向线
            Box xLine = new Box(20, 0.01f, 0.01f);
            Geometry xLineGeom = new Geometry("XLine" + i, xLine);
            xLineGeom.setMaterial(lineMat);
            xLineGeom.setLocalTranslation(0, 0, i);
            rootNode.attachChild(xLineGeom);

            // Z方向线
            Box zLine = new Box(0.01f, 0.01f, 20);
            Geometry zLineGeom = new Geometry("ZLine" + i, zLine);
            zLineGeom.setMaterial(lineMat);
            zLineGeom.setLocalTranslation(i, 0, 0);
            rootNode.attachChild(zLineGeom);
        }
    }

    private void addControlHints() {
        // 在控制台输出控制说明
        System.out.println("\n=== 动画速度测试控制 ===");
        System.out.println("1: 播放 Idle 动画");
        System.out.println("2: 播放 Walk 动画");
        System.out.println("3: 播放 Run 动画");
        System.out.println("+: 加速动画");
        System.out.println("-: 减速动画");
        System.out.println("R: 重置速度为 1.0");
        System.out.println("Space: 暂停/继续");
        System.out.println("=====================\n");
    }

    private void setupKeys() {
        inputManager.addMapping("Idle", new KeyTrigger(KeyInput.KEY_1));
        inputManager.addMapping("Walk", new KeyTrigger(KeyInput.KEY_2));
        inputManager.addMapping("Run", new KeyTrigger(KeyInput.KEY_3));
        inputManager.addMapping("SpeedUp", new KeyTrigger(KeyInput.KEY_EQUALS));
        inputManager.addMapping("SpeedDown", new KeyTrigger(KeyInput.KEY_MINUS));
        inputManager.addMapping("ResetSpeed", new KeyTrigger(KeyInput.KEY_R));
        inputManager.addMapping("Pause", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addMapping("ToggleSkeleton", new KeyTrigger(KeyInput.KEY_S));

        inputManager.addListener(this, "Idle", "Walk", "Run",
                "SpeedUp", "SpeedDown", "ResetSpeed", "Pause", "ToggleSkeleton");
    }

    private void createUI() {
        infoText = new BitmapText(guiFont, false);
        infoText.setSize(guiFont.getCharSet().getRenderedSize());
        infoText.setColor(ColorRGBA.White);
        infoText.setLocalTranslation(10, settings.getHeight() - 10, 0);
        guiNode.attachChild(infoText);

        updateInfoText();
    }

    private void updateInfoText() {
        if (infoText != null) {
            String text = String.format(
                "Animation: %s\n" +
                "Speed: %.2fx\n" +
                "Skeleton: %s",
                currentAnim,
                currentSpeed,
                showSkeleton ? "ON" : "OFF"
            );
            infoText.setText(text);
        }
    }

    private void playAnimation(String animName) {
        if (animControl != null && animControl.getAnim(animName) != null) {
            currentAnim = animName;
            animControl.getChannel(0).setAnim(animName);
            animControl.getChannel(0).setLoopMode(animName.equals("Idle") ?
                com.jme3.animation.LoopMode.Loop : com.jme3.animation.LoopMode.Loop);
            animControl.getChannel(0).setSpeed(currentSpeed);

            System.out.println("播放动画: " + animName + ", 速度: " + currentSpeed);
            updateInfoText();
        }
    }

    @Override
    public void simpleUpdate(float tpf) {
        // 在这里可以添加动画速度的实时调整
        // 例如根据按键改变速度
    }

    // 添加键盘控制
    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (!isPressed) return;

        switch(name) {
            case "Idle":
                playAnimation("Idle");
                break;
            case "Walk":
                playAnimation("Walk");
                break;
            case "Run":
                playAnimation("Run");
                break;
            case "SpeedUp":
                currentSpeed += 0.1f;
                if (currentSpeed > 3.0f) currentSpeed = 3.0f;
                if (animControl != null && animControl.getChannel(0) != null) {
                    animControl.getChannel(0).setSpeed(currentSpeed);
                }
                System.out.println("动画速度: " + currentSpeed);
                updateInfoText();
                break;
            case "SpeedDown":
                currentSpeed -= 0.1f;
                if (currentSpeed < 0.1f) currentSpeed = 0.1f;
                if (animControl != null && animControl.getChannel(0) != null) {
                    animControl.getChannel(0).setSpeed(currentSpeed);
                }
                System.out.println("动画速度: " + currentSpeed);
                updateInfoText();
                break;
            case "ResetSpeed":
                currentSpeed = 1.0f;
                if (animControl != null && animControl.getChannel(0) != null) {
                    animControl.getChannel(0).setSpeed(currentSpeed);
                }
                System.out.println("动画速度重置为: " + currentSpeed);
                updateInfoText();
                break;
            case "Pause":
                if (animControl != null && animControl.getChannel(0).getSpeed() > 0) {
                    animControl.getChannel(0).setSpeed(0);
                    System.out.println("动画暂停");
                } else if (animControl != null) {
                    animControl.getChannel(0).setSpeed(currentSpeed);
                    System.out.println("动画继续");
                }
                updateInfoText();
                break;
            case "ToggleSkeleton":
                showSkeleton = !showSkeleton;
                if (skeletonDebugger != null) {
                    skeletonDebugger.setCullHint(showSkeleton ?
                        com.jme3.scene.Spatial.CullHint.Never :
                        com.jme3.scene.Spatial.CullHint.Always);
                }
                updateInfoText();
                break;
        }
    }
}