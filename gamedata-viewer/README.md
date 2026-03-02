# JPsTale GameServer 配置查看器

一个用于查看和管理 Priston Tale 游戏服务器配置文件的 Java Swing 应用程序。

## 功能特性

- 📁 **文件浏览** - 查看怪物、NPC、道具和地图配置
- 🔍 **搜索功能** - 快速查找特定的游戏数据
- 📊 **详细信息** - 显示完整的属性和配置信息
- 🗂 **多格式支持** - 支持 .inf、.npc、.txt 等格式
- 🌍 **本地化界面** - 简体中文界面

## 系统要求

- Java 8 或更高版本
- 支持的操作系统：Windows、macOS、Linux

## 快速开始

### 方法 1：使用 Maven 运行

```bash
# 克隆项目并进入目录
cd gamedata-viewer

# 编译并运行
mvn compile exec:java -Dexec.mainClass="org.jpstale.gamedata.ui.Main"
```

### 方法 2：使用启动脚本

```bash
# 打包项目
mvn package -DskipTests

# 运行启动脚本
./run.sh
```

### 方法 3：直接运行 JAR 文件

```bash
# 打包项目
mvn package -DskipTests

# 运行 JAR 文件
java -jar target/gamedata-viewer-1.0.0-SNAPSHOT.jar
```

## 使用说明

1. **加载数据**
   - 启动后会自动加载测试数据
   - 使用 "文件 > 打开GameServer目录..." 加载实际配置文件

2. **浏览数据**
   - 左侧面板显示搜索和过滤选项
   - 中间显示文件树列表
   - 右侧显示选中项的详细信息

3. **导出功能**
   - 工具菜单支持导出为 Groovy 脚本或 JSON 格式（开发中）

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

## 注意事项

- 当前版本使用简化版数据模型
- 完整的文件解析功能正在开发中
- 某些高级功能（如编辑）尚未实现

## 许可证

本项目基于原版 Priston Tale 进行开发，仅用于学习和研究目的。