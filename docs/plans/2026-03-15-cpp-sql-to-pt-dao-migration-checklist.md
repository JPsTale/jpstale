# C++ SQL 迁移至 pt-dao 清单

**日期**: 2026-03-15  
**范围**: PristonTale-EU-main Server (C++) 中通过 `SQLConnection::Prepare("...")` 执行的静态 SQL，迁移到 pt-dao 各 Mapper XML（T-SQL → PostgreSQL）。

## 1. 迁移概况

- **源**: `E:\repo\PristonTale-EU-main\Server\server\` 下所有 `.cpp` 中字面量 `Prepare("...")`。
- **目标**: `server/pt-dao/src/main/resources/org/jpstale/dao/<schema>/mapper/*.xml`，每条 SQL 对应一个 `<select>`/`<insert>`/`<update>`/`<delete>`，`id` 为方法名。
- **转换规则**: GETDATE()→CURRENT_TIMESTAMP，TOP(n)→LIMIT n，[Column]→snake_case，?→#{paramName}，DATEADD→INTERVAL。
- **Schema 对应**: GameDB→gamedb，UserDB→userdb，LogDB→logdb，ServerDB→serverdb，EventDB→eventdb，ItemDB→itemdb，ClanDB→clandb。

## 2. 已迁移 Mapper（按 schema）

### userdb
- **UserInfoMapper** — selectOneByAccountName, selectIsMutedMuteCountByAccountName, selectGameMasterByAccountName, selectFlagByAccountName, updateUnban*, updateUnmute*, updateMuteById, updateBanStatusByAccountName, selectIdByAccountName, selectCoins* / updateCoins*
- **CharacterInfoMapper** — 多条 select/update/delete（按 AccountName/Name/Id）
- **CharacterInfoDeleteMapper** — insertFromCharacterInfoByName
- **CharacterItemTimerMapper** — deleteByCharacterName, updateCharacterNameByCharacterName, select*ByCharacterIdAndType, updateTimeLeft*, delete*, insertCharacterItemTimer
- **CharacterQuestMapper** — selectCompletedByCharacterId, deleteById, deleteByQuestIdAndCharacterId, updateEndDateCounter*, selectQuestId*, selectCount*, insert*, update*, selectTimeLeft*, selectMonsterCountItemCount*, updateCharacterNameByCharacterName
- **CharacterPvpMapper** — selectTop100*, updateTopPvp*, resetAllKillsDeaths, selectId*, selectKillsDeaths*, update*, insertCharacterPvp, updateCharacterNameByCharacterName
- **NotificationDataMapper** — selectMessageByAccountNameUnchecked, updateCheckedByAccountName
- **ItemBoxMapper** — select*ByAccountNameAndDateReceivedNull, updateDateReceivedById, selectCount*, selectItemByIdAndAccountName, insert*

### logdb
- **AccountLogMapper** — insertAccountLog
- **CharacterLogMapper** — insertCharacterLog
- **PostBoxLogMapper** — insertPostBoxLog
- **EventLogMapper** — deleteByEventType, insertEventLog8, insertEventLogFull
- **GoldLogMapper** — insertGoldLog
- **MutePlayerLogMapper** — insertMutePlayerLog
- **ItemCreateLogMapper** — selectItemById, insertItemCreateLog, selectTop1ItemByCode1AndCode2
- **ItemLogMapper** — insertItemLog
- **CheatLogMapper** — insertCheatLog
- **DisconnectsMapper** — insertDisconnects
- **UsersOnlineRecordMapper** — insertUsersOnlineRecord
- **CoinLogMapper** — insertCoinLog
- **BellatraRewardLogMapper** — insertBellatraRewardLog
- **OnlineRewardLogMapper** — insertOnlineRewardLog

### serverdb
- **MaintenanceMapper** — selectCornoByModeAndIp, selectIpByMode3
- **UsersOnlineMapper** — insertUsersOnline, deleteByAccountName, deleteAll
- **PostBoxMapper** — selectById, deleteById
- **CommandMapper** — selectUnprocessed, updateDateProcessedById, selectByParameter3AndUnprocessed, insertCommand
- **GmCommandMapper** — selectActiveCommands, updateInactiveAndResultById
- **MessageLoginMapper** — selectMessage
- **SpawnCameraMapper** — selectAllSpawnCamera
- **FunctionChecksumListMapper** — selectAll
- **WindowCheatListMapper** — selectTop50OrderByIdDesc
- **CrashDataMapper** — insertCrashData
- **BlessCastleSettingsMapper** — updateAll, selectAll
- **BellatraRewardMapper** — selectItemCodeQuantityPercentOrderByPercentDesc
- **OnlineRewardMapper** — selectItemCodeQuantityPercentOrderByRandom

### gamedb
- **MapListMapper** — selectCount, selectAllOrderById
- **ModelListMapper** — selectIdByModel, selectDeathModelIdByModel, selectWidthHeightById, selectModelById, insertModelList, selectTop1IdOrderByIdDesc
- **ModelAnimationListMapper** — selectCountByModelId, selectByModelId, insertModelAnimationList, insertModelAnimationListShort
- **MonsterListMapper** — selectAllMonsterList, selectIdByName
- **MapSpawnPointMapper** — selectCountByStage, selectByStage, selectCountByStageAndXAndZ, selectTop1IdOrderByIdDesc, insertMapSpawnPoint, deleteByXAndZ, selectXZByStage
- **MapMonsterMapper** — selectCountStageByStage, selectByStage
- **MapNpcMapper** — selectCountByStage, selectByStage, deleteByStageAndXAndZ, insertMapNpc, updateXYZByIdnpcAndStage, updateAngleByIdnpcAndStage
- **NpcListMapper** — selectById, selectCountById
- **MapIndicatorMapper** — insertMapIndicator, deleteByMapIdAndPosXAndPosZ, selectAllOrderByMapId
- **DropItemMapper** — selectAllByDropIdGt0
- **QuestListMapper** — selectDurationTypeMaxDurationById, selectMapIdNpcIdAreaTypeById, selectDetailById, selectNameById, selectIdMonsterIdWhereMonsterIdGt0
- **QuestWindowListMapper** — selectNpcIdQuestListId, selectQuestListIdMainImageMainTextByNpcId
- **CoinShopMapper** — selectById, selectActive, updateActive0, updateActive1ById
- **CoinShopTabMapper** — selectByCoinShopId
- **CoinShopItemMapper** — selectByTabIdAndDisabled0
- **AgeListMapper** — selectByAgeNumber
- **RarityChanceModMapper** — selectTypeAndMods
- **RarityChanceGroupMapper** — selectIdMinLevelMaxLevel
- **BaselineModMapper** — selectClassAndPercentBaseline
- **ItemSpecModMapper** — selectAddSpecClassAndPercentReq
- **RarityChanceMapper** — updateChanceByGroupAndRarity, selectRarityChanceGroupRarityChance
- **ItemFixesMapper** — selectAllItemFixes
- **MimicSpawnMapper** — selectMapIdMimicNameSpawnChanceMinDelay

### itemdb
- **ItemDumpMapper** — deleteAll

### clandb
- **ClanListMapper** — selectTop1IconIdById, selectLoginMessageById, selectIdByClanLeader, selectAccountNameByIconId, selectClanNameByIconId, updateClanLeaderByClanLeader, 以及 Bellatra 相关 select/update
- **CtMapper** — selectClanMoneyByClanZang, updateClanMoneyByClanZang, updateCpoint0, updateCpointSodDateByClanName, updateClanMoneyAddByClanName, updateClanZangByClanZang
- **UlMapper** — updateChNameByChName
- **BellatraPersonalScoreMapper** — deleteAll, selectTotalPointByCharacterName, selectIdByCharacterName, updateKillsScoreDateByCharacterName, insertBellatraPersonalScore, updateCharacterNameByCharacterName
- **BellatraTeamScoreMapper** — deleteAll, insertBellatraTeamScore, updateCharacterNameByCharacterName
- **BellatraPersonalScoreNewMapper** — deleteAll, insertBellatraPersonalScoreNew, updateCharacterNameByCharacterName

### eventdb
- **WantedWolfKillsMapper** — deleteAll
- **WantedWolfDropsMapper** — deleteAll
- **WantedMoriphKillsMapper** — deleteAll
- **WantedMoriphDropsMapper** — deleteAll

### chatdb（C++ ChatServer）
- **PublicChatMapper** — insertPublicChat
- **GameMasterCommandMapper** — insertGameMasterCommand
- **ClanChatMapper** — insertClanChat
- **PartyChatMapper** — insertPartyChat
- **TradeChatMapper** — insertTradeChat
- **PrivateChatMapper** — insertPrivateChat

### 其他已补（第 3 章原缺表）
- **itemdb**：GoldDumpMapper — insertGoldDump, deleteAll；ItemDumpMapper — deleteAll（见上）
- **logdb**：EventKillLogMapper — insertEventKillLog；PacketLogMapper — insertPacketLog

## 3. 未迁移 / 动态 SQL（需后续处理）

### 3.1 已补：原缺表与 Mapper（表 + pt-dao 已就绪）

- **GoldDump / ItemDump (itemdb)**：itemdb.gold_dump、itemdb.item_dump 已建；GoldDumpMapper（insertGoldDump、deleteAll）、ItemDumpMapper（deleteAll）已写入 XML。
- **PacketLog (logdb)**：logdb.packet_log 已建；PacketLogMapper.insertPacketLog 已写入 XML。
- **EventKillLog (logdb)**：logdb.event_kill_log 已建；EventKillLogMapper.insertEventKillLog 已写入 XML。
- **Chat 相关表 (chatdb)**：chatdb 已建（public_chat、game_master_command、clan_chat、party_chat、trade_chat、private_chat）；各 Mapper 已提供 insertXxx，对应 C++ ChatServer 的 INSERT。
- **SkillDB**：postgres-init 已提供 01-create-skilldb.sql（skilldb schema + 130+ 技能表）；pt-dao 含 skilldb 各表 Mapper（按需使用），C++ DATABASEID_SkillDB 对应 skilldb。

### 3.2 未迁移：动态 SQL（需后续处理）

- **动态 SQL**（`Prepare(query.c_str())` / `Prepare(szQuery)` 等）未在 XML 中写出，需按调用链归纳为固定 SQL 或单独实现：
  - accountserver.cpp:1424 — `query` 为 CharacterInfo 按 AccountName/Seasonal 的 TOP 6 查询
  - unitinfo.cpp:1785 — BellatraMonster / BellatraMonsterDebugMode 按 Round
  - servercore.cpp:374 — ItemDump INSERT 拼接
  - servercommand.cpp:57 — FormatString 动态表/列；5995,6012,6029 — CharacterInfo/TitleDef/CharacterTitleList 拼接
  - questserver.cpp:1392,3678,3800,3965 — 动态 query；4218 带 true 的 Prepare
  - server.cpp:1033 — 大 query 拼接
  - eventserver.cpp:743,815,855,903,989 — 动态 query
  - characterserver.cpp:537,635,730,1249,1472,1623,1678,2065 — 动态 query
  - bellatraserver.cpp — 多处 query.c_str()
  - RankingListHandler.cpp, HNSSkill.cpp — query.c_str()

## 4. 校验

- 已执行 `mvn -q clean compile` 于 `server/pt-dao`，通过。
- 建议后续：对关键 Mapper 编写单元测试或集成测试，连接 PostgreSQL 执行部分 XML 语句验证结果集与参数绑定。

## 5. 参考

- 设计文档: [2026-03-15-pt-dao-design.md](2026-03-15-pt-dao-design.md)
- 实现计划: [2026-03-15-pt-dao-implementation.md](2026-03-15-pt-dao-implementation.md)
- C++ SQL 入口: `SQLConnection::Prepare(const char*)`，[SQLConnection.h](E:\repo\PristonTale-EU-main\Server\server\SQLConnection.h)
- **ClanSystem ASP SQL**: [2026-03-15-clansystem-asp-sql-migration.md](2026-03-15-clansystem-asp-sql-migration.md) — ClanSystem（ASP）使用的 CT/CL/UL/LI/ClanList 已全部在 pt-dao 中实现。
