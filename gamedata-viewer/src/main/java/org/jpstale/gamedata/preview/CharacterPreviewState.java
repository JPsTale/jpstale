package org.jpstale.gamedata.preview;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.jme3.anim.AnimClip;
import com.jme3.anim.AnimComposer;
import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.simsilica.lemur.Button;
import com.simsilica.lemur.Checkbox;
import com.simsilica.lemur.Container;
import com.simsilica.lemur.FillMode;
import com.simsilica.lemur.Label;
import com.simsilica.lemur.DefaultRangedValueModel;
import com.simsilica.lemur.Selector;
import com.simsilica.lemur.Slider;
import com.simsilica.lemur.Axis;
import com.simsilica.lemur.component.BoxLayout;
import com.simsilica.lemur.component.SpringGridLayout;
import com.simsilica.lemur.core.GuiControl;
import com.simsilica.lemur.core.VersionedList;
import com.simsilica.lemur.core.VersionedReference;
import com.simsilica.lemur.style.BaseStyles;

/**
 * 角色骨骼动画预览控制面板（参考 LemurProto ProtoDemo 布局）。
 * 使用 glass 样式、title 标题、SpringGridLayout 分行排布。
 */
public class CharacterPreviewState extends BaseAppState {

    private final Spatial sceneRoot;
    private AnimComposer composer;
    private Node guiNode;
    private Container window;
    private VersionedList<String> animList;
    private Selector<String> animSelector;
    private VersionedReference<String> selectedAnimRef;
    private Button playPauseButton;
    private DefaultRangedValueModel speedModel;
    private DefaultRangedValueModel timelineModel;
    private Checkbox loopCheckbox;
    private double currentClipLength;
    private double lastComposerTime;
    private double lastTimelineValue;
    private boolean updatingTimeline;
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
        window = null;
        composer = null;
        animList = null;
        animSelector = null;
        selectedAnimRef = null;
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
        if (composer == null) return;

        if (selectedAnimRef != null && selectedAnimRef.update()) {
            String name = selectedAnimRef.get();
            if (name != null) {
                composer.setCurrentAction(name);
                AnimClip clip = composer.getAnimClip(name);
                currentClipLength = clip != null ? clip.getLength() : 0.0;
                composer.setTime(0.0);
                lastComposerTime = 0.0;
                if (timelineModel != null) {
                    updatingTimeline = true;
                    timelineModel.setValue(0.0);
                    lastTimelineValue = 0.0;
                    updatingTimeline = false;
                }
            }
        }

        if (speedModel != null && playing) {
            composer.setGlobalSpeed((float) speedModel.getValue());
        }

        // 播放时推进时间与时间轴（利用 AnimComposer 自己的循环行为）
        if (playing && currentClipLength > 0.0) {
            double t = composer.getTime();

            // 如果「不循环」且检测到时间从末尾跳回开头（wrap），则认为一轮已结束
            if (loopCheckbox != null && !loopCheckbox.isChecked()
                    && lastComposerTime > 0.0
                    && t + 1e-4 < lastComposerTime) {
                playing = false;
                composer.setGlobalSpeed(0f);
                if (playPauseButton != null) {
                    playPauseButton.setText("Play");
                }
                // 停在最后一帧
                t = currentClipLength;
                try {
                    composer.setTime(t);
                } catch (RuntimeException ignored) {
                }
            }

            if (timelineModel != null && !updatingTimeline) {
                updatingTimeline = true;
                double v = currentClipLength > 0.0 ? Math.min(t, currentClipLength) / currentClipLength : 0.0;
                timelineModel.setValue(v);
                lastTimelineValue = v;
                updatingTimeline = false;
            }

            lastComposerTime = t;
        }

        // 用户拖动时间轴时，驱动动画时间
        if (timelineModel != null && currentClipLength > 0.0 && !updatingTimeline) {
            double v = timelineModel.getValue();
            if (Math.abs(v - lastTimelineValue) > 1e-4) {
                lastTimelineValue = v;
                double t = v * currentClipLength;
                try {
                    composer.setTime(t);
                } catch (RuntimeException ignored) {
                    // 如果当前没有 action，忽略
                }
            }
        }
    }

    private void buildPanel() {
        BaseStyles.loadGlassStyle();
        com.simsilica.lemur.GuiGlobals.getInstance().getStyles().setDefaultStyle(BaseStyles.GLASS);

        // 主窗口：垂直堆叠，每一行一个子容器
        window = new Container(new BoxLayout(Axis.Y, FillMode.None), "glass");

        // 第 1 行：Animation 标签
        Container animLabelRow = new Container(
                new SpringGridLayout(Axis.X, Axis.Y, FillMode.None, FillMode.None), "glass");
        animLabelRow.addChild(new Label("Animation:", "glass"));
        window.addChild(animLabelRow);

        Set<String> names = composer.getAnimClipsNames();
        List<String> nameList = new ArrayList<>(names);
        animList = new VersionedList<>(nameList);

        // 第 2 行：动画下拉 + 右侧 Play/Pause 按钮
        Container animRow = new Container(
                new SpringGridLayout(Axis.X, Axis.Y, FillMode.None, FillMode.None), "glass");
        animSelector = new Selector<>(animList, "glass");
        animSelector.setPreferredSize(new Vector3f(260, 0, 0));
        animRow.addChild(animSelector);
        playPauseButton = new Button(playing ? "Pause" : "Play", "glass");
        playPauseButton.addClickCommands(btn -> {
            playing = !playing;
            composer.setGlobalSpeed(playing ? (float) speedModel.getValue() : 0f);
            playPauseButton.setText(playing ? "Pause" : "Play");
        });
        animRow.addChild(playPauseButton);
        window.addChild(animRow);

        selectedAnimRef = animSelector.createSelectedItemReference();
        if (!nameList.isEmpty()) {
            animSelector.setSelectedItem(nameList.get(0));
            composer.setCurrentAction(nameList.get(0));
        }

        // 第 3 行：Speed 标签 + 宽滑块 + Loop
        Container speedRow = new Container(
                new SpringGridLayout(Axis.X, Axis.Y, FillMode.None, FillMode.None), "glass");
        speedRow.addChild(new Label("Speed", "glass"));
        speedModel = new DefaultRangedValueModel(0.25, 2.0, 1.0);
        Slider speedSlider = new Slider(speedModel, "glass");
        speedSlider.setPreferredSize(new Vector3f(260, 0, 0));
        speedRow.addChild(speedSlider);
        loopCheckbox = new Checkbox("Loop", "glass");
        loopCheckbox.setChecked(true);
        speedRow.addChild(loopCheckbox);
        window.addChild(speedRow);

        // 第 4 行：时间轴
        Container timelineRow = new Container(
                new SpringGridLayout(Axis.X, Axis.Y, FillMode.None, FillMode.None), "glass");
        timelineRow.addChild(new Label("Time", "glass"));
        timelineModel = new DefaultRangedValueModel(0.0, 1.0, 0.0);
        Slider timelineSlider = new Slider(timelineModel, "glass");
        timelineSlider.setPreferredSize(new Vector3f(260, 0, 0));
        timelineRow.addChild(timelineSlider);
        window.addChild(timelineRow);

        // 第 5 行：Skeleton + Clear
        Container skeletonRow = new Container(
                new SpringGridLayout(Axis.X, Axis.Y, FillMode.None, FillMode.None), "glass");
        Checkbox skeletonCheckbox = new Checkbox("Skeleton", "glass");
        skeletonCheckbox.setChecked(false);
        skeletonCheckbox.addClickCommands(cb -> {
            // TODO: 骨骼线
        });
        skeletonRow.addChild(skeletonCheckbox);
        Button clearButton = new Button("Clear", "glass");
        clearButton.addClickCommands(btn -> {
            try {
                composer.reset();
                composer.removeCurrentAction();
            } catch (Exception ignored) {
            }
            composer.setGlobalSpeed(0f);
            playing = false;
            lastComposerTime = 0.0;
            if (playPauseButton != null) {
                playPauseButton.setText("Play");
            }
            currentClipLength = 0.0;
            if (timelineModel != null) {
                updatingTimeline = true;
                timelineModel.setValue(0.0);
                lastTimelineValue = 0.0;
                updatingTimeline = false;
            }
        });
        skeletonRow.addChild(clearButton);
        window.addChild(skeletonRow);

        guiNode.attachChild(window);

        // 只保证最小宽度，不拉伸高度
        Vector3f pref = window.getControl(GuiControl.class).getPreferredSize();
        float minW = 260f;
        float pw = Math.max(minW, pref.x);
        window.setPreferredSize(new Vector3f(pw, pref.y, 0f));

        // Lemur Panel 的 localTranslation 以左上角为基准，y 以屏幕上边为 0 向下增长
        float h = getApplication().getCamera().getHeight();
        window.setLocalTranslation(10, h - 10, 1);
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
