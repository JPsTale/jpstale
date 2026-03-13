# 结构体按头文件分包设计

**日期**: 2025-03-13  
**状态**: 已通过，待实施

## 1. 目标

将 `org.jpstale.server.common.struct` 下的结构体按 C++ 头文件拆分为 12 个子包（与枚举策略一致），便于与 C++ 对照；已存在的类迁移到对应子包，不存在的结构体仅列出清单供后续实现。

## 2. 范围与包划分

### 2.1 C++ 来源

以下 12 个头文件中定义的 **struct**（含继承自 Packet 的）均纳入本次分包与清单范围：

| 头文件     | Java 子包        |
|------------|------------------|
| account.h  | struct.account   |
| character.h| struct.character |
| chat.h     | struct.chat      |
| item.h     | struct.item      |
| map.h      | struct.map       |
| party.h    | struct.party     |
| quest.h    | struct.quest     |
| skill.h    | struct.skill     |
| sound.h    | struct.sound     |
| unit.h     | struct.unit      |
| user.h     | struct.user      |
| packets.h  | struct.packets   |

### 2.2 归属规则

- **以定义为准**：某 struct 在哪个头文件中**定义**，就归入对应的 Java 子包。若在 item.h 定义、被 packets.h 引用，仍归 `struct.item`。
- **内嵌 struct**：仅在 packets.h 某 Packet 内嵌定义的结构体（如 `PacketStageItemData::StageItemData`）归入 `struct.packets`，与主 Packet 同包。
- **范围外**：其他头文件（如 warehouse.h, socket.h, roll.h, premiumstruct.h, Coin.h 等）中的 struct 本次不改包；已有 Java 类可暂时保留在根包 `struct`，并在文档或 package-info 中注明来源。

## 3. 迁移策略

- **已有 Java 类**：根据其 Javadoc「对应 xxx.h」或「对应 packets.h」迁移到对应子包；仅修改 `package` 及全库 `import`，不改变类名、字段、序列化逻辑。
- **已存在于子包**：如当前 `struct.account` 下已有 `PacketAccountID`、`PacketWorldLoginToken`、`AccountLoginResult`、`AccountFileData` 等，保留并统一为 `struct.account`；其余根包下对应 account.h 的类一并迁入。
- **根包保留**：对应「范围外」头文件的类（如 `AgingRecoveryDataHandle` 对应 Coin.h）保留在 `org.jpstale.server.common.struct`，不迁入子包。
- **package-info**：每个子包可添加 `package-info.java`，注明对应 C++ 头文件路径，便于日后对照。

## 4. 缺失清单

- 对上述 12 个头文件逐一扫描，列出「该头文件中已定义、且当前 Java 无对应类」的 struct 名称及所在头文件。
- 输出为**待实现结构体清单**（建议放在 `docs/plans/STRUCT_TODO.md` 或设计文档附录），本次不实现，仅记录供后续补充。

## 5. 引用与验收

- **import 更新**：全仓库将旧包路径改为新子包路径（如 `org.jpstale.server.common.struct.Item` → `org.jpstale.server.common.struct.item.Item`），使用 grep 定位所有引用后批量替换。
- **编译**：迁移完成后执行 `mvn compile -pl server/pt-common` 及依赖该模块的构建，确保通过。
- **根包**：迁移后根包 `struct` 下仅保留「范围外」头文件对应的类；若后续需为 packets.h 等补充新类，则直接建在对应子包中。

## 6. 实施顺序建议

1. 建 12 个子包目录及 package-info（可选）。
2. 按头文件逐包迁移：先 account / character / chat / item / map / party / quest / skill / sound / unit / user，再 packets；每包修改 package 并更新该包内交叉引用。
3. 全库 import 替换并编译通过。
4. 扫描 12 个头文件，生成「待实现结构体清单」并写入文档。

---

**下一步**：由 writing-plans 生成具体实施计划（任务拆解、文件列表、验收步骤）。
