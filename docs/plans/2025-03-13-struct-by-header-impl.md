# 结构体按头文件分包实施计划

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** 将 pt-common 中现有 struct 按 12 个头文件迁入 12 个子包（account/character/chat/item/map/party/quest/skill/sound/unit/user/packets），并产出「待实现结构体」清单。

**Architecture:** 在 `org.jpstale.server.common.struct` 下建 12 个子包；根据每个 Java 类的 Javadoc「对应 xxx.h」决定目标子包，仅改 package 与 import，不改变类实现；对应 packets.h 的类迁入 struct.packets；范围外头文件的类保留在根包。最后扫描 12 个头文件列出未实现的 struct。

**Tech Stack:** Java 11+, Maven, pt-common 模块。

**参考设计:** `docs/plans/2025-03-13-struct-by-header-design.md`

---

## Task 1: 创建 12 个子包目录与 package-info

**Files:**
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/account/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/character/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/chat/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/item/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/map/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/party/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/quest/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/skill/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/sound/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/unit/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/user/package-info.java`
- Create: `server/pt-common/src/main/java/org/jpstale/server/common/struct/packets/package-info.java`

**Step 1:** 若某子包目录已存在（如 account），则只补全缺失子包目录。  
**Step 2:** 为每个子包创建 `package-info.java`，内容示例（以 account 为例）：
```java
/**
 * 对应 C++ shared/account.h 中定义的结构体。
 */
package org.jpstale.server.common.struct.account;
```
其他子包将 `account.h` 替换为 `character.h` / `chat.h` / `item.h` / `map.h` / `party.h` / `quest.h` / `skill.h` / `sound.h` / `unit.h` / `user.h` / `packets.h`。  
**Step 3:** 运行 `mvn compile -pl server/pt-common -q`，确认仍通过（仅新增空 package-info 时不应破坏编译）。  
**Step 4:** 提交：`git add server/pt-common/src/main/java/org/jpstale/server/common/struct/*/package-info.java && git commit -m "chore(struct): add 12 subpackages and package-info"`

---

## Task 2: 确定每个现有 struct 类的目标子包

**Files:**
- Modify: 无；产出为清单，供 Task 3 使用。

**Step 1:** 在 pt-common 中列出所有 `org.jpstale.server.common.struct` 下的 Java 类（含 struct 根包及 struct/account 等已有子包）。  
命令示例：`find server/pt-common/src/main/java/org/jpstale/server/common/struct -name "*.java" -type f`  
**Step 2:** 根据每个文件的 Javadoc「对应 shared/xxx.h」或「对应 packets.h」建立映射表：类名 → 目标子包（account|character|chat|item|map|party|quest|skill|sound|unit|user|packets）。无对应注释或对应其他头文件（如 Coin.h）的类 → 保留在根包，不迁移。  
**Step 3:** 将映射表写成实施清单（可写在计划附录或临时文件），便于 Task 3 按包批量移动。

---

## Task 3: 迁移 account / character / chat / item / map / party / quest 相关类

**Files:**
- Modify: 所有归属到 struct.account、struct.character、struct.chat、struct.item、struct.map、struct.party、struct.quest 的 .java 文件（改 package 声明）。
- Modify: 上述文件中引用到的其他 struct 类，若也迁到子包，则 import 改为新包路径。

**Step 1:** 将「对应 account.h」的类移入 `struct.account`：改 package 为 `org.jpstale.server.common.struct.account`。当前已知在 account 的已有：AccountLoginResult, PacketAccountID, PacketWorldLoginToken, AccountFileData 等；根包下若有注释为 account.h 的也一并迁入。  
**Step 2:** 对 character / chat / item / map / party / quest 同理：按 Task 2 的映射，把对应 shared/character.h、chat.h、item.h、map.h、party.h、quest.h 的类移入对应子包并改 package。  
**Step 3:** 在每个被移动的类内部，将 import 从 `org.jpstale.server.common.struct.XXX` 改为 `org.jpstale.server.common.struct.<子包>.XXX`（仅当 XXX 已迁入子包时）。  
**Step 4:** 运行 `mvn compile -pl server/pt-common -q`，若有缺失 import 或重复类名，修复至通过。  
**Step 5:** 提交：`git add server/pt-common/src/main/java/org/jpstale/server/common/struct/ && git commit -m "refactor(struct): move account/character/chat/item/map/party/quest structs to subpackages"`

---

## Task 4: 迁移 skill / sound / unit / user 相关类

**Files:**
- Modify: 所有归属到 struct.skill、struct.sound、struct.unit、struct.user 的 .java 文件。

**Step 1:** 将「对应 skill.h」的类移入 `struct.skill`，改 package 与 import。  
**Step 2:** 将「对应 sound.h」的类移入 `struct.sound`（若有）。  
**Step 3:** 将「对应 unit.h」的类移入 `struct.unit`。  
**Step 4:** 将「对应 user.h」的类移入 `struct.user`。  
**Step 5:** 运行 `mvn compile -pl server/pt-common -q`，修复至通过。  
**Step 6:** 提交：`git add server/pt-common/src/main/java/org/jpstale/server/common/struct/ && git commit -m "refactor(struct): move skill/sound/unit/user structs to subpackages"`

---

## Task 5: 迁移 packets.h 相关类到 struct.packets

**Files:**
- Modify: 所有 Javadoc 中「对应 packets.h」的 .java 文件（含内嵌如 StageItemData、PlayBuffer、PlayBufferData 等）；从根包或现有位置移至 `struct.packets`。

**Step 1:** 根据 Task 2 的映射，将全部「对应 packets.h」的类移入 `org.jpstale.server.common.struct.packets`，改 package。  
**Step 2:** 更新这些类内部对其它 struct 的 import（若被引用方已迁入子包，改为子包路径）。  
**Step 3:** 运行 `mvn compile -pl server/pt-common -q`，修复至通过。  
**Step 4:** 提交：`git add server/pt-common/src/main/java/org/jpstale/server/common/struct/ && git commit -m "refactor(struct): move packets.h structs to struct.packets"`

---

## Task 6: 全库更新对 struct 的 import

**Files:**
- Modify: 所有引用 `org.jpstale.server.common.struct` 下已迁移类的 Java 文件（pt-common 内及其他模块如 pt-game-server、pt-login-server 等）。

**Step 1:** 使用 grep 查找引用：  
`grep -r "org\.jpstale\.server\.common\.struct\." --include="*.java" server/`  
以及简单类名引用（如 `import org.jpstale.server.common.struct.Item`）。  
**Step 2:** 将旧 import 替换为新子包 import，例如：  
`org.jpstale.server.common.struct.Item` → `org.jpstale.server.common.struct.item.Item`  
`org.jpstale.server.common.struct.PacketLeaveRaid` → `org.jpstale.server.common.struct.packets.PacketLeaveRaid`  
按 Task 2 映射表逐类替换。  
**Step 3:** 运行 `mvn compile -pl server/pt-common` 及依赖 pt-common 的模块（如 `mvn compile -pl server`），确保全部通过。  
**Step 4:** 提交：`git add -A && git commit -m "refactor: update imports for struct subpackages"`

---

## Task 7: 生成「待实现结构体」清单

**Files:**
- Create: `docs/plans/STRUCT_TODO.md`（或写入设计文档附录）

**Step 1:** 扫描 C++ 头文件：对 shared/account.h、character.h、chat.h、item.h、map.h、party.h、quest.h、skill.h、sound.h、unit.h、user.h 和 shared/packets.h（或项目内等价路径）执行 grep/正则，提取所有 `struct Name` 或 `struct Name : Base` 的 Name。  
**Step 2:** 与当前 Java 类列表对比（按设计文档中的归属规则）：已存在于对应子包或根包的视为已实现，其余列入「待实现」。  
**Step 3:** 写出 `STRUCT_TODO.md`，格式示例：
```markdown
# 待实现结构体清单（按头文件）

## account.h
- StructName1
- StructName2

## character.h
...

## packets.h
...
```
**Step 4:** 提交：`git add docs/plans/STRUCT_TODO.md && git commit -m "docs: add STRUCT_TODO list for missing C++ structs"`

---

## Task 8: 最终编译与验收

**Files:** 无新增；仅验证。

**Step 1:** 在仓库根目录执行：`mvn compile -pl server/pt-common`，预期 BUILD SUCCESS。  
**Step 2:** 执行：`mvn compile -pl server`（或完整 server 聚合模块），预期 BUILD SUCCESS。  
**Step 3:** 确认根包 `struct` 下仅剩「范围外」头文件对应的类（如 AgingRecoveryDataHandle）；确认 12 个子包下均有对应头文件的类（sound 可能为空包）。  
**Step 4:** 若全部通过，本计划完成。

---

**Plan complete and saved to `docs/plans/2025-03-13-struct-by-header-impl.md`.**

执行方式可选：

1. **Subagent-Driven（本会话）** — 按任务拆给子 agent，每步完成后你审查，再进入下一步。  
2. **Parallel Session（新会话）** — 在新会话中用 executing-plans 按计划批量执行，并在检查点做验证。

你更倾向哪种？
