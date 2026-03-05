# 角色骨骼动画预览与 AnimControl → AnimComposer 迁移设计

## 1. 文档目的与范围

- **目标**：在 gamedata-viewer 中增强 3D 预览，支持角色骨骼动画的选取、播放/暂停、调速与骨骼线显示；并将现有基于已废弃的 `AnimControl` 的动画管线迁移到 jME3 3.9 推荐的 `AnimComposer` + `Armature`。
- **范围**：C++ 原版动画数据与播放分析、jME3 新动画模块分析、迁移策略、预览功能设计。不包含主窗口 Swing 与子进程的 IPC、对 INX 格式的修改。

---

## 2. C++ 原版 (pristontale) 动画：存储与播放

### 2.1 数据来源与格式

- **SMD**：网格 + 顶点/面/材质/顶点绑骨（`Physique`/boneArray）。
- **SMB**：骨骼层级与动画数据，由 `smRead3d`/`LoadFile` 读入为 `smPAT3D` + `smOBJ3D[]`。
- **INX**：配置模型文件、动画文件、`smMOTIONINFO`（State、StartFrame、EndFrame、Repeat 等），与 SMD/SMB 关联。

### 2.2 骨骼与动画数据结构 (smObj3d.h)

- **smOBJ3D（每根骨骼）**：
  - 标识：`NodeName`、`NodeParent`、`pParent`。
  - 绑定姿态：`Tm`、`TmInvert`、四元数 `qx,qy,qz,qw`，缩放 `sx,sy,sz`，位置 `px,py,pz`。
  - 动画数据：`TmRot`（旋转）、`TmPos`（位移）、`TmScale`（缩放），以及对应数量 `TmRotCnt`、`TmPosCnt`、`TmScaleCnt`。
  - 结果：`TmResult`（smFMATRIX），由动画帧计算得到。
  - 帧索引：`TmRotFrame[]`、`TmPosFrame[]`、`TmScaleFrame[]`、`TmFrameCnt`，用于按帧查找关键帧区间。

- **smPAT3D**：
  - `obj3d[]`：所有骨骼对象。
  - `TmSort[]`：骨骼更新顺序（父先子后）。
  - `Frame`、`MaxFrame`、`TmLastFrame`：当前帧与最大帧。

### 2.3 播放流程

- **SetFrame(frame)**：对根或子 PAT3D 调用 `TmAnimation(frame, ax, ay, az)`。
- **TmAnimation**：按 `TmSort` 顺序遍历每个 `smOBJ3D`，调用其 `TmAnimation(frame, ...)`。
- **每骨骼 TmAnimation**：
  - 用 `GetRotFrame`、`GetPosFrame`、`GetScaleFrame` 根据当前 `frame` 在 `TmRot`/`TmPos`/`TmScale` 中插值，得到旋转矩阵、位移、缩放。
  - 结合父节点 `TmResult` 与本地变换，写出本骨骼的 `TmResult`。
- **渲染**：顶点根据绑骨信息与各骨骼的 `TmResult` 做蒙皮变换。

结论：原版是**按帧驱动**的骨骼动画（每帧一个整数 frame，在关键帧间插值），数据在 SMB 中以骨骼为单位存储旋转/位移/缩放关键帧。

---

## 3. jME3 新动画模块 (com.jme3.anim)

### 3.1 核心类型

| 类型 | 作用 | 与旧 API 对应 |
|------|------|----------------|
| **Armature** | 骨骼层级与蒙皮矩阵 | 替代 Skeleton |
| **Joint** | 单关节（名、父子、本地变换） | 替代 Bone |
| **AnimClip** | 一组 AnimTrack，有 name、length | 替代单次 Animation |
| **TransformTrack** | 对 Joint 的平移/旋转/缩放关键帧 | 替代 BoneTrack |
| **AnimComposer** | 管理 AnimClip、按 name 播放 Action、调速 | 替代 AnimControl |
| **SkinningControl** | 用 Armature 的蒙皮矩阵变形 Mesh | 替代 SkeletonControl |

### 3.2 播放与调速

- **AnimComposer**：`addAnimClip(clip)`；`setCurrentAction(name)` 或 `setCurrentAction(name, layer, loop)`；`setGlobalSpeed(speed)`；`getAnimClipsNames()`。
- **AnimLayer**：每层一个当前 Action（如 ClipAction），有当前时间与循环。
- 无“通道”概念：通过多 Layer 或组合 Action 实现混合。

### 3.3 迁移工具 (AnimMigrationUtils)

- **migrate(Spatial)**：深度遍历，对带 `AnimControl` 的节点：用其 `Skeleton` 构建 `Armature`（Bone→Joint），用其 `Animation` 的每个 `BoneTrack` 转为 `TransformTrack` 并生成 `AnimClip`，加入 `AnimComposer`，移除 `AnimControl`；对带 `SkeletonControl` 的节点：用已建 Armature 替换为 `SkinningControl(armature)`。
- **BoneTrack → TransformTrack**：时间数组拷贝；位移/旋转/缩放需结合 Bone 的 bind pose（`fromBoneTrack` 中 bind+relative 与 JPsTale 的 buildBoneTrack 语义需一致，见下节）。

---

## 4. JPsTale 当前实现要点

- **AnimationBuilder**：`buildSkeleton(PAT3D)` → `Skeleton`(Bone[])；`buildAnimation(PAT3D)` → 单个 `Animation("Anim", length)` + 多个 `BoneTrack`（帧→时间用 160/4800 缩放）。
- **ModelBuilder**：对 PAT3D 建 `Skeleton`、`Animation`，挂 `AnimControl`、`SkeletonControl`；蒙皮用 `ske.getBoneIndex(bone.NodeName)` 写 BoneIndex。
- **BoneTrack** 存的是**相对 bind 的变换**（与 C++ 中相对父节点与 bind 一致）；时间单位为秒。

---

## 5. 迁移策略

### 5.1 方案 A：构建时直接产出新 API（长期推荐）

- **AnimationBuilder** 增加（或逐步替换为）：
  - `buildArmature(PAT3D)`：从 GeomObject[] 建 Joint 树，与现 Skeleton 顺序一致。
  - `buildAnimClip(PAT3D)` / `buildAnimClip(PAT3D, MotionInfo)`：产出 `AnimClip` + `TransformTrack[]`，时间与坐标系与现有 `buildBoneTrack` 一致（可先由 BoneTrack 数据构造 TransformTrack，或仿照 `AnimMigrationUtils.fromBoneTrack` 用 Joint 的 bind 构造）。
- **ModelBuilder**：
  - 使用 `Armature` + `AnimComposer` + `SkinningControl`；蒙皮时用 `armature.getJointIndex(jointName)` 或与 Joint 顺序一致的索引写 BoneIndex。
- **优点**：不再依赖废弃 API，管线清晰。**缺点**：改动面大，需验证蒙皮与所有动画用例。

### 5.2 方案 B：保持现有构建，加载后迁移（短期推荐）

- **保持**：AnimationBuilder 仍产出 `Skeleton` + `Animation`，ModelBuilder 仍挂 `AnimControl` + `SkeletonControl`。
- **在模型挂到场景后**：对返回的根 Spatial 调用 `AnimMigrationUtils.migrate(root)`，将同一节点上的 AnimControl/SkeletonControl 替换为 AnimComposer/SkinningControl。
- **适用位置**：`AssetFactory.loadCharacter()` 或 `ModelBuilder.buildModel()` 的 return 前。
- **优点**：改动小、风险低，可尽快切到 AnimComposer 并做预览。**缺点**：仍依赖旧 Skeleton/Bone/BoneTrack 的构建与 AnimMigrationUtils 的兼容性（Bone bind 与 TransformTrack 的换算需与当前 JPsTale 一致）。

### 5.3 建议执行顺序

1. **第一阶段**：采用方案 B。在 `loadCharacter` 或 `ModelBuilder.buildModel` 末尾对根节点执行 `AnimMigrationUtils.migrate(root)`；跑通现有 TestAnimation、TestLoadMonster 等，确认播放与蒙皮正常。
2. **第二阶段**：在 gamedata-viewer 与 loader 的预览/测试中，将所有对 `AnimControl`/`AnimChannel` 的调用改为 `AnimComposer`/`setCurrentAction`/`setGlobalSpeed`；骨骼线若依赖 Skeleton，改为从 Armature 取 Joint 或使用新 API 的调试显示（若有）。
3. **第三阶段**（可选）：按方案 A 将 AnimationBuilder/ModelBuilder 改为直接产出 Armature + AnimClip + AnimComposer + SkinningControl，去掉对 Skeleton/Animation/AnimControl 的依赖。

---

## 6. 预览功能设计（基于 AnimComposer）

### 6.1 架构

- **CharacterPreviewState**（jME AppState）：在 3D 场景上叠加 Lemur 面板；仅当当前加载的是带 **AnimComposer** 的角色时显示（无 AnimComposer 则不显示动画面板）。
- **ModelPreviewApp** / **EmbeddedPreviewApp**：加载角色后挂上 `CharacterPreviewState`；道具预览不挂或隐藏面板。

### 6.2 控件与交互

- **动画列表**：`AnimComposer.getAnimClipsNames()` 下拉选择；切换时 `setCurrentAction(name)` 并从头播放。
- **播放/暂停**：按钮切换；暂停可用 `setGlobalSpeed(0)` 或层时间停止（视 jME3 层 API 而定）。
- **速度**：滑块或选项（如 0.5x / 1x / 2x），调节 `setGlobalSpeed(float)`。
- **显示骨骼**：勾选时在模型上挂接骨骼线显示（若 jME3 提供 Armature 的 debug 显示则用之，否则保留 SkeletonDebugger 仅在做迁移前使用，迁移后需对应 Armature 的调试方式）。

### 6.3 依赖

- gamedata-viewer 的 `pom.xml` 增加 `lemur`（及必要时 `lemur-proto`），与父 POM 版本一致。

### 6.4 错误与边界

- 无 AnimComposer（例如道具、或迁移未执行）：不创建或隐藏动画面板。
- 无动画列表：下拉显示“无动画”或隐藏控件。
- 加载失败：保持原有错误提示，不因预览状态崩溃。

---

## 7. 实施顺序总结

1. **迁移**：在 loader 中接入 `AnimMigrationUtils.migrate`，验证现有角色与怪物动画。
2. **替换调用**：将所有 AnimControl/AnimChannel 改为 AnimComposer/ setCurrentAction/setGlobalSpeed。
3. **预览**：在 gamedata-viewer 中实现 CharacterPreviewState（Lemur），基于 AnimComposer 做动画列表、播放/暂停、调速、骨骼线。
4. **（可选）直建新 API**：AnimationBuilder/ModelBuilder 直接产出 Armature + AnimComposer + SkinningControl，移除对旧 API 的依赖。

---

## 8. 补充确认：关键帧语义与 INX 分段

### 8.1 C++ 中关键帧是绝对还是相对？转换到 Java 是否需要相对帧？

**结论**：

- **帧号（frame）**：在 C++ 中为**绝对**。SMB 里每个关键帧的 `tmRot[].frame`、`tmPos[].frame` 等是整条时间轴上的绝对帧索引。多段 SMB 合并时（smRead3d 中多文件合并为一段），会做 `TmRot[TmCnt].frame += TmFrame[cnt].StartFrame`，合并后仍是全局时间轴上的绝对帧。
- **旋转（TmRot）**：在**文件/内存中为相对**。smRead3d 中 `TmPrevRot[cnt]` 是「从第 0 帧到第 cnt 个关键帧」的**累积旋转矩阵**（`dPrevMat = dPrevMat * quatToMatrix(TmRot[cnt])`），即每关键帧存的是**相对上一关键帧的四元数**，播放时用 `PrevRot[cnt] * slerp(rot[cnt], rot[cnt+1], alpha)` 得到当前旋转。
- **位移（TmPos）/ 缩放（TmScale）**：在 C++ 中为**绝对**。`GetPosFrame` / `GetScaleFrame` 在相邻两关键帧之间线性插值，存的是该关键帧的绝对位置/缩放。

**转换到 Java（JPsTale）**：

- 当前 **AnimationBuilder.buildBoneTrack** 已按「相对 bind 姿态」处理：旋转用 `bindRotationGLInverse.mult(rotGL)` 得到相对 bind 的旋转；位移用 `pos - bindPosition` 再乘坐标变换。时间轴用 `frame / FramePerSecond * timeScale` 得到** clip 内绝对时间**（0～length）。因此**不需要再在 Java 里把“绝对帧”算成“相对帧”**；保持「帧号 → 时间」+ 「相对 bind 的变换」即可。

### 8.2 C++ 中 INX 如何读取动画信息？如何区分分段？当前 loader 是否正确？

**C++ 侧**：

- **来源**：动画分段信息来自 **.ini 脚本**（如 `char\monster\hopy\hopy.ini`），由 `fileread.cpp` 的 `AddModelDecode(iniFile, &Info)` 解析。
- **解析**：遇到 `*某动作` 等关键字时调用 `SetIniMotionInfo(&Info->MotionInfo[Info->MotionCount], p, ...)`，用 `atoi(strBuff)` 从脚本里读 **StartFrame**、**EndFrame**（数值，单位为 **Tick**，1 Tick = 160 帧）。同时根据关键字设置 `State`（如 RUN、ATTACK、DEAD 等）和 `Repeat`。
- **编码**：这些内容会经 `ModelKeyWordEncode`/`MotionKeyWordDecode` 写入/读出**二进制 .inx**，与 `smMODELINFO` 布局对应（含 `MotionInfo[]`、`MotionCount`、`StartFrame`/`EndFrame` 等）。
- **分段含义**：同一套骨骼动画（一个或合并后的 SMB）有一条**全局绝对帧**时间轴；INX 的每个 **MotionInfo** 用 **StartFrame/EndFrame（Tick）** 表示「这段动画在时间轴上的区间」，从而区分 Idle、Walk、Run、Attack 等**分段**。

**JPsTale loader 侧**：

- **INX 读取**：**正确**。`InxLoader` + `AnimateModel.loadData()` 按二进制布局读取，得到 `modelFile`、`motionFile`、`subMotions[]`、`subMotionCount`，以及每个 `MotionInfo` 的 `motionStartFrame`、`endFrame`、`State` 等，与 C++ 的 smMODELINFO/MotionInfo 对应。
- **分段使用**：**主路径未用分段**。`ModelBuilder.buildModel(pat, name)` 只调用了 `AnimationBuilder.buildAnimation(pat)`（无 MotionInfo），因此只生成**一个**名为 "Anim" 的完整长度动画，**没有**按 INX 的 subMotions 生成多段（Idle、Walk、Run 等）。
- **已有能力**：`AnimationBuilder.buildAnimation(pat, motionInfo)` 已实现按 `motionStartFrame`/`endFrame` 截取区间并命名为 `getAnimationNameById(motionInfo.State)`，在 TestSubAnimation、TestInxLoader 中有使用，但**未接入** `AssetFactory.loadCharacter` / `ModelBuilder.buildModel`。

**建议**：

- 迁移到 AnimComposer 时，在 **ModelBuilder**（或统一建动画的地方）中：对 `AnimateModel.subMotions` 中有效条目（如 `motionStartFrame`/`endFrame` 有效）循环调用 `buildAnimation(pat, motionInfo)`，为每个生成一个 **AnimClip** 并加入 **AnimComposer**，这样预览和游戏逻辑都能按名称（Idle、Walk、Run 等）选段播放。
- 若 INX 中某角色 `subMotionCount == 0` 或未使用分段，可退化为当前行为：只生成一个 "Anim" 的完整 clip。

实施计划见：`docs/plans/2025-03-05-character-skeletal-animation-preview-implementation.md`。

---

*文档日期：2025-03-05*
