package org.jpstale.server.common.protocol;

/**
 * 包头发送码，与 PristonTale-EU shared/packets.h 中 enum PacketsHeader 一一对应。
 */
public final class PacketIds {
    private PacketIds() {}

    // ===================== Net Server（Login/Game 服间通信） =====================
    /** 网络标识 */
    public static final int PKTHDR_NetIdentifier = 0x7F000001;
    /** 网络经验 */
    public static final int PKTHDR_NetExp = 0x7F000002;
    /** 获取经验 */
    public static final int PKTHDR_NetGetExp = 0x7F000003;
    /** 网络 GM */
    public static final int PKTHDR_NetGameMaster = 0x7F000004;
    /** 获取 GM */
    public static final int PKTHDR_NetGetGameMaster = 0x7F000005;
    /** 网络公会 */
    public static final int PKTHDR_NetClan = 0x7F000006;
    /** 断开用户 */
    public static final int PKTHDR_NetDisconnectUser = 0x7F000007;
    /** 强制 Orb */
    public static final int PKTHDR_NetForceOrb = 0x7F000008;
    /** 网络版本 */
    public static final int PKTHDR_NetVersion = 0x7F000009;
    /** 角色同步 */
    public static final int PKTHDR_NetCharacterSync = 0x7F00000A;
    /** 发放经验 */
    public static final int PKTHDR_NetGiveExp = 0x7F00000B;
    /** 网络 Ping/Pong */
    public static final int PKTHDR_NetPingPong = 0x7F00000C;
    /** Bless Castle 状态请求 */
    public static final int PKTHDR_NetBCStatusReq = 0x7F00000D;
    /** Bless Castle 状态发送 */
    public static final int PKTHDR_NetBCStatusSnd = 0x7F00000E;
    /** Bless Castle 新族长 ID */
    public static final int PKTHDR_NetBCNewOwnerClanID = 0x7F00000F;
    /** 添加 Bot */
    public static final int PKTHDR_NetBotAdd = 0x7F000010;
    /** 会员经验 */
    public static final int PKTHDR_NetPremiumEXP = 0x7F000011;
    /** 卸载用户 */
    public static final int PKTHDR_NetUnloadUser = 0x7F000012;
    /** 经验活动 */
    public static final int PKTHDR_NetEXPEvent = 0x7F000013;
    /** 交易金币 */
    public static final int PKTHDR_NetTradeCoin = 0x7F000014;
    /** 在线人数 */
    public static final int PKTHDR_NetUsersOnline = 0x7F000015;
    /** T5 任务竞技场数据 */
    public static final int PKTHDR_NetQuestT5Data = 0x7F000016;
    /** 任务更新数据 */
    public static final int PKTHDR_NetQuestUpdateData = 0x7F000017;
    /** 任务更新数据片段 */
    public static final int PKTHDR_NetQuestUpdateDataPart = 0x7F000018;
    /** 任务取消或完成 */
    public static final int PKTHDR_NetQuestCancelOrFinish = 0x7F000019;
    /** 加载 PVP 数据 */
    public static final int PKTHDR_NetLoadPVPData = 0x7F000020;
    /** 加载任务数据 */
    public static final int PKTHDR_NetLoadQuestData = 0x7F000021;
    /** 同步已完成任务数据（发往 Game Server） */
    public static final int PKTHDR_NetSyncFinishedQuestData = 0x7F000022;
    /** 玩家世界令牌 */
    public static final int PKTHDR_NetPlayerWorldToken = 0x7F000040;
    /** 玩家背包 */
    public static final int PKTHDR_NetPlayerInventory = 0x7F000041;
    /** 玩家金币 */
    public static final int PKTHDR_NetPlayerGold = 0x7F000042;
    /** 玩家金币变动 */
    public static final int PKTHDR_NetPlayerGoldDiff = 0x7F000043;
    /** 玩家丢弃 */
    public static final int PKTHDR_NetPlayerThrow = 0x7F000044;
    /** 开始维护 */
    public static final int PKTHDR_NetStartMaintenance = 0x7F000045;
    /** 玩家放入物品 */
    public static final int PKTHDR_NetPlayerItemPut = 0x7F000046;
    /** 复活节活动 */
    public static final int PKTHDR_NetEasterEvent = 0x7F000047;
    /** 强化/老化活动 */
    public static final int PKTHDR_NetAgingEvent = 0x7F000048;
    /** Bellatra 单人排行 */
    public static final int PKTHDR_NetBellatraSoloRanking = 0x7F000049;
    /** 万圣节活动 */
    public static final int PKTHDR_NetHallowenEvent = 0x7F000050;
    /** 打开仓库 */
    public static final int PKTHDR_NetOpenWarehouse = 0x7F000051;
    /** 打开赛季仓库 */
    public static final int PKTHDR_NetOpenWarehouseSeasonal = 0x7F000052;
    /** 圣诞节活动 */
    public static final int PKTHDR_NetChristmasEvent = 0x7F000053;
    /** 免费活动少女 */
    public static final int PKTHDR_NetFreeEventGirl = 0x7F000054;
    /** 停止维护 */
    public static final int PKTHDR_NetStopMaintenance = 0x7F000056;
    /** 升级 */
    public static final int PKTHDR_NetLevelUp = 0x7F000058;
    /** 设置版本 */
    public static final int PKTHDR_NetSetVersion = 0x7F000059;
    /** 重载金币商城 */
    public static final int PKTHDR_NetReloadCoinShop = 0x7F000060;
    /** 清除 RO 计时 */
    public static final int PKTHDR_NetClearTickRO = 0x7F000061;
    /** 清除圣诞节计时 */
    public static final int PKTHDR_NetClearTickChristmas = 0x7F000062;
    /** 踢出全部 */
    public static final int PKTHDR_NetKickAll = 0x7F000063;
    /** 禁言同步 */
    public static final int PKTHDR_NetMuteSync = 0x7F000064;
    /** 获取禁言同步 */
    public static final int PKTHDR_NetGetMuteSync = 0x7F000065;
    /** 星球大战活动 */
    public static final int PKTHDR_NetStarWarsEvent = 0x7F000066;
    /** 蜜蜂活动 */
    public static final int PKTHDR_NetBeeEvent = 0x7F000067;
    /** 打开道具发放器 */
    public static final int PKTHDR_NetOpenItemDistributor = 0x7F000068;
    /** GM 命令 */
    public static final int PKTHDR_NetGameMasterCommand = 0x7F000069;
    /** 玩法数据扩展（Game Server → Login Server） */
    public static final int PKTHDR_NetPlayDataEx = 0x7F000070;
    /** 移除已完成任务数据（Game/Login 互发） */
    public static final int PKTHDR_NetRemoveFinishedQuestData = 0x7F000071;
    /** 发送物品数据（Game Server → Login Server） */
    public static final int PKTHDR_NetSendItemData = 0x7F000072;
    /** 宝箱怪活动（Game Server → Login Server） */
    public static final int PKTHDR_NetMimicEvent = 0x7F000073;

    /** 已连接 */
    public static final int PKTHDR_Connected = 0x48470080;

    // ===================== 道具/背包/交易 =====================
    /** 完美道具数据 */
    public static final int PKTHDR_PerfectItemData = 0x5A320002;
    /** 合成描述 */
    public static final int PKTHDR_MixDescription = 0x5A320001;
    /** 打开合成 */
    public static final int PKTHDR_OpenMixItem = 0x48470049;
    /** 接收仓库 */
    public static final int PKTHDR_RecvWarehouse = 0x48470048;
    /** 发送仓库 */
    public static final int PKTHDR_SendWarehouse = 0x48470047;
    /** 交易数据 */
    public static final int PKTHDR_TradeData = 0x48470041;
    /** 交易请求 */
    public static final int PKTHDR_TradeRequest = 0x48470042;
    /** 交易物品（交易时把背包物品给玩家） */
    public static final int PKTHDR_TradeItems = 0x48470043;
    /** 交易就绪 */
    public static final int PKTHDR_TradeReady = 0x48470044;
    /** 丢弃物品 */
    public static final int PKTHDR_ThrowItem = 0x48470053;
    /** 检查物品使用槽 */
    public static final int PKTHDR_CheckItemUseSlot = 0x48478930;
    /** 检查物品使用槽扩展 */
    public static final int PKTHDR_CheckItemUseSlotEx = 0x48478931;

    /** 技能-治疗 */
    public static final int PKTHDR_Skill_Healing = 0x484700D2;
    /** 技能-神圣意志 */
    public static final int PKTHDR_Skill_HolyMind = 0x484700D3;
    /** 技能-大治疗 */
    public static final int PKTHDR_Skill_GrandHealing = 0x484700D4;

    /** 密钥交换 */
    public static final int PKTHDR_KeySet = 0x4847FFFF;
    /** 崩溃 */
    public static final int PKTHDR_Crash = 0x4847FFFE;
    /** 崩溃数据 */
    public static final int PKTHDR_CrashData = 0x4847FFFD;

    // ===================== 角色/玩法数据 =====================
    /** 包功能 */
    public static final int PKTHDR_PacketFun = 0x43550001;
    /** 设置经验 */
    public static final int PKTHDR_SetExp = 0x43550002;
    /** 攻击命中发送 */
    public static final int PKTHDR_AttackRatingSend = 0x43550003;
    /** 伤害调试信息 */
    public static final int PKTHDR_DamageDebugInfo = 0x43550004;
    /** 服务器信息 */
    public static final int PKTHDR_ServerInfo = 0x43550005;
    /** 玩法数据扩展（每 5 秒从各玩家接收） */
    public static final int PKTHDR_PlayDataEx = 0x43550006;
    /** 会员数据 */
    public static final int PKTHDR_PremiumData = 0x43550007;
    /** 设置物品计时器 */
    public static final int PKTHDR_SetItemTimer = 0x43550008;
    /** 禁用 GM */
    public static final int PKTHDR_DisableGM = 0x43550009;
    /** 任务数据（已废弃） */
    public static final int PKTHDR_QuestData = 0x4355000A;
    /** 更新任务数据 */
    public static final int PKTHDR_UpdateQuestData = 0x4355000B;
    /** 完成任务 */
    public static final int PKTHDR_FinishQuest = 0x4355000C;
    /** 重启任务 */
    public static final int PKTHDR_RestartQuest = 0x4355000D;
    /** Bellatra 王冠 */
    public static final int PKTHDR_BellatraCrown = 0x4355000E;
    /** PVP 数据更新 */
    public static final int PKTHDR_PVPDataUpdate = 0x4355000F;
    /** 更新星球大战阶段 */
    public static final int PKTHDR_UpdateSWPhase = 0x43550010;
    /** 取消任务 */
    public static final int PKTHDR_CancelQuest = 0x43550011;
    /** 使用水晶 */
    public static final int PKTHDR_CrystalUse = 0x43550012;
    /** 水晶使用死亡 */
    public static final int PKTHDR_CrystalUseDie = 0x43550013;
    /** 用户在线 */
    public static final int PKTHDR_UserOnline = 0x43550014;
    /** 取消强制 Orb */
    public static final int PKTHDR_CancelForceOrb = 0x43550015;
    /** 发射陨石 */
    public static final int PKTHDR_FireMeteorite = 0x43550016;
    /** NPC 复活节彩蛋 */
    public static final int PKTHDR_NPCEasterEgg = 0x43550017;
    /** PVP 击杀 */
    public static final int PKTHDR_PvPKill = 0x43550018;
    /** NPC 一欣奖励请求 */
    public static final int PKTHDR_NPCIhinRewardRequest = 0x43550019;
    /** 角色旧头型使用 */
    public static final int PKTHDR_CharacterHeadOldUse = 0x4355001A;
    /** Bless Castle 个人分数 */
    public static final int PKTHDR_BlessCastleIndividualScore = 0x4355001B;
    /** Bless Castle 用户分数更新 */
    public static final int PKTHDR_BlessCastleUserScoreUpdate = 0x4355001C;
    /** NPC 鲁道夫圣诞节 */
    public static final int PKTHDR_NPCRudolphChristmas = 0x4355001D;
    /** 取消物品计时器 */
    public static final int PKTHDR_CancelItemTimer = 0x4355001E;
    /** NPC 合成公会 */
    public static final int PKTHDR_NPCMixGuild = 0x4355001F;
    /** NPC 排行榜 */
    public static final int PKTHDR_NPCRankList = 0x43550020;
    /** 顶级等级 */
    public static final int PKTHDR_TOP_LEVEL = 0x44550022;
    /** 环绕镜头 */
    public static final int PKTHDR_WrapCamera = 0x44550024;
    /** Bless Castle 顶级公会同步 */
    public static final int PKTHDR_BlessCastleTopClanSync = 0x44550025;

    /** NPC 全玩家排行榜 */
    public static final int PKTHDR_NPCRankListAllPlayers = 0x43550030;
    /** NPC PVP 排行榜 */
    public static final int PKTHDR_NPCRankListPVP = 0x43550031;
    /** NPC 按职业排行榜 */
    public static final int PKTHDR_NPCRankListByClass = 0x43550032;
    /** NPC 公会 SoD 排行榜 */
    public static final int PKTHDR_NPCRankListClanSod = 0x43550033;
    /** NPC 个人 SoD 排行榜 */
    public static final int PKTHDR_NPCRankListIndividualSod = 0x43550034;
    /** NPC Bless Castle 排行榜 */
    public static final int PKTHDR_NPCRankListBlessedCastle = 0x43550035;
    /** NPC 单人 SoD 排行榜 */
    public static final int PKTHDR_NPCRankListSoloSod = 0x43550037;

    // ===================== 保护/日志/断线 =====================
    /** 记录作弊 */
    public static final int PKTHDR_LogCheat = 0x6F6A0001;
    /** 断开账号 */
    public static final int PKTHDR_DCAccount = 0x6A6A0001;
    /** 重连服务器 */
    public static final int PKTHDR_ReconnectedServer = 0x6A6A0002;
    /** 发往 Login Server */
    public static final int PKTHDR_SendToLoginServer = 0x6A6A0003;
    /** 麦克风 */
    public static final int PKTHDR_Microphone = 0x6A6A0004;
    /** 简单日志数据 */
    public static final int PKTHDR_LogDataSimple = 0x6A6A0005;
    /** 校验和 */
    public static final int PKTHDR_CheckSum = 0x6A6A0006;
    /** 调试日志 */
    public static final int PKTHDR_LogDebugger = 0x6A6A0008;
    /** 未识别包 */
    public static final int PKTHDR_UndentifiedPacket = 0x6A6A0007;
    /** 增加经验 */
    public static final int PKTHDR_AddExp = 0x6A6A0009;
    /** 损失经验 */
    public static final int PKTHDR_LoseExp = 0x6A6A000A;
    /** 获取物品数据 */
    public static final int PKTHDR_GetItemData = 0x6A6A000B;
    /** 设置物品数据 */
    public static final int PKTHDR_SetItemData = 0x6A6A000C;
    /** 设置金币 */
    public static final int PKTHDR_SetGold = 0x6A6A000D;
    /** 窗口列表 */
    public static final int PKTHDR_WindowList = 0x6A6A000E;
    /** 设置数据 */
    public static final int PKTHDR_SettingsData = 0x6A6A000F;
    /** 重试仓库 */
    public static final int PKTHDR_RetryWarehouse = 0x6A6A0010;
    /** 仓库保存成功 */
    public static final int PKTHDR_WarehouseSaveSuccess = 0x6A6A0011;
    /** 快速伤害 */
    public static final int PKTHDR_DamageQuick = 0x6A6A0012;
    /** 任务 NPC 打开 */
    public static final int PKTHDR_QuestNPCOpen = 0x6A6A0013;
    /** 任务 NPC 接受 */
    public static final int PKTHDR_QuestNPCAccept = 0x6A6A0014;
    /** 任务开始数据 */
    public static final int PKTHDR_QuestStartData = 0x6A6A0015;
    /** 任务更新数据 */
    public static final int PKTHDR_QuestUpdateData = 0x6A6A0016;
    /** 任务取消 */
    public static final int PKTHDR_QuestCancel = 0x6A6A0017;
    /** 任务 NPC 完成 */
    public static final int PKTHDR_QuestNPCFinish = 0x6A6A0018;
    /** 任务 NPC 物品列表 */
    public static final int PKTHDR_QuestNPCItemList = 0x6A6A0019;
    /** 任务处理已完成 */
    public static final int PKTHDR_QuestHandleFinished = 0x6A6A001A;
    /** 角色数据扩展 */
    public static final int PKTHDR_CharacterDataEx = 0x6A6A001B;
    /** 物品槽操作 */
    public static final int PKTHDR_ItemSlotHandle = 0x6A6A001C;
    /** T5 任务竞技场 */
    public static final int PKTHDR_T5QuestArena = 0x6A6A001D;
    /** 请求组队 */
    public static final int PKTHDR_RequestParty = 0x6A6A001E;
    /** 加入组队 */
    public static final int PKTHDR_JoinParty = 0x6A6A001F;
    /** 更新组队 */
    public static final int PKTHDR_UpdateParty = 0x6A6A0020;
    /** 更新组队数据 */
    public static final int PKTHDR_UpdatePartyData = 0x6A6A0021;
    /** 组队操作 */
    public static final int PKTHDR_ActionParty = 0x6A6A0022;
    /** 请求副本 */
    public static final int PKTHDR_RequestRaid = 0x6A6A0023;
    /** 加入副本 */
    public static final int PKTHDR_JoinRaid = 0x6A6A0024;
    /** 骰子掉落物品 */
    public static final int PKTHDR_RollDiceDropItem = 0x6A6A0025;
    /** 骰子排行 */
    public static final int PKTHDR_RollDiceRanking = 0x6A6A0026;
    /** 任务物品交换 */
    public static final int PKTHDR_QuestItemSwap = 0x6A6A0027;
    /** Boss 时间更新 */
    public static final int PKTHDR_BossTimeUpdate = 0x6A6A0028;
    /** 耐久度更新物品 */
    public static final int PKTHDR_IntegrityUpdateItem = 0x6A6A0029;
    /** 更新宠物数据扩展 */
    public static final int PKTHDR_UpdatePetDataEx = 0x6A6A002A;
    /** 动态任务打开 */
    public static final int PKTHDR_DynamicQuestOpen = 0x6A6A002B;
    /** 动态任务打开 NPC */
    public static final int PKTHDR_DynamicQuestOpenNPC = 0x6A6A002C;
    /** 任务处理已完成容器 */
    public static final int PKTHDR_QuestHandleFinishedContainer = 0x6A6A002D;
    /** 快速伤害 PVP */
    public static final int PKTHDR_DamageQuickPVP = 0x6A6A002E;
    /** 拾取金币 */
    public static final int PKTHDR_GoldPickup = 0x6A6A002F;
    /** 角色战斗数据（主要用于 PVP） */
    public static final int PKTHDR_CharacterCombatData = 0x6A6A0030;
    /** 任务数据请求 */
    public static final int PKTHDR_QuestDataRequest = 0x6A6A0031;
    /** 任务数据响应 */
    public static final int PKTHDR_QuestDataResponse = 0x6A6A0032;
    /** 任务名称请求 */
    public static final int PKTHDR_QuestNamesRequest = 0x6A6A0033;
    /** 任务名称响应 */
    public static final int PKTHDR_QuestNamesResponse = 0x6A6A0034;
    /** 升级后新增任务名称 */
    public static final int PKTHDR_NewQuestNamesPostLvlUp = 0x6A6A0035;
    /** Never Sink 传送请求 */
    public static final int PKTHDR_NeverSinkTeleportRequest = 0x6A6A0036;
    /** Never Sink 打开 UI */
    public static final int PKTHDR_NeverSinkOpenUI = 0x6A6A0037;
    /** 缺少所需任务物品（完成时客户端不存在） */
    public static final int PKTHDR_MissingRequiredQuestItems = 0x6A6A0038;
    /** 移除已完成任务 */
    public static final int PKTHDR_RemoveFinishedQuest = 0x6A6A0039;
    /** 骰子掉落用户结果 */
    public static final int PKTHDR_RollDiceDropUserResult = 0x6A6A0040;

    // ===================== 金币商城 =====================
    /** 金币商城 NPC */
    public static final int PKTHDR_CoinShopNPC = 0x48476A01;
    /** 金币商城数量 */
    public static final int PKTHDR_CoinShopAmount = 0x48476A02;
    /** 金币商城打开标签 */
    public static final int PKTHDR_CoinShopOpenTab = 0x48476A03;
    /** 金币商城标签 */
    public static final int PKTHDR_CoinShopTab = 0x48476A04;
    /** 金币商城打开物品数据 */
    public static final int PKTHDR_CoinShopOpenItemData = 0x48476A05;
    /** 金币商城物品数据 */
    public static final int PKTHDR_CoinShopItemData = 0x48476A06;
    /** 金币商城购买 */
    public static final int PKTHDR_CoinShopBuy = 0x48476A07;
    /** 打开金币商城 */
    public static final int PKTHDR_OpenCoinShop = 0x48476A08;
    /** 金币服务打开 */
    public static final int PKTHDR_CoinServiceOpen = 0x48476A09;
    /** 金币服务购买 */
    public static final int PKTHDR_CoinServiceBuy = 0x48476A0A;
    /** 金币服务强化恢复打开 */
    public static final int PKTHDR_CoinServiceAgingRecoveryOpen = 0x48476A0B;
    /** 金币已交易 */
    public static final int PKTHDR_CoinTraded = 0x48476A0C;
    /** 金币交易设置 */
    public static final int PKTHDR_CoinTradeSet = 0x48476A0D;
    /** 玩家信息 2 */
    public static final int PKTHDR_PlayerInfo2 = 0x48470032;

    // ===================== 活动/事件 =====================
    /** SoD 击杀数 */
    public static final int PKTHDR_KillsInSod = 0x503220B1;
    /** 检查物品 */
    public static final int PKTHDR_CHECKITEM = 0x50320300;
    /** 伤害上限 */
    public static final int PKTHDR_LIMIT_DAMAGE = 0x50322050;
    /** Bless Castle 信息 */
    public static final int PKTHDR_BLESSCASTLE_INFO = 0x503220C0;
    /** Bless Castle 税收 */
    public static final int PKTHDR_BLESSCASTLE_TAX = 0x503220D0;

    // ===================== 聊天/同步 =====================
    /** 游戏聊天 */
    public static final int PKTHDR_ChatGame = 0x48471001;
    /** 聊天消息（角色上方气泡） */
    public static final int PKTHDR_ChatMessage = 0x48471005;
    /** 聊天物品链接 */
    public static final int PKTHDR_ChatItemLink = 0x48471007;
    /** 个人商店消息 */
    public static final int PKTHDR_PersonalShopMessage = 0x48478AC0;
    /** 同步数据 1 */
    public static final int PKTHDR_SyncData1 = 0x4847008B;
    /** 同步数据 2 */
    public static final int PKTHDR_SyncData2 = 0x4847008E;
    /** 角色数据（也可用于单位） */
    public static final int PKTHDR_CharacterData = 0x48470020;
    /** 获取玩家信息数据（也可用于单位） */
    public static final int PKTHDR_GetPlayerInfoData = 0x48470021;
    /** Ping */
    public static final int PKTHDR_Ping = 0x435A0007;
    /** Ping Login Server */
    public static final int PKTHDR_PingLoginServer = 0x435A0008;
    /** 狂暴竞技场 */
    public static final int PKTHDR_FuryArena = 0x435A0009;
    /** 狂暴竞技场物品数据 */
    public static final int PKTHDR_FuryArenaItemData = 0x435A000A;
    /** 狂暴竞技场 Boss 数据 */
    public static final int PKTHDR_FuryArenaBossData = 0x435A000B;
    /** NPC Larry 打开 */
    public static final int PKTHDR_NPCLarryOpen = 0x435A000C;
    /** 技能状态 */
    public static final int PKTHDR_SkillStatus = 0x435A000E;
    /** 使用新技能 */
    public static final int PKTHDR_UseSkillNew = 0x435A000F;
    /** NPC Marina 打开 */
    public static final int PKTHDR_NPCMarinaOpen = 0x435A0010;
    /** 保存并关闭 */
    public static final int PKTHDR_SaveAndClose = 0x435A0011;
    /** 凤凰宠物 */
    public static final int PKTHDR_PhoenixPet = 0x484700B0;
    /** 仓库 */
    public static final int PKTHDR_Warehouse = 0x48470047;
    /** 保存 */
    public static final int PKTHDR_Save = 0x484700E8;
    /** 断开连接 */
    public static final int PKTHDR_Disconnect = 0x484700E6;
    /** 重连 */
    public static final int PKTHDR_Reconnect = 0x48478010;
    /** 重连登录 */
    public static final int PKTHDR_ReconnectLogin = 0x48478011;
    /** 更新公会等级 */
    public static final int PKTHDR_UpdateLevelClan = 0x48470038;
    /** 标题框消息 */
    public static final int PKTHDR_TitleBoxMessage = 0x48478100;
    /** 玩法角色数据（其他玩家单位） */
    public static final int PKTHDR_PlayDataChar = 0x48470013;
    /** 单位状态容器（其他玩家单位） */
    public static final int PKTHDR_UnitStatusContainer = 0x48470014;
    /** 游戏状态 */
    public static final int PKTHDR_GameStatus = 0x48470018;
    /** 击杀角色 */
    public static final int PKTHDR_KillCharacter = 0x50320E00;
    /** 角色回血（虚拟药水） */
    public static final int PKTHDR_RegenChar = 0x50320B00;
    /** 更新宠物数据（仅用于宠物） */
    public static final int PKTHDR_UpdatePetData = 0x50320A40;
    /** 攻击数据 */
    public static final int PKTHDR_AttackData = 0x48470030;
    /** 攻击数据 2 */
    public static final int PKTHDR_AttackData2 = 0x48470040;
    /** Bellatra 公会金币 */
    public static final int PKTHDR_GoldBellatraClan = 0x48478A18;
    /** 打开我的个人商店 */
    public static final int PKTHDR_OpenMyPlayerShop = 0x48478A90;
    /** 打开玩家商店 */
    public static final int PKTHDR_OpenPlayerShop = 0x48478AA0;
    /** 玩家商店配置 */
    public static final int PKTHDR_PlayerShopConfig = 0x48478AB0;
    /** 玩家商店交易 */
    public static final int PKTHDR_PlayerShopTrade = 0x48478AD0;
    /** 上次攻击伤害 */
    public static final int PKTHDR_LastAttackDamage = 0x50322030;
    /** 单体技能伤害数据 */
    public static final int PKTHDR_SingleTargetSkillData = 0x50322000;
    /** 群体技能伤害数据 */
    public static final int PKTHDR_MultiTargetSkillData = 0x50322010;
    /** 攻击结果（暴击/强化等） */
    public static final int PKTHDR_AttackResult = 0x50322020;
    /** NPC 商店购买 */
    public static final int PKTHDR_BuyItemNPCShop = 0x50320210;
    /** NPC 商店出售 */
    public static final int PKTHDR_SellItemNPCShop = 0x50320212;
    /** NPC 商店修理 */
    public static final int PKTHDR_RepairItemNPCShop = 0x50320213;
    /** 强制 Orb 数据 */
    public static final int PKTHDR_ForceOrbData = 0x50320030;
    /** NPC 单位点击 */
    public static final int PKTHDR_NpcUnitClick = 0x50320031;
    /** 任务命令 */
    public static final int PKTHDR_QuestCommand = 0x50320220;

    // ===================== 登录/选角 =====================
    /** 服务器列表 */
    public static final int PKTHDR_ServerList = 0x484700C0;
    /** 存档数据 */
    public static final int PKTHDR_SaveData = 0x48470081;
    /** 选择角色 */
    public static final int PKTHDR_SelectCharacter = 0x48470082;
    /** 存档失败 */
    public static final int PKTHDR_FailRecordData = 0x48470083;
    /** 用户信息 */
    public static final int PKTHDR_UserInfo = 0x48470086;
    /** 创建角色 */
    public static final int PKTHDR_CreateCharacter = 0x48470088;
    /** 删除角色 */
    public static final int PKTHDR_DeleteCharacter = 0x48470087;
    /** 版本 */
    public static final int PKTHDR_Version = 0x4847008A;
    /** 账号登录结果码 */
    public static final int PKTHDR_AccountLoginCode = 0x48470023;
    /** 商店物品列表 */
    public static final int PKTHDR_Shop_ItemList = 0x48470054;
    /** 登录用户（客户端发账号密码等） */
    public static final int PKTHDR_LoginUser = 0x48480001;

    // ===================== 技能 =====================
    /** 组队增益技能 */
    public static final int PKTHDR_BuffSkillsParty = 0x50320A00;
    /** 取消剧烈精神 */
    public static final int PKTHDR_CancelDrasticSpirit = 0x50320A11;
    /** 取消技能 */
    public static final int PKTHDR_CancelSkill = 0x50320A10;
    /** 技能施放 */
    public static final int PKTHDR_SkillCast = 0x50320A20;
    /** 技能施放数据 */
    public static final int PKTHDR_SkillCastData = 0x50320A30;
    /** 闪避成功 */
    public static final int PKTHDR_EvasionSuccess = 0x50320A50;
    /** 组队使用药水 */
    public static final int PKTHDR_PartyUsePot = 0x484700D0;
    /** 神圣意志 */
    public static final int PKTHDR_HolyMind = 0x484700D3;
    /** 精灵 */
    public static final int PKTHDR_Wisp = 0x484700C3;

    // ===================== 单位/NPC =====================
    /** 打开 NPC */
    public static final int PKTHDR_OpenNPC = 0x48470024;
    /** NPC 数据 */
    public static final int PKTHDR_NpcData = 0x48470070;
    /** 设置经验旧版（勿用） */
    public static final int PKTHDR_SetExpOld_DontUse = 0x48470031;
    /** 传送事件 */
    public static final int PKTHDR_TeleportEvent = 0x4847005D;
    /** 单位状态移动 */
    public static final int PKTHDR_UnitStatusMove = 0x48470010;
    /** 玩法数据 */
    public static final int PKTHDR_PlayData = 0x48470013;
    /** 单位信息快速 */
    public static final int PKTHDR_UnitInfoQuick = 0x4847004C;
    /** 打开活动少女 */
    public static final int PKTHDR_OpenEventGirl = 0x4847004F;
    /** 打开强化大师 */
    public static final int PKTHDR_OpenAgingMaster = 0x4847004D;
    /** 打开星点 */
    public static final int PKTHDR_OpenStarPoint = 0x48478A10;
    /** 打开收集 */
    public static final int PKTHDR_OpenCollect = 0x4847004A;
    /** 打开赠送金币 */
    public static final int PKTHDR_OpenGiveMoney = 0x48478A14;
    /** 打开公会菜单 */
    public static final int PKTHDR_OpenClanMenu = 0x48478A00;
    /** 公共轮询 */
    public static final int PKTHDR_PublicPolling = 0x50320A70;

    // ===================== 特效（C++ 中部分为 PTKHDR） =====================
    /** 特效-物品 */
    public static final int PTKHDR_Effect_Item = 0x48478000;
    /** 特效-武器 */
    public static final int PTKHDR_Effect_Weapon = 0x48478002;
    /** 特效-眩晕 */
    public static final int PTKHDR_Effect_Stun = 0x48478004;
    /** 特效-诅咒 */
    public static final int PTKHDR_Effect_Curse = 0x48478006;
    /** 特效-冰冻 */
    public static final int PTKHDR_Effect_Ice = 0x48478008;
    /** 特效-毒 */
    public static final int PTKHDR_Effect_Poison = 0x4847800A;
    /** 特效-隐身 */
    public static final int PTKHDR_Effect_Vanish = 0x4847800C;
    /** 特效-个人商店 */
    public static final int PTKHDR_Effect_PersonalShop = 0x4847800E;
    /** 特效-低级宠物 */
    public static final int PTKHDR_Effect_LowLevelPet = 0x4847800F;
    /** 特效-公会管理 */
    public static final int PTKHDR_Effect_ClanManager = 0x48479000;
    /** 特效-强制 Orb */
    public static final int PTKHDR_Effect_ForceOrb = 0x48479010;
    /** 特效-Bless 分数 */
    public static final int PTKHDR_Effect_BlessScore = 0x48479012;
    /** 特效-用户 */
    public static final int PKTHDR_Effect_User = 0x48479014;
    /** 特效-减益 */
    public static final int PTKHDR_Effect_Debuff = 0x48479015;
    /** 特效-持续技能 */
    public static final int PTKHDR_Effect_KeepSkill = 0x48479020;

    // ===================== 地图/传送/物品 =====================
    /** 传送门地图 */
    public static final int PKTHDR_WarpGateField = 0x48470040;
    /** 删除标记点 */
    public static final int PKTHDR_DeleteFlagPoint = 0x48470061;
    /** 死亡 */
    public static final int PKTHDR_TheDeath = 0x48478800;
    /** 地面物品显示 */
    public static final int PKTHDR_PlayItem = 0x48470050;
    /** 保存丢弃金币 */
    public static final int PKTHDR_SaveThrowMoney = 0x48470056;
    /** 保存丢弃物品 2（Game→Login） */
    public static final int PKTHDR_SaveThrowItem2 = 0x48470057;
    /** 使用联合核心 */
    public static final int PKTHDR_UseUnionCore = 0x50320206;
    /** 翅膀物品 */
    public static final int PKTHDR_WingItem = 0x50320208;
    /** Bellatra 信息 */
    public static final int PKTHDR_BellatraInformation = 0x503220B0;
    /** 镶嵌物品数据发往服务器 */
    public static final int PKTHDR_SocketItemDataToServer = 0x48470025;
    /** 镶嵌物品数据发往客户端 */
    public static final int PKTHDR_SocketItemDataToClient = 0x48470026;
    /** 从地图删除物品 */
    public static final int PKTHDR_DeleteItemFromMap = 0x48470051;
    /** 新物品 */
    public static final int PKTHDR_NewItem = 0x48470052;
    /** 获取物品 */
    public static final int PKTHDR_GetItem = 0x4847005A;
    /** 支付金币 */
    public static final int PKTHDR_PaymentMoney = 0x4847005E;
    /** 强化/老化物品升级 */
    public static final int PKTHDR_UpgradeAgingItem = 0x50320204;
    /** 老化物品（也用于成熟） */
    public static final int PKTHDR_AgingItem = 0x50320202;
    /** 打开熔炼 */
    public static final int PKTHDR_OpenSmelting = 0x50325000;
    /** 打开重置物品 */
    public static final int PKTHDR_OpenResetItem = 0x484700A6;
    /** 打开制造 */
    public static final int PKTHDR_OpenManufacture = 0x50326000;
    /** 制造物品 */
    public static final int PKTHDR_ManufactureItem = 0x50326001;
    /** 合成物品 */
    public static final int PKTHDR_MixItem = 0x50320200;
    /** 重置物品 */
    public static final int PKTHDR_ResetItem = 0x50326006;
    /** NPC 物品箱 */
    public static final int PKTHDR_NPCItemBox = 0x48478A80;

    // ===================== 其它 =====================
    /** 存档结果 */
    public static final int PKTHDR_RecordResult = 0x48470084;
    /** 发送 Game Server */
    public static final int PKTHDR_SendGameServer = 0x50320110;
    /** 伤害编码内存 */
    public static final int PKTHDR_DamageEncodeMem = 0x50322F00;
    /** 伤害编码内存 2 */
    public static final int PKTHDR_DamageEncodeMem2 = 0x50322EC0;
    /** 网络质量 */
    public static final int PKTHDR_NETWORK_QUALITY = 0x484700E0;
    /** 已连接 */
    public static final int PKTHDR_CONNECTED = 0x48470080;
    /** 更新服务器参数 */
    public static final int PKTHDR_UPDATE_SERVER_PARAM = 0x503220F0;
    /** 进程信息 */
    public static final int PKTHDR_PROCESSINFO = 0x484700E4;
    /** 设置黑名单 */
    public static final int PKTHDR_SET_BLACKLIST = 0x48470033;
    /** 设置黑名单 2 */
    public static final int PKTHDR_SET_BLACKLIST2 = 0x48478400;
    /** 设置黑名单 3 */
    public static final int PKTHDR_SET_BLACKLIST3 = 0x48478500;
    /** 黑客陷阱 */
    public static final int PKTHDR_HACKTRAP = 0x50320a90;
    /** 使用物品代码 */
    public static final int PKTHDR_USEITEM_CODE = 0x4847005b;
    /** 制作链接核心 */
    public static final int PKTHDR_MAKE_LINKCORE = 0x50320205;
    /** 处理时间上限 */
    public static final int PKTHDR_PROCESS_TIMEMAX = 0x50320500;
    /** 伤害编码内存（同 DamageEncodeMem） */
    public static final int PKTHDR_DAMAGE_ENCODE_MEM = 0x50322F00;
    /** 发送 Game Server（同 SendGameServer） */
    public static final int PKTHDR_SEND_GAMESERVER = 0x50320110;

    // ===================== 新增包 =====================
    /** 活动少女重置 */
    public static final int PTKHDR_EventGirlReset = 0x6FFF0001;
    /** 排行榜请求 */
    public static final int PKTHDR_RankingListRequest = 0x6FFF0002;
    /** Bellatra 初始玩家人数 */
    public static final int PKTHDR_NumfOfInitialBellatraPlayers = 0x6FFF0003;
    /** 扩展用户数据 */
    public static final int PKTHDR_ExtraUserData = 0x6FFF0004;
    /** 单人排行榜请求 */
    public static final int PKTHDR_SoloRankingListRequest = 0x6FFF0005;
    /** 会员数据同步（计时器同步到客户端） */
    public static final int PKTHDR_PremiumDataSync = 0x6FFF0006;
    /** 杂项单位命令 */
    public static final int PKTHDR_MiscUnitCommand = 0x6FFF0007;
    /** 强制 Orb 取消 */
    public static final int PKTHDR_ForceOrbCancel = 0x6FFF0009;
    /** 地图出生点标记 */
    public static final int PKTHDR_MapSpawnMarkers = 0x6FFF000A;
    /** 服务器技能数据 */
    public static final int PKTHDR_ServerSkillData = 0x6FFF000B;
    /** 技能增益状态 */
    public static final int PKTHDR_SkillBuffStatus = 0x6FFF000D;
    /** 万圣节活动状态 */
    public static final int PKTHDR_HalloweenEventStatus = 0x6FFF000E;
    /** 称号列表 */
    public static final int PKTHDR_TitleList = 0x6FFF000F;
    /** 设置称号 */
    public static final int PKTHDR_SetTitle = 0x6FFF0010;
    /** 恢复物品 */
    public static final int PKTHDR_RecoverItem = 0x6FFF0011;
    /** 进入 Bellatra 城堡 */
    public static final int PKTHDR_EnterBellatraCastle = 0x6FFF0012;
    /** 游戏时间同步 */
    public static final int PKTHDR_GameTimeSync = 0x6FFF0013;
    /** Bellatra 王冠完整 */
    public static final int PKTHDR_BellatraCrownFull = 0x6FFF0014;
    /** Bellatra 王冠单人 */
    public static final int PKTHDR_BellatraCrownSolo = 0x6FFF0015;
    /** 服务器技能信息 */
    public static final int PKTHDR_ServerSkillInfo = 0x6FFF0016;
    /** 伤害信息容器 */
    public static final int PKTHDR_DamageInfoContainer = 0x6FFF0017;
    /** 新物品 NPC */
    public static final int PKTHDR_NewItemNPC = 0x6FFF0018;
    /** 服务器技能链数据 */
    public static final int PKTHDR_ServerSkillChainData = 0x6FFF0019;
    /** 组队增益技能使用新 */
    public static final int PKTHDR_UseSkillPartyBuffNew = 0x6FFF0020;
    /** 服务器通用技能信息 */
    public static final int PKTHDR_ServerCommonSkillInfo = 0x6FFF0021;
    /** 快速生命更新 */
    public static final int PKTHDR_QuickHealthUpdate = 0x6FFF0022;
    /** 从地图清除单位数据 */
    public static final int PKTHDR_ClearUnitDataFromMap = 0x6FFF0023;
    /** NPC 任务状态 */
    public static final int PKTHDR_NpcQuestStatus = 0x6FFF0024;
    /** 新物品自动 */
    public static final int PKTHDR_NewItemAuto = 0x6FFF0025;
    /** 地图指示物 */
    public static final int PKTHDR_MapIndicators = 0x6FFF0026;
    /** 任务怪物名 */
    public static final int PKTHDR_QuestMonsterName = 0x6FFF0027;
    /** 任务怪物名请求 */
    public static final int PKTHDR_QuestMonsterNameReq = 0x6FFF0028;
    /** 升级任务武器 */
    public static final int PKTHDR_UpgradeQuestWeapon = 0x6FFF0029;
    /** 怪物击杀 */
    public static final int PKTHDR_MonsterKill = 0x6FFF0030;
    /** 发送马厩宠物 */
    public static final int PKTHDR_SendStablePet = 0x6FFF0031;
    /** 发送马厩宠物-改名 */
    public static final int PKTHDR_SendStablePet_Change_Name = 0x6FFF0032;
    /** 发送马厩宠物-当前宠物 */
    public static final int PKTHDR_SendStablePet_ActivePet = 0x6FFF0033;

    /** 技能警告 */
    public static final int PKTHDR_Warning_Skill = 0x50322080;
    /** 客户端错误 */
    public static final int PKTHDR_Client_Error = 0x48478900;
    /** 抗性 */
    public static final int PKTHDR_Resistance = 0x50320a60;
    /** 发送数据服务器（转移连接到数据服） */
    public static final int PKTHDR_SendDataServer = 0x50320100;

    // ===================== 未知（保留与 C++ 一致） =====================
    public static final int PKTHDR_Unknown1 = 0x50320040;
    public static final int PKTHDR_Unknown2 = 0x50326070;
    public static final int PKTHDR_Unknown3 = 0x50320120;
    /** 与仓库相关 */
    public static final int PKTHDR_Unknown4 = 0x7f000051;
    public static final int PKTHDR_Unknown5 = 0x48470109;
    /** 与技能大师相关 */
    public static final int PKTHDR_Unknown6 = 0x48470045;
    /** 与物品过期删除相关 */
    public static final int PKTHDR_Unknown7 = 0x50320039;
    public static final int PKTHDR_Unknown8 = 0x50320C00;
    public static final int PKTHDR_Unknown9 = 0x50326030;
    public static final int PKTHDR_Unknown10 = 0x50326002;
    public static final int PKTHDR_Unknown11 = 0x50320800;
    public static final int PKTHDR_Unknown12 = 0x50326040;

    /** GM 命令用户 */
    public static final int PKTHDR_CommandUser = 0x4847005c;
    /** 雅虎动作（执行动作） */
    public static final int PKTHDR_YahooMotion = 0x50320E10;
}
