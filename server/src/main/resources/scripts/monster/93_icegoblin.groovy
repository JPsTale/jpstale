monster = [
	ID:'93_icegoblin',
	Name:'冰甲魔兽兵',
	Clazz:0,// 1 BOSS
	Brood:0x00,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:93,
	ActiveHour:0,
	RespawnGroup:[1, 1],

	Attributes:[
		Life:7000,
		// Attack Status
		Atk:[80, 95],
		AtkSpeed:7,
		Range:90,
		Rating:1250,

		// Defence Status
		Flee:820,
		Absorb:22,
		Block:10,
		DamageStunPers:100,

		// Resistance
		Earth:30,
		Fire:-80,
		Ice:100,// Water
		Lighting:30,// Wind
		Poison:20,
	],

	// AI
	AI:[
		Nature:0x82,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:8,
		Real_Sight:350,
		Talks:[],

		// Move Behavier
		Move_Speed:5,
		MoveRange:64,

		// Skill Behavier
		SpAttackPercetage:0,
		SkillDamage:[96, 106],
		SkillDistance:50,
		SkillRange:70,
		SkillRating:15,
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
		SizeLevel:1,
		Model:'char/monster/icegoblin/icegoblin.ini',
		Sound:0x00001620,
	],

	// Drops
	AllSeeItem:false,
	Exp:74500,
	Quantity:1,
	drops:[
		[probability:1775, code:"NULL"/* Drops nothing */],
		[probability:5635, code:"GG101", value:[400, 600]/* Gold */],
		[probability:600, code:"PL104"/* 顶级恢复生命药水 */],
		[probability:600, code:"PM104"/* 顶级恢复魔法药水 */],
		[probability:600, code:"PM104"/* 顶级恢复魔法药水 */],
		[probability:30, code:"DA116"/* 暗黑铠 */],
		[probability:30, code:"DA216"/* 祝福法袍 */],
		[probability:30, code:"WA114"/* 战神之刃 */],
		[probability:30, code:"WC114"/* 天狼爪 */],
		[probability:30, code:"WH115"/* 雷公槌 */],
		[probability:30, code:"WM115"/* 亡灵刺 */],
		[probability:30, code:"WP115"/* 狂暴之枪 */],
		[probability:30, code:"WS116"/* 血精灵 */],
		[probability:30, code:"WS217"/* 鬼切 */],
		[probability:30, code:"WT115"/* 惊鸿 */],
		[probability:30, code:"DB114"/* 鹏翅之靴 */],
		[probability:30, code:"DS114"/* 泰坦之盾 */],
		[probability:30, code:"OM115"/* 炫彩水晶 */],
		[probability:30, code:"DG114"/* 金刚护手 */],
		[probability:30, code:"OA214"/* 金刚臂环 */],
		[probability:30, code:"OR115"/* 守护之戒 */],
		[probability:30, code:"OA115"/* 暗印护符 */],
		[probability:30, code:"OS107"/* 水晶石 */],
		[probability:30, code:"GP109"/* 神秘水晶 */],
		[probability:30, code:"GP110"/* 守护圣徒水晶 */],
		[probability:6, code:"DA117"/* 远古圣铠 */],
		[probability:6, code:"DA217"/* 天使法袍 */],
		[probability:6, code:"WA115"/* 泰坦斧 */],
		[probability:6, code:"WC115"/* 魔玉爪 */],
		[probability:6, code:"WH116"/* 轰天锤 */],
		[probability:6, code:"WM116"/* 诸神的黄昏 */],
		[probability:6, code:"WP116"/* 虹月 */],
		[probability:6, code:"WS117"/* 破鹫 */],
		[probability:6, code:"WS218"/* 天裂 */],
		[probability:6, code:"WT116"/* 玛雅神标 */],
		[probability:6, code:"DB115"/* 时空之靴 */],
		[probability:6, code:"DS115"/* 亢龙之盾 */],
		[probability:6, code:"OM116"/* 龙之护身 */],
		[probability:6, code:"DG115"/* 赤龙护手 */],
		[probability:6, code:"OA215"/* 赤龙臂环 */],
		[probability:6, code:"OR116"/* 雅典娜之吻 */],
		[probability:6, code:"OA116"/* 苍穹之链 */],
		[probability:6, code:"OS107"/* 水晶石 */],
		[probability:6, code:"GP109"/* 神秘水晶 */],
		[probability:6, code:"GP110"/* 守护圣徒水晶 */],
		[probability:2, code:"DA118"/* 米诺陶斯铠 */],
		[probability:2, code:"DA218"/* 撒旦披风 */],
		[probability:2, code:"WA116"/* 轮回战斧 */],
		[probability:2, code:"WC116"/* 泰坦爪 */],
		[probability:2, code:"WH117"/* 兽神锤 */],
		[probability:2, code:"WM117"/* 神圣之光 */],
		[probability:2, code:"WP117"/* 银河战镰 */],
		[probability:2, code:"WS118"/* 风切 */],
		[probability:2, code:"WS219"/* 凝雾 */],
		[probability:2, code:"WT117"/* 夜叉 */],
		[probability:2, code:"DB116"/* 赤龙战靴 */],
		[probability:2, code:"DS116"/* 远古之盾 */],
		[probability:2, code:"OM117"/* 绿釉之眼 */],
		[probability:2, code:"DG116"/* 星辰护手 */],
		[probability:2, code:"OA216"/* 鎏金臂环 */],
		[probability:2, code:"OR117"/* 封魔之戒 */],
		[probability:2, code:"OA117"/* 天眼护符 */],
		[probability:2, code:"OS108"/* 虎翼石 */],
		[probability:2, code:"GP110"/* 守护圣徒水晶 */],
		[probability:2, code:"GP113"/* 铁甲狂魔水晶 */],
		[probability:1, code:"DA119"/* 死神绝命铠 */],
		[probability:1, code:"DA219"/* 幻彩羽袍 */],
		[probability:1, code:"WA117"/* 远古战斧 */],
		[probability:1, code:"WC117"/* 冰魄爪 */],
		[probability:1, code:"WH118"/* 灭神锤 */],
		[probability:1, code:"WM118"/* 日月同辉 */],
		[probability:1, code:"WP118"/* 月影神矛 */],
		[probability:1, code:"WS119"/* 丘比特之弓 */],
		[probability:1, code:"WS220"/* 龙牙 */],
		[probability:1, code:"WT118"/* 噬月 */],
		[probability:1, code:"DB117"/* 烈焰靴 */],
		[probability:1, code:"DS117"/* 米诺陶斯盾 */],
		[probability:1, code:"OM118"/* 黑魔 */],
		[probability:1, code:"DG117"/* 炫钻护手 */],
		[probability:1, code:"OA217"/* 炫钻臂环 */],
		[probability:1, code:"OR118"/* 封神之戒 */],
		[probability:1, code:"OA118"/* 圣光勋章 */],
		[probability:1, code:"OS128"/* 虎翼石(魔法) */]
	],
	drops_more:[
		[probability:1000, code:"OS109"/* 龙鳞石 */]	]
]
