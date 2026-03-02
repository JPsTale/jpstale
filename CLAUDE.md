# JPsTale 项目说明

## 项目概述

JPsTale 是一个使用 Java 语言和 jMonkeyEngine 3D 游戏引擎重新开发的 3D MMORPG 游戏"Priston Tale"（精灵）。项目旨在解析和重构原版精灵游戏的各种资源文件，包括模型、地图、装备、怪物、NPC 等，并实现 complete 的游戏服务器和客户端。

## 技术栈

### 核心技术
- **Java 8** - 主要编程语言
- **jMonkeyEngine 3.6.1** - 3D 游戏引擎
- **Maven** - 项目构建工具
- **SQLite** - 数据库（通过 sqlite-jdbc 3.28.0）
- **MyBatis 3.5.2** - ORM 框架
- **HikariCP 3.4.0** - 数据库连接池

### 主要依赖库
- **Lemur 1.16.0** - GUI 框架
- **Groovy 2.4.21** - 脚本语言支持
- **Google Gson 2.8.9** - JSON 处理
- **Recast4j 1.5.6** - 导航网格系统
- **SLF4J + Logback** - 日志框架
- **Lombok 1.18.20** - 代码简化工具

## 项目结构

### 多模块架构
```
JPsTale/
├── loader/          # 资源文件解析器
├── client/          # 客户端应用（FieldBox 刷怪点查看器）
├── core/            # 核心游戏逻辑和实体定义
├── server/          # 游戏服务器
├── tool/            # 游戏工具集
├── sio2-bullet/     # 物理引擎集成
├── navmesh/         # 导航网格系统
├── demos/           # 演示程序
└── assets/          # 游戏资源文件
```

### 各模块功能

#### loader 模块
负责解析原版精灵游戏的各种资源文件格式：
- **ASE 模型加载器** - 解析 .ase 模型文件的网格/骨骼/动画数据
- **Inx 加载器** - 解析 .inx 动画索引、.smd 网格数据、.smb 骨骼动画
- **图像解码器** - 解码加密的 BMP/TGA 图片文件
- **音频文件** - 处理 WAV/BGM 音频格式

#### client 模块
基于 jMonkeyEngine 开发的客户端工具：
- **FieldBox** - 可视化地图和刷怪点编辑器
- 支持 3D 地图显示、刷怪点预览、NPC 管理
- 背景音乐播放和地形渲染

#### core 模块
定义游戏的核心数据结构和实体：
- 游戏角色属性（等级、攻击、防御、元素抗性等）
- 装备系统（属性、随机取值范围）
- 怪物数据和 AI 行为定义
- NPC 对话和功能系统

#### server 模块
游戏服务器逻辑（目前模块较新，主要包含配置文件）：
- 地图配置（scripts/field/*.config 和 *.json）
- 刷怪点管理和怪物 AI
- 网络通信和玩家状态同步

## 资源文件格式

### 地图系统
- **3D 模型** - .ASE 格式，存储在地形文件夹中
- **小地图** - 加密的 .TGA 文件（Field/map/）
- **地图标题** - 加密的 .TGA 文件（Field/title/）
- **配置文件** - JSON 格式，包含传送门、刷怪点、NPC 信息

### 音频系统
- **背景音乐** - .BGM 文件（实际为 WAV 格式）
- **环境音效** - .WAV 文件，支持 3D 定位音源

### 模型与动画
- **装备模型** - .SMD（网格）+ .SMB（骨骼动画）
- **角色动画** - 复杂的多动画集文件
- **材质贴图** - .BMP/.TGA 格式，支持透明通道

## 开发工具集

### 游戏编辑器
- **Aging** - 锻造模拟器，调整成功率
- **Craft** - 合成配方管理器
- **Monsters** - 怪物属性编辑器
- **NPC** - NPC 管理器和商店配置
- **Loots** - 掉落表管理工具
- **FieldBox** - 地图和刷怪点可视化编辑器

## 数据模型

### 核心实体
- **玩家系统** - 等级/经验值、属性点、职业系统
- **战斗系统** - 攻击力/命中率/必杀率/射程/元素抗性
- **移动系统** - 移动速度和恢复能力
- **装备系统** - 装备属性和随机值范围

### 地区生态
- **刷怪系统** - 刷怪点坐标、怪物种类、数量、频率
- **Boss 系统** - Boss 刷新时间和奴隶怪物配置
- **NPC 系统** - 对话脚本、商店物品、特殊功能
- **传送系统** - 地图间传送门和复活点设置

## 构建和运行

### 环境要求
- JDK 8 或更高版本
- Maven 3.6+
- OpenGL 3.3+ 支持的显卡

### 构建命令
```bash
mvn clean compile          # 编译项目
mvn package                # 打包项目
mvn install                # 安装到本地仓库
```

### 运行示例
```bash
# 运行导航网格演示
cd navmesh
mvn exec:java -Dexec.mainClass="net.jmecn.ai.recast.Main"

# 运行客户端工具
cd client
mvn exec:java -Dexec.mainClass="org.jpstale.client.ClientMain"
```

## 项目状态

### 已完成功能
- ✅ 资源文件解析器（模型、贴图、音频）
- ✅ 3D 地图渲染和显示
- ✅ 刷怪点可视化编辑
- ✅ 导航网格系统集成
- ✅ 基础游戏实体定义

### 开发中功能
- 🚧 游戏服务器核心逻辑
- 🚧 网络通信协议
- 🚧 玩家角色系统
- 🚧 战斗和技能系统

### 计划功能
- 📋 完整的客户端游戏界面
- 📋 多人在线支持
- 📋 装备锻造和合成系统
- 📋 公会和社交系统

## 开发注意事项

### 代码规范
- 使用 Lombok 简化样板代码
- 遵循 Google Java Style Guide
- 所有实体类使用 @Data 注解
- 配置文件优先使用 JSON 格式

### 资源管理
- 原版游戏资源文件受版权保护
- 新增资源应使用开源或原创内容
- 支持资源热重载和缓存机制

### 性能优化
- 3D 模型使用 LoD（细节层次）系统
- 大地图采用分块加载
- 音频文件建议转换为 OGG 格式以减小体积

## 贡献指南

1. Fork 项目仓库
2. 创建功能分支（git checkout -b feature/新功能）
3. 提交更改（git commit -am '添加新功能'）
4. 推送到分支（git push origin feature/新功能）
5. 创建 Pull Request

## 许可证

本项目基于原版 Priston Tale 进行重新开发，仅用于学习和研究目的。所有新增代码采用开源许可证，原版游戏资源文件版权归原厂商所有。

## 联系方式

- 项目维护者：yanmaoyuan
- 技术交流：请通过 GitHub Issues 提交问题和建议

---

## MCP 服务器配置

### 浏览器操作（Playwright）
用户需要先安装 Playwright：
```bash
npm install -g @modelcontextprotocol/server-playwright
npx playwright install chromium
```

在 `~/.claude/settings.json` 中配置（需要重启 CLI）：
```json
{
  "mcpServers": {
    "playwright": {
      "command": "npx",
      "args": ["-y", "@modelcontextprotocol/server-playwright"]
    }
  }
}
```