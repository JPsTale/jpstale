package org.jpstale.app;


import org.jpstale.assets.AssetFactory;
import org.jpstale.assets.plugins.smd.geom.PAT3D;
import org.jpstale.assets.utils.AnimationBuilder;
import org.jpstale.assets.utils.ModelBuilder;

import com.jme3.animation.AnimChannel;
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
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.Spatial.CullHint;
import com.jme3.scene.debug.SkeletonDebugger;
import com.jme3.system.AppSettings;

/**
 * 动画对比测试工具
 * 用于对比原版和 jME3 版本的动画播放效果
 */
public class TestAnimationCompare extends SimpleApplication implements ActionListener {

    private Node originalModel;
    private Node optimizedModel;
    private AnimControl originalAnimControl;
    private AnimControl optimizedAnimControl;
    private AnimChannel originalChannel;
    private AnimChannel optimizedChannel;

    private String currentAnim = "Walk";
    private float playbackSpeed = 1.0f;
    private boolean showSkeleton = false;
    private boolean isPaused = false;

    private BitmapText infoText;

    // 模型路径配置
    private static final String MODEL_PATH = "assets/monster/00001/00001.smd";

    public static void main(String[] args) {
        TestAnimationCompare app = new TestAnimationCompare();
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Animation Comparison Test");
        settings.setResolution(1400, 800);
        app.setSettings(settings);
        app.setShowSettings(false);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        // 设置背景颜色
        viewPort.setBackgroundColor(new ColorRGBA(0.15f, 0.15f, 0.15f, 1.0f));

        // 设置光照
        setupLighting();

        // 设置键盘输入
        setupKeys();

        // 创建地面网格
        createGround();

        // 创建UI
        createUI();

        // 加载模型
        loadModels();

        // 设置相机
        setupCamera();
    }

    private void setupLighting() {
        AmbientLight ambient = new AmbientLight();
        ambient.setColor(ColorRGBA.White.mult(0.4f));
        rootNode.addLight(ambient);

        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(-1f, -2f, -3f).normalizeLocal());
        sun.setColor(ColorRGBA.White.mult(0.8f));
        rootNode.addLight(sun);
    }

    private void setupKeys() {
        // 动画控制
        inputManager.addMapping("Idle", new KeyTrigger(KeyInput.KEY_1));
        inputManager.addMapping("Walk", new KeyTrigger(KeyInput.KEY_2));
        inputManager.addMapping("Run", new KeyTrigger(KeyInput.KEY_3));
        inputManager.addMapping("Attack", new KeyTrigger(KeyInput.KEY_4));

        // 播放控制
        inputManager.addMapping("Pause", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addMapping("SpeedUp", new KeyTrigger(KeyInput.KEY_EQUALS));
        inputManager.addMapping("SpeedDown", new KeyTrigger(KeyInput.KEY_MINUS));
        inputManager.addMapping("ResetSpeed", new KeyTrigger(KeyInput.KEY_R));

        // 显示控制
        inputManager.addMapping("ToggleSkeleton", new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("ToggleOriginal", new KeyTrigger(KeyInput.KEY_O));
        inputManager.addMapping("ToggleOptimized", new KeyTrigger(KeyInput.KEY_P));

        inputManager.addListener(this, "Idle", "Walk", "Run", "Attack",
                                       "Pause", "SpeedUp", "SpeedDown", "ResetSpeed",
                                       "ToggleSkeleton", "ToggleOriginal", "ToggleOptimized");
    }

    private void createGround() {
        // 创建一个简单的地面
        float groundSize = 20f;
        Node ground = new Node("Ground");

        // 使用 assetManager 创建地面材质
        ground.setLocalTranslation(0, -0.1f, 0);
        rootNode.attachChild(ground);

        // 添加网格线标记位置
        for (float x = -groundSize; x <= groundSize; x += 2f) {
            Geometry line = createLine(new Vector3f(x, 0, -groundSize),
                new Vector3f(x, 0, groundSize), ColorRGBA.Gray);
            ground.attachChild(line);
        }
        for (float z = -groundSize; z <= groundSize; z += 2f) {
            Geometry line = createLine(new Vector3f(-groundSize, 0, z),
                new Vector3f(groundSize, 0, z), ColorRGBA.Gray);
            ground.attachChild(line);
        }
    }

    private Geometry createLine(Vector3f start, Vector3f end, ColorRGBA color) {
        // 这里应该使用 Line 创建线条，简化实现
        return new Geometry();
    }

    private void createUI() {
        // 创建信息文本
        infoText = new BitmapText(guiFont, false);
        infoText.setSize(guiFont.getCharSet().getRenderedSize());
        infoText.setColor(ColorRGBA.White);
        infoText.setLocalTranslation(10, settings.getHeight() - 10, 0);
        guiNode.attachChild(infoText);

        // 添加标题
        BitmapText title = new BitmapText(guiFont, false);
        title.setSize(guiFont.getCharSet().getRenderedSize() * 1.5f);
        title.setColor(ColorRGBA.Yellow);
        title.setText("Animation Comparison Test");
        title.setLocalTranslation(settings.getWidth() / 2 - title.getLineWidth() / 2,
                                settings.getHeight() - 30, 0);
        guiNode.attachChild(title);

        // 添加说明
        BitmapText instructions = new BitmapText(guiFont, false);
        instructions.setSize(guiFont.getCharSet().getRenderedSize() * 0.8f);
        instructions.setColor(ColorRGBA.White);
        instructions.setText(
            "Controls:\n" +
            "1-4: Select animation (Idle/Walk/Run/Attack)\n" +
            "Space: Pause/Resume\n" +
            "+/-: Speed up/down\n" +
            "R: Reset speed\n" +
            "S: Toggle skeleton view\n" +
            "O: Toggle original model\n" +
            "P: Toggle optimized model"
        );
        instructions.setLocalTranslation(10, 150, 0);
        guiNode.attachChild(instructions);

        // 添加模型标签
        BitmapText originalLabel = new BitmapText(guiFont, false);
        originalLabel.setSize(guiFont.getCharSet().getRenderedSize());
        originalLabel.setColor(ColorRGBA.Red);
        originalLabel.setText("Original");
        originalLabel.setLocalTranslation(settings.getWidth() / 4 - 30, 50, 0);
        guiNode.attachChild(originalLabel);

        BitmapText optimizedLabel = new BitmapText(guiFont, false);
        optimizedLabel.setSize(guiFont.getCharSet().getRenderedSize());
        optimizedLabel.setColor(ColorRGBA.Green);
        optimizedLabel.setText("Optimized");
        optimizedLabel.setLocalTranslation(3 * settings.getWidth() / 4 - 30, 50, 0);
        guiNode.attachChild(optimizedLabel);
    }

    private void loadModels() {
        try {
            // 初始化 AssetFactory
            AssetFactory.setAssetManager(assetManager);

            // 加载原始模型（使用原始的动画处理）
            String modelPath = MODEL_PATH.replace(".smd", "");
            PAT3D pat3d1 = AssetFactory.loadSmd(modelPath);
            if (pat3d1 == null) {
                System.err.println("找不到模型文件: " + MODEL_PATH);
                createTestModels();
                return;
            }

            // 创建两个模型副本
            originalModel = ModelBuilder.buildModel(pat3d1, "Original");
            originalModel.setLocalTranslation(-3, 0, 0);

            PAT3D pat3d2 = AssetFactory.loadSmd(modelPath);
            optimizedModel = ModelBuilder.buildModel(pat3d2, "Optimized");
            optimizedModel.setLocalTranslation(3, 0, 0);

            // 获取动画控制器
            originalAnimControl = originalModel.getControl(AnimControl.class);
            optimizedAnimControl = optimizedModel.getControl(AnimControl.class);

            if (originalAnimControl != null && optimizedAnimControl != null) {
                originalChannel = originalAnimControl.createChannel();
                optimizedChannel = optimizedAnimControl.createChannel();

                // 同步播放动画
                playBothAnimations(currentAnim);

                // 添加骨骼调试器
                if (showSkeleton) {
                    addSkeletonDebuggers();
                }
            }

            // 添加到场景
            rootNode.attachChild(originalModel);
            rootNode.attachChild(optimizedModel);

            // 创建半透明的材质区分两个模型
            // 这里应该为原始模型添加红色色调，优化模型添加绿色色调

        } catch (Exception e) {
            e.printStackTrace();
            createTestModels();
        }
    }

    private void createTestModels() {
        // 创建测试用的简单模型
        originalModel = new Node("Original");
        optimizedModel = new Node("Optimized");

        // 设置位置
        originalModel.setLocalTranslation(-3, 0, 0);
        optimizedModel.setLocalTranslation(3, 0, 0);

        // 添加到场景
        rootNode.attachChild(originalModel);
        rootNode.attachChild(optimizedModel);
    }

    private void addSkeletonDebuggers() {
        if (originalModel != null) {
            SkeletonControl sc = originalModel.getControl(SkeletonControl.class);
            if (sc != null) {
                SkeletonDebugger skeletonDebug = new SkeletonDebugger("skeleton", sc.getSkeleton());
                skeletonDebug.setMaterial(assetManager.loadMaterial("Common/Materials/VertexColor.j3md"));
                originalModel.attachChild(skeletonDebug);
            }
        }

        if (optimizedModel != null) {
            SkeletonControl sc = optimizedModel.getControl(SkeletonControl.class);
            if (sc != null) {
                SkeletonDebugger skeletonDebug = new SkeletonDebugger("skeleton", sc.getSkeleton());
                skeletonDebug.setMaterial(assetManager.loadMaterial("Common/Materials/VertexColor.j3md"));
                optimizedModel.attachChild(skeletonDebug);
            }
        }
    }

    private void setupCamera() {
        cam.setLocation(new Vector3f(0, 3, 10));
        cam.lookAtDirection(new Vector3f(0, -0.3f, -1).normalizeLocal(), Vector3f.UNIT_Y);
    }

    private void playBothAnimations(String animName) {
        if (originalAnimControl != null && optimizedAnimControl != null) {
            if (originalAnimControl.getAnim(animName) != null) {
                originalChannel.setAnim(animName);
                originalChannel.setLoopMode(animName.equals("Idle") ?
                    com.jme3.animation.LoopMode.Loop : com.jme3.animation.LoopMode.Loop);
                originalChannel.setSpeed(playbackSpeed);

                // 确保两个模型的动画同步
                optimizedChannel.setAnim(animName);
                optimizedChannel.setLoopMode(animName.equals("Idle") ?
                    com.jme3.animation.LoopMode.Loop : com.jme3.animation.LoopMode.Loop);
                optimizedChannel.setSpeed(playbackSpeed);

                currentAnim = animName;
                updateInfoText();
            }
        }
    }

    private void updateInfoText() {
        if (infoText != null) {
            String text = String.format(
                "Animation: %s\n" +
                "Speed: %.2fx\n" +
                "Status: %s\n" +
                "Skeleton: %s",
                currentAnim,
                playbackSpeed,
                isPaused ? "PAUSED" : "PLAYING",
                showSkeleton ? "ON" : "OFF"
            );
            infoText.setText(text);
        }
    }

    @Override
    public void onAction(String name, boolean isPressed, float tpf) {
        if (!isPressed) return;

        switch (name) {
            case "Idle":
            case "Walk":
            case "Run":
            case "Attack":
                String animName = name;
                playBothAnimations(animName);
                break;

            case "Pause":
                isPaused = !isPaused;
                if (originalChannel != null) {
                    originalChannel.setSpeed(isPaused ? 0 : playbackSpeed);
                }
                if (optimizedChannel != null) {
                    optimizedChannel.setSpeed(isPaused ? 0 : playbackSpeed);
                }
                updateInfoText();
                break;

            case "SpeedUp":
                playbackSpeed += 0.1f;
                if (playbackSpeed > 3.0f) playbackSpeed = 3.0f;
                if (originalChannel != null) originalChannel.setSpeed(playbackSpeed);
                if (optimizedChannel != null) optimizedChannel.setSpeed(playbackSpeed);
                updateInfoText();
                break;

            case "SpeedDown":
                playbackSpeed -= 0.1f;
                if (playbackSpeed < 0.1f) playbackSpeed = 0.1f;
                if (originalChannel != null) originalChannel.setSpeed(playbackSpeed);
                if (optimizedChannel != null) optimizedChannel.setSpeed(playbackSpeed);
                updateInfoText();
                break;

            case "ResetSpeed":
                playbackSpeed = 1.0f;
                if (originalChannel != null) originalChannel.setSpeed(playbackSpeed);
                if (optimizedChannel != null) optimizedChannel.setSpeed(playbackSpeed);
                updateInfoText();
                break;

            case "ToggleSkeleton":
                showSkeleton = !showSkeleton;
                updateInfoText();
                break;

            case "ToggleOriginal":
                if (originalModel != null) {
                    originalModel.setCullHint(
                        originalModel.getCullHint() == CullHint.Always ?
                        CullHint.Never : CullHint.Always);
                }
                break;

            case "ToggleOptimized":
                if (optimizedModel != null) {
                    optimizedModel.setCullHint(
                        optimizedModel.getCullHint() == CullHint.Always ?
                        CullHint.Never : CullHint.Always);
                }
                break;
        }
    }
}