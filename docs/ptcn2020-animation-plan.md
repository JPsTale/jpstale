# PTCN2020 动画系统适配计划

## 背景

PTCN2020 客户端使用分体的动画文件格式（M1-motion*.smb），与原版 Priston Tale 的复合动画文件（m1.smb）不同。需要创建专门的加载器来处理这种格式。

## 文件结构分析

### PTCN2020 动画文件分布
- 路径：`/Users/yanmaoyuan/PTCN2020/char/tmABCD/`
- 动画文件：`M1-motion1.smb`, `M1-motion2.smb`, ... `M1-motion13.smb`
- INX配置文件：各种 .inx 文件定义模型和动画的关联

### 文件对应关系
```
M1-motion#.smb - Mechanician/Fighter/Knight
M2-motion#.smb - Archer/Atlanta
M3-motion#.smb - Magician
M4-motion#.smb - Pikeman
M5-motion#.smb - Priestess
M6-motion#.smb - Assassin
M7-motion#.smb - Shaman
M8-motion#.smb - MartialArtist
```

## 实施方案

### Phase 1: 理解PTCN2020加载流程

#### 1.1 文件加载顺序 (基于INX文件分析)
正确的加载流程：
1. **加载 INX 文件** (配置文件) - 例如 `A001.inx`
2. **INX 文件包含信息**：
   - `modelFile`: `tmbA01.ASE` (模型文件)
   - 骨骼文件: `M1Bip.in` (骨骼定义)
   - 网格名称列表: TAHA01, TBHA01等 (不同部位)
3. **骨骼文件映射**:
   - `M1Bip.in` → 加载 `M1-motion*.smb` 系列
   - `M2Bip.in` → 加载 `M2-motion*.smb` 系列
   - 等等...

#### 1.2 修改现有加载逻辑
由于 PTCN2020 使用的是分体动画而非复合动画，需要：
- 修改 `loadCharacter()` 方法中的动画加载部分（第289-296行）
- 根据 INX 中的骨骼文件（如M1Bip.in）决定加载哪套分体动画
- **关键发现**：PTCN2020的INX文件中`motionFile`字段存储的是`skeletonName`而非直接的smb文件

### Phase 2: 创建分体动画加载器

#### 2.1 创建 PTMotionLoader 类
**目标文件**: `loader/src/main/java/org/jpstale/assets/plugins/ptcn2020/PTMotionLoader.java`

**功能需求**：
- 根据 skeletal 文件名（如 M1Bip）加载对应的所有 motion*.smb
- 将多个分体文件合并到一个 PAT3D 结构中
- 为每个动画创建相应的 MotionInfo，包含正确的帧范围
- 保持每个动画的独立性，便于 AnimControl 控制

**核心方法**：
```java
public class PTMotionLoader {
    /**
     * 根据骨骼文件名加载完整的动画系列
     * @param skeletonName 骨骼文件名 (如 M1Bip)
     * @param basePath 动画文件基础路径
     * @return 包含所有动画的 PAT3D
     */
    public static PAT3D loadMotionSeries(String skeletonName, String basePath) {
        String characterType = extractCharacterType(skeletonName);

        // 创建主 PAT3D 结构
        PAT3D combined = new PAT3D();

        // 扫描并加载所有 motion*.smb 文件
        for (int i = 1; i <= 13; i++) { // M1-motion1 到 M1-motion13
            String motionFile = String.format("%s%s-motion%d.smb", basePath, characterType, i);

            try {
                PAT3D motion = loadSingleMotion(motionFile);
                if (motion != null) {
                    // 合并到 PAT3D 结构中
                    combineMotion(combined, motion);
                }
            } catch (Exception e) {
                log.warn("无法加载动画文件: " + motionFile, e);
            }
        }

        return combined;
    }

    /**
     * 将单个动画合并到主结构中
     */
    private static void combineMotion(PAT3D combined, PAT3D motion) {
        // 实现动画合并逻辑
        // 更新 objCount, 合并 objArray, 处理帧偏移等
    }

    /**
     * 从文件名提取角色类型
     * @param skeletonName 如 "M1Bip.in"
     * @return "M1"
     */
    private static String extractCharacterType(String skeletonName) {
        return skeletonName.substring(0, 2);
    }
}
```

#### 2.2 修改 AssetFactory.loadCharacter
**目标文件**: `loader/src/main/java/org/jpstale/assets/AssetFactory.java`

**修改内容**（第275-303行）：
```java
public static Node loadCharacter(String path) {
    AnimateModel modelInfo = loadInx(path);

    String folder = AssetNameUtils.getFolder(path);

    // 有共享数据?
    String linkFile = modelInfo.motionLinkFile;
    if (linkFile.length() > 0) {
        AnimateModel mi = AssetFactory.loadInx(linkFile);
        modelInfo.motionFile = mi.motionFile;
        modelInfo.subMotions = mi.subMotions;
        modelInfo.subMotionCount = mi.subMotionCount;
    }

    PAT3D skeleton = null;
    // PTCN2020 修改：使用分体动画加载
    if (modelInfo.motionFile.length() > 0) {
        // 检查是否是PTCN2020的分体动画格式
        if (isPTMotionFormat(modelInfo.motionFile)) {
            // 从骨骼文件名提取类型（如 M1Bip）
            skeleton = PTMotionLoader.loadMotionSeries(
                modelInfo.motionFile, folder);

            // 生成 subMotions 和 subMotionCount
            String characterType = extractCharacterType(modelInfo.motionFile);
            modelInfo.subMotions = PTAnimationMap.createMotionInfos(characterType, 13);
            modelInfo.subMotionCount = 13; // M1-motion1 到 M1-motion13
        } else {
            // 原始复合动画加载方式
            String smbFile = AssetNameUtils.changeExt(modelInfo.motionFile, "smb");
            String name = AssetNameUtils.getName(smbFile);
            skeleton = AssetFactory.loadSmb(folder + name);
        }
    }

    // 读取网格
    String smdFile = AssetNameUtils.changeExt(modelInfo.modelFile, "smd");
    smdFile = AssetNameUtils.getName(smdFile);
    PAT3D model = AssetFactory.loadSmd(folder + smdFile);
    model.setSkeleton(skeleton);

    return ModelBuilder.buildModel(model, path);
}

private static boolean isPTMotionFormat(String motionFile) {
    // 检查是否是 Bip 文件（PTCN2020 特有）
    return motionFile.endsWith("Bip.in") || motionFile.endsWith("Bip");
}

private static String extractCharacterType(String skeletonName) {
    // 从 "M1Bip.in" 提取 "M1"
    if (skeletonName.length() >= 2) {
        return skeletonName.substring(0, 2);
    }
    return "M1"; // 默认
}
```

#### 2.3 创建 PT 动画索引映射和 MotionInfo 生成
**目标文件**: `loader/src/main/java/org/jpstale/assets/plugins/ptcn2020/PTAnimationMap.java`

```java
public class PTAnimationMap {
    /**
     * 创建 MotionInfo 数组，每个 motion 文件对应一个
     */
    public static MotionInfo[] createMotionInfos(String characterType, int motionCount) {
        MotionInfo[] motions = new MotionInfo[motionCount];
        int frameOffset = 0;

        for (int i = 0; i < motionCount; i++) {
            MotionInfo motion = new MotionInfo();
            motion.State = getAnimationState(characterType, i + 1);
            motion.motionStartFrame = frameOffset;
            // 假设每个动画160帧（需要实际验证）
            motion.endFrame = frameOffset + 160;

            motions[i] = motion;
            frameOffset += 160;
        }

        return motions;
    }

    /**
     * 根据 motion 文件序号返回动画状态ID
     */
    public static int getAnimationState(String characterType, int motionNumber) {
        // M1系列映射 - 需要通过实际测试确定
        if ("M1".equals(characterType)) {
            switch(motionNumber) {
                case 1: return AnimationBuilder.IDLE;    // 站立
                case 2: return AnimationBuilder.WALK;    // 行走
                case 3: return AnimationBuilder.RUN;     // 跑步
                case 4: return AnimationBuilder.ATTACK;  // 攻击
                case 5: return AnimationBuilder.DAMAGE;  // 受伤
                case 6: return AnimationBuilder.DIE;     // 死亡
                // ... 更多映射
                default: return AnimationBuilder.IDLE;
            }
        }
        // 其他职业的映射...
        return AnimationBuilder.IDLE;
    }
}
```

### Phase 3: 测试和验证

#### 3.1 创建 PTCN2020 测试套件
**目标文件**: `loader/src/test/java/org/jpstale/app/TestPTCN2020Animation.java`

**测试内容**：
1. **INX文件解析测试**
   - 加载 `char/tmABCD/A001.inx`
   - 验证 `modelFile` 和 `motionFile` 字段
   - 确认骨骼文件名解析正确（如 M1Bip.in）

2. **分体动画加载测试**
   - 自动检测并加载 M1-motion*.smb 系列
   - 验证 MotionInfo 生成正确
   - 测试帧范围设置正确

3. **动画播放测试**
   - 基础动画（站立、行走、跑步）
   - 验证之前修复的动画系统正常工作
   - 动画切换流畅性测试

```java
public class TestPTCN2020Animation extends SimpleApplication {
    @Override
    public void simpleInitApp() {
        AssetFactory.setAssetManager(assetManager);

        // 使用 PTCN2020 实际路径
        String characterPath = "/Users/yanmaoyuan/PTCN2020/char/tmABCD/A001";
        Node character = AssetFactory.loadCharacter(characterPath);
        rootNode.attachChild(character);

        // 测试动画切换
        AnimControl control = character.getControl(AnimControl.class);
        if (control != null) {
            // 遍历所有可用动画
            for(String animName : control.getAnimationNames()) {
                System.out.println("可用动画: " + animName);
            }
            control.getChannel(0).setAnim("Idle");
        }
    }
}
```

#### 3.2 性能对比测试
- 对比分体加载和复合加载的性能差异
- 内存占用分析（13个motion文件的合并）
- 动画切换流畅度测试

#### 3.3 动画帧率测试
- 验证每个motion文件的帧数是否正确
- 测试帧偏移计算是否准确
- 确保动画循环时无缝衔接

### Phase 4: 优化和扩展

#### 4.1 缓存机制
- 实现动画文件的智能缓存
- 支持热加载
- 减少重复加载

#### 4.2 动画混合支持
- 实现不同 motion 之间的平滑过渡
- 支持动画混合（如边跑边攻击）

#### 4.3 NPC 和怪物动画
- 扩展到怪物和 NPC 的分体动画
- 统一的加载接口

## 技术挑战

1. **帧率同步**：
   - 确保分体文件的帧率一致（4800 FPS）
   - 处理不同动画文件的帧数差异
   - 正确计算帧偏移，避免动画重叠

2. **骨骼对齐**：
   - 验证所有分体文件使用相同的骨骼结构
   - 处理可能的骨骼差异
   - 确保motion文件顺序与骨骼定义一致

3. **内存管理**：
   - 13个motion文件合并后的内存优化
   - 动态加载和卸载策略
   - 避免重复加载相同骨骼

4. **动画索引**：
   - 正确映射motion序号到动画状态
   - 处理不同职业的动画差异
   - 确保动画名称可以通过getAnimationNames()获取

5. **版本兼容性**：
   - 处理不同客户端版本的文件格式差异
   - 向后兼容旧的复合动画格式
   - 自动检测文件格式

## 预期成果

1. **完整的 PTCN2020 动画支持**：
   - 所有角色的动画正常播放
   - 动画切换流畅无卡顿

2. **性能优化**：
   - 动画加载时间 < 500ms
   - 内存占用 < 50MB（完整角色动画）

3. **扩展性**：
   - 易于添加新的动画支持
   - 模块化的加载器设计

## 相关文件

- 研究文档：`/Users/yanmaoyuan/repo/JPsTale/docs/research/animation.md`
- PTCN2020 路径：`/Users/yanmaoyuan/PTCN2020/`
- 现有动画系统：`loader/src/main/java/org/jpstale/assets/utils/AnimationBuilder.java`

## 下一步

1. **优先级确认**：确认 PTCN2020 客户端的使用场景和优先级
2. **文件分析**：
   - 使用现有工具分析 M1-motion*.smb 文件结构
   - 确定每个文件的帧数和持续时间
   - 测试骨骼文件是否与motion文件兼容
3. **实施 Phase 1**：
   - 创建 PTMotionLoader 基础结构
   - 实现基本的文件扫描和加载逻辑
4. **关键验证点**：
   - 确认 M1Bip.in 的实际结构
   - 验证 motion 文件序号与动画状态的对应关系
   - 测试动画合并后的完整性

---

*创建日期：2026-03-02*
*更新日期：2026-03-02*
*状态：待实施*