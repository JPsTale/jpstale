# Priston Tale C++ → JPsTale Java 角色属性对照表

## 项目信息

- **C++ 源码位置**: `/Users/yanmaoyuan/htai/Source/J_Server`
- **Java 项目**: `/Users/yanmaoyuan/repo/JPsTale`
- **C++ 源码版本**: Priston Tale 原始代码
- **Java 实现**: JPsTale (jMonkeyEngine 重制版)

## 资源对照关系

| C++ 源码目录 | Java 模块 | 功能描述 | 状态 |
|-------------|----------|---------|------|
| `sinbaram/` | `core/src/main/java/org/jpstale/entity/` | 客户端角色系统 | 进行中 |
| `smLib3d/` | `loader/` | 3D 图形引擎 | 部分完成 |
| `SrcServer/` | `server/` | 服务器端代码 | 基础框架 |
| `DataServer/` | - | 数据服务器 | 未开始 |
| `sinItem.h` | `entity/item/` | 物品系统 | 部分完成 |
| `sinSkill_Info.cpp` | - | 技能数据 | 未开始 |
| `sinShop.cpp` | - | 商店逻辑 | 未开始 |

---

## 角色属性类实现状态

### 已实现

| Java 类 | C++ 对应 | C++ 文件位置 | 说明 |
|---------|---------|-------------|------|
| `Attack.java` | `Attack_Damage[2]` | sinCharStatus.h | 攻击力（最小/最大） |
| `Defense.java` | `Defence` | sinCharStatus.h | 防御力 |
| `Health.java` | `Life/MaxLife` | sinCharStatus.h | 生命值 |
| `Mana.java` | `Mana/MaxMana` | sinCharStatus.h | 法力值 |
| `MoveSpeed.java` | `Attack_Speed/Move_Speed` | sinCharStatus.h | 攻击/移动速度 |
| `Resistance.java` | `FireRegist~PoisonRegist` | sinCharStatus.h | 属性抗性 |
| `Critical.java` | `Critical_Hit` | Damage.cpp | 暴击率/暴击伤害 |
| `AttackRate.java` | `Attack_Rating/Accuracy` | sinSubMain.cpp | 命中率 |
| `Absorb.java` | `Absorption` | sinSubMain.cpp | 伤害吸收 |
| `BlockRate.java` | `Chance_Block` | sinSubMain.cpp | 格挡率 |
| `Stamina.java` | `Stamina/MaxStamina` | sinSubMain.cpp | 耐力系统 |

### 已存在但待完善

| Java 类 | 说明 |
|---------|------|
| `Level.java` | 等级类 |
| `State.java` | 状态类 |
| `Player.java` | 玩家实体 |
| `Monster.java` | 怪物实体 |

### 未实现（待移植）

| C++ 字段/类 | Java 类 | 优先级 |
|------------|--------|--------|
| `Fatigue` | Fatigue.java | 中 |
| `Skill` (技能点) | SkillPoint.java | 中 |
| `Attack_Range` | AttackRange.java | 低 |
| `Gravity` | Gravity.java | 低 |
| `sinShop.cpp` | Shop.java | 高 |
| `sinQuest.cpp` | Quest.java | 高 |
| `sinItem.h` / `sinInvenTory.h` | Item.java | 高 |

---

## 详细实现笔记

### 1. Critical (暴击率)

**C++ 源码**: `Damage.cpp:296-316`

**字段映射**:
```cpp
short Critical[2];  // TransAttackData 中的结构
// Critical[0] = 基础暴击率 (来自装备)
// Critical[1] = 职业属性加成
```

**Java 实现** (`Critical.java`):
```java
int criticalRate;        // 基础暴击率
int criticalDamageBonus; // 暴击伤害加成

// 根据职业获取暴击加成
public static int getCriticalBonusByJob(long jobCode, int strength, int dexterity, int spirit) {
    // 祭司/法师系 -> Spirit (精神)
    // 战士/骑士系 -> Strength (力量)
    // 弓箭手系 -> Dexterity (敏捷)
}
```

**参考技能暴击表** (`sinSkill_Info.cpp`):
```cpp
int B_Swing_Critical[10]   = {3,7,10,13,16,19,21,24,27,30};
int Critical_Hit_Critical[10] = {15,19,23,26,29,32,34,36,38,40};
int Critical_Mastery_Critical[10] = {9,11,12,13,14,15,16,17,18,19};
```

---

### 2. AttackRate (命中率)

**C++ 源码**: `sinSubMain.cpp:1655-1689`

**计算公式**:
```cpp
// 1. 基础命中值
AC_R = (Attack_Rating - desDefense) * 1.4;

// 2. 查表转换为命中率
if (AC_R < -190) RealAC = 50;
if (AC_R > 2100) RealAC = 95;

// 3. 等级差调整
Result = RealAC - ((desLV - myLV)/100) * 28;

// 4. 边界限制
if (Result < 30) Result = 30;
if (Result > 95) Result = 95;
```

**Java 实现** (`AttackRate.java`):
```java
int attackRating;  // 基础命中率
int accuracy;      // 计算后命中率

public int calculateAccuracy(int targetDefense, int targetLevel, int myLevel) {
    int acR = (int) ((this.attackRating - targetDefense) * 1.4f);
    int realAC = lookupAccuracyFromTable(acR);
    float levelDiff = (targetLevel - myLevel) / 100.0f;
    float result = realAC - (levelDiff * 28);
    return clamp(result, 30, 95);
}
```

**怪物命中率** (`sinSubMain.cpp:1692-1710`):
```cpp
// 怪物使用不同倍率
AC_R = (MonsterAttack_Rating - sinChar->Defence) * 2;
```

---

### 3. Absorb (伤害吸收)

**C++ 源码**: `sinSubMain.cpp:1778-1791`

```cpp
#define SIN_MONSTER_UNDEAD 1

int sinGetAbsorb(int Type) {
    switch(Type) {
        case SIN_MONSTER_UNDEAD:
            return sinChar->Absorption + sinUndeadAbsorb;  // 不死系额外加成
        default:
            return sinChar->Absorption;
    }
}
```

**技能吸收表** (`sinSkill_Info.cpp`):
```cpp
int P_Absorb[10][2] = {{3,4},{3,5},{4,6},{4,7},{5,8},{5,9},{6,10},{6,11},{7,12},{7,13}};
```

---

### 4. BlockRate (格挡率)

**C++ 源码**: `sinSubMain.cpp:1765-1774`

```cpp
int sinGetBlockRating(int desLV) {
    fDesLV = (float)desLV;
    fMyLV  = (float)sinChar->Level;
    Result = (int)(sinChar->Chance_Block + ((fMyLV - fDesLV)/100)*25);
    return Result;
}
```

**公式**: 格挡率 = 基础格挡 + ((己方等级 - 目标等级)/100) × 25

---

### 5. Stamina (耐力)

**C++ 源码**: `sinSubMain.cpp:1508-1586`

**耐力消耗** (奔跑时):
```cpp
DeCreaSTM = (1000 + sinChar->Weight[0]) / (sinChar->Weight[1] + sinChar->Strength/2 + 500) + 0.4;
```

**耐力恢复**:
```cpp
// 静止时
InCreaSTM = 3.8 + sinChar->Level/7 + sinChar->Stamina_Regen;

// 行走时 (乘以 0.6)
InCreaSTM = (3.8 + sinChar->Level/7 + sinChar->Stamina_Regen) * 0.6;
```

---

## 职业代码对照

**C++ 定义**: `character.h` / `language.h`

**Java 实现** (`entity/job/JobConstant.java`):
```java
// 战士系
JOB_CODE_MECHANICIAN = 0x00000001  // 机械兵
JOB_CODE_FIGHTER     = 0x00000002  // 武士
JOB_CODE_PIKEMAN     = 0x00000004  // 枪兵
JOB_CODE_KNIGHT      = 0x00010000  // 骑士

// 弓箭手系
JOB_CODE_ARCHER      = 0x00000008  // 弓箭手
JOB_CODE_ATALANTA    = 0x00020000  // 魔枪手

// 法师系
JOB_CODE_PRIESTESS   = 0x00000020  // 祭司
JOB_CODE_MAGICIAN    = 0x00000040  // 魔法师
```

---

## 待办事项

### 高优先级
- [ ] 完善 sinItem.h / sinInvenTory.h 对照
- [ ] 实现 Shop.java (商店系统)
- [ ] 实现 Quest.java (任务系统)

### 中优先级
- [ ] 实现 Skill.java (技能点系统)
- [ ] 实现 Fatigue.java (疲劳系统)
- [ ] 对照 sinSkill_Info.cpp 技能数据

### 低优先级
- [ ] 实现 AttackRange.java (射程)
- [ ] 完善服务器端 SrcServer 对照

---

## 有效 C++ 文件路径参考

```
/Users/yanmaoyuan/htai/Source/J_Server/
├── sinbaram/
│   ├── sinCharStatus.h          # 角色属性定义
│   ├── sinCharStatus.cpp        # 角色属性计算
│   ├── sinSubMain.h             # 函数声明
│   ├── sinSubMain.cpp           # 命中率/格挡率/吸收
│   ├── Damage.cpp               # 伤害计算 (暴击)
│   ├── sinSkill_Info.cpp        # 技能数据表
│   └── sinInvenTory.cpp         # 物品栏/装备
├── character.h                  # smCHAR 结构定义
└── language.h                   # 职业代码定义
```

---

*最后更新: 2025-02-28*