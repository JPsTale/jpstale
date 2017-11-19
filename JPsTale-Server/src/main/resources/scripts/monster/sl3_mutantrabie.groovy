monster = [
	ID:'sl3_mutantrabie',
	Name:'长腿兔',
	Clazz:0,// 1 BOSS
	Brood:0x91,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:173,
	ActiveHour:0,
	RespawnGroup:[0, 0],

	Attributes:[
		Life:30000,
		// Attack Status
		Atk:[782, 1360],
		AtkSpeed:7,
		Range:75,
		Rating:400,

		// Defence Status
		Flee:4500,
		Absorb:30,
		Block:4500,
		DamageStunPers:100,

		// Resistance
		Earth:0,
		Fire:-10,
		Ice:10,// Water
		Lighting:-15,// Wind
		Poison:100,
	],

	// AI
	AI:[
		Nature:0x80,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:7,
		Real_Sight:350,
		Talks:[],

		// Move Behavier
		Move_Speed:1,
		MoveRange:64,

		// Skill Behavier
		SpAttackPercetage:17,
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
		ArrowPosi:[-1, 50],
		ModelSize:0.0,
		UseEventModel:false,
		SizeLevel:3,
		Model:'char/monster/Monrebion/Monrebion.ini',
		Sound:0x00001260,
	],

	// Drops
	AllSeeItem:false,
	Exp:390000,
	Quantity:0,
	drops:[

	],
	drops_more:[
	]
]
