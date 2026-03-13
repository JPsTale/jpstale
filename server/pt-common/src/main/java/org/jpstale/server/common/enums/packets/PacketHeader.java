package org.jpstale.server.common.enums.packets;

import java.util.HashMap;
import java.util.Map;

/**
 * 包头发送码，与 PristonTale-EU shared/packets.h 中 enum PacketsHeader 一一对应。
 */
public enum PacketHeader {
    // ===================== Net Server（Login/Game 服间通信） =====================
    /** 网络标识 */
    PKTHDR_NetIdentifier(0x7F000001),
    /** 网络经验 */
    PKTHDR_NetExp(0x7F000002),
    /** 获取经验 */
    PKTHDR_NetGetExp(0x7F000003),
    /** 网络 GM */
    PKTHDR_NetGameMaster(0x7F000004),
    /** 获取 GM */
    PKTHDR_NetGetGameMaster(0x7F000005),
    /** 网络公会 */
    PKTHDR_NetClan(0x7F000006),
    /** 断开用户 */
    PKTHDR_NetDisconnectUser(0x7F000007),
    /** 强制 Orb */
    PKTHDR_NetForceOrb(0x7F000008),
    /** 网络版本 */
    PKTHDR_NetVersion(0x7F000009),
    /** 角色同步 */
    PKTHDR_NetCharacterSync(0x7F00000A),
    /** 发放经验 */
    PKTHDR_NetGiveExp(0x7F00000B),
    /** 网络 Ping/Pong */
    PKTHDR_NetPingPong(0x7F00000C),
    /** Bless Castle 状态请求 */
    PKTHDR_NetBCStatusReq(0x7F00000D),
    /** Bless Castle 状态发送 */
    PKTHDR_NetBCStatusSnd(0x7F00000E),
    /** Bless Castle 新族长 ID */
    PKTHDR_NetBCNewOwnerClanID(0x7F00000F),
    /** 添加 Bot */
    PKTHDR_NetBotAdd(0x7F000010),
    /** 会员经验 */
    PKTHDR_NetPremiumEXP(0x7F000011),
    /** 卸载用户 */
    PKTHDR_NetUnloadUser(0x7F000012),
    /** 经验活动 */
    PKTHDR_NetEXPEvent(0x7F000013),
    /** 交易金币 */
    PKTHDR_NetTradeCoin(0x7F000014),
    /** 在线人数 */
    PKTHDR_NetUsersOnline(0x7F000015),
    /** T5 任务竞技场数据 */
    PKTHDR_NetQuestT5Data(0x7F000016),
    /** 任务更新数据 */
    PKTHDR_NetQuestUpdateData(0x7F000017),
    /** 任务更新数据片段 */
    PKTHDR_NetQuestUpdateDataPart(0x7F000018),
    /** 任务取消或完成 */
    PKTHDR_NetQuestCancelOrFinish(0x7F000019),
    /** 加载 PVP 数据 */
    PKTHDR_NetLoadPVPData(0x7F000020),
    /** 加载任务数据 */
    PKTHDR_NetLoadQuestData(0x7F000021),
    /** 同步已完成任务数据（发往 Game Server） */
    PKTHDR_NetSyncFinishedQuestData(0x7F000022),
    /** 玩家世界令牌 */
    PKTHDR_NetPlayerWorldToken(0x7F000040),
    /** 玩家背包 */
    PKTHDR_NetPlayerInventory(0x7F000041),
    /** 玩家金币 */
    PKTHDR_NetPlayerGold(0x7F000042),
    /** 玩家金币变动 */
    PKTHDR_NetPlayerGoldDiff(0x7F000043),
    /** 玩家丢弃 */
    PKTHDR_NetPlayerThrow(0x7F000044),
    /** 开始维护 */
    PKTHDR_NetStartMaintenance(0x7F000045),
    /** 玩家放入物品 */
    PKTHDR_NetPlayerItemPut(0x7F000046),
    /** 复活节活动 */
    PKTHDR_NetEasterEvent(0x7F000047),
    /** 强化/老化活动 */
    PKTHDR_NetAgingEvent(0x7F000048),
    /** Bellatra 单人排行 */
    PKTHDR_NetBellatraSoloRanking(0x7F000049),
    /** 万圣节活动 */
    PKTHDR_NetHallowenEvent(0x7F000050),
    /** 打开仓库 */
    PKTHDR_NetOpenWarehouse(0x7F000051),
    /** 打开赛季仓库 */
    PKTHDR_NetOpenWarehouseSeasonal(0x7F000052),
    /** 圣诞节活动 */
    PKTHDR_NetChristmasEvent(0x7F000053),
    /** 免费活动少女 */
    PKTHDR_NetFreeEventGirl(0x7F000054),
    /** 停止维护 */
    PKTHDR_NetStopMaintenance(0x7F000056),
    /** 升级 */
    PKTHDR_NetLevelUp(0x7F000058),
    /** 设置版本 */
    PKTHDR_NetSetVersion(0x7F000059),
    /** 重载金币商城 */
    PKTHDR_NetReloadCoinShop(0x7F000060),
    /** 清除 RO 计时 */
    PKTHDR_NetClearTickRO(0x7F000061),
    /** 清除圣诞节计时 */
    PKTHDR_NetClearTickChristmas(0x7F000062),
    /** 踢出全部 */
    PKTHDR_NetKickAll(0x7F000063),
    /** 禁言同步 */
    PKTHDR_NetMuteSync(0x7F000064),
    /** 获取禁言同步 */
    PKTHDR_NetGetMuteSync(0x7F000065),
    /** 星球大战活动 */
    PKTHDR_NetStarWarsEvent(0x7F000066),
    /** 蜜蜂活动 */
    PKTHDR_NetBeeEvent(0x7F000067),
    /** 打开道具发放器 */
    PKTHDR_NetOpenItemDistributor(0x7F000068),
    /** GM 命令 */
    PKTHDR_NetGameMasterCommand(0x7F000069),
    /** 玩法数据扩展（Game Server → Login Server） */
    PKTHDR_NetPlayDataEx(0x7F000070),
    /** 移除已完成任务数据（Game/Login 互发） */
    PKTHDR_NetRemoveFinishedQuestData(0x7F000071),
    /** 发送物品数据（Game Server → Login Server） */
    PKTHDR_NetSendItemData(0x7F000072),
    /** 宝箱怪活动（Game Server → Login Server） */
    PKTHDR_NetMimicEvent(0x7F000073),

    /** 已连接 */
    PKTHDR_Connected(0x48470080),

    // ===================== 道具/背包/交易 =====================
    /** 完美道具数据 */
    PKTHDR_PerfectItemData(0x5A320002),
    /** 合成描述 */
    PKTHDR_MixDescription(0x5A320001),
    /** 打开合成 */
    PKTHDR_OpenMixItem(0x48470049),
    /** 接收仓库 */
    PKTHDR_RecvWarehouse(0x48470048),
    /** 发送仓库 */
    PKTHDR_SendWarehouse(0x48470047),
    /** 交易数据 */
    PKTHDR_TradeData(0x48470041),
    /** 交易请求 */
    PKTHDR_TradeRequest(0x48470042),
    /** 交易物品（交易时把背包物品给玩家） */
    PKTHDR_TradeItems(0x48470043),
    /** 交易就绪 */
    PKTHDR_TradeReady(0x48470044),
    /** 丢弃物品 */
    PKTHDR_ThrowItem(0x48470053),
    /** 检查物品使用槽 */
    PKTHDR_CheckItemUseSlot(0x48478930),
    /** 检查物品使用槽扩展 */
    PKTHDR_CheckItemUseSlotEx(0x48478931),

    /** 技能-治疗 */
    PKTHDR_Skill_Healing(0x484700D2),
    /** 技能-神圣意志 */
    PKTHDR_Skill_HolyMind(0x484700D3),
    /** 技能-大治疗 */
    PKTHDR_Skill_GrandHealing(0x484700D4),

    /** 密钥交换 */
    PKTHDR_KeySet(0x4847FFFF),
    /** 崩溃 */
    PKTHDR_Crash(0x4847FFFE),
    /** 崩溃数据 */
    PKTHDR_CrashData(0x4847FFFD),

    // ===================== 角色/玩法数据 =====================
    /** 包功能 */
    PKTHDR_PacketFun(0x43550001),
    /** 设置经验 */
    PKTHDR_SetExp(0x43550002),
    /** 攻击命中发送 */
    PKTHDR_AttackRatingSend(0x43550003),
    /** 伤害调试信息 */
    PKTHDR_DamageDebugInfo(0x43550004),
    /** 服务器信息 */
    PKTHDR_ServerInfo(0x43550005),
    /** 玩法数据扩展（每 5 秒从各玩家接收） */
    PKTHDR_PlayDataEx(0x43550006),
    /** 会员数据 */
    PKTHDR_PremiumData(0x43550007),
    /** 设置物品计时器 */
    PKTHDR_SetItemTimer(0x43550008),
    /** 禁用 GM */
    PKTHDR_DisableGM(0x43550009),
    /** 任务数据（已废弃） */
    PKTHDR_QuestData(0x4355000A),
    /** 更新任务数据 */
    PKTHDR_UpdateQuestData(0x4355000B),
    /** 完成任务 */
    PKTHDR_FinishQuest(0x4355000C),
    /** 重启任务 */
    PKTHDR_RestartQuest(0x4355000D),
    /** Bellatra 王冠 */
    PKTHDR_BellatraCrown(0x4355000E),
    /** PVP 数据更新 */
    PKTHDR_PVPDataUpdate(0x4355000F),
    /** 更新星球大战阶段 */
    PKTHDR_UpdateSWPhase(0x43550010),
    /** 取消任务 */
    PKTHDR_CancelQuest(0x43550011),
    /** 使用水晶 */
    PKTHDR_CrystalUse(0x43550012),
    /** 水晶使用死亡 */
    PKTHDR_CrystalUseDie(0x43550013),
    /** 用户在线 */
    PKTHDR_UserOnline(0x43550014),
    /** 取消强制 Orb */
    PKTHDR_CancelForceOrb(0x43550015),
    /** 发射陨石 */
    PKTHDR_FireMeteorite(0x43550016),
    /** NPC 复活节彩蛋 */
    PKTHDR_NPCEasterEgg(0x43550017),
    /** PVP 击杀 */
    PKTHDR_PvPKill(0x43550018),
    /** NPC 一欣奖励请求 */
    PKTHDR_NPCIhinRewardRequest(0x43550019),
    /** 角色旧头型使用 */
    PKTHDR_CharacterHeadOldUse(0x4355001A),
    /** Bless Castle 个人分数 */
    PKTHDR_BlessCastleIndividualScore(0x4355001B),
    /** Bless Castle 用户分数更新 */
    PKTHDR_BlessCastleUserScoreUpdate(0x4355001C),
    /** NPC 鲁道夫圣诞节 */
    PKTHDR_NPCRudolphChristmas(0x4355001D),
    /** 取消物品计时器 */
    PKTHDR_CancelItemTimer(0x4355001E),
    /** NPC 合成公会 */
    PKTHDR_NPCMixGuild(0x4355001F),
    /** NPC 排行榜 */
    PKTHDR_NPCRankList(0x43550020),
    /** 顶级等级 */
    PKTHDR_TOP_LEVEL(0x44550022),
    /** 环绕镜头 */
    PKTHDR_WrapCamera(0x44550024),
    /** Bless Castle 顶级公会同步 */
    PKTHDR_BlessCastleTopClanSync(0x44550025),

    /** NPC 全玩家排行榜 */
    PKTHDR_NPCRankListAllPlayers(0x43550030),
    /** NPC PVP 排行榜 */
    PKTHDR_NPCRankListPVP(0x43550031),
    /** NPC 按职业排行榜 */
    PKTHDR_NPCRankListByClass(0x43550032),
    /** NPC 公会 SoD 排行榜 */
    PKTHDR_NPCRankListClanSod(0x43550033),
    /** NPC 个人 SoD 排行榜 */
    PKTHDR_NPCRankListIndividualSod(0x43550034),
    /** NPC Bless Castle 排行榜 */
    PKTHDR_NPCRankListBlessedCastle(0x43550035),
    /** NPC 单人 SoD 排行榜 */
    PKTHDR_NPCRankListSoloSod(0x43550037),

    // ===================== 保护/日志/断线 =====================
    /** 记录作弊 */
    PKTHDR_LogCheat(0x6F6A0001),
    /** 断开账号 */
    PKTHDR_DCAccount(0x6A6A0001),
    /** 重连服务器 */
    PKTHDR_ReconnectedServer(0x6A6A0002),
    /** 发往 Login Server */
    PKTHDR_SendToLoginServer(0x6A6A0003),
    /** 麦克风 */
    PKTHDR_Microphone(0x6A6A0004),
    /** 简单日志数据 */
    PKTHDR_LogDataSimple(0x6A6A0005),
    /** 校验和 */
    PKTHDR_CheckSum(0x6A6A0006),
    /** 调试日志 */
    PKTHDR_LogDebugger(0x6A6A0008),
    /** 未识别包 */
    PKTHDR_UndentifiedPacket(0x6A6A0007),
    /** 增加经验 */
    PKTHDR_AddExp(0x6A6A0009),
    /** 损失经验 */
    PKTHDR_LoseExp(0x6A6A000A),
    /** 获取物品数据 */
    PKTHDR_GetItemData(0x6A6A000B),
    /** 设置物品数据 */
    PKTHDR_SetItemData(0x6A6A000C),
    /** 设置金币 */
    PKTHDR_SetGold(0x6A6A000D),
    /** 窗口列表 */
    PKTHDR_WindowList(0x6A6A000E),
    /** 设置数据 */
    PKTHDR_SettingsData(0x6A6A000F),
    /** 重试仓库 */
    PKTHDR_RetryWarehouse(0x6A6A0010),
    /** 仓库保存成功 */
    PKTHDR_WarehouseSaveSuccess(0x6A6A0011),
    /** 快速伤害 */
    PKTHDR_DamageQuick(0x6A6A0012),
    /** 任务 NPC 打开 */
    PKTHDR_QuestNPCOpen(0x6A6A0013),
    /** 任务 NPC 接受 */
    PKTHDR_QuestNPCAccept(0x6A6A0014),
    /** 任务开始数据 */
    PKTHDR_QuestStartData(0x6A6A0015),
    /** 任务更新数据 */
    PKTHDR_QuestUpdateData(0x6A6A0016),
    /** 任务取消 */
    PKTHDR_QuestCancel(0x6A6A0017),
    /** 任务 NPC 完成 */
    PKTHDR_QuestNPCFinish(0x6A6A0018),
    /** 任务 NPC 物品列表 */
    PKTHDR_QuestNPCItemList(0x6A6A0019),
    /** 任务处理已完成 */
    PKTHDR_QuestHandleFinished(0x6A6A001A),
    /** 角色数据扩展 */
    PKTHDR_CharacterDataEx(0x6A6A001B),
    /** 物品槽操作 */
    PKTHDR_ItemSlotHandle(0x6A6A001C),
    /** T5 任务竞技场 */
    PKTHDR_T5QuestArena(0x6A6A001D),
    /** 请求组队 */
    PKTHDR_RequestParty(0x6A6A001E),
    /** 加入组队 */
    PKTHDR_JoinParty(0x6A6A001F),
    /** 更新组队 */
    PKTHDR_UpdateParty(0x6A6A0020),
    /** 更新组队数据 */
    PKTHDR_UpdatePartyData(0x6A6A0021),
    /** 组队操作 */
    PKTHDR_ActionParty(0x6A6A0022),
    /** 请求副本 */
    PKTHDR_RequestRaid(0x6A6A0023),
    /** 加入副本 */
    PKTHDR_JoinRaid(0x6A6A0024),
    /** 骰子掉落物品 */
    PKTHDR_RollDiceDropItem(0x6A6A0025),
    /** 骰子排行 */
    PKTHDR_RollDiceRanking(0x6A6A0026),
    /** 任务物品交换 */
    PKTHDR_QuestItemSwap(0x6A6A0027),
    /** Boss 时间更新 */
    PKTHDR_BossTimeUpdate(0x6A6A0028),
    /** 耐久度更新物品 */
    PKTHDR_IntegrityUpdateItem(0x6A6A0029),
    /** 更新宠物数据扩展 */
    PKTHDR_UpdatePetDataEx(0x6A6A002A),
    /** 动态任务打开 */
    PKTHDR_DynamicQuestOpen(0x6A6A002B),
    /** 动态任务打开 NPC */
    PKTHDR_DynamicQuestOpenNPC(0x6A6A002C),
    /** 任务处理已完成容器 */
    PKTHDR_QuestHandleFinishedContainer(0x6A6A002D),
    /** 快速伤害 PVP */
    PKTHDR_DamageQuickPVP(0x6A6A002E),
    /** 拾取金币 */
    PKTHDR_GoldPickup(0x6A6A002F),
    /** 角色战斗数据（主要用于 PVP） */
    PKTHDR_CharacterCombatData(0x6A6A0030),
    /** 任务数据请求 */
    PKTHDR_QuestDataRequest(0x6A6A0031),
    /** 任务数据响应 */
    PKTHDR_QuestDataResponse(0x6A6A0032),
    /** 任务名称请求 */
    PKTHDR_QuestNamesRequest(0x6A6A0033),
    /** 任务名称响应 */
    PKTHDR_QuestNamesResponse(0x6A6A0034),
    /** 升级后新增任务名称 */
    PKTHDR_NewQuestNamesPostLvlUp(0x6A6A0035),
    /** Never Sink 传送请求 */
    PKTHDR_NeverSinkTeleportRequest(0x6A6A0036),
    /** Never Sink 打开 UI */
    PKTHDR_NeverSinkOpenUI(0x6A6A0037),
    /** 缺少所需任务物品（完成时客户端不存在） */
    PKTHDR_MissingRequiredQuestItems(0x6A6A0038),
    /** 移除已完成任务 */
    PKTHDR_RemoveFinishedQuest(0x6A6A0039),
    /** 骰子掉落用户结果 */
    PKTHDR_RollDiceDropUserResult(0x6A6A0040),

    // ===================== 金币商城 =====================
    /** 金币商城 NPC */
    PKTHDR_CoinShopNPC(0x48476A01),
    /** 金币商城数量 */
    PKTHDR_CoinShopAmount(0x48476A02),
    /** 金币商城打开标签 */
    PKTHDR_CoinShopOpenTab(0x48476A03),
    /** 金币商城标签 */
    PKTHDR_CoinShopTab(0x48476A04),
    /** 金币商城打开物品数据 */
    PKTHDR_CoinShopOpenItemData(0x48476A05),
    /** 金币商城物品数据 */
    PKTHDR_CoinShopItemData(0x48476A06),
    /** 金币商城购买 */
    PKTHDR_CoinShopBuy(0x48476A07),
    /** 打开金币商城 */
    PKTHDR_OpenCoinShop(0x48476A08),
    /** 金币服务打开 */
    PKTHDR_CoinServiceOpen(0x48476A09),
    /** 金币服务购买 */
    PKTHDR_CoinServiceBuy(0x48476A0A),
    /** 金币服务强化恢复打开 */
    PKTHDR_CoinServiceAgingRecoveryOpen(0x48476A0B),
    /** 金币已交易 */
    PKTHDR_CoinTraded(0x48476A0C),
    /** 金币交易设置 */
    PKTHDR_CoinTradeSet(0x48476A0D),
    /** 玩家信息 2 */
    PKTHDR_PlayerInfo2(0x48470032),

    // ===================== 活动/事件 =====================
    /** SoD 击杀数 */
    PKTHDR_KillsInSod(0x503220B1),
    /** 检查物品 */
    PKTHDR_CHECKITEM(0x50320300),
    /** 伤害上限 */
    PKTHDR_LIMIT_DAMAGE(0x50322050),
    /** Bless Castle 信息 */
    PKTHDR_BLESSCASTLE_INFO(0x503220C0),
    /** Bless Castle 税收 */
    PKTHDR_BLESSCASTLE_TAX(0x503220D0),

    // ===================== 聊天/同步 =====================
    /** 游戏聊天 */
    PKTHDR_ChatGame(0x48471001),
    /** 聊天消息（角色上方气泡） */
    PKTHDR_ChatMessage(0x48471005),
    /** 聊天物品链接 */
    PKTHDR_ChatItemLink(0x48471007),
    /** 个人商店消息 */
    PKTHDR_PersonalShopMessage(0x48478AC0),
    /** 同步数据 1 */
    PKTHDR_SyncData1(0x4847008B),
    /** 同步数据 2 */
    PKTHDR_SyncData2(0x4847008E),
    /** 角色数据（也可用于单位） */
    PKTHDR_CharacterData(0x48470020),
    /** 获取玩家信息数据（也可用于单位） */
    PKTHDR_GetPlayerInfoData(0x48470021),
    /** Ping */
    PKTHDR_Ping(0x435A0007),
    /** Ping Login Server */
    PKTHDR_PingLoginServer(0x435A0008),
    /** 狂暴竞技场 */
    PKTHDR_FuryArena(0x435A0009),
    /** 狂暴竞技场物品数据 */
    PKTHDR_FuryArenaItemData(0x435A000A),
    /** 狂暴竞技场 Boss 数据 */
    PKTHDR_FuryArenaBossData(0x435A000B),
    /** NPC Larry 打开 */
    PKTHDR_NPCLarryOpen(0x435A000C),
    /** 技能状态 */
    PKTHDR_SkillStatus(0x435A000E),
    /** 使用新技能 */
    PKTHDR_UseSkillNew(0x435A000F),
    /** NPC Marina 打开 */
    PKTHDR_NPCMarinaOpen(0x435A0010),
    /** 保存并关闭 */
    PKTHDR_SaveAndClose(0x435A0011),
    /** 凤凰宠物 */
    PKTHDR_PhoenixPet(0x484700B0),
    /** 仓库 */
    PKTHDR_Warehouse(0x48470047),
    /** 保存 */
    PKTHDR_Save(0x484700E8),
    /** 断开连接 */
    PKTHDR_Disconnect(0x484700E6),
    /** 重连 */
    PKTHDR_Reconnect(0x48478010),
    /** 重连登录 */
    PKTHDR_ReconnectLogin(0x48478011),
    /** 更新公会等级 */
    PKTHDR_UpdateLevelClan(0x48470038),
    /** 标题框消息 */
    PKTHDR_TitleBoxMessage(0x48478100),
    /** 玩法角色数据（其他玩家单位） */
    PKTHDR_PlayDataChar(0x48470013),
    /** 单位状态容器（其他玩家单位） */
    PKTHDR_UnitStatusContainer(0x48470014),
    /** 游戏状态 */
    PKTHDR_GameStatus(0x48470018),
    /** 击杀角色 */
    PKTHDR_KillCharacter(0x50320E00),
    /** 角色回血（虚拟药水） */
    PKTHDR_RegenChar(0x50320B00),
    /** 更新宠物数据（仅用于宠物） */
    PKTHDR_UpdatePetData(0x50320A40),
    /** 攻击数据 */
    PKTHDR_AttackData(0x48470030),
    /** 攻击数据 2 */
    PKTHDR_AttackData2(0x48470040),
    /** Bellatra 公会金币 */
    PKTHDR_GoldBellatraClan(0x48478A18),
    /** 打开我的个人商店 */
    PKTHDR_OpenMyPlayerShop(0x48478A90),
    /** 打开玩家商店 */
    PKTHDR_OpenPlayerShop(0x48478AA0),
    /** 玩家商店配置 */
    PKTHDR_PlayerShopConfig(0x48478AB0),
    /** 玩家商店交易 */
    PKTHDR_PlayerShopTrade(0x48478AD0),
    /** 上次攻击伤害 */
    PKTHDR_LastAttackDamage(0x50322030),
    /** 单体技能伤害数据 */
    PKTHDR_SingleTargetSkillData(0x50322000),
    /** 群体技能伤害数据 */
    PKTHDR_MultiTargetSkillData(0x50322010),
    /** 攻击结果（暴击/强化等） */
    PKTHDR_AttackResult(0x50322020),
    /** NPC 商店购买 */
    PKTHDR_BuyItemNPCShop(0x50320210),
    /** NPC 商店出售 */
    PKTHDR_SellItemNPCShop(0x50320212),
    /** NPC 商店修理 */
    PKTHDR_RepairItemNPCShop(0x50320213),
    /** 强制 Orb 数据 */
    PKTHDR_ForceOrbData(0x50320030),
    /** NPC 单位点击 */
    PKTHDR_NpcUnitClick(0x50320031),
    /** 任务命令 */
    PKTHDR_QuestCommand(0x50320220),

    // ===================== 登录/选角 =====================
    /** 服务器列表 */
    PKTHDR_ServerList(0x484700C0),
    /** 存档数据 */
    PKTHDR_SaveData(0x48470081),
    /** 选择角色 */
    PKTHDR_SelectCharacter(0x48470082),
    /** 存档失败 */
    PKTHDR_FailRecordData(0x48470083),
    /** 用户信息 */
    PKTHDR_UserInfo(0x48470086),
    /** 创建角色 */
    PKTHDR_CreateCharacter(0x48470088),
    /** 删除角色 */
    PKTHDR_DeleteCharacter(0x48470087),
    /** 版本 */
    PKTHDR_Version(0x4847008A),
    /** 账号登录结果码 */
    PKTHDR_AccountLoginCode(0x48470023),
    /** 商店物品列表 */
    PKTHDR_Shop_ItemList(0x48470054),
    /** 登录用户（客户端发账号密码等） */
    PKTHDR_LoginUser(0x48480001),

    // ===================== 技能 =====================
    /** 组队增益技能 */
    PKTHDR_BuffSkillsParty(0x50320A00),
    /** 取消剧烈精神 */
    PKTHDR_CancelDrasticSpirit(0x50320A11),
    /** 取消技能 */
    PKTHDR_CancelSkill(0x50320A10),
    /** 技能施放 */
    PKTHDR_SkillCast(0x50320A20),
    /** 技能施放数据 */
    PKTHDR_SkillCastData(0x50320A30),
    /** 闪避成功 */
    PKTHDR_EvasionSuccess(0x50320A50),
    /** 组队使用药水 */
    PKTHDR_PartyUsePot(0x484700D0),
    /** 神圣意志 */
    PKTHDR_HolyMind(0x484700D3),
    /** 精灵 */
    PKTHDR_Wisp(0x484700C3),

    // ===================== 单位/NPC =====================
    /** 打开 NPC */
    PKTHDR_OpenNPC(0x48470024),
    /** NPC 数据 */
    PKTHDR_NpcData(0x48470070),
    /** 设置经验旧版（勿用） */
    PKTHDR_SetExpOld_DontUse(0x48470031),
    /** 传送事件 */
    PKTHDR_TeleportEvent(0x4847005D),
    /** 单位状态移动 */
    PKTHDR_UnitStatusMove(0x48470010),
    /** 玩法数据 */
    PKTHDR_PlayData(0x48470013),
    /** 单位信息快速 */
    PKTHDR_UnitInfoQuick(0x4847004C),
    /** 打开活动少女 */
    PKTHDR_OpenEventGirl(0x4847004F),
    /** 打开强化大师 */
    PKTHDR_OpenAgingMaster(0x4847004D),
    /** 打开星点 */
    PKTHDR_OpenStarPoint(0x48478A10),
    /** 打开收集 */
    PKTHDR_OpenCollect(0x4847004A),
    /** 打开赠送金币 */
    PKTHDR_OpenGiveMoney(0x48478A14),
    /** 打开公会菜单 */
    PKTHDR_OpenClanMenu(0x48478A00),
    /** 公共轮询 */
    PKTHDR_PublicPolling(0x50320A70),

    // ===================== 特效（C++ 中部分为 PTKHDR） =====================
    /** 特效-物品 */
    PTKHDR_Effect_Item(0x48478000),
    /** 特效-武器 */
    PTKHDR_Effect_Weapon(0x48478002),
    /** 特效-眩晕 */
    PTKHDR_Effect_Stun(0x48478004),
    /** 特效-诅咒 */
    PTKHDR_Effect_Curse(0x48478006),
    /** 特效-冰冻 */
    PTKHDR_Effect_Ice(0x48478008),
    /** 特效-毒 */
    PTKHDR_Effect_Poison(0x4847800A),
    /** 特效-隐身 */
    PTKHDR_Effect_Vanish(0x4847800C),
    /** 特效-个人商店 */
    PTKHDR_Effect_PersonalShop(0x4847800E),
    /** 特效-低级宠物 */
    PTKHDR_Effect_LowLevelPet(0x4847800F),
    /** 特效-公会管理 */
    PTKHDR_Effect_ClanManager(0x48479000),
    /** 特效-强制 Orb */
    PTKHDR_Effect_ForceOrb(0x48479010),
    /** 特效-Bless 分数 */
    PTKHDR_Effect_BlessScore(0x48479012),
    /** 特效-用户 */
    PKTHDR_Effect_User(0x48479014),
    /** 特效-减益 */
    PTKHDR_Effect_Debuff(0x48479015),
    /** 特效-持续技能 */
    PTKHDR_Effect_KeepSkill(0x48479020),

    // ===================== 地图/传送/物品 =====================
    /** 传送门地图 */
    PKTHDR_WarpGateField(0x48470040),
    /** 删除标记点 */
    PKTHDR_DeleteFlagPoint(0x48470061),
    /** 死亡 */
    PKTHDR_TheDeath(0x48478800),
    /** 地面物品显示 */
    PKTHDR_PlayItem(0x48470050),
    /** 保存丢弃金币 */
    PKTHDR_SaveThrowMoney(0x48470056),
    /** 保存丢弃物品 2（Game→Login） */
    PKTHDR_SaveThrowItem2(0x48470057),
    /** 使用联合核心 */
    PKTHDR_UseUnionCore(0x50320206),
    /** 翅膀物品 */
    PKTHDR_WingItem(0x50320208),
    /** Bellatra 信息 */
    PKTHDR_BellatraInformation(0x503220B0),
    /** 镶嵌物品数据发往服务器 */
    PKTHDR_SocketItemDataToServer(0x48470025),
    /** 镶嵌物品数据发往客户端 */
    PKTHDR_SocketItemDataToClient(0x48470026),
    /** 从地图删除物品 */
    PKTHDR_DeleteItemFromMap(0x48470051),
    /** 新物品 */
    PKTHDR_NewItem(0x48470052),
    /** 获取物品 */
    PKTHDR_GetItem(0x4847005A),
    /** 支付金币 */
    PKTHDR_PaymentMoney(0x4847005E),
    /** 强化/老化物品升级 */
    PKTHDR_UpgradeAgingItem(0x50320204),
    /** 老化物品（也用于成熟） */
    PKTHDR_AgingItem(0x50320202),
    /** 打开熔炼 */
    PKTHDR_OpenSmelting(0x50325000),
    /** 打开重置物品 */
    PKTHDR_OpenResetItem(0x484700A6),
    /** 打开制造 */
    PKTHDR_OpenManufacture(0x50326000),
    /** 制造物品 */
    PKTHDR_ManufactureItem(0x50326001),
    /** 合成物品 */
    PKTHDR_MixItem(0x50320200),
    /** 重置物品 */
    PKTHDR_ResetItem(0x50326006),
    /** NPC 物品箱 */
    PKTHDR_NPCItemBox(0x48478A80),

    // ===================== 其它 =====================
    /** 存档结果 */
    PKTHDR_RecordResult(0x48470084),
    /** 发送 Game Server */
    PKTHDR_SendGameServer(0x50320110),
    /** 伤害编码内存 */
    PKTHDR_DamageEncodeMem(0x50322F00),
    /** 伤害编码内存 2 */
    PKTHDR_DamageEncodeMem2(0x50322EC0),
    /** 网络质量 */
    PKTHDR_NETWORK_QUALITY(0x484700E0),
    /** 已连接 */
    PKTHDR_CONNECTED(0x48470080),
    /** 更新服务器参数 */
    PKTHDR_UPDATE_SERVER_PARAM(0x503220F0),
    /** 进程信息 */
    PKTHDR_PROCESSINFO(0x484700E4),
    /** 设置黑名单 */
    PKTHDR_SET_BLACKLIST(0x48470033),
    /** 设置黑名单 2 */
    PKTHDR_SET_BLACKLIST2(0x48478400),
    /** 设置黑名单 3 */
    PKTHDR_SET_BLACKLIST3(0x48478500),
    /** 黑客陷阱 */
    PKTHDR_HACKTRAP(0x50320a90),
    /** 使用物品代码 */
    PKTHDR_USEITEM_CODE(0x4847005b),
    /** 制作链接核心 */
    PKTHDR_MAKE_LINKCORE(0x50320205),
    /** 处理时间上限 */
    PKTHDR_PROCESS_TIMEMAX(0x50320500),
    /** 伤害编码内存（同 DamageEncodeMem） */
    PKTHDR_DAMAGE_ENCODE_MEM(0x50322F00),
    /** 发送 Game Server（同 SendGameServer） */
    PKTHDR_SEND_GAMESERVER(0x50320110),

    // ===================== 新增包 =====================
    /** 活动少女重置 */
    PTKHDR_EventGirlReset(0x6FFF0001),
    /** 排行榜请求 */
    PKTHDR_RankingListRequest(0x6FFF0002),
    /** Bellatra 初始玩家人数 */
    PKTHDR_NumfOfInitialBellatraPlayers(0x6FFF0003),
    /** 扩展用户数据 */
    PKTHDR_ExtraUserData(0x6FFF0004),
    /** 单人排行榜请求 */
    PKTHDR_SoloRankingListRequest(0x6FFF0005),
    /** 会员数据同步（计时器同步到客户端） */
    PKTHDR_PremiumDataSync(0x6FFF0006),
    /** 杂项单位命令 */
    PKTHDR_MiscUnitCommand(0x6FFF0007),
    /** 强制 Orb 取消 */
    PKTHDR_ForceOrbCancel(0x6FFF0009),
    /** 地图出生点标记 */
    PKTHDR_MapSpawnMarkers(0x6FFF000A),
    /** 服务器技能数据 */
    PKTHDR_ServerSkillData(0x6FFF000B),
    /** 技能增益状态 */
    PKTHDR_SkillBuffStatus(0x6FFF000D),
    /** 万圣节活动状态 */
    PKTHDR_HalloweenEventStatus(0x6FFF000E),
    /** 称号列表 */
    PKTHDR_TitleList(0x6FFF000F),
    /** 设置称号 */
    PKTHDR_SetTitle(0x6FFF0010),
    /** 恢复物品 */
    PKTHDR_RecoverItem(0x6FFF0011),
    /** 进入 Bellatra 城堡 */
    PKTHDR_EnterBellatraCastle(0x6FFF0012),
    /** 游戏时间同步 */
    PKTHDR_GameTimeSync(0x6FFF0013),
    /** Bellatra 王冠完整 */
    PKTHDR_BellatraCrownFull(0x6FFF0014),
    /** Bellatra 王冠单人 */
    PKTHDR_BellatraCrownSolo(0x6FFF0015),
    /** 服务器技能信息 */
    PKTHDR_ServerSkillInfo(0x6FFF0016),
    /** 伤害信息容器 */
    PKTHDR_DamageInfoContainer(0x6FFF0017),
    /** 新物品 NPC */
    PKTHDR_NewItemNPC(0x6FFF0018),
    /** 服务器技能链数据 */
    PKTHDR_ServerSkillChainData(0x6FFF0019),
    /** 组队增益技能使用新 */
    PKTHDR_UseSkillPartyBuffNew(0x6FFF0020),
    /** 服务器通用技能信息 */
    PKTHDR_ServerCommonSkillInfo(0x6FFF0021),
    /** 快速生命更新 */
    PKTHDR_QuickHealthUpdate(0x6FFF0022),
    /** 从地图清除单位数据 */
    PKTHDR_ClearUnitDataFromMap(0x6FFF0023),
    /** NPC 任务状态 */
    PKTHDR_NpcQuestStatus(0x6FFF0024),
    /** 新物品自动 */
    PKTHDR_NewItemAuto(0x6FFF0025),
    /** 地图指示物 */
    PKTHDR_MapIndicators(0x6FFF0026),
    /** 任务怪物名 */
    PKTHDR_QuestMonsterName(0x6FFF0027),
    /** 任务怪物名请求 */
    PKTHDR_QuestMonsterNameReq(0x6FFF0028),
    /** 升级任务武器 */
    PKTHDR_UpgradeQuestWeapon(0x6FFF0029),
    /** 怪物击杀 */
    PKTHDR_MonsterKill(0x6FFF0030),
    /** 发送马厩宠物 */
    PKTHDR_SendStablePet(0x6FFF0031),
    /** 发送马厩宠物-改名 */
    PKTHDR_SendStablePet_Change_Name(0x6FFF0032),
    /** 发送马厩宠物-当前宠物 */
    PKTHDR_SendStablePet_ActivePet(0x6FFF0033),

    /** 技能警告 */
    PKTHDR_Warning_Skill(0x50322080),
    /** 客户端错误 */
    PKTHDR_Client_Error(0x48478900),
    /** 抗性 */
    PKTHDR_Resistance(0x50320a60),
    /** 发送数据服务器（转移连接到数据服） */
    PKTHDR_SendDataServer(0x50320100),

    // ===================== 未知（保留与 C++ 一致） =====================
    PKTHDR_Unknown1(0x50320040),
    PKTHDR_Unknown2(0x50326070),
    PKTHDR_Unknown3(0x50320120),
    /** 与仓库相关 */
    PKTHDR_Unknown4(0x7f000051),
    PKTHDR_Unknown5(0x48470109),
    /** 与技能大师相关 */
    PKTHDR_Unknown6(0x48470045),
    /** 与物品过期删除相关 */
    PKTHDR_Unknown7(0x50320039),
    PKTHDR_Unknown8(0x50320C00),
    PKTHDR_Unknown9(0x50326030),
    PKTHDR_Unknown10(0x50326002),
    PKTHDR_Unknown11(0x50320800),
    PKTHDR_Unknown12(0x50326040),

    /** GM 命令用户 */
    PKTHDR_CommandUser(0x4847005c),
    /** 雅虎动作（执行动作） */
    PKTHDR_YahooMotion(0x50320E10),

    /** 未知 ID 默认值 */
    UNKNOWN(0);

    private final int value;

    private static final Map<Integer, PacketHeader> BY_VALUE = new HashMap<>();

    static {
        for (PacketHeader id : values()) {
            BY_VALUE.putIfAbsent(id.value, id);
        }
    }

    PacketHeader(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PacketHeader fromValue(int value) {
        return BY_VALUE.getOrDefault(value, UNKNOWN);
    }
}