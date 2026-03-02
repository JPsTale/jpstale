# 原版 Priston Tale 角色骨骼动画系统分析

## 概述

本文档分析了原版 Priston Tale 的 C++ 源码中角色骨骼动画的处理和使用方式，包括动画状态机、技能动画系统等核心机制。

## 1. 动画文件格式和数据结构

### 文件类型
- **.SMD** - 骨骼动画数据文件
- **.SMB** - 骨骼绑定数据文件
- **.INX** - 动画索引配置文件
- **.ASE** - 3D Studio MAX 导出的场景文件

### 核心数据结构

```cpp
// 动画信息结构
struct smMOTIONINFO {
    DWORD State;              // 动画状态ID
    DWORD StartFrame;         // 起始帧
    DWORD EndFrame;           // 结束帧
    DWORD EventFrame[4];      // 事件触发帧
    int ItemCodeCount;        // 装备要求
    BYTE ItemCodeList[52];    // 支持的装备代码
    BYTE SkillCodeList[8];    // 支持的技能代码
    DWORD Repeat;             // 是否循环
    CHAR KeyCode;             // 触发按键
    int MotionFrame;          // 使用的动画文件编号
    // ...
};

// 模型信息结构
struct smMODELINFO {
    char szModelFile[64];     // 模型文件名
    char szMotionFile[64];    // 动画文件名
    char szSubModelFile[64];  // 副模型文件

    // LOD 模型组
    _MODELGROUP HighModel;     // 高精度模型
    _MODELGROUP DefaultModel; // 默认模型
    _MODELGROUP LowModel;     // 简化模型

    smMOTIONINFO MotionInfo[MOTION_INFO_MAX];  // 动画信息数组
    DWORD MotionCount;        // 动画数量

    // 表情动画支持
    char szTalkLinkFile[64];  // 表情链接文件
    char szTalkMotionFile[64]; // 表情动画文件
    smMOTIONINFO TalkMotionInfo[TALK_MOTION_INFO_MAX];
    DWORD TalkMotionCount;

    // NPC 动画控制
    int NpcMotionRate[NPC_MOTION_INFO_MAX];
    int NpcMotionRateCnt[100];
    // ...
};

// 骨骼对象结构
struct smOBJ3D {
    char NodeName[32];        // 骨骼节点名称
    char NodeParent[32];      // 父骨骼名称
    smOBJ3D *pParent;         // 父骨骼指针

    // 变换矩阵
    smMATRIX Tm;              // 基础变换矩阵
    smMATRIX TmInvert;        // 逆矩阵
    smFMATRIX TmResult;       // 动画结果矩阵

    // 动画数据
    smTM_ROT *TmRot;          // 旋转动画
    smTM_POS *TmPos;          // 位置动画
    smTM_SCALE *TmScale;      // 缩放动画
    int TmRotCnt, TmPosCnt, TmScaleCnt;

    // 骨骼绑定信息
    float qx,qy,qz,qw;        // 绑定姿态四元数
    int sx,sy,sz;             // 绑定缩放
    int px,py,pz;             // 绑定位置
};
```

## 2. 动画状态定义

```cpp
#define CHRMOTION_STATE_STAND        0x40   // 站立
#define CHRMOTION_STATE_WALK         0x50   // 行走
#define CHRMOTION_STATE_RUN          0x60   // 奔跑
#define CHRMOTION_STATE_FALLDOWN     0x80   // 跌倒
#define CHRMOTION_STATE_ATTACK       0x100  // 攻击
#define CHRMOTION_STATE_DAMAGE       0x110  // 受伤
#define CHRMOTION_STATE_DEAD         0x120  // 死亡
#define CHRMOTION_STATE_SOMETIME     0x130  // 特殊动作
#define CHRMOTION_STATE_EAT          0x140  // 使用道具
#define CHRMOTION_STATE_SKILL        0x150  // 技能

#define CHRMOTION_STATE_FALLSTAND    0x170  // 跌倒后站立
#define CHRMOTION_STATE_FALLDAMAGE   0x180  // 跌倒受伤

#define CHRMOTION_STATE_RESTART      0x200  // 复活
#define CHRMOTION_STATE_WARP         0x210  // 传送
#define CHRMOTION_STATE_YAHOO        0x220  // 欢呼

// 表情动画状态
#define CHRMOTION_STATE_TALK_AR      0x400  // - 表情
#define CHRMOTION_STATE_TALK_E       0x410  // E 表情
#define CHRMOTION_STATE_TALK_OH      0x420  // OH 表情
#define CHRMOTION_STATE_TALK_EYE     0x430  // 眼睛表情
#define CHRMOTION_STATE_TALK_SMILE   0x440  // 微笑
#define CHRMOTION_STATE_TALK_GRUMBLE 0x450  // 皱眉
#define CHRMOTION_STATE_TALK_SORROW  0x460  // 悲伤
#define CHRMOTION_STATE_TALK_STARTLED 0x470 // 惊讶
#define CHRMOTION_STATE_TALK_NATURE  0x480  // 自然
#define CHRMOTION_STATE_TALK_SPECIAL 0x490  // 特殊表情
```

## 3. 动画帧率系统

- **基础帧率**：每秒 70 帧（`PLAYCOUNT_PER_SECOND`）
- **动画帧单位**：1 Tick = 160 帧
- **帧计算**：`frame_index = frame_number * 160`
- **更新步长**：
  - 服务器角色：`SERVER_CHAR_FRAME_STEP`
  - 客户端玩家：80 帧/更新
  - 帧计数器：`FrameCounter += 3`

## 4. 动画状态机核心逻辑

### 玩家角色动画更新（case 99）：

```cpp
// 1. 处理网络同步数据
playBuff = &PlayBuff[PlayBuffCnt & PLAYBUFF_MASK];
action = playBuff->angle[3];  // 获取动作状态

// 2. 根据移动距离选择移动动画
distance = abs(pX - playBuff->x) + abs(pZ - playBuff->z);
if (distance > 32) {
    if (distance < 512) {
        SetMotionFromCode(CHRMOTION_STATE_WALK);  // 步行
    } else {
        SetMotionFromCode(CHRMOTION_STATE_RUN);   // 奔跑
    }
}

// 3. 帧更新
frame += playBuff->frame & 0xFFFF;
compFrame = frame / 160;

// 4. 检查动画结束
if (compFrame >= MotionInfo->EndFrame) {
    if (MotionInfo->Repeat) {
        ChangeMotion(action, AnimDispMode);  // 循环播放
    } else {
        frame = MotionInfo->EndFrame * 160; // 停在最后一帧
        SetMotionFromCode(CHRMOTION_STATE_STAND); // 返回站立
    }
}
```

## 5. 技能动画系统

### 技能触发流程：

```cpp
// 1. 技能使用检测
if (playBuff->wStickItems[smPLAYBUFF_ITEM_SKIL] >= 0) {
    BeginSkill(skillCode, level, target, x, y, z);
}

// 2. 技能动画状态切换
if (MotionInfo->State == CHRMOTION_STATE_SKILL) {
    // 触发技能效果
    BeginSkill(0, 0, chrAttackTarget, 0, 0, 0);
}

// 3. 技能代码匹配
if (MotionCode == CHRMOTION_STATE_SKILL && AttackSkil) {
    skillCode = AttackSkil & 0xFF;
    // 遍历技能代码列表
    for (cnt2 = 0; cnt2 < 8; cnt2++) {
        bSkill = smMotionInfo->MotionInfo[cnt].SkillCodeList[cnt2];
        if (bSkill == 0) break;
        if (SkillDataCode[bSkill].dwPlaySkillCode == skillCode) {
            // 找到匹配的技能动画
            FoundNum[FindCnt++] = cnt;
            break;
        }
    }
}

// 4. 事件帧处理
for (int i = 0; i < 4; i++) {
    if (MotionInfo->EventFrame[i]) {
        compFrame = frame - (MotionInfo->StartFrame * 160);
        if (MotionInfo->EventFrame[i] > (compFrame - 80) &&
            MotionInfo->EventFrame[i] <= compFrame) {
            // 触发技能效果
            EventAttack();
        }
    }
}
```

## 6. 动画选择和过滤

### 动画选择逻辑：

```cpp
int SetMotionFromCode(DWORD MotionCode) {
    int StageVillage = 0;  // 地图类型
    DWORD dwJobCodeMask = 0;  // 职业掩码
    int FindCnt = 0;
    int FoundNum[32];

    // 1. 遍历所有动画
    for (cnt = 0; cnt < smMotionInfo->MotionCount; cnt++) {
        // 2. 状态匹配
        if (smMotionInfo->MotionInfo[cnt].State == MotionCode) {

            // 3. 地图位置检查
            if (!smMotionInfo->MotionInfo[cnt].MapPosition ||
                (smMotionInfo->MotionInfo[cnt].MapPosition & StageVillage)) {

                // 4. 职业检查
                if (!smMotionInfo->MotionInfo[cnt].dwJobCodeBit ||
                    (smMotionInfo->MotionInfo[cnt].dwJobCodeBit & dwJobCodeMask)) {

                    // 5. 装备检查
                    if (Item匹配检查()) {
                        // 6. 技能检查（针对技能动画）
                        if (MotionCode == CHRMOTION_STATE_SKILL && AttackSkil) {
                            // 检查技能代码列表
                            if (SkillCode匹配()) {
                                FoundNum[FindCnt++] = cnt;
                            }
                        } else {
                            FoundNum[FindCnt++] = cnt;
                        }
                    }
                }
            }
        }
    }

    // 7. 如果主模型没找到，检查副模型
    if (FindCnt == 0 && AnimDispMode && lpDinaPattern2) {
        // 在 smMotionInfo2 中查找
        // ...
    }

    // 8. 随机选择或使用第一个匹配的动画
    if (FindCnt > 0) {
        ChangeMotion(FoundNum[rand() % FindCnt], AnimDispMode);
    }

    return FindCnt > 0;
}
```

## 7. 多层动画系统

- **主模型**（`DISP_MODE_PATMAIN`）：基础角色模型
- **副模型**（`DISP_MODE_PATSUB`）：武器、翅膀等附加模型
- **表情动画**（`DISP_MODE_PATTALK`）：面部表情动画
- **动画混合**：支持同时播放多个动画层

### 动画显示模式控制：
```cpp
if (AnimDispMode) {
    if (MotionSelectFrame)
        PatDispMode = DISP_MODE_PATSUB;    // 使用副模型
    else
        PatDispMode = DISP_MODE_PATMAIN;   // 使用主模型
}
```

## 8. 动画优化策略

### 1. 距离 LOD（Level of Detail）
```cpp
lpModelGroup = &smMotionInfo->DefaultModel;

if (dDist < VIEW_HIGH_DIST && smMotionInfo->HighModel.ModelNameCnt)
    lpModelGroup = &smMotionInfo->HighModel;    // 高精度

if (dDist > VIEW_MID_DIST && smMotionInfo->LowModel.ModelNameCnt)
    lpModelGroup = &smMotionInfo->LowModel;      // 简化
```

### 2. 帧率自适应
- 根据性能调整帧步长
- 重要动画优先更新
- FrameCounter 控制更新频率

### 3. 缓存机制
- `smDPAT` 缓存已加载的动画
- `UseCount` 管理内存引用
- 自动释放未使用的资源

## 9. NPC 动画系统

### NPC 动画特点：
```cpp
// NPC 特有的动画控制
if (smMotionInfo->NpcMotionRate[CHRMOTION_EXT]) {
    // 根据权重随机选择动画
    TalkCnt = rand() % 100;
    TalkCnt = smMotionInfo->NpcMotionRateCnt[TalkCnt];
    ChangeMotion(smMotionInfo->NpcMotionRateCnt[TalkCnt]);

    // 自动移动逻辑
    if (MotionInfo->State == CHRMOTION_STATE_WALK) {
        MoveAngle(SERVER_CHAR_SKIP);
    }
}
```

## 10. 关键特性总结

1. **状态驱动的动画系统**：基于角色状态自动选择动画
2. **灵活的条件过滤**：支持职业、装备、地图、技能等多维度过滤
3. **事件帧机制**：精确控制音效、特效的触发时机
4. **网络同步优化**：通过 PlayBuff 缓冲区平滑同步
5. **模块化设计**：支持模型、动画、表情的独立加载和组合
6. **性能优化**：LOD 系统、缓存机制、帧率控制
7. **扩展性强**：支持多层动画、表情系统、技能动画

## 11. 与 JPsTale 实现的对比

| 特性 | 原版 Priston Tale | JPsTale (Java/jME3) |
|-----|------------------|-------------------|
| 动画格式 | SMD/SMB/INX | 转换为 jME3 格式 |
| 帧率 | 70 FPS，160 帧/Tick | 可配置，默认 4800 帧/秒 |
| 坐标系 | DirectX | OpenGL |
| 动画控制 | 状态机 + 事件帧 | AnimControl/AnimComposer |
| 网络同步 | PlayBuff 缓冲 | 待实现 |
| LOD 系统 | 三级模型 | 待实现 |
| 技能系统 | 技能代码列表 | 待实现 |

## 12. 迁移建议

1. **保留核心设计**：状态驱动、事件帧机制、多层动画等优秀设计
2. **现代化实现**：利用 jME3 的动画系统简化实现
3. **性能优化**：保留 LOD 概念，使用现代优化技术
4. **网络同步**：设计更高效的状态同步机制
5. **扩展性**：支持更多动画效果和过渡

这个动画系统设计精巧，既考虑了性能优化，又保证了丰富的表现力，是典型的早期网络游戏架构的优秀范例。

---

*文档创建时间：2026-03-02*
*基于原版 Priston Tale C++ 源码分析*