monster = [
	ID:'ymu',
	Name:'幽绿毒虫',
	Clazz:0,// 1 BOSS
	Brood:0x00,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:165,
	ActiveHour:0,
	RespawnGroup:[1, 1],

	Attributes:[
		Life:12000,
		// Attack Status
		Atk:[180, 280],
		AtkSpeed:8,
		Range:80,
		Rating:1180,

		// Defence Status
		Flee:1580,
		Absorb:20,
		Block:8,
		DamageStunPers:70,

		// Resistance
		Earth:0,
		Fire:40,
		Ice:40,// Water
		Lighting:40,// Wind
		Poison:60,
	],

	// AI
	AI:[
		Nature:0x82,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:9,
		Real_Sight:480,
		Talks:[],

		// Move Behavier
		Move_Speed:5,
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
		ClassCode:0,
		ArrowPosi:[0, 25],
		ModelSize:1.3,
		UseEventModel:false,
		SizeLevel:2,
		Model:'char/monster/Omu/Omu.ini',
		Sound:0x000015D0,
	],

	// Drops
	AllSeeItem:false,
	Exp:480000,
	Quantity:1,
	drops:[
		[probability:8000, code:"NULL"/* Drops nothing */],
		[probability:2000, code:"EC105"/* 公会卷轴 */]
	],
	drops_more:[
	]
]
