monster = [
	ID:'30_santagoblin-c',
	Name:'圣诞精灵',
	Clazz:0,// 1 BOSS
	Brood:0x00,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:30,
	ActiveHour:0,
	RespawnGroup:[0, 0],

	Attributes:[
		Life:600,
		// Attack Status
		Atk:[10, 14],
		AtkSpeed:8,
		Range:50,
		Rating:600,

		// Defence Status
		Flee:110,
		Absorb:55,
		Block:0,
		DamageStunPers:100,

		// Resistance
		Earth:30,
		Fire:20,
		Ice:10,// Water
		Lighting:0,// Wind
		Poison:0,
	],

	// AI
	AI:[
		Nature:0x80,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:10,
		Real_Sight:300,
		Talks:[],

		// Move Behavier
		Move_Speed:2,
		MoveRange:64,

		// Skill Behavier
		SpAttackPercetage:20,
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
		ArrowPosi:[0, 0],
		ModelSize:0.0,
		UseEventModel:false,
		SizeLevel:1,
		Model:'char/monster/Monhobsanta/Monhobsanta.INI',
		Sound:0x00001010,
	],

	// Drops
	AllSeeItem:false,
	Exp:1200,
	Quantity:8,
	drops:[
		[probability:1000, code:"NULL"/* Drops nothing */],
		[probability:4000, code:"GG101", value:[700, 1000]/* Gold */],
		[probability:2000, code:"PM102"/* 中级恢复魔法药水 */],
		[probability:102, code:"DA105"/* 鱼鳞甲 */],
		[probability:102, code:"DA205"/* 战斗袍 */],
		[probability:102, code:"DS105"/* 罗塔盾 */],
		[probability:102, code:"WA105"/* 双刃战斧 */],
		[probability:102, code:"WC105"/* 玄电爪 */],
		[probability:102, code:"WM105"/* 旋风之杖 */],
		[probability:102, code:"WH105"/* 破天锤 */],
		[probability:102, code:"WS206"/* 阔剑 */],
		[probability:102, code:"WS106"/* 长弓 */],
		[probability:102, code:"WP106"/* 三叉戟 */],
		[probability:102, code:"WT106"/* 精灵标 */],
		[probability:102, code:"OA205"/* 龙鳞臂环 */],
		[probability:102, code:"OM105"/* 龙额念珠 */],
		[probability:102, code:"DB105"/* 百兽靴 */],
		[probability:102, code:"DS105"/* 罗塔盾 */],
		[probability:102, code:"DG105"/* 钢指护手 */],
		[probability:102, code:"EC101"/* 回城卷 */],
		[probability:102, code:"EC102"/* 回城卷 */],
		[probability:102, code:"EC104"/* 回城卷 */],
		[probability:102, code:"OR105"/* 蓝宝石戒指 */],
		[probability:102, code:"OA105"/* 梦之心链 */],
		[probability:22, code:"DA106"/* 索子甲 */],
		[probability:22, code:"DA206"/* 精灵袍 */],
		[probability:22, code:"DS106"/* 百炼盾 */],
		[probability:22, code:"wa106"/* 凯旋 */],
		[probability:22, code:"WC106"/* 狼牙刃 */],
		[probability:22, code:"WM106"/* 抗拒之杖 */],
		[probability:22, code:"WH106"/* 浑元金锤 */],
		[probability:22, code:"WS207"/* 长刀 */],
		[probability:22, code:"WS107"/* 射日弓 */],
		[probability:22, code:"WP107"/* 战神之镰 */],
		[probability:22, code:"WT107"/* 天命标 */],
		[probability:22, code:"OA206"/* 精灵臂环 */],
		[probability:22, code:"OM106"/* 水星 */],
		[probability:22, code:"DB106"/* 黄金靴 */],
		[probability:22, code:"DS106"/* 百炼盾 */],
		[probability:22, code:"DG106"/* 白金护手 */],
		[probability:22, code:"EC101"/* 回城卷 */],
		[probability:22, code:"EC102"/* 回城卷 */],
		[probability:22, code:"EC104"/* 回城卷 */],
		[probability:22, code:"OR106"/* 红宝石戒指 */],
		[probability:22, code:"OA106"/* 碧云石链 */],
		[probability:22, code:"OS104"/* 天仪石 */],
		[probability:13, code:"DA107"/* 全钢胸铠 */],
		[probability:13, code:"DA207"/* 紫电袍 */],
		[probability:13, code:"DS107"/* 金刚盾 */],
		[probability:13, code:"WA107"/* 刺脊斧 */],
		[probability:13, code:"WC107"/* 平手刃 */],
		[probability:13, code:"WM107"/* 天魔杖 */],
		[probability:13, code:"WH107"/* 十字锤 */],
		[probability:13, code:"WS208"/* 圣殿武士剑 */],
		[probability:13, code:"WS108"/* 巨弩 */],
		[probability:13, code:"WP108"/* 血烟长矛 */],
		[probability:13, code:"WT108"/* 金标 */],
		[probability:13, code:"OA207"/* 乌金臂环 */],
		[probability:13, code:"OM107"/* 火星 */],
		[probability:13, code:"DB107"/* 冰火靴 */],
		[probability:13, code:"DS107"/* 金刚盾 */],
		[probability:13, code:"DG107"/* 百裂护手 */],
		[probability:13, code:"EC101"/* 回城卷 */],
		[probability:13, code:"EC102"/* 回城卷 */],
		[probability:13, code:"EC104"/* 回城卷 */],
		[probability:13, code:"OR107"/* 法师戒指 */],
		[probability:13, code:"OA107"/* 水晶项链 */],
		[probability:13, code:"OS105"/* 冰晶石 */],
		[probability:2, code:"DA108"/* 精制链铠 */],
		[probability:2, code:"DA208"/* 圣女袍 */],
		[probability:2, code:"DS108"/* 赤龙焰盾 */],
		[probability:2, code:"WA108"/* 叼刚 清磐 */],
		[probability:2, code:"WC108"/* 矩记飘 府亥瘤 */],
		[probability:2, code:"WM108"/* 公正之杖 */],
		[probability:2, code:"WH108"/* 圣光锤 */],
		[probability:2, code:"WS209"/* 镇妖剑 */],
		[probability:2, code:"WS109"/* 点金手弩 */],
		[probability:2, code:"WP109"/* 单喉 荤捞靛 */],
		[probability:2, code:"WT109"/* 酒唱能促 */],
		[probability:2, code:"OA208"/* 百炼臂环 */],
		[probability:2, code:"OM108"/* 阳炎 */],
		[probability:2, code:"DB108"/* 百战靴 */],
		[probability:2, code:"DS108"/* 赤龙焰盾 */],
		[probability:2, code:"DG108"/* 大地护手 */],
		[probability:2, code:"EC101"/* 回城卷 */],
		[probability:2, code:"EC102"/* 回城卷 */],
		[probability:2, code:"EC104"/* 回城卷 */],
		[probability:2, code:"OR108"/* 翡翠戒指 */],
		[probability:2, code:"OA108"/* 靛青石链 */],
		[probability:2, code:"OS106"/* 玄风石 */]
	],
	drops_more:[
	]
]
