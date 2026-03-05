# 角色骨骼动画预览与 AnimComposer 迁移 — 实施计划

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** 将 loader 中角色动画从 AnimControl 迁移到 AnimComposer，按 INX 分段生成多段 AnimClip，并在 gamedata-viewer 中增加 Lemur 动画预览面板（选动画、播放/暂停、调速、骨骼线）。

**Architecture:** 先保持现有 AnimationBuilder/ModelBuilder 产出 Skeleton+Animation+AnimControl，在 loadCharacter/buildModel 返回前调用 AnimMigrationUtils.migrate；再在 ModelBuilder 中按 AnimateModel.subMotions 为每段生成 AnimClip 并加入 AnimComposer（迁移前需先产出多 Animation）；预览侧用 AnimComposer 的 getAnimClipsNames/setCurrentAction/setGlobalSpeed 驱动 Lemur 控件。

**Tech Stack:** Java 8、jME3 3.9（com.jme3.anim）、Lemur、Maven、JPsTale loader / gamedata-viewer。

---

## 阶段一：AnimControl → AnimComposer 迁移

### Task 1：在 buildModel 返回前调用 AnimMigrationUtils.migrate

**文件：**
- 修改：`loader/src/main/java/org/jpstale/assets/utils/ModelBuilder.java`（buildModel 末尾）
- 测试：`loader/src/test/java/org/jpstale/app/TestAnimation.java`（或现有动画测试）

**Step 1：确认迁移 API 可用**

在 ModelBuilder 类顶部添加 import：
```java
import com.jme3.anim.util.AnimMigrationUtils;
```

**Step 2：在 buildModel 中挂接迁移**

在 `buildModel(PAT3D pat, String name)` 中，在 `return rootNode;` 之前添加：
```java
rootNode = AnimMigrationUtils.migrate(rootNode);
```
（若 migrate 为 void，则调用 `AnimMigrationUtils.migrate(rootNode);` 后直接 return rootNode。）

**Step 3：编译并运行现有动画测试**

- 运行：`cd loader && mvn test-compile exec:java -Dexec.mainClass="org.jpstale.app.TestAnimation" -Dexec.classpathScope=test`
- 预期：角色加载并播放动画，无 ClassNotFoundException 或运行时错误。

**Step 4：Commit**

```bash
git add loader/src/main/java/org/jpstale/assets/utils/ModelBuilder.java
git commit -m "feat(loader): migrate AnimControl to AnimComposer after buildModel"
```

---

### Task 2：将 TestAnimation / 测试类改为使用 AnimComposer

**文件：**
- 修改：`loader/src/test/java/org/jpstale/app/TestAnimation.java`
- 视情况修改：`loader/src/test/java/org/jpstale/app/TestSkeleton.java`、`TestSubAnimation.java` 等引用 AnimControl 的测试

**Step 1：替换 AnimControl/AnimChannel 为 AnimComposer**

在 TestAnimation 中：
- 将 `AnimControl ac = npc.getControl(AnimControl.class)` 改为 `AnimComposer composer = npc.getControl(AnimComposer.class)`。
- 将 `ac.getSkeleton()` 改为从 `composer` 所在 Spatial 下找 `SkinningControl`，再 `getArmature()`（或暂时保留 SkeletonDebugger 的获取方式，若 jME3 提供 Armature 的 debug 则后续再换）。
- 将 `ac.createChannel().setAnim("Anim")` 改为 `composer.setCurrentAction("Anim")`。
- 骨骼线：若迁移后节点上为 SkinningControl，用 `SkinningControl.getArmature()` 的 Joint 做调试显示，或暂时注释掉 SkeletonDebugger 仅验证动画播放。

**Step 2：运行测试**

- 运行：`cd loader && mvn test-compile exec:java -Dexec.mainClass="org.jpstale.app.TestAnimation" -Dexec.classpathScope=test`
- 预期：动画正常播放，无 NPE。

**Step 3：Commit**

```bash
git add loader/src/test/java/org/jpstale/app/TestAnimation.java [及其他修改的测试类]
git commit -m "test(loader): switch animation tests to AnimComposer"
```

---

## 阶段二：按 INX 分段生成多段 AnimClip

### Task 3：在 buildModel 中根据 AnimateModel.subMotions 生成多个 Animation 再迁移

**文件：**
- 修改：`loader/src/main/java/org/jpstale/assets/AssetFactory.java`（loadCharacter：将 modelInfo 传入 buildModel 或先建 PAT3D 再根据 modelInfo 生成多段）
- 修改：`loader/src/main/java/org/jpstale/assets/utils/ModelBuilder.java`（增加重载或内部逻辑：接收 AnimateModel，对 subMotions 有效项调用 buildAnimation(pat, motionInfo)，为每个生成 Animation 并加入 AnimControl；然后再执行 migrate）

**说明：** 当前 ModelBuilder.buildModel 只接收 PAT3D 和 name，不接收 AnimateModel。需要：
- 要么在 AssetFactory.loadCharacter 中先 loadInx 得到 modelInfo，再 loadSmd/loadSmb 得到 PAT3D，然后调用新方法如 ModelBuilder.buildModel(pat, name, modelInfo)，在 buildModel 内为每个 subMotions 有效条目调用 AnimationBuilder.buildAnimation(pat, motionInfo)，把多个 Animation 都加入同一个 AnimControl（旧 API 支持 addAnim 多次），最后 migrate；
- 要么在 loadCharacter 里先 buildModel(pat, name)，再遍历 modelInfo.subMotions 用 buildAnimation(pat, mi) 得到多个 Animation，然后挂到已建的 AnimControl 上（需在 migrate 前拿到 rootNode 的 AnimControl 并 addAnim），再 migrate。

**Step 1：在 loadCharacter 中传入 modelInfo 并在 buildModel 前/内生成多段动画**

- 在 AssetFactory.loadCharacter 中已有 modelInfo（loadInx）。在调用 ModelBuilder.buildModel 时传入 modelInfo。
- 在 ModelBuilder 中增加重载：`buildModel(PAT3D pat, String name, AnimateModel modelInfo)`。若 modelInfo != null 且 modelInfo.subMotionCount > 0，则循环 modelInfo.subMotions（i < subMotionCount），对每个 motionInfo 若 motionStartFrame/endFrame 有效则调用 `Animation anim = AnimationBuilder.buildAnimation(pat, motionInfo)`，若 anim != null 则 `animControl.addAnim(anim)`；否则保持现有逻辑只 addAnim(buildAnimation(pat))。

**Step 2：保持 migrate 在最后执行**

- buildModel 末尾仍调用 AnimMigrationUtils.migrate(rootNode)，这样多个 Animation 会变成多个 AnimClip 进入 AnimComposer。

**Step 3：运行 TestAnimation 与 TestSubAnimation**

- 运行 TestAnimation，预期仍有 "Anim" 或第一个 clip；运行 TestSubAnimation（若存在）预期可切换多段。
- 运行：`cd loader && mvn test-compile exec:java -Dexec.mainClass="org.jpstale.app.TestSubAnimation" -Dexec.classpathScope=test`（如有）。

**Step 4：Commit**

```bash
git add loader/src/main/java/org/jpstale/assets/AssetFactory.java loader/src/main/java/org/jpstale/assets/utils/ModelBuilder.java
git commit -m "feat(loader): build multiple AnimClips from INX subMotions before migrate"
```

---

## 阶段三：gamedata-viewer 动画预览（Lemur）

### Task 4：gamedata-viewer 添加 Lemur 依赖

**文件：**
- 修改：`gamedata-viewer/pom.xml`

**Step 1：添加 lemur 依赖**

在 `<dependencies>` 内添加（版本与父 POM dependencyManagement 一致）：
```xml
<dependency>
    <groupId>org.jmonkeyengine</groupId>
    <artifactId>lemur</artifactId>
    <version>${jme3.version}</version>
</dependency>
```

**Step 2：编译**

- 运行：`cd gamedata-viewer && mvn compile`
- 预期：BUILD SUCCESS。

**Step 3：Commit**

```bash
git add gamedata-viewer/pom.xml
git commit -m "chore(gamedata-viewer): add Lemur dependency for preview GUI"
```

---

### Task 5：实现 CharacterPreviewState（Lemur 面板）

**文件：**
- 新建：`gamedata-viewer/src/main/java/org/jpstale/gamedata/preview/CharacterPreviewState.java`
- 修改：`gamedata-viewer/src/main/java/org/jpstale/gamedata/preview/ModelPreviewApp.java`（加载角色后 attach state）
- 修改：`gamedata-viewer/src/main/java/org/jpstale/gamedata/preview/EmbeddedPreviewApp.java`（loadCharacter 成功后 attach state）

**Step 1：创建 CharacterPreviewState 类**

- 继承 `com.jme3.app.state.BaseAppState`，在 stateAttached 时从 getStateManager().getApplication().getRootNode() 或传入的 modelRoot 下查找带 `AnimComposer` 的 Spatial（深度遍历）；若找到则创建 Lemur GUI：Container 含下拉（AnimComposer.getAnimClipsNames()）、播放/暂停按钮、速度滑块、骨骼线复选框。
- 下拉选择时调用 `composer.setCurrentAction(selectedName)`；暂停可 `composer.setGlobalSpeed(0)`，播放恢复 1f 或当前速度；速度滑块设置 `composer.setGlobalSpeed(value)`。
- 骨骼线：若 jME3 有 Armature 的 debug 显示则使用，否则可先预留接口或从 SkinningControl.getArmature() 取 Joint 做简单线框（视 jME3 示例而定）。

**Step 2：在 ModelPreviewApp.simpleInitApp 中挂载**

- 加载角色并 attachChild 后，`getStateManager().attach(new CharacterPreviewState(modelRoot或rootNode));`，并确保只对角色（有 AnimComposer）显示面板。

**Step 3：在 EmbeddedPreviewApp.loadCharacter 中挂载**

- 在 enqueue 的 loadCharacter 回调里，加载成功后 attach 同一 CharacterPreviewState，并传入当前 rootNode 或 model 节点以便查找 AnimComposer。

**Step 4：运行 gamedata-viewer 验证**

- 运行：`cd gamedata-viewer && mvn exec:java -Dexec.mainClass="org.jpstale.gamedata.GameDataViewer"`
- 打开 GameServer 目录，选中怪物/NPC，工具 → 预览3D模型，预期出现 Lemur 面板并可切换动画、调速、播放/暂停。

**Step 5：Commit**

```bash
git add gamedata-viewer/src/main/java/org/jpstale/gamedata/preview/CharacterPreviewState.java \
  gamedata-viewer/src/main/java/org/jpstale/gamedata/preview/ModelPreviewApp.java \
  gamedata-viewer/src/main/java/org/jpstale/gamedata/preview/EmbeddedPreviewApp.java
git commit -m "feat(gamedata-viewer): add CharacterPreviewState with Lemur animation controls"
```

---

### Task 6：ModelPreviewApp 启用动画播放

**文件：**
- 修改：`gamedata-viewer/src/main/java/org/jpstale/gamedata/preview/ModelPreviewApp.java`

**Step 1：取消注释并改为 AnimComposer**

- 将原先注释掉的 AnimControl/AnimChannel 逻辑删除，改为查找 AnimComposer，若有则 `setCurrentAction(getAnimClipsNames().iterator().next())` 或首个 clip 名，保证子进程预览窗口打开时默认播放第一段动画。

**Step 2：Commit**

```bash
git add gamedata-viewer/src/main/java/org/jpstale/gamedata/preview/ModelPreviewApp.java
git commit -m "fix(gamedata-viewer): enable default animation play in ModelPreviewApp"
```

---

## 验收与文档

### Task 7：验收与设计文档引用

**Step 1：全量编译与冒烟测试**

- 运行：`mvn clean compile -pl loader,gamedata-viewer`
- 运行 loader 的 TestAnimation、TestLoadMonster（若有），以及 gamedata-viewer 的 3D 预览，确认无回归。

**Step 2：在设计文档中注明实施计划路径**

- 在 `docs/plans/2025-03-05-character-skeletal-animation-preview-design.md` 末尾增加一行：
  - “实施计划见：`docs/plans/2025-03-05-character-skeletal-animation-preview-implementation.md`。”

**Step 3：Commit**

```bash
git add docs/plans/2025-03-05-character-skeletal-animation-preview-design.md
git commit -m "docs: link implementation plan in animation preview design"
```

---

*计划日期：2025-03-05*
