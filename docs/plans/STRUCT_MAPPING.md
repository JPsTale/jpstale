# 结构体类 → 目标子包映射表

供 Task 3 / Task 4 / Task 5 按包迁移使用。依据 Javadoc「对应 shared/xxx.h」或「对应 packets.h」判定；无对应或对应其他头文件（如 Coin.h）→ 保留根包。

---

## struct.account（对应 account.h）

**已在子包，无需移动：**
- AccountLoginResult
- PacketAccountID
- PacketWorldLoginToken
- AccountFileData
- PacketAccountLoginCode
- PacketWorldLoginAuth

**根包需迁入：** 无（上述已全部在 account 子包）

---

## struct.character（对应 shared/character.h）

**根包需迁入：** 无（当前无类标注对应 character.h）

---

## struct.chat（对应 shared/chat.h）

**根包需迁入：** 无

---

## struct.item（对应 shared/item.h）

**根包需迁入：**
- Item
- ItemData
- ItemFixData（C++ struct ItemFixData，item.h）
- SpecItemData（C++ struct SpecItemData，item.h）

---

## struct.map（对应 shared/map.h）

**根包需迁入：** 无

---

## struct.party（对应 shared/party.h）

**根包需迁入：**
- PartyRaidMemberData
- PartyMemberData
- PartyRaidMember
- PartyRaid
- PartyMember

---

## struct.quest（对应 shared/quest.h）

**根包需迁入：**
- QuestInformation
- QuestData

---

## struct.skill（对应 shared/skill.h）

**根包需迁入：** 无

---

## struct.sound（对应 shared/sound.h）

**根包需迁入：** 无

---

## struct.unit（对应 shared/unit.h）

**根包需迁入：** 无

---

## struct.user（对应 shared/user.h）

**根包需迁入：** 无

---

## struct.packets（对应 packets.h）

**根包需迁入：** 所有 Javadoc 中「对应 packets.h」的类，含基类与内嵌结构体，例如：

- Packet（基类，packets.h struct Packet）
- PacketSimple
- PlayBuffer
- PlayBufferData
- DropItemData
- StageItemData
- BlessCastleStatusShort
- StructFuryArenaBoss
- ItemListMix
- ItemMixDesc
- PartyUserInfo
- ItemUsing
- PacketLeaveRaid
- PacketRollDiceDropItem
- PacketWarpGateField
- PacketCoinServiceBuy
- PacketJoinParty
- PacketItem
- PacketChatBoxMessage
- PacketSkillDataContainer
- PacketUpdateParty
- PacketBlessCastleUserScoreUpdate
- PacketCoinBuy
- PacketHalloweenEventStatus
- PacketQuestStartData
- PacketDynamicQuestOpen
- PacketNetGetGameMaster
- PacketNetBCNewOwnerClanID
- PacketMixDescription
- PacketListUsingItem
- PacketChat
- PacketBuyNPCShop
- PacketSkillInfoContainer
- PacketWarehouse
- PacketWindowList
- PacketNetQuestUpdateData
- PacketPartyPotion
- PacketQuestNPCItemList
- PacketNetMuteSync
- PacketSkillCast
- PacketSyncFinishedQuestData
- PacketTradeData
- PacketDamageQuick
- PacketCoinOpenService
- PacketMixServer
- PacketTradeCoinSet
- PacketGameStatusBase
- PacketWrapCamera
- PacketItemShopBot
- PacketSelectCharacter
- PacketQuestCancel
- PacketLoseExperience
- PacketNetPlayerWorldToken
- PacketItemData
- PacketNetAskPlayerData
- PacketReconnectUser
- PacketUseUnionCore
- PacketUnitStatusContainer
- PacketDamageQuickDelayed
- PacketBellatraInformation
- PacketQuestFinish
- PacketQuestNPCAccept
- PacketNumberOfInitialBellatraPlayers
- PacketCoinOpenItemData
- PacketSettingsData
- PacketGameStatusPvPMap
- PacketUserWarpEffect
- PacketCharacterRecordData
- PacketOpenAgingRecoveryService
- PacketUserOnline
- PacketNetClan
- PacketItemPerfectView
- PacketSaveData
- PacketFireMeteorite
- PacketFuryArenaRequest
- PacketNetExp
- PacketRepairNPCShop
- PacketRankingListByClass
- PacketMultiTargetSkillData
- PacketQuestDataResponse
- PacketAttackDataEx
- PacketRankingListIndividualSod
- PacketUpdatePartyData
- PacketContainer
- PacketEventGirlResetResult
- PacketPlayDataEx
- PacketClanGoldReceive
- PacketTransCommandEx
- PacketTradeRequest
- PacketSetPremium
- PacketCharacterDataEx
- PacketUseSkillSingle
- PacketRequestRaid
- PacketGetItemPerfectView
- PacketNetUsersOnline
- PacketCommand
- PacketResetItem
- PacketMapSpawnMarkers
- PacketActionParty
- PacketCrashData
- PacketRankingListPVP
- PacketUserInfo
- PacketStablePetTab
- PacketAgingItem
- PacketCrash
- PacketBellatraCrownFull
- PacketGoldPickup
- PacketUnitStatusMove
- PacketCharacterCombatData
- PacketNetPingPong
- PacketSkillDamageRange
- PacketQuestNPCFinish
- PacketSendUseUnionCore
- PacketQuestNPCOpen
- PacketHealing
- PacketCoinTab
- PacketSkillPartyData
- PacketRequestParty
- PacketPing
- PacketEventGirlReset
- PacketManufactureItem
- PacketSingleTargetSkillData
- PacketUseSkillParty
- PacketSocketSystem
- PacketItemLinkChat
- PacketNetVersion
- PacketAttackData
- PacketUpdateClanLevel
- PacketQuickHealthUpdate
- PacketSetCharacterGold
- PacketDebugDamageInfoContainer
- PacketPvPKillType
- PacketWarehouseData
- PacketSkillBuffStatus
- PacketThrowItem
- PacketGameStatusBlessCastle
- PacketNetPlayerItemPut
- PacketQuestItemSwap
- PacketDynamicQuestNPCOpen
- PacketQuestNamesRequest
- PacketNPCItemBox
- PacketNetExpEvent
- PacketNetGameMaster
- PacketNPCRudolphChristmas
- PacketQuestRestart
- PacketLogCheat
- PacketExperience
- PacketGetItem
- PacketPvPData
- PacketNetEXPPotion
- PacketUpdatePetDataEx
- PacketTradeCoinSet
- PacketNetTradeCoin
- PacketDeleteCharacter
- （以及根包下其余所有标注「对应 packets.h」的类，以 grep 为准）

---

## 保留根包（不迁移）

- **AgingRecoveryDataHandle** — 对应 shared/Coin.h
- **Point2D** — 无对应 12 头文件标注
- **IMinMax** — 与 C++ IMinMax 对应，未标注具体头文件
- **CoinItem** — 无对应 12 头文件标注
- 其他无「对应 shared/xxx.h」或「对应 packets.h」的类均保留在根包

---

## 汇总

| 目标子包   | 需从根包迁入数量 | 已在子包 |
|------------|------------------|----------|
| account    | 0                | 6        |
| character  | 0                | 0        |
| chat       | 0                | 0        |
| item       | 4                | 0        |
| map        | 0                | 0        |
| party      | 5                | 0        |
| quest      | 2                | 0        |
| skill      | 0                | 0        |
| sound      | 0                | 0        |
| unit       | 0                | 0        |
| user       | 0                | 0        |
| packets    | ~120+            | 0        |
| （根包保留） | 若干             | —        |

*Task 3 迁移：account / character / chat / item / map / party / quest。*  
*Task 4 迁移：skill / sound / unit / user。*  
*Task 5 迁移：packets。*
