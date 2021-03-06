monster = [
	ID:'70_santagoblin-a',
	Name:'巨大圣诞精灵',
	Clazz:0,// 1 BOSS
	Brood:0x00,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:70,
	ActiveHour:0,
	RespawnGroup:[0, 0],

	Attributes:[
		Life:2500,
		// Attack Status
		Atk:[36, 44],
		AtkSpeed:8,
		Range:85,
		Rating:600,

		// Defence Status
		Flee:110,
		Absorb:50,
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
		IQ:9,
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
		ModelSize:2.0,
		UseEventModel:false,
		SizeLevel:3,
		Model:'char/monster/Monhobsanta/Monhobsanta.INI',
		Sound:0x00001010,
	],

	// Drops
	AllSeeItem:false,
	Exp:2000,
	Quantity:8,
	drops:[
		[probability:1000, code:"NULL"/* Drops nothing */],
		[probability:4000, code:"GG101", value:[1200, 1800]/* Gold */],
		[probability:2000, code:"PM104"/* 顶级恢复魔法药水 */],
		[probability:102, code:"DA107"/* 全钢胸铠 */],
		[probability:102, code:"DA207"/* 紫电袍 */],
		[probability:102, code:"DS107"/* 金刚盾 */],
		[probability:102, code:"WA107"/* 刺脊斧 */],
		[probability:102, code:"WC107"/* 平手刃 */],
		[probability:102, code:"WM107"/* 天魔杖 */],
		[probability:102, code:"WH107"/* 十字锤 */],
		[probability:102, code:"WS208"/* 圣殿武士剑 */],
		[probability:102, code:"WS107"/* 射日弓 */],
		[probability:102, code:"WP108"/* 血烟长矛 */],
		[probability:102, code:"WT108"/* 金标 */],
		[probability:102, code:"OA207"/* 乌金臂环 */],
		[probability:102, code:"OM107"/* 火星 */],
		[probability:102, code:"DB107"/* 冰火靴 */],
		[probability:102, code:"DS107"/* 金刚盾 */],
		[probability:102, code:"DG107"/* 百裂护手 */],
		[probability:102, code:"EC101"/* 回城卷 */],
		[probability:102, code:"EC102"/* 回城卷 */],
		[probability:102, code:"EC104"/* 回城卷 */],
		[probability:102, code:"OR107"/* 法师戒指 */],
		[probability:102, code:"OA107"/* 水晶项链 */],
		[probability:22, code:"DA108"/* 精制链铠 */],
		[probability:22, code:"DA208"/* 圣女袍 */],
		[probability:22, code:"DS108"/* 赤龙焰盾 */],
		[probability:22, code:"WA108"/* 叼刚 清磐 */],
		[probability:22, code:"WC108"/* 矩记飘 府亥瘤 */],
		[probability:22, code:"WM108"/* 公正之杖 */],
		[probability:22, code:"WH108"/* 圣光锤 */],
		[probability:22, code:"WS209"/* 镇妖剑 */],
		[probability:22, code:"WS108"/* 巨弩 */],
		[probability:22, code:"WP109"/* 单喉 荤捞靛 */],
		[probability:22, code:"WT109"/* 酒唱能促 */],
		[probability:22, code:"OA208"/* 百炼臂环 */],
		[probability:22, code:"OM108"/* 阳炎 */],
		[probability:22, code:"DB108"/* 百战靴 */],
		[probability:22, code:"DS108"/* 赤龙焰盾 */],
		[probability:22, code:"DG108"/* 大地护手 */],
		[probability:22, code:"EC101"/* 回城卷 */],
		[probability:22, code:"EC102"/* 回城卷 */],
		[probability:22, code:"EC104"/* 回城卷 */],
		[probability:22, code:"OR108"/* 翡翠戒指 */],
		[probability:22, code:"OA108"/* 靛青石链 */],
		[probability:22, code:"OS106"/* 玄风石 */],
		[probability:13, code:"DA109"/* 黄铜战铠 */],
		[probability:13, code:"DA209"/* 学徒披风 */],
		[probability:13, code:"DS109"/* 圣盾 */],
		[probability:13, code:"WA109"/* 破山斧 */],
		[probability:13, code:"WC109"/* 兽之斧刃 */],
		[probability:13, code:"WM109"/* 绊胶飘 */],
		[probability:13, code:"WH109"/* 固萍绢扼捞飘 */],
		[probability:13, code:"WS210"/* 敲饭萍逞 家靛 */],
		[probability:13, code:"WS109"/* 点金手弩 */],
		[probability:13, code:"WP110"/* 白银之枪 */],
		[probability:13, code:"WT110"/* 飞云标 */],
		[probability:13, code:"OA209"/* 飞翼臂环 */],
		[probability:13, code:"OM109"/* 暗月 */],
		[probability:13, code:"DB109"/* 大地靴 */],
		[probability:13, code:"DS109"/* 圣盾 */],
		[probability:13, code:"DG109"/* 神力护手 */],
		[probability:13, code:"EC101"/* 回城卷 */],
		[probability:13, code:"EC102"/* 回城卷 */],
		[probability:13, code:"EC104"/* 回城卷 */],
		[probability:13, code:"OR109"/* 黑暗之戒 */],
		[probability:13, code:"OA109"/* 海蓝石链 */],
		[probability:13, code:"OS107"/* 水晶石 */],
		[probability:1, code:"DA110"/* 百裂铠 */],
		[probability:1, code:"DA210"/* 信徒披风 */],
		[probability:1, code:"DS110"/* 宙斯盾 */],
		[probability:1, code:"WA110"/* 定神斧 */],
		[probability:1, code:"WC110"/* 九头刺蛇爪 */],
		[probability:1, code:"WM110"/* 圣者杖 */],
		[probability:1, code:"WH110"/* 轩辕巨锤 */],
		[probability:1, code:"WS211"/* 斩马刀 */],
		[probability:1, code:"WS110"/* 固胶飘 */],
		[probability:1, code:"WP111"/* 屠龙枪 */],
		[probability:1, code:"WT111"/* 神标 */],
		[probability:1, code:"OA210"/* 百川流水臂环 */],
		[probability:1, code:"OM110"/* 蓝色星辰 */],
		[probability:1, code:"DB110"/* 地火战靴 */],
		[probability:1, code:"DS110"/* 宙斯盾 */],
		[probability:1, code:"DG110"/* 火云护手 */],
		[probability:1, code:"EC101"/* 回城卷 */],
		[probability:1, code:"EC102"/* 回城卷 */],
		[probability:1, code:"EC104"/* 回城卷 */],
		[probability:1, code:"OR110"/* 伏魔戒指 */],
		[probability:1, code:"OA110"/* 镇魂铃 */],
		[probability:1, code:"OS108"/* 虎翼石 */]
	],
	drops_more:[
	]
]
