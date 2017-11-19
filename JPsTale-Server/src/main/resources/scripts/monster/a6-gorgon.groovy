monster = [
	ID:'a6-gorgon',
	Name:'堕落战神',
	Clazz:0,// 1 BOSS
	Brood:0x92,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:92,
	ActiveHour:0,
	RespawnGroup:[0, 0],

	Attributes:[
		Life:10000,
		// Attack Status
		Atk:[245, 274],
		AtkSpeed:9,
		Range:80,
		Rating:1800,

		// Defence Status
		Flee:1100,
		Absorb:20,
		Block:15,
		DamageStunPers:80,

		// Resistance
		Earth:0,
		Fire:100,
		Ice:100,// Water
		Lighting:100,// Wind
		Poison:100,
	],

	// AI
	AI:[
		Nature:0x82,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:10,
		Real_Sight:440,
		Talks:[],

		// Move Behavier
		Move_Speed:6,
		MoveRange:64,

		// Skill Behavier
		SpAttackPercetage:0,
		SkillDamage:[296, 349],
		SkillDistance:0,
		SkillRange:200,
		SkillRating:20,
		SkillCurse:0,

		// Heal Behavier
		PotionPercent:0,
		PotionCount:0,
	],

	Looks:[
		ClassCode:0,
		ArrowPosi:[0, 0],
		ModelSize:0.0,
		UseEventModel:false,
		SizeLevel:2,
		Model:'char/monster/gorgon/gorgon.ini',
		Sound:0x00001990,
	],

	// Drops
	AllSeeItem:false,
	Exp:27000,
	Quantity:2,
	drops:[
		[probability:3410, code:"NULL"/* Drops nothing */],
		[probability:4560, code:"GG101", value:[750, 1000]/* Gold */],
		[probability:37, code:"WA120"/* 米诺陶斯斧 */],
		[probability:37, code:"WC120"/* 寂灭龙爪 */],
		[probability:37, code:"WH121"/* 轰雷战锤 */],
		[probability:37, code:"WM121"/* 雅典娜之光 */],
		[probability:37, code:"WP121"/* 灵犀之镰 */],
		[probability:37, code:"WS122"/* 凤舞九天 */],
		[probability:37, code:"WS223"/* 创世之剑 */],
		[probability:37, code:"WT121"/* 龙翔标枪 */],
		[probability:37, code:"DA117"/* 远古圣铠 */],
		[probability:37, code:"DA217"/* 天使法袍 */],
		[probability:37, code:"DS120"/* 炫金之盾 */],
		[probability:37, code:"OM121"/* 海洋之心 */],
		[probability:16, code:"WA121"/* 苍红斧 */],
		[probability:16, code:"WC121"/* 灭牙爪 */],
		[probability:16, code:"WH122"/* 魁伐折罗 */],
		[probability:16, code:"WM122"/* 流泉月花 */],
		[probability:16, code:"WP122"/* 天之琼侔 */],
		[probability:16, code:"WS123"/* 红羽 */],
		[probability:16, code:"WS224"/* 暗牙黄泉津 */],
		[probability:16, code:"WT122"/* 暗破 */],
		[probability:16, code:"DA118"/* 米诺陶斯铠 */],
		[probability:16, code:"DA218"/* 撒旦披风 */],
		[probability:16, code:"DS121"/* 凤凰之盾 */],
		[probability:16, code:"OM122"/* 恶魔法珠 */],
		[probability:8, code:"WA122"/* 龙炎斧 */],
		[probability:8, code:"WC122"/* 黑虹爪 */],
		[probability:8, code:"WH123"/* 大鎚伊武岐 */],
		[probability:8, code:"WM123"/* 螺钿三日星 */],
		[probability:8, code:"WP123"/* 卡厄斯 */],
		[probability:8, code:"WS124"/* 天之麻迦古弓 */],
		[probability:8, code:"WS225"/* 32d22w */],
		[probability:8, code:"WT123"/* 天严云 */],
		[probability:8, code:"DA119"/* 死神绝命铠 */],
		[probability:8, code:"DA219"/* 幻彩羽袍 */],
		[probability:8, code:"DS122"/* 奥丁之盾 */],
		[probability:8, code:"OM123"/* 紫金之光 */],
		[probability:1, code:"WA109"/* 破山斧 */],
		[probability:1, code:"WC109"/* 兽之斧刃 */],
		[probability:1, code:"WM111"/* 王者杖 */],
		[probability:1, code:"WP112"/* 傲天枪 */],
		[probability:1, code:"WS111"/* 龙骨战弓 */],
		[probability:1, code:"WS214"/* 金刚伏魔剑 */],
		[probability:1, code:"WT110"/* 飞云标 */],
		[probability:1, code:"DA121"/* 魔龙圣铠 */],
		[probability:1, code:"DA221"/* 涅磐圣衣 */],
		[probability:1, code:"DS113"/* 龙纹盾 */],
		[probability:1, code:"OM106"/* 水星 */],
		[probability:31, code:"DB106"/* 黄金靴 */],
		[probability:31, code:"DG106"/* 白金护手 */],
		[probability:31, code:"OA210"/* 百川流水臂环 */],
		[probability:31, code:"DB109"/* 大地靴 */],
		[probability:31, code:"DG110"/* 火云护手 */],
		[probability:31, code:"OA211"/* 玄铁臂环 */],
		[probability:1000, code:"EC103"/* 回城卷 */]
	],
	drops_more:[
	]
]
