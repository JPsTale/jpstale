monster = [
	ID:'80_guardian',
	Name:'守护圣徒',
	Clazz:0,// 1 BOSS
	Brood:0x00,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:80,
	ActiveHour:0,
	RespawnGroup:[0, 0],

	Attributes:[
		Life:15000,
		// Attack Status
		Atk:[100, 120],
		AtkSpeed:7,
		Range:75,
		Rating:1200,

		// Defence Status
		Flee:520,
		Absorb:20,
		Block:0,
		DamageStunPers:70,

		// Resistance
		Earth:50,
		Fire:30,
		Ice:30,// Water
		Lighting:20,// Wind
		Poison:50,
	],

	// AI
	AI:[
		Nature:0x82,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:8,
		Real_Sight:400,
		Talks:[],

		// Move Behavier
		Move_Speed:4,
		MoveRange:64,

		// Skill Behavier
		SpAttackPercetage:20,
		SkillDamage:[110, 130],
		SkillDistance:0,
		SkillRange:100,
		SkillRating:17,
		SkillCurse:0,

		// Heal Behavier
		PotionPercent:10,
		PotionCount:0,
	],

	Looks:[
		ClassCode:0,
		ArrowPosi:[0, 0],
		ModelSize:0.0,
		UseEventModel:false,
		SizeLevel:-1,
		Model:'char/monster/guardian/guardian.ini',
		Sound:0x00001470,
	],

	// Drops
	AllSeeItem:false,
	Exp:18000,
	Quantity:1,
	drops:[
		[probability:2450, code:"NULL"/* Drops nothing */],
		[probability:2500, code:"GG101", value:[350, 480]/* Gold */],
		[probability:1033, code:"PL104"/* 顶级恢复生命药水 */],
		[probability:1033, code:"PS104"/* 顶级恢复耐力药水 */],
		[probability:1033, code:"PM104"/* 顶级恢复魔法药水 */],
		[probability:55, code:"DA108"/* 精制链铠 */],
		[probability:55, code:"DA208"/* 圣女袍 */],
		[probability:55, code:"WA107"/* 刺脊斧 */],
		[probability:55, code:"WC107"/* 平手刃 */],
		[probability:55, code:"WH108"/* 圣光锤 */],
		[probability:55, code:"WM108"/* 公正之杖 */],
		[probability:55, code:"WP107"/* 战神之镰 */],
		[probability:55, code:"WS109"/* 点金手弩 */],
		[probability:55, code:"WS209"/* 镇妖剑 */],
		[probability:55, code:"WT107"/* 天命标 */],
		[probability:55, code:"DB107"/* 冰火靴 */],
		[probability:55, code:"DS107"/* 金刚盾 */],
		[probability:55, code:"OM107"/* 火星 */],
		[probability:55, code:"DG107"/* 百裂护手 */],
		[probability:55, code:"OA207"/* 乌金臂环 */],
		[probability:55, code:"OR111"/* 封印之戒 */],
		[probability:55, code:"OA111"/* 圣者之链 */],
		[probability:55, code:"OS104"/* 天仪石 */],
		[probability:23, code:"DA109"/* 黄铜战铠 */],
		[probability:23, code:"DA209"/* 学徒披风 */],
		[probability:23, code:"WA108"/* 叼刚 清磐 */],
		[probability:23, code:"WC108"/* 矩记飘 府亥瘤 */],
		[probability:23, code:"WH109"/* 固萍绢扼捞飘 */],
		[probability:23, code:"WM109"/* 绊胶飘 */],
		[probability:23, code:"WP108"/* 血烟长矛 */],
		[probability:23, code:"WS110"/* 固胶飘 */],
		[probability:23, code:"WS210"/* 敲饭萍逞 家靛 */],
		[probability:23, code:"WT108"/* 金标 */],
		[probability:23, code:"DB108"/* 百战靴 */],
		[probability:23, code:"DS108"/* 赤龙焰盾 */],
		[probability:23, code:"OM108"/* 阳炎 */],
		[probability:23, code:"DG108"/* 大地护手 */],
		[probability:23, code:"OA208"/* 百炼臂环 */],
		[probability:23, code:"OR112"/* 王者戒指 */],
		[probability:23, code:"OA112"/* 魔龙之心 */],
		[probability:23, code:"OS105"/* 冰晶石 */],
		[probability:23, code:"OS106"/* 玄风石 */],
		[probability:23, code:"OS106"/* 玄风石 */],
		[probability:23, code:"EC105"/* 公会卷轴 */],
		[probability:13, code:"DA110"/* 百裂铠 */],
		[probability:13, code:"DA210"/* 信徒披风 */],
		[probability:13, code:"WA109"/* 破山斧 */],
		[probability:13, code:"WC109"/* 兽之斧刃 */],
		[probability:13, code:"WH110"/* 轩辕巨锤 */],
		[probability:13, code:"WM110"/* 圣者杖 */],
		[probability:13, code:"WP109"/* 单喉 荤捞靛 */],
		[probability:13, code:"WS111"/* 龙骨战弓 */],
		[probability:13, code:"WS211"/* 斩马刀 */],
		[probability:13, code:"WT109"/* 酒唱能促 */],
		[probability:13, code:"DB109"/* 大地靴 */],
		[probability:13, code:"DS109"/* 圣盾 */],
		[probability:13, code:"OM109"/* 暗月 */],
		[probability:13, code:"DG109"/* 神力护手 */],
		[probability:13, code:"OA209"/* 飞翼臂环 */],
		[probability:13, code:"EC102"/* 回城卷 */],
		[probability:13, code:"OR113"/* 灵魂之戒 */],
		[probability:13, code:"OA113"/* 生命之链 */],
		[probability:13, code:"EC102"/* 回城卷 */],
		[probability:13, code:"OS106"/* 玄风石 */],
		[probability:13, code:"OS106"/* 玄风石 */],
		[probability:13, code:"OS107"/* 水晶石 */],
		[probability:4, code:"DA111"/* 重装机铠 */],
		[probability:4, code:"DA211"/* 大法师袍 */],
		[probability:4, code:"WA110"/* 定神斧 */],
		[probability:4, code:"WC110"/* 九头刺蛇爪 */],
		[probability:4, code:"WH111"/* 赤冥之锤 */],
		[probability:4, code:"WM111"/* 王者杖 */],
		[probability:4, code:"WP111"/* 屠龙枪 */],
		[probability:4, code:"WS212"/* 嗜血屠魔剑 */],
		[probability:4, code:"WS112"/* 人马之辉 */],
		[probability:4, code:"WT110"/* 飞云标 */],
		[probability:4, code:"DB110"/* 地火战靴 */],
		[probability:4, code:"DS110"/* 宙斯盾 */],
		[probability:4, code:"OM110"/* 蓝色星辰 */],
		[probability:4, code:"DG110"/* 火云护手 */],
		[probability:4, code:"OA210"/* 百川流水臂环 */],
		[probability:4, code:"EC102"/* 回城卷 */],
		[probability:4, code:"OR113"/* 灵魂之戒 */],
		[probability:4, code:"OA113"/* 生命之链 */],
		[probability:4, code:"EC102"/* 回城卷 */],
		[probability:4, code:"OS106"/* 玄风石 */],
		[probability:4, code:"OS106"/* 玄风石 */],
		[probability:4, code:"OS107"/* 水晶石 */],
		[probability:2, code:"DA112"/* 战神宝铠 */],
		[probability:2, code:"DA212"/* 红莲战袍 */],
		[probability:2, code:"WA111"/* 天阙斧 */],
		[probability:2, code:"WC111"/* 利维坦 */],
		[probability:2, code:"WH112"/* 碎星锤 */],
		[probability:2, code:"WM112"/* 审判之杖 */],
		[probability:2, code:"WP112"/* 傲天枪 */],
		[probability:2, code:"WS213"/* 双截刃 */],
		[probability:2, code:"WS113"/* 猛犸巨弩 */],
		[probability:2, code:"WT111"/* 神标 */],
		[probability:2, code:"DB111"/* 圣靴 */],
		[probability:2, code:"DS111"/* 苍穹之盾 */],
		[probability:2, code:"OM111"/* 淬火乌晶 */],
		[probability:2, code:"DG111"/* 黄铜护手 */],
		[probability:2, code:"OA211"/* 玄铁臂环 */],
		[probability:2, code:"EC102"/* 回城卷 */],
		[probability:2, code:"OR114"/* 帝王之戒 */],
		[probability:2, code:"OA114"/* 神之庇护 */],
		[probability:2, code:"EC102"/* 回城卷 */],
		[probability:2, code:"OS106"/* 玄风石 */],
		[probability:2, code:"OS106"/* 玄风石 */],
		[probability:2, code:"OS107"/* 水晶石 */]
	],
	drops_more:[
	]
]
