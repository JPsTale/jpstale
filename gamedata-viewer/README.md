# JPsTale GameServer 配置查看器

一个用于查看和分析 JPsTale 游戏服务器配置文件的桌面工具。支持查看怪物、NPC、道具和地图数据，并提供数据导出和统计分析功能。

## 功能特性

### 1. 数据查看
- 📁 **怪物数据** - 等级、生命值、攻击力、防御力、经验值、元素抗性、掉落物等
- 🏪 **NPC数据** - 名称、等级、是否为商人等
- 💎 **道具数据** - 名称、类别、等级需求、价格、属性等
- 🗺️ **地图数据** - 刷怪点、出生点、NPC分布、怪物密度等

### 2. 数据导出
- 📄 **JSON格式导出** - 将数据导出为结构化的JSON格式

### 3. 数据分析
- 📊 **数据统计** - 怪物等级分布、NPC类型统计、地图分析
- 🔎 **掉落物分析** - 查找掉落特定物品的怪物
- 📈 **掉落物统计** - 统计最常见的掉落物品

### 4. 实用功能
- 📁 **目录选择** - 支持选择并加载本地GameServer目录
- 🔍 **搜索功能** - 快速查找特定的怪物、NPC、道具或地图
- 🌳 **树形展示** - 以树形结构组织展示所有数据
- 📝 **详细信息** - 点击查看每个条目的详细属性
- 🔗 **道具关联** - 怪物掉落、NPC 商店与道具表关联，物品代码以十六进制显示（如 0x05010100）
- 📍 **定位到道具** - 按物品代码在树中定位并查看道具详情
- 🎬 **3D 预览** - 预览怪物、NPC 的 3D 模型与骨骼动画；预览道具的 3D 掉落模型

## 系统要求

- Java 8 或更高版本
- 支持的操作系统：Windows、macOS、Linux

## 运行方式

### 1. 图形界面版本
```bash
# 编译项目
mvn compile

# 运行图形界面
mvn exec:java -Dexec.mainClass="org.jpstale.gamedata.GameDataViewer"
```

### 2. 命令行测试
```bash
# 测试基本数据加载
mvn test-compile exec:java -Dexec.mainClass="org.jpstale.gamedata.TestSingleMonster" -Dexec.classpathScope="test"

# 测试怪物掉落物
mvn test-compile exec:java -Dexec.mainClass="org.jpstale.gamedata.TestMonsterWithDrops" -Dexec.classpathScope="test"

# 测试数据导出
mvn test-compile exec:java -Dexec.mainClass="org.jpstale.gamedata.TestDataExport" -Dexec.classpathScope="test"

# 测试选择性导出
mvn test-compile exec:java -Dexec.mainClass="org.jpstale.gamedata.TestSelectiveExport" -Dexec.classpathScope="test"

# 测试所有功能
mvn test-compile exec:java -Dexec.mainClass="org.jpstale.gamedata.TestAllFeatures" -Dexec.classpathScope="test"
```

## 使用说明

1. **加载数据**
   - 启动后会自动加载测试数据
   - 使用 "文件 > 打开GameServer目录..." 加载实际配置文件
   - 数据加载进度会在日志区域显示

2. **浏览数据**
   - 左侧面板提供搜索和过滤功能
   - 中间树形结构显示所有数据
   - 右侧显示选中项的详细信息

3. **数据导出**
   - "工具 > 导出为JSON" - 导出结构化数据，支持选择导出路径和文件名

4. **3D 预览**
   - 在树中选中怪物、NPC 或道具后，使用 "工具 > 预览3D模型" 在独立窗口中预览 3D 模型（需先打开 GameServer 目录）

5. **数据分析**
   - "工具 > 数据统计" - 查看各类数据统计信息
   - "工具 > 掉落物分析" - 输入物品代码查询相关怪物
   - "工具 > 地图分析" - 查看地图怪物密度和分布

## 项目结构

```
gamedata-viewer/
├── src/main/java/org/jpstale/gamedata/
│   ├── model/          # 数据模型
│   │   ├── SimpleMonsterData.java
│   │   ├── SimpleNPCData.java
│   │   ├── SimpleItemData.java
│   │   └── SimpleMapData.java
│   ├── service/        # 服务层
│   │   ├── SimpleGameDataService.java
│   │   └── SimpleGameServiceImpl.java
│   └── ui/             # 用户界面
│       ├── MainFrame.java
│       ├── SearchPanel.java
│       └── DetailPanel.java
├── target/             # 编译输出
├── run.sh              # 启动脚本
└── pom.xml             # Maven 配置
```

## 开发说明

### 技术栈

- **Java Swing** - GUI 框架
- **jMonkeyEngine** - 3D 游戏引擎（用于资源加载）
- **Maven** - 项目构建工具
- **Lombok** - 代码简化工具

### 扩展开发

1. **添加新的数据类型支持**
   - 在 `model` 包中创建新的数据模型
   - 在 `service` 中实现加载逻辑
   - 在 `ui` 中添加显示支持

2. **自定义加载器**
   - 实现 `GameDataService` 接口
   - 配置文件解析逻辑

3. **添加导出功能**
   - 实现导出为不同格式的转换器

## 工作原理

1. **数据加载** - 使用 AssetFactory 和 DesktopAssetManager 加载原始游戏数据
2. **数据转换** - 通过 DataConverter 将复杂数据模型转换为简化的GUI数据模型
3. **界面展示** - 使用 Java Swing 构建图形用户界面
4. **数据分析** - 实时计算统计数据并展示分析结果

## 技术栈

- **Java 8+** - 编程语言
- **Swing** - GUI框架
- **jMonkeyEngine** - 资源管理器
- **Google Gson** - JSON处理
- **Maven** - 构建工具

## 支持的数据格式

- `.inf` - 怪物配置文件
- `.npc` - NPC配置文件
- `.txt` - 道具配置文件
- `.spm` - 地图刷怪点配置
- `.spp` - 地图出生点配置
- `.spc` - 地图NPC配置

## 示例数据

加载典型 GameServer 目录后的数据量：
- 怪物：~293个
- NPC：~107个（其中36个为商人）
- 道具：~1214个
- 地图：~77个（其中70个有刷怪配置）

## 注意事项

1. 游戏文件路径需要正确配置，确保包含 GameServer 目录
2. 某些特殊道具文件可能包含解析错误，但不影响主要功能
3. 导出的大型数据文件可能需要较长时间处理

## 后续计划

- [ ] 添加数据对比功能
- [ ] 支持自定义数据筛选条件
- [ ] 添加数据批量编辑功能
- [ ] 支持导入修改后的数据配置
- [ ] 添加数据验证和错误检查

## 许可证

本项目基于原版 Priston Tale 进行开发，仅用于学习和研究目的。