monster = [
	ID:'hpt1_fireelemental',
	Name:'诅咒之焰',
	Clazz:0,// 1 BOSS
	Brood:0x00,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:95,
	ActiveHour:0,
	RespawnGroup:[1, 1],

	Attributes:[
		Life:12000,
		// Attack Status
		Atk:[230, 250],
		AtkSpeed:8,
		Range:280,
		Rating:1400,

		// Defence Status
		Flee:1200,
		Absorb:25,
		Block:20,
		DamageStunPers:60,

		// Resistance
		Earth:0,
		Fire:30,
		Ice:40,// Water
		Lighting:30,// Wind
		Poison:60,
	],

	// AI
	AI:[
		Nature:0x82,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:9,
		Real_Sight:520,
		Talks:[],

		// Move Behavier
		Move_Speed:4,
		MoveRange:64,

		// Skill Behavier
		SpAttackPercetage:0,
		SkillDamage:[255, 280],
		SkillDistance:0,
		SkillRange:130,
		SkillRating:17,
		SkillCurse:0,

		// Heal Behavier
		PotionPercent:0,
		PotionCount:0,
	],

	Looks:[
		ClassCode:0,
		ArrowPosi:[-8, 200],
		ModelSize:0.0,
		UseEventModel:false,
		SizeLevel:2,
		Model:'char/monster/Firegolem/Firegolem.INI',
		Sound:0x000018D0,
	],

	// Drops
	AllSeeItem:false,
	Exp:50000,
	Quantity:1,
	drops:[
		[probability:4410, code:"NULL"/* Drops nothing */],
		[probability:4560, code:"GG101", value:[4300, 6800]/* Gold */],
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
		[probability:14, code:"OA102"/* 红玉项链 */],
		[probability:14, code:"OR101"/* 情殇 */],
		[probability:14, code:"OA101"/* 爱之石链 */],
		[probability:14, code:"OR102"/* 铜戒指 */],
		[probability:14, code:"OA114"/* 神之庇护 */]
	],
	drops_more:[
	]
]
