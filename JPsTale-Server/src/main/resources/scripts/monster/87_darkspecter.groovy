monster = [
	ID:'87_darkspecter',
	Name:'鬼影魔神',
	Clazz:0,// 1 BOSS
	Brood:0x92,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:87,
	ActiveHour:0,
	RespawnGroup:[1, 1],

	Attributes:[
		Life:3000,
		// Attack Status
		Atk:[50, 60],
		AtkSpeed:7,
		Range:170,
		Rating:1400,

		// Defence Status
		Flee:720,
		Absorb:20,
		Block:10,
		DamageStunPers:100,

		// Resistance
		Earth:50,
		Fire:40,
		Ice:40,// Water
		Lighting:20,// Wind
		Poison:40,
	],

	// AI
	AI:[
		Nature:0x82,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:8,
		Real_Sight:410,
		Talks:[],

		// Move Behavier
		Move_Speed:4,
		MoveRange:64,

		// Skill Behavier
		SpAttackPercetage:20,
		SkillDamage:[60, 70],
		SkillDistance:0,
		SkillRange:110,
		SkillRating:20,
		SkillCurse:0,

		// Heal Behavier
		PotionPercent:0,
		PotionCount:0,
	],

	Looks:[
		ClassCode:36,
		ArrowPosi:[0, 30],
		ModelSize:0.0,
		UseEventModel:false,
		SizeLevel:-1,
		Model:'char/monster/Monshadow-1/Monshadow-1.ini',
		Sound:0x000012E0,
	],

	// Drops
	AllSeeItem:false,
	Exp:40000,
	Quantity:1,
	drops:[
		[probability:2340, code:"NULL"/* Drops nothing */],
		[probability:3000, code:"GG101", value:[330, 400]/* Gold */],
		[probability:850, code:"PL104"/* 顶级恢复生命药水 */],
		[probability:850, code:"PM104"/* 顶级恢复魔法药水 */],
		[probability:88, code:"DA110"/* 百裂铠 */],
		[probability:88, code:"DA210"/* 信徒披风 */],
		[probability:88, code:"WA108"/* 叼刚 清磐 */],
		[probability:88, code:"WC108"/* 矩记飘 府亥瘤 */],
		[probability:88, code:"WH109"/* 固萍绢扼捞飘 */],
		[probability:88, code:"WM109"/* 绊胶飘 */],
		[probability:88, code:"WP109"/* 单喉 荤捞靛 */],
		[probability:88, code:"WS110"/* 固胶飘 */],
		[probability:88, code:"WS210"/* 敲饭萍逞 家靛 */],
		[probability:88, code:"WT109"/* 酒唱能促 */],
		[probability:88, code:"DB108"/* 百战靴 */],
		[probability:88, code:"DS108"/* 赤龙焰盾 */],
		[probability:88, code:"OM109"/* 暗月 */],
		[probability:88, code:"DG108"/* 大地护手 */],
		[probability:88, code:"OA208"/* 百炼臂环 */],
		[probability:88, code:"OR111"/* 封印之戒 */],
		[probability:88, code:"OA111"/* 圣者之链 */],
		[probability:44, code:"DA111"/* 重装机铠 */],
		[probability:44, code:"DA211"/* 大法师袍 */],
		[probability:44, code:"WA109"/* 破山斧 */],
		[probability:44, code:"WC109"/* 兽之斧刃 */],
		[probability:44, code:"WH110"/* 轩辕巨锤 */],
		[probability:44, code:"WM110"/* 圣者杖 */],
		[probability:44, code:"WP110"/* 白银之枪 */],
		[probability:44, code:"WS111"/* 龙骨战弓 */],
		[probability:44, code:"WS211"/* 斩马刀 */],
		[probability:44, code:"WT110"/* 飞云标 */],
		[probability:44, code:"DB109"/* 大地靴 */],
		[probability:44, code:"DS109"/* 圣盾 */],
		[probability:44, code:"OM110"/* 蓝色星辰 */],
		[probability:44, code:"DG109"/* 神力护手 */],
		[probability:44, code:"OA209"/* 飞翼臂环 */],
		[probability:44, code:"OR112"/* 王者戒指 */],
		[probability:44, code:"OA112"/* 魔龙之心 */],
		[probability:44, code:"EC105"/* 公会卷轴 */],
		[probability:19, code:"DA112"/* 战神宝铠 */],
		[probability:19, code:"DA212"/* 红莲战袍 */],
		[probability:19, code:"WA110"/* 定神斧 */],
		[probability:19, code:"WC110"/* 九头刺蛇爪 */],
		[probability:19, code:"WH111"/* 赤冥之锤 */],
		[probability:19, code:"WM111"/* 王者杖 */],
		[probability:19, code:"WP111"/* 屠龙枪 */],
		[probability:19, code:"WS212"/* 嗜血屠魔剑 */],
		[probability:19, code:"WS112"/* 人马之辉 */],
		[probability:19, code:"WT111"/* 神标 */],
		[probability:19, code:"DB110"/* 地火战靴 */],
		[probability:19, code:"DS110"/* 宙斯盾 */],
		[probability:19, code:"OM111"/* 淬火乌晶 */],
		[probability:19, code:"DG110"/* 火云护手 */],
		[probability:19, code:"OA210"/* 百川流水臂环 */],
		[probability:19, code:"EC102"/* 回城卷 */],
		[probability:19, code:"OR113"/* 灵魂之戒 */],
		[probability:19, code:"OA113"/* 生命之链 */],
		[probability:19, code:"OS106"/* 玄风石 */],
		[probability:19, code:"OS107"/* 水晶石 */],
		[probability:19, code:"OS108"/* 虎翼石 */],
		[probability:10, code:"DA113"/* 虎刹魔铠 */],
		[probability:10, code:"DA213"/* 幽绿之眼 */],
		[probability:10, code:"WA111"/* 天阙斧 */],
		[probability:10, code:"WC111"/* 利维坦 */],
		[probability:10, code:"WH112"/* 碎星锤 */],
		[probability:10, code:"WM112"/* 审判之杖 */],
		[probability:10, code:"WP112"/* 傲天枪 */],
		[probability:10, code:"WS213"/* 双截刃 */],
		[probability:10, code:"WS113"/* 猛犸巨弩 */],
		[probability:10, code:"WT112"/* 鸩尾标 */],
		[probability:10, code:"DB111"/* 圣靴 */],
		[probability:10, code:"DS111"/* 苍穹之盾 */],
		[probability:10, code:"OM112"/* 菱晶石 */],
		[probability:10, code:"DG111"/* 黄铜护手 */],
		[probability:10, code:"OA210"/* 百川流水臂环 */],
		[probability:10, code:"EC102"/* 回城卷 */],
		[probability:10, code:"OR113"/* 灵魂之戒 */],
		[probability:10, code:"OA113"/* 生命之链 */],
		[probability:10, code:"OS107"/* 水晶石 */],
		[probability:10, code:"GP112"/* 鬼影魔神水晶 */],
		[probability:2, code:"DA114"/* 星晨宝铠 */],
		[probability:2, code:"DA214"/* 绯红之眼 */],
		[probability:2, code:"WA112"/* 奥丁斧 */],
		[probability:2, code:"WC112"/* 飞龙爪 */],
		[probability:2, code:"WH113"/* 破日锤 */],
		[probability:2, code:"WM113"/* 魔蜓杖 */],
		[probability:2, code:"WP113"/* 冥河战镰 */],
		[probability:2, code:"WS214"/* 金刚伏魔剑 */],
		[probability:2, code:"WS114"/* 爱神之翼 */],
		[probability:2, code:"WT113"/* 魔龙标 */],
		[probability:2, code:"DB112"/* 破棘之靴 */],
		[probability:2, code:"DS112"/* 暗黑盾 */],
		[probability:2, code:"OM113"/* 西法路 */],
		[probability:2, code:"DG112"/* 巨灵护手 */],
		[probability:2, code:"OA212"/* 紫焰臂环 */],
		[probability:2, code:"EC102"/* 回城卷 */],
		[probability:2, code:"OR114"/* 帝王之戒 */],
		[probability:2, code:"OA114"/* 神之庇护 */],
		[probability:2, code:"OS107"/* 水晶石 */],
		[probability:2, code:"OS108"/* 虎翼石 */],
		[probability:2, code:"GP110"/* 守护圣徒水晶 */]
	],
	drops_more:[
	]
]
