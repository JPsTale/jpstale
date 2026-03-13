# 待实现结构体清单（按头文件，初版）

> 说明：本清单是按照 C++ 头文件中出现的 `struct Name` 逐个罗列的「待跟进列表」。
>
> - **是否“已实现”未在此文件中做自动判定**：同名 Java 类（例如 `org.jpstale.server.common.struct.*` 及其子包）可能已经存在，请在后续梳理时将已完成项勾掉或删除。
> - 本文件的目标是：**给出一个完整的 C++ 结构体名字空间视图**，方便后续逐步对照 Java 侧实现情况。

---

## account.h

- AccountFileData
- PacketAccountLoginCode
- PacketAccountID
- PacketWorldLoginToken
- PacketWorldLoginAuth
- AccountLogin

---

## character.h

- CharacterSoundEffect
- SoundEffectData
- ItemRequeriments
- CharStats
- CharTotalStats
- CharacterClassData
- JOB_DATA_CODE
- CharacterBody
- QuestCharacterSave
- LastQuestSave
- CharacterSave
- UnitInfo
- CharacterData
- PacketUnitInfo
- PacketPlayerTitleList
- PacketCharacterRecordData
- PacketCharacterCombatData
- PacketCharacterDataEx
- PacketUpdateIntegrity

---

## chat.h

- ChatBoxMessage
- PacketChat
- PacketChatMessage
- PacketChatBoxMessage

---

## item.h

- SocketItem
- ItemFix
- ItemFixData
- SpecItemData
- Item
- DefinitionItem
- DropSettingsData
- ItemBoxItem
- ItemBoxSlot
- PlayerTitle
- RecordItem
- InventoryItemData
- SellItemShopData
- ItemLoadData
- RespecStone
- PriceItem
- SocketItemData
- ItemLogBox
- CompressedItem
- RGB
- ARGBNew
- DropItemView
- ItemInventoryData
- PacketPersonalBotShopData
- PacketSlotItemHandle
- NPCItemBoxMessageBox
- PacketNPCItemBox
- PacketMixServer
- PacketRecoverItem
- PacketItemData
- PacketUseUnionCore
- PacketWingItem
- PacketThrowItem
- PacketResetItem
- PacketQuestNPCItemList
- PacketFuryArenaItemData
- PacketSocketSystem
- PacketItemPerfectView
- PacketItem
- PacketManufactureItem
- PacketAgingItem
- PacketBuyNPCShop
- PacketItemShopList
- PacketNetSendItemData
- PacketSellNPCShop
- PacketRepairNPCShop
- PacketGetItem
- PacketItemLinkChat

---

## map.h

- MapBorder
- Teleport
- MapPosition
- FlatMap
- StageVertex
- StageFace
- StageTexture
- LootItem
- Loot
- PacketBossTimeUpdate
- PacketMapSpawnMarkers

---

## party.h

- PartyInfo
- PartyMemberData
- PartyRaidMemberData
- PartyMember
- PartyRaidMember
- PartyRaid
- PacketUpdateParty
- PacketUpdatePartyData
- PacketRequestParty
- PacketLeaveRaid
- PacketRequestRaid
- PacketJoinRaid
- PacketJoinParty
- PacketActionParty
- PacketSkillPartyData

---

## quest.h

- QuestDataNew
- PacketQuestFinish
- PacketQuestRestart
- PacketQuestCancel
- PacketQuestNPCOpen
- PacketQuestNPCAccept
- PacketQuestDataRequest
- QuestInformation
- PacketQuestNamesResponse
- PacketQuestDataResponse
- PacketQuestWeaponMature
- PacketQuestNPCFinish
- PacketDynamicQuestOpen
- PacketQuestHandleCancel
- PacketHandleFinishedQuest
- PacketQuestMonsterName
- PacketQuestUpdateData
- PacketNetQuestUpdateData
- PacketNetQuestUpdateDataPart
- PacketSyncFinishedQuestData
- PacketQuestStartData
- PacketDynamicQuestNPCOpen
- PacketQuestItemSwap
- QuestFinishedData

---

## skill.h

- ActiveSkill
- RecordSkill
- SkillBox
- SkillBase
- Skill
- UseSkill
- PacketSkillBuffStatus
- PacketSkillBuffStatusContainer
- PacketSkillCast
- PacketUseSkillBase
- PacketUseSkillSingle
- PacketUseSkillParty
- sSKILL_SOUND_FILE

---

## sound.h

> `shared/sound.h` 当前未检测到顶层 `struct Name` 定义（仅可能有 typedef / 内联定义），如后续补充请在此处添加。

---

## unit.h

- EXEModelData
- DamageInfo
- AttackDamageData
- PlayBuff
- ModelAnimation
- ModelAnimationOld
- ModelData
- ModelDataOld
- UnitTool
- MonsterMapSpawnHandle
- PacketUnitStatusMove
- PacketGameStatusBase
- PacketGameStatusBabelStormMap
- PacketGameStatusBlessCastle
- PacketGameStatusPvPMap
- PacketUnitStatusContainer

---

## user.h

- PartyInfo
- PacketItemData
- QuestStatusData
- FinishedQuestData
- BlessCastleItemBuff
- DamagePvPDataHandler
- CastleMaster
- GoldThrowHistory
- PacketBellatraResult

---

## packets.h（非 Packet 基类的辅助 struct）

> `shared/packets.h` 中包含大量 `PacketXxx : Packet` 结构体，其中大部分已在 Java 侧的 `org.jpstale.server.common.struct.packets.*` 中实现。
> 为避免冗长，这里优先列出 **非 Packet 基类的辅助结构体**，以及部分与业务逻辑紧密相关的辅助 struct，作为后续梳理的重点对象。

- HPStruct
- StructFuryArenaBoss
- ItemListMix
- ItemMixDesc
- MapIndicator
- PartyUserData
- PartyUserInfo
- _sTRANS_SERVER_INFO
- _TRANS_CHAR_INFO
- ChecksumFunction
- BlessCastleStatusShort
- BlessCastleStatusSettingsData
- BlessCastleStatusData
- BlessCastlePVPLeague
- DropItemData
- LifeStealParam
- SPrizeData
- SkillArrayData
- SkillInfoCommon
- SkillInfo
- SkillChainScaleData

> 需要时，可再针对 `shared/packets.h` 中所有 `PacketXxx : Packet` 名称与 Java 中 `struct.packets.PacketXxx` 做一轮自动比对，将真正缺失的报文结构体追加到本节下方。

