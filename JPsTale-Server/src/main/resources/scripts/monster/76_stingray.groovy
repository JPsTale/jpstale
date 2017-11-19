monster = [
	ID:'76_stingray',
	Name:'毒眼飞蛾',
	Clazz:0,// 1 BOSS
	Brood:0x00,// 0 Normal; 0x90(144) UNDEAD; 0x91 MUTANT; 0x92 DEMON; 0x93 MECHANIC;
	// Common Status
	Level:76,
	ActiveHour:0,
	RespawnGroup:[1, 1],

	Attributes:[
		Life:2000,
		// Attack Status
		Atk:[40, 50],
		AtkSpeed:8,
		Range:80,
		Rating:1400,

		// Defence Status
		Flee:480,
		Absorb:18,
		Block:0,
		DamageStunPers:60,

		// Resistance
		Earth:40,
		Fire:30,
		Ice:40,// Water
		Lighting:30,// Wind
		Poison:60,
	],

	// AI
	AI:[
		Nature:0x82,// 0x80 NATURAL; 0x81 GOOD; 0x82 EVIL
		IQ:9,
		Real_Sight:370,
		Talks:[],

		// Move Behavier
		Move_Speed:4,
		MoveRange:64,

		// Skill Behavier
		SpAttackPercetage:0,
		SkillDamage:[50, 60],
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
		ArrowPosi:[0, 25],
		ModelSize:1.2,
		UseEventModel:false,
		SizeLevel:-1,
		Model:'char/monster/stingray/stingray.ini',
		Sound:0x00001740,
	],

	// Drops
	AllSeeItem:false,
	Exp:25000,
	Quantity:1,
	drops:[
		[probability:2950, code:"NULL"/* Drops nothing */],
		[probability:1826, code:"PM104"/* 顶级恢复魔法药水 */],
		[probability:1826, code:"PM103"/* 高级恢复魔法药水 */],
		[probability:1826, code:"PM103"/* 高级恢复魔法药水 */],
		[probability:45, code:"DA109"/* 黄铜战铠 */],
		[probability:45, code:"DA209"/* 学徒披风 */],
		[probability:45, code:"WA108"/* 叼刚 清磐 */],
		[probability:45, code:"WC108"/* 矩记飘 府亥瘤 */],
		[probability:45, code:"WH109"/* 固萍绢扼捞飘 */],
		[probability:45, code:"WM109"/* 绊胶飘 */],
		[probability:45, code:"WP109"/* 单喉 荤捞靛 */],
		[probability:45, code:"WS110"/* 固胶飘 */],
		[probability:45, code:"WS210"/* 敲饭萍逞 家靛 */],
		[probability:45, code:"WT110"/* 飞云标 */],
		[probability:45, code:"DB108"/* 百战靴 */],
		[probability:45, code:"DS108"/* 赤龙焰盾 */],
		[probability:45, code:"OM109"/* 暗月 */],
		[probability:45, code:"DG108"/* 大地护手 */],
		[probability:45, code:"OA208"/* 百炼臂环 */],
		[probability:45, code:"PM103"/* 高级恢复魔法药水 */],
		[probability:45, code:"EC102"/* 回城卷 */],
		[probability:45, code:"OR109"/* 黑暗之戒 */],
		[probability:45, code:"OA109"/* 海蓝石链 */],
		[probability:45, code:"EC105"/* 公会卷轴 */],
		[probability:20, code:"DA110"/* 百裂铠 */],
		[probability:20, code:"DA210"/* 信徒披风 */],
		[probability:20, code:"WA109"/* 破山斧 */],
		[probability:20, code:"WC109"/* 兽之斧刃 */],
		[probability:20, code:"WH110"/* 轩辕巨锤 */],
		[probability:20, code:"WM110"/* 圣者杖 */],
		[probability:20, code:"WP110"/* 白银之枪 */],
		[probability:20, code:"WS111"/* 龙骨战弓 */],
		[probability:20, code:"WS211"/* 斩马刀 */],
		[probability:20, code:"WT110"/* 飞云标 */],
		[probability:20, code:"DB109"/* 大地靴 */],
		[probability:20, code:"DS109"/* 圣盾 */],
		[probability:20, code:"OM110"/* 蓝色星辰 */],
		[probability:20, code:"DG109"/* 神力护手 */],
		[probability:20, code:"OA209"/* 飞翼臂环 */],
		[probability:20, code:"PM104"/* 顶级恢复魔法药水 */],
		[probability:20, code:"EC102"/* 回城卷 */],
		[probability:20, code:"OR110"/* 伏魔戒指 */],
		[probability:20, code:"OA110"/* 镇魂铃 */],
		[probability:20, code:"EC102"/* 回城卷 */],
		[probability:20, code:"OS106"/* 玄风石 */],
		[probability:20, code:"OS106"/* 玄风石 */],
		[probability:6, code:"DA111"/* 重装机铠 */],
		[probability:6, code:"DA211"/* 大法师袍 */],
		[probability:6, code:"WA110"/* 定神斧 */],
		[probability:6, code:"WC110"/* 九头刺蛇爪 */],
		[probability:6, code:"WH111"/* 赤冥之锤 */],
		[probability:6, code:"WM111"/* 王者杖 */],
		[probability:6, code:"WP111"/* 屠龙枪 */],
		[probability:6, code:"WS112"/* 人马之辉 */],
		[probability:6, code:"WS212"/* 嗜血屠魔剑 */],
		[probability:6, code:"WT111"/* 神标 */],
		[probability:6, code:"DB110"/* 地火战靴 */],
		[probability:6, code:"DS110"/* 宙斯盾 */],
		[probability:6, code:"OM111"/* 淬火乌晶 */],
		[probability:6, code:"DG110"/* 火云护手 */],
		[probability:6, code:"OA210"/* 百川流水臂环 */],
		[probability:6, code:"PM104"/* 顶级恢复魔法药水 */],
		[probability:6, code:"EC102"/* 回城卷 */],
		[probability:6, code:"OR111"/* 封印之戒 */],
		[probability:6, code:"OA111"/* 圣者之链 */],
		[probability:6, code:"OS107"/* 水晶石 */],
		[probability:6, code:"GP109"/* 神秘水晶 */],
		[probability:6, code:"GP110"/* 守护圣徒水晶 */],
		[probability:3, code:"DA112"/* 战神宝铠 */],
		[probability:3, code:"DA212"/* 红莲战袍 */],
		[probability:3, code:"WA111"/* 天阙斧 */],
		[probability:3, code:"WC111"/* 利维坦 */],
		[probability:3, code:"WH112"/* 碎星锤 */],
		[probability:3, code:"WM112"/* 审判之杖 */],
		[probability:3, code:"WP112"/* 傲天枪 */],
		[probability:3, code:"WS113"/* 猛犸巨弩 */],
		[probability:3, code:"WS213"/* 双截刃 */],
		[probability:3, code:"WT112"/* 鸩尾标 */],
		[probability:3, code:"DB111"/* 圣靴 */],
		[probability:3, code:"DS111"/* 苍穹之盾 */],
		[probability:3, code:"OM112"/* 菱晶石 */],
		[probability:3, code:"DG111"/* 黄铜护手 */],
		[probability:3, code:"OA211"/* 玄铁臂环 */],
		[probability:3, code:"PM104"/* 顶级恢复魔法药水 */],
		[probability:3, code:"EC102"/* 回城卷 */],
		[probability:3, code:"OR112"/* 王者戒指 */],
		[probability:3, code:"OA112"/* 魔龙之心 */],
		[probability:3, code:"OS108"/* 虎翼石 */]
	],
	drops_more:[
		[probability:200, code:"DA111"/* 重装机铠 */]	]
]
