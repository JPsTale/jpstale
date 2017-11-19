monster = [
	ID:'4_rabie',
	Name:'兔妖',
	Clazz:0,// 1 BOSS
	Brood:0x00,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:4,
	ActiveHour:0,
	RespawnGroup:[2, 2],

	Attributes:[
		Life:15,
		// Attack Status
		Atk:[2, 3],
		AtkSpeed:8,
		Range:30,
		Rating:100,

		// Defence Status
		Flee:10,
		Absorb:0,
		Block:0,
		DamageStunPers:100,

		// Resistance
		Earth:10,
		Fire:10,
		Ice:5,// Water
		Lighting:0,// Wind
		Poison:10,
	],

	// AI
	AI:[
		Nature:0x80,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:5,
		Real_Sight:240,
		Talks:[],

		// Move Behavier
		Move_Speed:1,
		MoveRange:64,

		// Skill Behavier
		SpAttackPercetage:0,
		SkillDamage:[0, 0],
		SkillDistance:0,
		SkillRange:0,
		SkillRating:0,
		SkillCurse:0,

		// Heal Behavier
		PotionPercent:0,
		PotionCount:0,
	],

	Looks:[
		ClassCode:42,
		ArrowPosi:[-5, 44],
		ModelSize:0.0,
		UseEventModel:false,
		SizeLevel:0,
		Model:'char/monster/Monrebi/Monrebi.ini',
		Sound:0x00001200,
	],

	// Drops
	AllSeeItem:false,
	Exp:105,
	Quantity:10,
	drops:[
		[probability:2050, code:"NULL"/* Drops nothing */],
		[probability:5800, code:"GG101", value:[8, 15]/* Gold */],
		[probability:300, code:"PS101"/* 低级恢复耐力药水 */],
		[probability:300, code:"PS101"/* 低级恢复耐力药水 */],
		[probability:300, code:"PL101"/* 低级复生命药水 */],
		[probability:300, code:"PL101"/* 低级复生命药水 */],
		[probability:300, code:"PL101"/* 低级复生命药水 */],
		[probability:33, code:"DA102"/* 战斗服 */],
		[probability:33, code:"DA202"/* 袍 */],
		[probability:33, code:"WA101"/* 石斧 */],
		[probability:33, code:"WH101"/* 狼牙棒 */],
		[probability:33, code:"WM101"/* 沉默之杖 */],
		[probability:33, code:"WP101"/* 精制木杖 */],
		[probability:33, code:"WS101"/* 短弓 */],
		[probability:33, code:"WT101"/* 标枪 */],
		[probability:33, code:"OM101"/* 念珠 */],
		[probability:33, code:"OR101"/* 情殇 */],
		[probability:33, code:"GP101"/* 独角兽水晶 */],
		[probability:33, code:"OS101"/* 星遗石 */],
		[probability:40, code:"DS101"/* 木盾 */],
		[probability:40, code:"DB101"/* 皮靴 */],
		[probability:40, code:"DG101"/* 手套 */],
		[probability:40, code:"OA201"/* 皮制臂环 */],
		[probability:40, code:"PM101"/* 低级恢复魔法药水 */],
		[probability:7, code:"OS103"/* 海精石 */],
		[probability:7, code:"OR102"/* 铜戒指 */],
		[probability:7, code:"OR103"/* 金戒指 */],
		[probability:7, code:"OA102"/* 红玉项链 */],
		[probability:7, code:"OA103"/* 多情环 */],
		[probability:7, code:"PM101"/* 低级恢复魔法药水 */],
		[probability:7, code:"GP109"/* 神秘水晶 */]
	],
	drops_more:[
	]
]