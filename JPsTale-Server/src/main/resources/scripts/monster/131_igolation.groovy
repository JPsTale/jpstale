monster = [
	ID:'131_igolation',
	Name:'死神',
	Clazz:0,// 1 BOSS
	Brood:0x00,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:131,
	ActiveHour:0,
	RespawnGroup:[1, 1],

	Attributes:[
		Life:24000,
		// Attack Status
		Atk:[283, 293],
		AtkSpeed:8,
		Range:80,
		Rating:1634,

		// Defence Status
		Flee:1236,
		Absorb:43,
		Block:26,
		DamageStunPers:26,

		// Resistance
		Earth:68,
		Fire:63,
		Ice:69,// Water
		Lighting:64,// Wind
		Poison:70,
	],

	// AI
	AI:[
		Nature:0x82,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:8,
		Real_Sight:380,
		Talks:[],

		// Move Behavier
		Move_Speed:2,
		MoveRange:64,

		// Skill Behavier
		SpAttackPercetage:30,
		SkillDamage:[300, 311],
		SkillDistance:0,
		SkillRange:0,
		SkillRating:60,
		SkillCurse:0,

		// Heal Behavier
		PotionPercent:56,
		PotionCount:1,
	],

	Looks:[
		ClassCode:0,
		ArrowPosi:[0, 0],
		ModelSize:0.0,
		UseEventModel:false,
		SizeLevel:1,
		Model:'char/monster/Igolation/igolation.ini',
		Sound:0x00002120,
	],

	// Drops
	AllSeeItem:false,
	Exp:1525000,
	Quantity:1,
	drops:[
		[probability:1740, code:"NULL"/* Drops nothing */],
		[probability:2020, code:"GG101", value:[3650, 4050]/* Gold */],
		[probability:933, code:"PL104"/* 顶级恢复生命药水 */],
		[probability:933, code:"PS104"/* 顶级恢复耐力药水 */],
		[probability:933, code:"PM104"/* 顶级恢复魔法药水 */],
		[probability:83, code:"DA121"/* 魔龙圣铠 */],
		[probability:83, code:"DA221"/* 涅磐圣衣 */],
		[probability:83, code:"WA119"/* 幽月斧 */],
		[probability:83, code:"WC119"/* 修罗爪 */],
		[probability:83, code:"WH120"/* 无畏 */],
		[probability:83, code:"WM120"/* 灭绝 */],
		[probability:83, code:"WP120"/* 炎枪素戋鸣 */],
		[probability:83, code:"WS121"/* 亚罗栖 */],
		[probability:83, code:"WS222"/* 赤焰流星 */],
		[probability:83, code:"WT120"/* 天妒 */],
		[probability:83, code:"DB119"/* 死神战靴 */],
		[probability:83, code:"DS119"/* 蛮狮之盾 */],
		[probability:83, code:"OM120"/* 炫钻水晶 */],
		[probability:83, code:"DG119"/* 炫彩护手 */],
		[probability:83, code:"OA219"/* 兽神臂环 */],
		[probability:83, code:"OR118"/* 封神之戒 */],
		[probability:83, code:"OA118"/* 圣光勋章 */],
		[probability:83, code:"OS110"/* 钻晶石 */],
		[probability:52, code:"DA122"/* 炫金圣铠 */],
		[probability:52, code:"DA222"/* 雅典娜圣衣 */],
		[probability:52, code:"WA120"/* 米诺陶斯斧 */],
		[probability:52, code:"WC120"/* 寂灭龙爪 */],
		[probability:52, code:"WH121"/* 轰雷战锤 */],
		[probability:52, code:"WM121"/* 雅典娜之光 */],
		[probability:52, code:"WP121"/* 灵犀之镰 */],
		[probability:52, code:"WS122"/* 凤舞九天 */],
		[probability:52, code:"WS223"/* 创世之剑 */],
		[probability:52, code:"WT121"/* 龙翔标枪 */],
		[probability:52, code:"DB120"/* 炫金战靴 */],
		[probability:52, code:"DS120"/* 炫金之盾 */],
		[probability:52, code:"OM121"/* 海洋之心 */],
		[probability:52, code:"DG120"/* 炫金护手 */],
		[probability:52, code:"OA220"/* 炫金臂环 */],
		[probability:52, code:"OR119"/* 轮回之戒 */],
		[probability:52, code:"OA119"/* 逆天纹章 */],
		[probability:52, code:"OS111"/* 龙睛石 */],
		[probability:29, code:"DA123"/* 凤凰圣铠 */],
		[probability:29, code:"DA223"/* 凤凰圣衣 */],
		[probability:29, code:"WA121"/* 苍红斧 */],
		[probability:29, code:"WC121"/* 灭牙爪 */],
		[probability:29, code:"WH122"/* 魁伐折罗 */],
		[probability:29, code:"WM122"/* 流泉月花 */],
		[probability:29, code:"WP122"/* 天之琼侔 */],
		[probability:29, code:"WS123"/* 红羽 */],
		[probability:29, code:"WS224"/* 暗牙黄泉津 */],
		[probability:29, code:"WT122"/* 暗破 */],
		[probability:29, code:"DB121"/* 凤凰战靴 */],
		[probability:29, code:"DS121"/* 凤凰之盾 */],
		[probability:29, code:"OM122"/* 恶魔法珠 */],
		[probability:29, code:"DG121"/* 凤凰护手 */],
		[probability:29, code:"OA221"/* 凤凰臂环 */],
		[probability:29, code:"OR120"/* 涅磐之戒 */],
		[probability:29, code:"OA120"/* 九转护符 */],
		[probability:29, code:"OS112"/* 圣晶石 */],
		[probability:15, code:"DA124"/* 奥丁圣铠 */],
		[probability:15, code:"DA224"/* 奥丁圣衣 */],
		[probability:15, code:"WA122"/* 龙炎斧 */],
		[probability:15, code:"WC122"/* 黑虹爪 */],
		[probability:15, code:"WH123"/* 大鎚伊武岐 */],
		[probability:15, code:"WM123"/* 螺钿三日星 */],
		[probability:15, code:"WP123"/* 卡厄斯 */],
		[probability:15, code:"WS124"/* 天之麻迦古弓 */],
		[probability:15, code:"WS225"/* 32d22w */],
		[probability:15, code:"WT123"/* 天严云 */],
		[probability:15, code:"DB122"/* 奥丁战靴 */],
		[probability:15, code:"DS122"/* 奥丁之盾 */],
		[probability:15, code:"OM123"/* 紫金之光 */],
		[probability:15, code:"DG122"/* 奥丁护手 */],
		[probability:15, code:"OA222"/* 奥丁臂环 */],
		[probability:15, code:"OR121"/* 龙誉之戒 */],
		[probability:15, code:"OA121"/* 圣龙之光 */],
		[probability:15, code:"OS113"/* 恶魔石 */],
		[probability:8, code:"DA125"/* 汉兰达铠 */],
		[probability:8, code:"DA225"/* 天使圣衣 */],
		[probability:8, code:"WA123"/* 龙之破坏者 */],
		[probability:8, code:"WC123"/* 红蛛之牙 */],
		[probability:8, code:"WH124"/* 龙王之锤 */],
		[probability:8, code:"WM124"/* 双龙阿修罗 */],
		[probability:8, code:"WP124"/* 烈枪降阎魔 */],
		[probability:8, code:"WS125"/* 潘多拉之弓 */],
		[probability:8, code:"WS226"/* 真龙神啸 */],
		[probability:8, code:"WT124"/* 皓月谙晓 */],
		[probability:8, code:"DB123"/* 圣龙之靴 */],
		[probability:8, code:"DS123"/* 地狱之盾 */],
		[probability:8, code:"OM124"/* 圣龙之光 */],
		[probability:8, code:"DG123"/* 圣龙护手 */],
		[probability:8, code:"OA223"/* 圣龙臂环 */],
		[probability:8, code:"OR122"/* 彩晶环 */],
		[probability:8, code:"OA122"/* 彩晶链 */],
		[probability:8, code:"OS114"/* 彩晶石 */]
	],
	drops_more:[
	]
]
