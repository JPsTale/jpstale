package org.jpstale.gamedata.preview;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.jme3.anim.AnimComposer;
import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.simsilica.lemur.Button;
import com.simsilica.lemur.Checkbox;
import com.simsilica.lemur.Container;
import com.simsilica.lemur.Label;
import com.simsilica.lemur.DefaultRangedValueModel;
import com.simsilica.lemur.Slider;
import com.simsilica.lemur.component.QuadBackgroundComponent;
import com.simsilica.lemur.style.ElementId;

/**
 * 角色骨骼动画预览控制面板（Lemur）。
 * 仅当场景中存在 AnimComposer 时显示；提供动画切换、播放/暂停、速度、骨骼线开关。
 */
public class CharacterPreviewState extends BaseAppState {

    private final Spatial sceneRoot;
    private AnimComposer composer;
    private Node guiNode;
    private Container panel;
    private Label animNameLabel;
    private List<String> animNames = new ArrayList<>();
    private int animIndex;
    private Button playPauseButton;
    private Slider speedSlider;
    private DefaultRangedValueModel speedModel;
    private boolean playing = true;

    public CharacterPreviewState(Spatial sceneRoot) {
        this.sceneRoot = sceneRoot;
    }

    @Override
    protected void initialize(Application app) {
        composer = findAnimComposer(sceneRoot);
        guiNode = new Node("CharacterPreviewGUI");
    }

    @Override
    protected void cleanup(Application app) {
        guiNode = null;
        panel = null;
        composer = null;
        animNames = null;
    }

    @Override
    protected void onEnable() {
        if (composer == null) return;
        buildPanel();
        ((com.jme3.app.SimpleApplication) getApplication()).getGuiNode().attachChild(guiNode);
    }

    @Override
    protected void onDisable() {
        if (guiNode != null && guiNode.getParent() != null) {
            guiNode.removeFromParent();
        }
    }

    @Override
    public void update(float tpf) {
        if (composer != null && speedModel != null && playing) {
            composer.setGlobalSpeed((float) speedModel.getValue());
        }
    }

    private void buildPanel() {
        panel = new Container(new ElementId("characterPreview"));
        QuadBackgroundComponent bg = new QuadBackgroundComponent(new ColorRGBA(0.2f, 0.2f, 0.25f, 0.85f));
        panel.setBackground(bg);
        float h = getApplication().getCamera().getHeight();
        panel.setLocalTranslation(10, h - 10, 1);

        Set<String> names = composer.getAnimClipsNames();
        animNames.clear();
        animNames.addAll(names);
        animIndex = 0;

        panel.addChild(new Label("动画", new ElementId("title")));
        animNameLabel = panel.addChild(new Label(animNames.isEmpty() ? "-" : animNames.get(0), new ElementId("animName")));
        Button prevBtn = panel.addChild(new Button("上一个", new ElementId("prev")));
        prevBtn.addClickCommands(b -> {
            if (animNames.isEmpty()) return;
            animIndex = (animIndex - 1 + animNames.size()) % animNames.size();
            String name = animNames.get(animIndex);
            composer.setCurrentAction(name);
            animNameLabel.setText(name);
        });
        Button nextBtn = panel.addChild(new Button("下一个", new ElementId("next")));
        nextBtn.addClickCommands(b -> {
            if (animNames.isEmpty()) return;
            animIndex = (animIndex + 1) % animNames.size();
            String name = animNames.get(animIndex);
            composer.setCurrentAction(name);
            animNameLabel.setText(name);
        });
        if (!animNames.isEmpty()) {
            composer.setCurrentAction(animNames.get(0));
        }

        playPauseButton = panel.addChild(new Button(playing ? "暂停" : "播放", new ElementId("playPause")));
        playPauseButton.addClickCommands(btn -> {
            playing = !playing;
            composer.setGlobalSpeed(playing ? (float) speedModel.getValue() : 0f);
            playPauseButton.setText(playing ? "暂停" : "播放");
        });

        panel.addChild(new Label("速度", new ElementId("speedLabel")));
        speedModel = new DefaultRangedValueModel(0.25, 2.0, 1.0);
        speedSlider = panel.addChild(new Slider(speedModel, new ElementId("speed")));
        // 速度在 update() 中与 composer 同步

        Checkbox skeletonCheckbox = panel.addChild(new Checkbox("骨骼线", "glass"));
        skeletonCheckbox.setChecked(false);
        skeletonCheckbox.addClickCommands(cb -> {
            // TODO: 根据 Armature 显示骨骼线（jME3 新 API 需单独实现）
        });

        guiNode.attachChild(panel);
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
}
