package org.jpstale.entity.item;

public interface ItemConstant {
    public final static int MAX_ITEM = 983;

    public final static int ITEMSIZE = 22; // 酒捞袍 捞固瘤狼 农扁甫 唱穿绰 蔼

    public final static int CHECK_COPY_ITEM = 1; // 汗荤酒捞袍
    public final static int CHECK_GIVE_ITEM = 2; // 刘沥侩酒捞袍

    /*---------------------------------------------*
     *			装备位置
     *----------------------------------------------*/
    public final static int INVENTORY_POS_BOX = 0x00000001;
    public final static int INVENTORY_POS_LHAND = 0x00000002;
    public final static int INVENTORY_POS_RHAND = 0x00000004;
    public final static int INVENTORY_POS_ARMOR = 0x00000008;
    public final static int INVENTORY_POS_BOOTS = 0x00000010;
    public final static int INVENTORY_POS_GLOVES = 0x00000020;
    public final static int INVENTORY_POS_LRING = 0x00000040;
    public final static int INVENTORY_POS_RRING = 0x00000080;
    public final static int INVENTORY_POS_SHELTOM = 0x00000100;
    public final static int INVENTORY_POS_AMULET = 0x00000200;
    public final static int INVENTORY_POS_ARMLET = 0x00000800;
    public final static int INVENTORY_POS_TWO_HAND = 0x00001000;
    public final static int INVENTORY_POS_POTION = 0x00002000;

    /*---------------------------------------------*
     *			装备类型
     *----------------------------------------------*/

    public final static int ITEM_CLASS_WEAPON_ONE = INVENTORY_POS_RHAND;
    public final static int ITEM_CLASS_WEAPON_TWO = (INVENTORY_POS_RHAND | INVENTORY_POS_LHAND);
    public final static int ITEM_CLASS_ARMOR = INVENTORY_POS_ARMOR;
    public final static int ITEM_CLASS_BOOTS = INVENTORY_POS_BOOTS;
    public final static int ITEM_CLASS_GLOVES = INVENTORY_POS_GLOVES;
    public final static int ITEM_CLASS_SHIELDS = INVENTORY_POS_LHAND;
    public final static int ITEM_CLASS_RING = (INVENTORY_POS_LRING | INVENTORY_POS_RRING);
    public final static int ITEM_CLASS_SHELTOM = INVENTORY_POS_SHELTOM;
    public final static int ITEM_CLASS_AMULET = INVENTORY_POS_AMULET;
    public final static int ITEM_CLASS_ARMLET = INVENTORY_POS_ARMLET;
    public final static int ITEM_CLASS_MAGICIAL_STUFFS = INVENTORY_POS_LHAND;
    public final static int ITEM_CLASS_POTION = INVENTORY_POS_POTION;
    public final static int ITEM_CLASS_ECORE = INVENTORY_POS_BOX;
    public final static int ITEM_CLASS_QUEST = INVENTORY_POS_BOX;
    public final static int ITEM_CLASS_FORCEORB = INVENTORY_POS_BOX;
    public final static int ITEM_CLASS_SEEL = INVENTORY_POS_BOX;

    // 武器类型
    public final static int ITEM_WEAPONCLASS_NOT_SHOOTING = 1; // 辟立屈
    public final static int ITEM_WEAPONCLASS_SHOOTING = 2; // 惯荤屈
    public final static int ITEM_WEAPONCLASS_CASTING = 3; // 过荤屈

    // 武器编类型编码
    /*---------------------------------------------*
     *			武器类型编码				    
     *----------------------------------------------*/
    public final static int sinWA1 = 0x01010000;// Axes
    public final static int sinWC1 = 0x01020000;// Claws
    public final static int sinWH1 = 0x01030000;// Hammer & So On
    public final static int sinWM1 = 0x01040000;// Magicial Stuffs
    public final static int sinWP1 = 0x01050000;// Poles & Spears
    public final static int sinWS1 = 0x01060000;// Shooters
    public final static int sinWS2 = 0x01070000;// Swords
    public final static int sinWT1 = 0x01080000;// Throwing Arms

    /*---------------------------------------------*
     *			防具类型编码			    
     *----------------------------------------------*/
    public final static int sinDA1 = 0x02010000;// Armor
    public final static int sinDB1 = 0x02020000;// Boots
    public final static int sinDG1 = 0x02030000;// Gloves
    public final static int sinDS1 = 0x02040000;// Shields
    public final static int sinDA2 = 0x02050000;// Armor

    /*---------------------------------------------*
     *			护身符、戒指、石头、臂环等编码
     *----------------------------------------------*/

    public final static int sinOA1 = 0x03010000;// Amulet
    public final static int sinOA2 = 0x03020000;// Armlet
    public final static int sinOM1 = 0x03030000;// Magicial Stuffs
    public final static int sinOR1 = 0x03040000;// Ring
    public final static int sinOR2 = 0x03050000;// Ring2
    public final static int sinOS1 = 0x02350000;// Sheltom
    public final static int sinFO1 = 0x03060000;// Force Orb
    public final static int sinSE1 = 0x03070000;// Seel
    public final static int sinPR1 = 0x03080000;// 堡籍 pluto
    public final static int sinPR2 = 0x03090000;// 荐沥 pluto
    public final static int sinPR3 = 0x03100000;// 烽(A) pluto
    public final static int sinPR4 = 0x03110000;// 烽(B) pluto
    /*---------------------------------------------*
     *			药剂类型编码
     *----------------------------------------------*/
    public final static int sinPM1 = 0x04010000;// Mana
    public final static int sinPL1 = 0x04020000;// Life
    public final static int sinPS1 = 0x04030000;// Stamina

    /*---------------------------------------------*
     *			经济类型编码
     *----------------------------------------------*/
    public final static int sinGG1 = 0x05010000; // Gold
    public final static int sinBS1 = 0x05020000; // 骇扼配胶沛

    /*---------------------------------------------*
     *			卷轴类型编码
     *----------------------------------------------*/
    public final static int sinEC1 = 0x06010000;

    /*---------------------------------------------*
     *			 任务物品类型编码
     *----------------------------------------------*/

    public final static int sinQT1 = 0x07010000;

    /*---------------------------------------------*
     *			  商城物品类型编码
     *----------------------------------------------*/
    public final static int sinSP1 = 0x08010000;
    public final static int sinGP1 = 0x08020000; // 0x09010000 栏肺窍聪 巩力捞匙 弊妨..
                                                 // (& sinITEM_MASK2 啊 救冈澜)
    public final static int sinQW1 = 0x08030000; // 况橇霸捞飘 喇
    public final static int sinGF1 = 0x08040000; // 喊惑前鼻
    public final static int sinPZ1 = 0x08060000; // 酒贸 欺榴
    public final static int sinPZ2 = 0x08070000; // 欧龋乔 欺榴
    public final static int sinCH1 = 0x08080000; // 惯坊鸥牢单捞 檬妮房
    public final static int sinSD2 = 0x08090000; // Sod2 惯积 酒捞袍
    public final static int sinBC1 = 0x080A0000; // 傍己傈 惯积 酒捞袍
    public final static int sinBI1 = 0x080B0000; // 蜡丰备概 酒捞袍
    public final static int sinBI2 = 0x080C0000; // 蜡丰备概 酒捞袍(菩虐瘤 某浆 酒捞袍 )
    public final static int sinGP2 = 0x080D0000; // 厘喊 - 家匡胶沛

    /*---------------------------------------------*
     *			  Make Item
     *----------------------------------------------*/
    public final static int sinMA1 = 0x09010000;
    public final static int sinMA2 = 0x09020000;

    /*---------------------------------------------*
     *			  力累 犁丰 酒捞袍
     *----------------------------------------------*/
    public final static int sinWR1 = 0x0A010000; // 公备 饭矫乔
    public final static int sinDR1 = 0x0A020000; // 癌林 饭矫乔

    public final static int EXTREME_RECIPE = 1; // 镭囚柳 饭矫乔
    public final static int ANCIENT_RECIPE = 2; // 绊措狼 饭矫乔
    public final static int MINOTAUR_RECIPE = 3; // 措瘤狼 饭矫乔
    public final static int DOOM_RECIPE = 4; // 绢狄狼 饭矫乔
    public final static int SALAMANDER_RECIPE = 5; // 拳疙狼 饭矫乔
    public final static int WYVERN_RECIPE = 6; // 官恩狼 饭矫乔
    public final static int PHOENIX_RECIPE = 7; // 怕剧狼 饭矫乔
    public final static int FRENZY_RECIPE = 8; // 堡器茄 饭矫乔
    public final static int HEAVENS_RECIPE = 9; // 玫惑狼 饭矫乔
    public final static int SNOW_RECIPE = 10; // 器汲狼 饭矫乔
    public final static int MEMORY_RECIPE = 11; // 扁撅狼 饭矫乔 // 厘喊 - 措厘厘捞狼 去

    /*---------------------------------------------*
     *			装备序号
     *----------------------------------------------*/
    public final static int sin00 = 0x00000000;
    public final static int sin01 = 0x00000100;
    public final static int sin02 = 0x00000200;
    public final static int sin03 = 0x00000300;
    public final static int sin04 = 0x00000400;
    public final static int sin05 = 0x00000500;
    public final static int sin06 = 0x00000600;
    public final static int sin07 = 0x00000700;
    public final static int sin08 = 0x00000800;
    public final static int sin09 = 0x00000900;
    public final static int sin10 = 0x00000A00;
    public final static int sin11 = 0x00000B00;
    public final static int sin12 = 0x00000C00;
    public final static int sin13 = 0x00000D00;
    public final static int sin14 = 0x00000E00;
    public final static int sin15 = 0x00000F00;
    public final static int sin16 = 0x00001000;
    public final static int sin17 = 0x00001100;
    public final static int sin18 = 0x00001200;
    public final static int sin19 = 0x00001300;
    public final static int sin20 = 0x00001400;
    public final static int sin21 = 0x00001500;
    public final static int sin22 = 0x00001600;
    public final static int sin23 = 0x00001700;
    public final static int sin24 = 0x00001800;
    public final static int sin25 = 0x00001900;
    public final static int sin26 = 0x00002A00;
    public final static int sin27 = 0x00002B00;
    public final static int sin28 = 0x00002C00;
    public final static int sin29 = 0x00002D00;
    public final static int sin30 = 0x00002E00;
    public final static int sin31 = 0x00002F00;
    public final static int sin32 = 0x00003000;
    public final static int sin33 = 0x00003100;
    public final static int sin34 = 0x00003200;
    public final static int sin35 = 0x00003300;
    public final static int sin36 = 0x00003400;
    public final static int sin37 = 0x00003500;
    public final static int sin38 = 0x00003600;
    public final static int sin39 = 0x00003700;
    public final static int sin40 = 0x00003800;
    public final static int sin41 = 0x00003900;
    public final static int sin42 = 0x00003A00;
    public final static int sin43 = 0x00003B00;
    public final static int sin44 = 0x00003C00;
    public final static int sin45 = 0x00003D00;
    public final static int sin46 = 0x00003E00;
    public final static int sin47 = 0x00003F00;
    public final static int sin48 = 0x00004000;
    public final static int sin49 = 0x00004100;
    public final static int sin50 = 0x00004200;
    public final static int sin51 = 0x00004300;
    public final static int sin52 = 0x00004400;
    public final static int sin53 = 0x00004500;
    public final static int sin54 = 0x00004600;
    public final static int sin55 = 0x00004700;
    public final static int sin56 = 0x00004800;
    public final static int sin57 = 0x00004900;
    public final static int sin58 = 0x00004A00;
    public final static int sin59 = 0x00004B00;
    public final static int sin60 = 0x00004C00;
    public final static int sin61 = 0x00004D00;
    public final static int sin62 = 0x00004E00;
    public final static int sin63 = 0x00004F00;
    public final static int sin64 = 0x00005000;
    public final static int sin65 = 0x00005100;
    public final static int sin66 = 0x00005200;
    public final static int sin67 = 0x00005300;
    public final static int sin68 = 0x00005400;
    public final static int sin69 = 0x00005500;
    public final static int sin70 = 0x00005600;
    public final static int sin71 = 0x00005700;
    public final static int sin72 = 0x00005800;
    public final static int sin73 = 0x00005900;
    public final static int sin74 = 0x00005A00;
    public final static int sin75 = 0x00005B00;
    public final static int sin76 = 0x00005C00;
    public final static int sin77 = 0x00005D00;
    public final static int sin78 = 0x00005E00;
    public final static int sin79 = 0x00005F00;
    public final static int sin80 = 0x00006000;
    public final static int sin81 = 0x00006100;
    public final static int sin82 = 0x00006200;
    public final static int sin83 = 0x00006300;
    public final static int sin84 = 0x00006400;
    public final static int sin85 = 0x00006500;
    public final static int sin86 = 0x00006600;
    public final static int sin87 = 0x00006700;
    public final static int sin88 = 0x00006800;
    public final static int sin89 = 0x00006900;
    public final static int sin90 = 0x00006A00;
    public final static int sin91 = 0x00006B00;
    public final static int sin92 = 0x00006C00;
    public final static int sin93 = 0x00006D00;
    public final static int sin94 = 0x00006E00;
    public final static int sin95 = 0x00006F00;
    public final static int sin96 = 0x00007000;
    public final static int sin97 = 0x00007100;
    public final static int sin98 = 0x00007200;

    /** 元素抗性编码 **/
    public final static int ITEMINFO_BIONIC = 0; // 积眉
    public final static int ITEMINFO_EARTH = 1; // 措磊楷
    public final static int ITEMINFO_FIRE = 2; // 阂
    public final static int ITEMINFO_ICE = 3; // 趁扁
    public final static int ITEMINFO_LIGHTING = 4; // 锅俺
    public final static int ITEMINFO_POISON = 5; // 刀
    public final static int ITEMINFO_WATER = 6; // 拱
    public final static int ITEMINFO_WIND = 7; // 官恩
    public final static int ITEMINFO_NONE = 15; // 加己 公矫

    // ////////* 酒捞袍 辆幅 *////////
    public final static int ITEM_KIND_NORMAL = 0; // 扁夯 酒捞袍
    public final static int ITEM_KIND_CRAFT = 1; // 炼钦 酒捞袍
    public final static int ITEM_KIND_AGING = 2; // 俊捞隆 酒捞袍
    public final static int ITEM_KIND_QUEST = 3; // 涅胶飘侩 酒捞袍
    public final static int ITEM_KIND_EVENT = 4; // 捞亥飘 酒捞袍
    public final static int ITEM_KIND_MAKE_MAIN = 5; // 捞亥飘 酒捞袍
    public final static int ITEM_KIND_MAKE_ELEMENT = 6; // 捞亥飘 酒捞袍
    public final static int ITEM_KIND_QUEST_WEAPON = 7; // 捞亥飘 酒捞袍
    public final static int ITEM_KIND_SPECIAL = 8; // SpecialItemFlag[1] 俊
                                                   // 敲发殿废矫 胶其既酒捞袍栏肺 备盒
    /*---------------------------------------------*
    *			物品音效编码
    *----------------------------------------------*/
    public final static int SIN_SOUND_AXES = 1;
    public final static int SIN_SOUND_CLAWS = 2;
    public final static int SIN_SOUND_HAMMER = 3;
    public final static int SIN_SOUND_MAGICIAL = 4;
    public final static int SIN_SOUND_POLES = 5;
    public final static int SIN_SOUND_SHOOTERS = 6;
    public final static int SIN_SOUND_SWORDS = 7;
    public final static int SIN_SOUND_THROWING = 8;
    public final static int SIN_SOUND_ARMOR = 9;
    public final static int SIN_SOUND_BOOTS = 10;
    public final static int SIN_SOUND_GLOVES = 11;
    public final static int SIN_SOUND_SHIELDS = 12;
    public final static int SIN_SOUND_AMULET = 13;
    public final static int SIN_SOUND_Armlet = 14;
    public final static int SIN_SOUND_RING = 15;
    public final static int SIN_SOUND_SHELTOM = 16;
    public final static int SIN_SOUND_POTION = 17;
    public final static int SIN_SOUND_COIN = 18;
    public final static int SIN_SOUND_STAFF = 19;
    public final static int SIN_SOUND_EAT_POTION = 20;
    public final static int SIN_SOUND_SHOW_INTER = 21;
    public final static int SIN_SOUND_REPAIR_ITEM = 22;
    public final static int SIN_SOUND_FAILD_MIXITEM = 23;
    public final static int SIN_SOUND_ARMOR2 = 24;
    public final static int SIN_SOUND_EAT_POTION2 = 25;

    /*----------------------------------------------------------------------------*
     *	              所有物品数据
     *-----------------------------------------------------------------------------*/
    Item itemDataBase[] = {

            /*-------------------*
             *	(Weapon)					  	
             *--------------------*/
            // Axe A1
            new Item(sinWA1 | sin01, "Stone Axe", "WA101", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WA101", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin02, "Steel Axe", "WA102", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WA102", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin03, "Battle Axe", "WA103", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WA103", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin04, "War Axe", "WA104", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WA104", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin05, "DoubleSidedWarAxe", "WA105", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WA105", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin06, "Bat Axe", "WA106", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WA106", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin07, "Mechanic Axe", "WA107", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WA107", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin08, "Double Head Axe", "WA108", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WA108", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin09, "Great Axe", "WA109", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WA109", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin10, "Diamond Axe", "WA110", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WA110", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin11, "Jagged Axe", "WA111", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WA111", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin12, "Cleaver", "WA112", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WA112", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin13, "Gigantifc Axe", "WA113", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WA113", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin14, "ChaosAxe", "WA114", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WA114", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin15, "SinBaRam Axe", "WA115", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WA115", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin16, "Fury Axe", "WA116", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WA116", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin17, "Ancient Axe", "WA117", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WA117", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin18, "Chaos Axe", "WA118", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WA118", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin19, "Relic Axe", "WA119", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WA119", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin20, "Minotaur Axe", "WA120", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WA120", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin21, "Wyvern Axe", "WA121", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WA121", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin22, "Zecram Axe", "WA122", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WA122", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWA1 | sin23, "Dragon Axe", "WA123", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WA123", INVENTORY_POS_RHAND, SIN_SOUND_AXES, ITEM_WEAPONCLASS_NOT_SHOOTING),

            // Claws C1
            new Item(sinWC1 | sin01, "Eagle Claw", "WC101", ITEMSIZE * 1, ITEMSIZE * 2, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WC101", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin02, "Tiger Claw", "WC102", ITEMSIZE * 1, ITEMSIZE * 2, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WC102", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin03, "Griffin Claw", "WC103", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC103", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin04, "Eagle Claw", "WC104", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WC104", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin05, "Eagle Claw", "WC105", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WC105", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin06, "Fingered Edge", "WC106", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC106", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin07, "Hand Blade", "WC107", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WC107", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin08, "Pharaoh", "WC108", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WC108", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin09, "Brutal Claw", "WC109", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC109", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin10, "Hydra Claw", "WC110", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WC110", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin11, "Leviathan", "WC111", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WC111", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin12, "Wyvern Claw", "WC112", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC112", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin13, "Chaos Claw", "WC113", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WC113", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin14, "Titan Claw", "WC114", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WC114", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin15, "SinBaRam Claw", "WC115", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC115", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin16, "Titan Talon", "WC116", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC116", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin17, "Salamander Talon", "WC117", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC117", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin18, "Phoenix Talon", "WC118", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC118", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin19, "Chimera Talon", "WC119", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC119", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin20, "Extreme Talon", "WC120", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC120", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin21, "Viper Talon", "WC121", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC121", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin22, "Injustice Talon", "WC122", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC122", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWC1 | sin23, "Heretic Talon", "WC123", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WC123", INVENTORY_POS_RHAND, SIN_SOUND_CLAWS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),

            // Hammer & So On H1
            new Item(sinWH1 | sin01, "Club", "WH101", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WH101", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin02, "War Mac", "WH102", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WH102", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin03, "Pole Mace", "WH103", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WH103", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin04, "Gothic Mace", "WH104", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WH104", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin05, "War Hammer", "WH105", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WH105", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin06, "Metal Hammer", "WH106", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WH106", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin07, "Cross Hammer", "WH107", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WH107", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin08, "Holy Hammer", "WH108", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WH108", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin09, "Star", "WH109", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WH109", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin10, "Maximum", "WH110", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WH110", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin11, "Meditaition", "WH111", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WH111", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin12, "Rune Hammer", "WH112", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WH112", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin13, "Solar", "WH113", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WH113", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin14, "War Maul", "WH114", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WH114", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin15, "Titan Maul", "WH115", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WH115", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin16, "SinBaRam Mace", "WH116", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WH116", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin17, "Brutal Hammer", "WH117", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WH117", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin18, "Gladiator Hammer", "WH118", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WH118", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin19, "Archon Hammer", "WH119", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WH119", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin20, "Justice Hammer", "WH120", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WH120", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin21, "Dragon Bone Hammer", "WH121", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WH121", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin22, "Guardian Hammer", "WH122", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WH122", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin23, "Bane Hammer", "WH123", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WH123", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWH1 | sin24, "Dragon Hammer", "WH124", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WH124", INVENTORY_POS_RHAND, SIN_SOUND_HAMMER,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),

            // Wand -_-;
            new Item(sinWM1 | sin01, "Wand", "WM101", ITEMSIZE * 1, ITEMSIZE * 2, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WM101", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin02, "Sphere Wand", "WM102", ITEMSIZE * 1, ITEMSIZE * 2, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WM102", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin03, "Obi Wand", "WM103", ITEMSIZE * 1, ITEMSIZE * 2, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WM103", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin04, "Root Staff", "WM104", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WM104", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin05, "Poly Staff", "WM105", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WM105", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin06, "Elven Wand", "WM106", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WM106", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin07, "Dryad Wand", "WM107", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WM107", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin08, "Meditaion Staff", "WM108", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WM108", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin09, "Skull Staff", "WM109", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WM109", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin10, "Mage Staff", "WM110", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WM110", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin11, "Faith Wand", "WM111", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WM111", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin12, "Lofty Staff", "WM112", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WM112", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin13, "Arch Wand", "WM113", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WM113", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin14, "Chaos Staff", "WM114", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WM114", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin15, "Dragon Staff", "WM115", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WM115", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin16, "SinBaRam Staff", "WM116", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WM116", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin17, "Apostle Wand", "WM117", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WM117", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin18, "Relic Staff", "WM118", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WM118", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin19, "Dragon Staff", "WM119", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WM119", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin20, "Wyvern Wand", "WM120", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WM120", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin21, "Gothic Staff", "WM121", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WM121", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin22, "Oracle Wand", "WM122", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WM122", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin23, "Celestial Staff", "WM123", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WM123", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),
            new Item(sinWM1 | sin24, "Astral Staff", "WM124", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WM124", INVENTORY_POS_RHAND, SIN_SOUND_STAFF, ITEM_WEAPONCLASS_CASTING),

            // Poles & Spears P1
            new Item(sinWP1 | sin01, "Pole", "WP101", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WP101", INVENTORY_POS_RHAND, SIN_SOUND_POLES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin02, "Spear", "WP102", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WP102", INVENTORY_POS_RHAND, SIN_SOUND_POLES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin03, "Bill", "WP103", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WP103", INVENTORY_POS_RHAND, SIN_SOUND_POLES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin04, "Halberd", "WP104", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WP104", INVENTORY_POS_RHAND, SIN_SOUND_POLES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin05, "Horn Scythe", "WP105", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP105", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin06, "Trident", "WP106", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WP106", INVENTORY_POS_RHAND, SIN_SOUND_POLES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin07, "Enriched Scythe", "WP107", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP107", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin08, "Double Scythe", "WP108", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP108", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin09, "Evil Scythe", "WP109", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP109", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin10, "Silver Bird", "WP110", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP110", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin11, "Chaos Spear", "WP111", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP111", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin12, "Titan Spear", "WP112", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP112", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin13, "Styx Scythe", "WP113", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP113", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin14, "Dragon's Wing", "WP114", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP114", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin15, "Rage", "WP115", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WP115", INVENTORY_POS_RHAND, SIN_SOUND_POLES, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin16, "SinBaRam Darkness", "WP116", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP116", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin17, "Hyper Scythe", "WP117", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP117", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin18, "Oracle Spear", "WP118", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP118", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin19, "Immortal Scythe", "WP119", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP119", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin20, "Extreme Spear", "WP120", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP120", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin21, "Hellfire Scythe", "WP121", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP121", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin22, "Dreadnaught Spear", "WP122", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP122", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin23, "Reaper Scythe", "WP123", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP123", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWP1 | sin24, "Dragon Scythe", "WP124", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WP124", INVENTORY_POS_RHAND, SIN_SOUND_POLES,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),

            // Shooters S1
            new Item(sinWS1 | sin01, "Short Bow", "WS101", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS101", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin02, "Horned Bow", "WS102", ITEMSIZE * 2, ITEMSIZE * 2, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WS102", INVENTORY_POS_RHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin03, "Hand CrossBow", "WS103", ITEMSIZE * 2, ITEMSIZE * 2, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS103", INVENTORY_POS_RHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin04, "CrossBow", "WS104", ITEMSIZE * 3, ITEMSIZE * 2, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS104", INVENTORY_POS_RHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin05, "Battle Bow", "WS105", ITEMSIZE * 2, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS105", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin06, "Great Bow", "WS106", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS106", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin07, "War Bow", "WS107", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS107", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin08, "Great CrossBow", "WS108", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS108", INVENTORY_POS_RHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin09, "MetalHandCrossBow", "WS109", ITEMSIZE * 2, ITEMSIZE * 2, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS109", INVENTORY_POS_RHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin10, "Double CrossBow", "WS110", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS110", INVENTORY_POS_RHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin11, "Bone Bow", "WS111", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS111", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin12, "Sagittarius", "WS112", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS112", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin13, "Ancient CrossBow", "WS113", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS113", INVENTORY_POS_RHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin14, "Titan Bow", "WS114", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS114", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin15, "Chaos Bow", "WS115", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS115", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin16, "Dragon Bow", "WS116", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS116", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin17, "SinBaRam CrossBow", "WS117", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS117", INVENTORY_POS_RHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin18, "Minotaur Bow", "WS118", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS118", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin19, "Wave Bow", "WS119", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS119", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin20, "Grande Bow", "WS120", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS120", INVENTORY_POS_RHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin21, "Dragon Bow", "WS121", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS121", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin22, "Revenge Bow", "WS122", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS122", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin23, "Wyvern Bow", "WS123", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS123", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin24, "Immortal Bow", "WS124", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS124", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS1 | sin25, "Salamander Bow", "WS125", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS125", INVENTORY_POS_LHAND, SIN_SOUND_SHOOTERS, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWS2 | sin26, "Mirage Sword", "WS226", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS226", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),

            // Swords
            new Item(sinWS2 | sin01, "Dagger", "WS201", ITEMSIZE * 1, ITEMSIZE * 2, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WS201", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin02, "Celtic Dagger", "WS202", ITEMSIZE * 1, ITEMSIZE * 2, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS202", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin03, "SwordBreaker", "WS203", ITEMSIZE * 1, ITEMSIZE * 2, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS203", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin04, "Short Sword", "WS204", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS204", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin05, "Long Sword", "WS205", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_TWO,
                    "WS205", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin06, "Broad Sword", "WS206", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS206", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin07, "Blade", "WS207", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WS207", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin08, "Templar Sword", "WS208", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS208", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin09, "Shield Sword", "WS209", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS209", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin10, "Plated Sword", "WS210", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS210", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin11, "Claymore", "WS211", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WS211", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin12, "Slayer", "WS212", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WS212", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin13, "Gigantic Sword", "WS213", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS213", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin14, "HighLander", "WS214", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WS214", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS, ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin15, "Bastard Sword", "WS215", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS215", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin16, "TItan Sword", "WS216", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS216", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin17, "Chaos Sword", "WS217", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS217", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin18, "SinBaRam Sword", "WS218", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS218", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin19, "Salamanger Sword", "WS219", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS219", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin20, "Avenger Sword", "WS220", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS220", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin21, "Titan Sword", "WS221", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS221", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin22, "Wyvern Sword", "WS222", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS222", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin23, "Immortal Sword", "WS223", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS223", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin24, "Justice Sword", "WS224", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS224", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin25, "Extreme Sword", "WS225", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_TWO, "WS225", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),
            new Item(sinWS2 | sin51, "Memorial Blade", "WS251", ITEMSIZE * 2, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WS251", INVENTORY_POS_RHAND, SIN_SOUND_SWORDS,
                    ITEM_WEAPONCLASS_NOT_SHOOTING),

            // Throwing Arms T1
            new Item(sinWT1 | sin01, "Javelin", "WT101", ITEMSIZE * 1, ITEMSIZE * 3, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WT101", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin02, "War Javelin", "WT102", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT102", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin03, "Edged Javelin", "WT103", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT103", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin04, "Steel Javelin", "WT104", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT104", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin05, "Double Javelin", "WT105", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT105", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin06, "Elven Javelin", "WT106", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT106", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin07, "Fatal Javelin", "WT107", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT107", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin08, "Metal Javelin", "WT108", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT108", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin09, "Cobra", "WT109", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon", ITEM_CLASS_WEAPON_ONE,
                    "WT109", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin10, "Winged Javelin", "WT110", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT110", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin11, "Holy Javelin", "WT111", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT111", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin12, "Throwing Trident", "WT112", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT112", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin13, "Wyvern Javelin", "WT113", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT113", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin14, "Twisted Javelin", "WT114", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT114", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin15, "Linked Javelin", "WT115", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT115", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin16, "SinBaRam Javelin", "WT116", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT116", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin17, "Mystic Javelin", "WT117", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT117", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin18, "Extreme Javelin", "WT118", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT118", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin19, "Dragon Javelin", "WT119", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT119", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin20, "Spike Javelin", "WT120", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT120", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin21, "Salamander Javelin", "WT121", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT121", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin22, "Immortal Javelin", "WT122", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT122", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin23, "Heretic Javelin", "WT123", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT123", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),
            new Item(sinWT1 | sin24, "Salamander Javelin", "WT124", ITEMSIZE * 1, ITEMSIZE * 4, "Weapon",
                    ITEM_CLASS_WEAPON_ONE, "WT124", INVENTORY_POS_RHAND, SIN_SOUND_THROWING, ITEM_WEAPONCLASS_SHOOTING),

            /*------------------------*
             * 	 (Amulet, Ring .. )					  	
             *-------------------------*/
            // Amulet A1
            new Item(sinOA1 | sin01, "Round Amulet ", "OA101", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa101", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin02, "Round Amulet #1", "OA102", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa102", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin03, "Round Amulet #2", "OA103", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa103", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin04, "Round Amulet #3", "OA104", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa104", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin05, "Gem Amulet ", "OA105", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_AMULET,
                    "oa105", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin06, "Gem Amulet #1", "OA106", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa106", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin07, "Gem Amulet #2", "OA107", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa107", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin08, "Gem Amulet #3", "OA108", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa108", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin09, "Magic Amulet ", "OA109", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa109", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin10, "Magic Amulet #1", "OA110", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa110", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin11, "Magic Amulet #2", "OA111", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa111", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin12, "Magic Amulet #3", "OA112", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa112", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin13, "Rune Amulet ", "OA113", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa113", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin14, "Rune Amulet #1", "OA114", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa114", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin15, "Rune Amulet #2", "OA115", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa115", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin16, "Rune Amulet #3", "OA116", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa116", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin17, "Sealed Amulet ", "OA117", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa117", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin18, "Sealed Amulet #1", "OA118", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa118", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin19, "Sealed Amulet #2", "OA119", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa119", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin20, "Sealed Amulet #3", "OA120", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa120", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin21, "Mystic Amulet", "OA121", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa121", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin22, "Mystic Amulet +1", "OA122", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa122", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin30, "Kelvezu Amulet", "OA130", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa130", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin32, "Santa Amulet", "OA132", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa132", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin33, "Event Amulet", "OA133", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa133", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin34, "Event Amulet(1H)", "OA134", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa133", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin35, "Event Amulet(1Day)", "OA135", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa133", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin36, "Snowflower Amulet(7Day)", "OA136", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa136", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin37, "Heart Amulet(7Day)", "OA137", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa137", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin38, "ChickSoup Amulet", "OA138", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa138", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin39, "Muffin Amulet", "OA139", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa139", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin40, "Sliver Amulet", "OA140", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa140", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin41, "Metron Amulet", "OA141", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa141", 0, SIN_SOUND_AMULET),
            new Item(sinOA1 | sin42, "Grotesque Amulet", "OA142", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_AMULET, "oa142", 0, SIN_SOUND_AMULET),

            // Armlet A2
            new Item(sinOA2 | sin01, "Leather Armlets", "OA201", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa201", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin02, "Long Armlets", "OA202", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa202", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin03, "Wide Armlets", "OA203", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa203", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin04, "Fold Armlets", "OA204", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa204", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin05, "Scale Armlets", "OA205", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa205", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin06, "Elven Armlets", "OA206", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa206", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin07, "Solid Armlets", "OA207", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa207", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin08, "Mechanic Armlets", "OA208", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa208", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin09, "Winged Armlets", "OA209", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa209", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin10, "Great Bracelet", "OA210", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa210", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin11, "Steel Bracelet", "OA211", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa211", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin12, "Magicial Bracelet", "OA212", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa212", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin13, "Spiked Bracelet", "OA213", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa213", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin14, "Justice Bracelet", "OA214", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa214", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin15, "Minotaur Bracelet", "OA215", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa215", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin16, "Metal Bracelet", "OA216", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa216", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin17, "Titan Bracelet", "OA217", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa217", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin18, "Saint Bracelet", "OA218", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa218", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin19, "Wyvern Bracelet", "OA219", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa219", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin20, "Dragon Bracelet", "OA220", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa220", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin21, "Inferno Bracelets", "OA221", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa221", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin22, "Phoenix Bracelets", "OA222", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa222", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin23, "Frenzy Bracelets", "OA223", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_ARMLET, "oa223", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin31, "Super Armlets(7Day)", "OA231", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa231", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin32, "Super Armlets(30Day)", "OA232", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa232", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin33, "Super Armlets(1Day)", "OA233", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa233", 0, SIN_SOUND_Armlet),
            new Item(sinOA2 | sin34, "Super Armlets(1H)", "OA234", ITEMSIZE * 2, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_ARMLET, "oa234", 0, SIN_SOUND_Armlet),

            // Magicial Stuffs M1
            new Item(sinOM1 | sin01, "Pearl Beads", "OM101", ITEMSIZE * 1, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om101", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin02, "Crystal Sphere", "OM102", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om102", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin03, "Prizm Sphere", "OM103", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om103", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin04, "Bone Beads", "OM104", ITEMSIZE * 1, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om104", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin05, "Skull Beads", "OM105", ITEMSIZE * 1, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om105", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin06, "Orb", "OM106", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om106", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin07, "Holy Orb", "OM107", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om107", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin08, "Arch Orb", "OM108", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om108", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin09, "Dark Moon", "OM109", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om109", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin10, "Ceremonial Sphere", "OM110", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om110", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin11, "Orbital Beads", "OM111", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om111", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin12, "Harmony Sphere", "OM112", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om112", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin13, "Angel", "OM113", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om113", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin14, "Lucifer", "OM114", ITEMSIZE * 1, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om114", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin15, "Astral Orb", "OM115", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om115", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin16, "Rune Beads", "OM116", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om116", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin17, "Creation Orb", "OM117", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om117", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin18, "Mundane", "OM118", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om118", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin19, "Salamander Beads", "OM119", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om119", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin20, "Cosmos", "OM120", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om120", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin21, "Wyvern Orb", "OM121", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om121", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin22, "Ebony Manes", "OM122", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om122", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin23, "Avernus Beads", "OM123", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om123", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),
            new Item(sinOM1 | sin24, "Malice Rosary", "OM124", ITEMSIZE * 2, ITEMSIZE * 2, "Accessory",
                    ITEM_CLASS_MAGICIAL_STUFFS, "om124", INVENTORY_POS_LHAND, SIN_SOUND_MAGICIAL),

            // Ring R1
            new Item(sinOR1 | sin01, "Round Ring ", "OR101", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or101", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin02, "Round Ring #1", "OR102", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or102", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin03, "Round Ring #2", "OR103", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or103", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin04, "Round Ring #3", "OR104", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or104", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin05, "Gem RIng ", "OR105", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or105", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin06, "Gem RIng #1", "OR106", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or106", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin07, "Gem RIng #2", "OR107", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or107", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin08, "Gem RIng #3", "OR108", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or108", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin09, "Magic Ring ", "OR109", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or109", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin10, "Magic Ring #1", "OR110", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or110", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin11, "Magic Ring #2", "OR111", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or111", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin12, "Magic Ring #3", "OR112", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or112", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin13, "Rune Ring ", "OR113", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or113", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin14, "Rune Ring #1", "OR114", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or114", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin15, "Rune Ring #2", "OR115", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or115", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin16, "Rune Ring #3", "OR116", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or116", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin17, "Sealed Ring ", "OR117", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or117", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin18, "Sealed Ring #1", "OR118", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or118", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin19, "Sealed Ring #2", "OR119", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or119", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin20, "Sealed Ring #3", "OR120", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or120", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin21, "Mystic Ring", "OR121", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or121", 0, SIN_SOUND_RING),
            new Item(sinOR1 | sin22, "Mystic Ring +1", "OR122", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or122", 0, SIN_SOUND_RING),

            // Sheltom S1
            new Item(sinOS1 | sin01, "Lucidy", "OS101", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os101", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin02, "Sereno", "OS102", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os102", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin03, "Fadeo", "OS103", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os103", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin04, "Sparky", "OS104", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os104", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin05, "Raident", "OS105", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os105", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin06, "Transparo", "OS106", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os106", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin07, "Murky", "OS107", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os107", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin08, "Devine", "OS108", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os108", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin09, "Celesto", "OS109", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os109", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin10, "Mirage", "OS110", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os110", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin11, "Inferna", "OS111", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os111", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin12, "Enigma", "OS112", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os112", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin13, "Bellum", "OS113", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os113", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin14, "Ordo", "OS114", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os114", 0, SIN_SOUND_SHELTOM),

            //
            new Item(sinOS1 | sin21, "Magic Lucidy", "OS121", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os101", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin22, "Magic Sereno", "OS122", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os102", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin23, "Magic Fadeo", "OS123", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os103", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin24, "Magic Sparky", "OS124", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os104", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin25, "Magic Raident", "OS125", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os105", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin26, "Magic Transparo", "OS126", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os106", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin27, "Magic Murky", "OS127", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os107", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin28, "Magic Devine", "OS128", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os108", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin29, "Magic Celesto", "OS129", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os109", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin30, "Magic Mirage", "OS130", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os110", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin31, "Magic Inferna", "OS131", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os111", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin32, "Magic Enigma", "OS132", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os112", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin33, "Magic Bellum", "OS133", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_SHELTOM, "os113", 0, SIN_SOUND_SHELTOM),
            new Item(sinOS1 | sin34, "Magic Ordo", "OS134", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SHELTOM,
                    "os114", 0, SIN_SOUND_SHELTOM),

            // Force Orb
            new Item(sinFO1 | sin01, "Lucidy Force", "FO101", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os101", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin02, "Sereno Force", "FO102", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os102", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin03, "Fadeo Force", "FO103", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os103", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin04, "Sparky Force", "FO104", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os104", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin05, "Raident Force", "FO105", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os105", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin06, "Transparo Force", "FO106", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os106", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin07, "Murky Force", "FO107", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os107", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin08, "Devine Force", "FO108", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os108", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin09, "Celesto Force", "FO109", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os109", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin10, "Mirage Force", "FO110", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os110", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin11, "Inferna Force", "FO111", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os111", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin12, "Enigma Force", "FO112", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os112", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin13, "Bellum Force", "FO113", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os113", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin14, "Ordo Force", "FO114", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os114", 0, SIN_SOUND_SHELTOM),

            //
            new Item(sinFO1 | sin21, "Magic Lucidy Force", "FO121", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os101", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin22, "Magic Sereno Force", "FO122", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os102", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin23, "Magic Fadeo Force", "FO123", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os103", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin24, "Magic Sparky Force", "FO124", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os104", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin25, "Magic Raident Force", "FO125", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os105", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin26, "Magic Transparo Force", "FO126", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os106", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin27, "Magic Murky Force", "FO127", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os107", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin28, "Magic Devine Force", "FO128", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os108", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin29, "Magic Celesto Force", "FO129", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os109", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin30, "Magic Mirage Force", "FO130", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os110", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin31, "Magic Inferna Force", "FO131", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os111", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin32, "Magic Enigma Force", "FO132", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os112", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin33, "Magic Bellum Force", "FO133", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os113", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin34, "Magic Ordo Force", "FO134", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os114", 0, SIN_SOUND_SHELTOM),

            new Item(sinFO1 | sin35, "Magic Force(1H)", "FO135", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os135", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin36, "Magic Force(3H)", "FO136", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os136", 0, SIN_SOUND_SHELTOM),
            new Item(sinFO1 | sin37, "Magic Force(1Day)", "FO137", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_FORCEORB, "os137", 0, SIN_SOUND_SHELTOM),

            /*------------------------*
             *	(Armor, Boots .. )					  	
             *-------------------------*/

            // Armor
            new Item(sinDA1 | sin01, "Nude", "DA101", ITEMSIZE * 0, ITEMSIZE * 0, "Defense", ITEM_CLASS_ARMOR, "da101",
                    INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR), // Nude
            new Item(sinDA1 | sin02, "Battle Suit", "DA102", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da102", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin03, "Leather Armor", "DA103", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da103", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin04, "Brigandine", "DA104", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da104", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin05, "Steel Armor", "DA105", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da105", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin06, "Round Armor", "DA106", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da106", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin07, "Breast Plate Armor", "DA107", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da107", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin08, "Ring Armor", "DA108", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da108", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin09, "Scale Armor", "DA109", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da109", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin10, "Synthethic Armor", "DA110", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da110", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin11, "Full Plate Armor", "DA111", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da111", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin12, "Full Metal Armor", "DA112", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da112", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin13, "Supreme Armor", "DA113", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da113", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin14, "Spiked Armor", "DA114", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da114", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin15, "Titan Armor", "DA115", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da115", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin16, "Extreme Armor", "DA116", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da116", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin17, "Ancient Armor", "DA117", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da117", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin18, "Minotaur Armor", "DA118", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da118", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin19, "Doom Armor", "DA119", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da119", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin20, "Salamander Armor", "DA120", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da120", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin21, "Wyvern Armor", "DA121", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da121", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin22, "Dragon Armor", "DA122", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da122", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin23, "PhoeniX Armor", "DA123", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da123", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin24, "Frenzy Armor", "DA124", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da124", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin25, "HighLander Armor", "DA125", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da125", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),

            // Robe
            new Item(sinDA2 | sin01, "Nude", "DA201", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR, "da202",
                    INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR), // Nude
            new Item(sinDA2 | sin02, "Faded Robe", "DA202", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da202", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin03, "Enhanced Robe", "DA203", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da203", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin04, "Battle Robe", "DA204", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da204", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin05, "Elven Robe", "DA205", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da205", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin06, "Dryad Robe", "DA206", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da206", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin07, "Nymph Robe", "DA207", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da207", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin08, "Apperntice Robe", "DA208", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da208", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin09, "Disciple Robe", "DA209", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da209", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin10, "Master Robe", "DA210", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da210", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin11, "Arch Robe", "DA211", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da211", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin12, "Saint Robe", "DA212", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da212", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin13, "Royal Robe", "DA213", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da213", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin14, "Mystic Robe", "DA214", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da214", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin15, "Devine Robe", "DA215", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da215", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin16, "Bishop", "DA216", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da216", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin17, "Celestial Robe", "DA217", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da217", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin18, "Salvation Robe", "DA218", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da218", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin19, "Alchemist Robe", "DA219", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da219", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin20, "Astral Robe", "DA220", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da220", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin21, "Archon Robe", "DA221", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da221", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin22, "Angel Robe", "DA222", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da222", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin23, "Ruah Robe", "DA223", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da223", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin24, "Eternal Robe", "DA224", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da224", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin25, "Archangel Robe", "DA225", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da225", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            // ========
            new Item(sinDA1 | sin31, "Party Costume(7Day)", "DA131", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da131", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin32, "Party Costume(30Day)", "DA132", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da132", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin33, "Party Costume(7Day)", "DA133", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da133", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin34, "Party Costume(30Day)", "DA134", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da134", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin35, "Idas Armor(7Day)", "DA135", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da135", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin36, "Idas Armor(30Day)", "DA136", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da136", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin37, "Idas Armor(7Day)", "DA137", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da137", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin38, "Idas Armor(30Day)", "DA138", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da138", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin39, "Silver Party Costume(7Day)", "DA139", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da139", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin40, "Silver Party Costume(30Day)", "DA140", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da140", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin41, "Silver Party Costume(7Day)", "DA141", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da141", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin42, "Silver Party Costume(30Day)", "DA142", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da142", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin43, "Taless Armor(7Day)", "DA143", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da143", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin44, "Taless Armor(30Day)", "DA144", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da144", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin45, "Taless Armor(7Day)", "DA145", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da145", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin46, "Taless Armor(30Day)", "DA146", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da146", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin47, "Korea replica", "DA147", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da147", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin48, "Korean dress", "DA148", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da148", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin49, "JPT Type A", "DA149", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da149", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin50, "JPT Type B", "DA150", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da150", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin51, "Black Gaia Armor", "DA151", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da151", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin52, "Black Iris Armor", "DA152", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da152", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin54, "Beach Costume(30Day)", "DA154", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da154", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA1 | sin55, "Beach Costume(30Day)", "DA155", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da155", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),

            //
            new Item(sinDA2 | sin31, "Party Costume(7Day)", "DA231", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da231", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin32, "Party Costume(30Day)", "DA232", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da232", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin33, "Party Costume(7Day)", "DA233", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da233", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin34, "Party Costume(30Day)", "DA234", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da234", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin35, "Mardanos Robe(7Day)", "DA235", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da235", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin36, "Mardanos Robe(30Day)", "DA236", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da236", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin37, "Mardanos Robe(7Day)", "DA237", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da237", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin38, "Mardanos Robe(30Day)", "DA238", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da238", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin39, "Silver Party Costume(7Day)", "DA239", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da239", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin40, "Silver Party Costume(30Day)", "DA240", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da240", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin41, "Silver Party Costume(7Day)", "DA241", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da241", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin42, "Silver Party Costume(30Day)", "DA242", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da242", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin43, "Migal Robe(7Day)", "DA243", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da243", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin44, "Migal Robe(30Day)", "DA244", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da244", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin45, "Migal Robe(7Day)", "DA245", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da245", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin46, "Migal Robe(30Day)", "DA246", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da246", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin47, "Korea replica", "DA247", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da247", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin48, "Korean dress", "DA248", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da248", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin49, "JPT Type A", "DA249", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da249", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin50, "JPT Type B", "DA250", ITEMSIZE * 3, ITEMSIZE * 4, "Defense", ITEM_CLASS_ARMOR,
                    "da250", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin51, "Black Gaia Robe", "DA251", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da251", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin52, "Black Iris Robe", "DA252", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da252", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),

            new Item(sinDA2 | sin54, "Beach Costume(30Day)", "DA254", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da254", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),
            new Item(sinDA2 | sin55, "Beach Costume(30Day)", "DA255", ITEMSIZE * 3, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_ARMOR, "da255", INVENTORY_POS_ARMOR, SIN_SOUND_ARMOR),

            // Boots B1
            new Item(sinDB1 | sin01, "Leather Boots", "DB101", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db101", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin02, "Elven Boots", "DB102", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db102", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin03, "Steel Boots", "DB103", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db103", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin04, "Long Boots", "DB104", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db104", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin05, "Chain Boots", "DB105", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db105", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin06, "Plated Boots", "DB106", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db106", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin07, "Brass Boots", "DB107", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db107", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin08, "War Boots", "DB108", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db108", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin09, "Metal Boots", "DB109", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db109", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin10, "Chaos Boots", "DB110", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db110", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin11, "Holy Boots", "DB111", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db111", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin12, "Spiked Boots", "DB112", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db112", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin13, "Grand Boots", "DB113", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db113", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin14, "Winged Boots", "DB114", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db114", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin15, "Titan Boots", "DB115", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db115", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin16, "Saint Boots", "DB116", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db116", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin17, "Wyvern Boots", "DB117", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db117", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin18, "Rune Boots", "DB118", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db118", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin19, "Royal Boots", "DB119", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db119", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin20, "Dragon Boots", "DB120", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db120", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin21, "Inferno Boots", "DB121", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db121", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin22, "Phoenix Boots", "DB122", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db122", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin23, "Frenzy Boots", "DB123", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db123", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin30, "Mokova Boots ", "DB130", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_BOOTS,
                    "db130", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin31, "Speed Boots(7Day)", "DB131", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_BOOTS, "db131", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin32, "Speed Boots(30Day)", "DB132", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_BOOTS, "db132", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin33, "Speed Boots(1Day)", "DB133", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_BOOTS, "db133", 0, SIN_SOUND_BOOTS),
            new Item(sinDB1 | sin34, "Speed Boots(1H)", "DB134", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_BOOTS, "db134", 0, SIN_SOUND_BOOTS),

            // Gloves G1
            new Item(sinDG1 | sin01, "Leather Gloves", "DG101", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg101", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin02, "Leather Half Gauntlets", "DG102", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg102", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin03, "Steel Half Gauntlets", "DG103", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg103", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin04, "Clamshell Gauntlets", "DG104", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg104", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin05, "Finger Gauntlets", "DG105", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg105", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin06, "Gothic Mitten Gauntlets", "DG106", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg106", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin07, "War Gauntlets", "DG107", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_GLOVES,
                    "dg107", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin08, "Metal Gauntlets", "DG108", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg108", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin09, "Holy Gauntlets", "DG109", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg109", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin10, "Great Gauntlets", "DG110", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg110", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin11, "Brass Gauntlets", "DG111", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg111", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin12, "Giant Gauntlets", "DG112", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg112", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin13, "Titan Gauntlets", "DG113", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg113", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin14, "Grand Gauntlets", "DG114", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg114", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin15, "Ivory Gauntlets", "DG115", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg115", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin16, "Saint Gauntlets", "DG116", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg116", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin17, "Diamond Gauntlets", "DG117", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg117", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin18, "Angel Gauntlets", "DG118", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg118", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin19, "Relic Gauntlets", "DG119", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg119", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin20, "Dragon Gauntlets", "DG120", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg120", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin21, "INferno Gauntlets", "DG121", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg121", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin22, "Phoenix Gauntlets", "DG122", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg122", 0, SIN_SOUND_GLOVES),
            new Item(sinDG1 | sin23, "Frenzy Gauntlets", "DG123", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_GLOVES, "dg123", 0, SIN_SOUND_GLOVES),

            // Shields S1
            new Item(sinDS1 | sin01, "Wood Shield", "DS101", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_SHIELDS,
                    "ds101", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin02, "Targe", "DS102", ITEMSIZE * 2, ITEMSIZE * 2, "Defense", ITEM_CLASS_SHIELDS,
                    "ds102", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin03, "Steel Buckler", "DS103", ITEMSIZE * 2, ITEMSIZE * 2, "Defense",
                    ITEM_CLASS_SHIELDS, "ds103", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin04, "Kite Shield", "DS104", ITEMSIZE * 2, ITEMSIZE * 3, "Defense", ITEM_CLASS_SHIELDS,
                    "ds104", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin05, "Tower Shield", "DS105", ITEMSIZE * 2, ITEMSIZE * 4, "Defense", ITEM_CLASS_SHIELDS,
                    "ds105", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin06, "Metalic Shield", "DS106", ITEMSIZE * 2, ITEMSIZE * 3, "Defense",
                    ITEM_CLASS_SHIELDS, "ds106", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin07, "Scutum", "DS107", ITEMSIZE * 2, ITEMSIZE * 4, "Defense", ITEM_CLASS_SHIELDS,
                    "ds107", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin08, "Great Shield", "DS108", ITEMSIZE * 2, ITEMSIZE * 4, "Defense", ITEM_CLASS_SHIELDS,
                    "ds108", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin09, "Brass Shield", "DS109", ITEMSIZE * 2, ITEMSIZE * 4, "Defense", ITEM_CLASS_SHIELDS,
                    "ds109", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin10, "Claw Shield", "DS110", ITEMSIZE * 2, ITEMSIZE * 4, "Defense", ITEM_CLASS_SHIELDS,
                    "ds110", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin11, "Winged Shield", "DS111", ITEMSIZE * 2, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_SHIELDS, "ds111", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin12, "Spiked Shield", "DS112", ITEMSIZE * 2, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_SHIELDS, "ds112", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin13, "Grand Shield", "DS113", ITEMSIZE * 2, ITEMSIZE * 4, "Defense", ITEM_CLASS_SHIELDS,
                    "ds113", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin14, "Titan Shield", "DS114", ITEMSIZE * 2, ITEMSIZE * 4, "Defense", ITEM_CLASS_SHIELDS,
                    "ds114", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin15, "Gladiator Shield", "DS115", ITEMSIZE * 2, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_SHIELDS, "ds115", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin16, "Fury Shield", "DS116", ITEMSIZE * 2, ITEMSIZE * 4, "Defense", ITEM_CLASS_SHIELDS,
                    "ds116", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin17, "Titan Shield", "DS117", ITEMSIZE * 2, ITEMSIZE * 4, "Defense", ITEM_CLASS_SHIELDS,
                    "ds117", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin18, "Mystic Shield", "DS118", ITEMSIZE * 2, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_SHIELDS, "ds118", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin19, "Vampire Shield", "DS119", ITEMSIZE * 2, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_SHIELDS, "ds119", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin20, "Dragon Shield", "DS120", ITEMSIZE * 2, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_SHIELDS, "ds120", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin21, "Phoenix Shield", "DS121", ITEMSIZE * 2, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_SHIELDS, "ds121", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin22, "Dreadnaught Shield", "DS122", ITEMSIZE * 2, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_SHIELDS, "ds122", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),
            new Item(sinDS1 | sin23, "Inferno Shield", "DS123", ITEMSIZE * 2, ITEMSIZE * 4, "Defense",
                    ITEM_CLASS_SHIELDS, "ds123", INVENTORY_POS_LHAND, SIN_SOUND_SHIELDS),

            // Ring R2
            new Item(sinOR2 | sin01, "G-Zone Ring", "OR201", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or201", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin02, "Arcane Ring", "OR202", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or202", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin03, "Emperor Ring", "OR203", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or203", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin04, "Focus Ring", "OR204", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or204", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin05, "Valento Ring", "OR205", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or205", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin06, "Zzangpy Ring", "OR206", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or206", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin07, "Mekhist Ring", "OR207", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or207", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin08, "Ede Ring    ", "OR208", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or208", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin09, "Platin Mav Ring", "OR209", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or209", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin10, "Grave Shakins Ring", "OR210", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or210", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin11, "Cyclops Ring", "OR211", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or211", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin12, "Bauton Ring", "OR212", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or212", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin13, "Guilty Gorden Ring", "OR213", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or213", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin14, "El Rasi Kun Ring", "OR214", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or214", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin15, "Fright Nemyun Ring", "OR215", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or215", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin16, "Apostasy Ring", "OR216", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or216", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin17, "Unholy Knight Ring", "OR217", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or217", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin18, "Vega Demir Ring", "OR218", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or218", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin19, "Vega Demitri Ring", "OR219", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or219", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin20, "Slayon Ring", "OR220", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or220", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin21, "Bloody Rose Ring", "OR221", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or221", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin22, "HellSing Ring", "OR222", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or222", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin23, "Vermun Actarun Ring", "OR223", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or223", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin24, "STYX Archon Ring", "OR224", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or224", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin25, "RaSha's Ring", "OR225", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or225", 0, SIN_SOUND_RING),

            new Item(sinOR2 | sin27, "Santa Ring", "OR227", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or227", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin28, "Event Ring", "OR228", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or228", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin29, "Event Ring(1H)", "OR229", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or228", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin30, "Event Ring(1Day)", "OR230", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or228", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin31, "Babel Ring", "OR231", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or231", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin32, "Fury Ring", "OR232", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or232", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin33, "Heart Ring(7Day)", "OR233", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or233", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin34, "Fried Chicken Ring", "OR234", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or234", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin35, "Spiced Chicken Ring", "OR235", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory",
                    ITEM_CLASS_RING, "or235", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin36, "叼内捞 傅", "OR236", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or236", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin37, "鸥捞藕 傅", "OR237", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or237", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin38, "困摹 傅", "OR238", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING, "or238",
                    0, SIN_SOUND_RING),
            new Item(sinOR2 | sin39, "货靛聪胶 傅", "OR239", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or239", 0, SIN_SOUND_RING),
            new Item(sinOR2 | sin40, "奔啊福 傅", "OR240", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or240", 0, SIN_SOUND_RING),

            // Potion
            new Item(sinPM1 | sin01, "Small  Mana Potion", "PM101", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "pm101", 0, SIN_SOUND_POTION),
            new Item(sinPM1 | sin02, "Middle Mana Potion", "PM102", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "pm101", 0, SIN_SOUND_POTION),
            new Item(sinPM1 | sin03, "High   Mana Potion", "PM103", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "pm101", 0, SIN_SOUND_POTION),
            new Item(sinPM1 | sin04, "Greate Mana Potion", "PM104", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "pm101", 0, SIN_SOUND_POTION),

            new Item(sinPL1 | sin01, "Small  Life Potion", "PL101", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "pl101", 0, SIN_SOUND_POTION),
            new Item(sinPL1 | sin02, "Middle Life Potion", "PL102", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "pl101", 0, SIN_SOUND_POTION),
            new Item(sinPL1 | sin03, "High   Life Potion", "PL103", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "pl101", 0, SIN_SOUND_POTION),
            new Item(sinPL1 | sin04, "Greate Life Potion", "PL104", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "pl101", 0, SIN_SOUND_POTION),

            new Item(sinPS1 | sin01, "Small  Stamina Potion", "PS101", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "ps101", 0, SIN_SOUND_POTION),
            new Item(sinPS1 | sin02, "Middle Stamina Potion", "PS102", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "ps101", 0, SIN_SOUND_POTION),
            new Item(sinPS1 | sin03, "High   Stamina Potion", "PS103", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "ps101", 0, SIN_SOUND_POTION),
            new Item(sinPS1 | sin04, "Greate Stamina Potion", "PS104", ITEMSIZE * 1, ITEMSIZE * 1, "Potion",
                    ITEM_CLASS_POTION, "ps101", 0, SIN_SOUND_POTION),

            // Ether Core
            new Item(sinEC1 | sin01, "府墨福刨 蓖券", "EC101", ITEMSIZE * 2, ITEMSIZE * 1, "Potion", ITEM_CLASS_ECORE,
                    "ec101", 0, SIN_SOUND_Armlet),
            new Item(sinEC1 | sin02, "匙厚胶内 蓖券", "EC102", ITEMSIZE * 2, ITEMSIZE * 1, "Potion", ITEM_CLASS_ECORE,
                    "ec102", 0, SIN_SOUND_Armlet),
            new Item(sinEC1 | sin03, "风捞迟   蓖券", "EC103", ITEMSIZE * 2, ITEMSIZE * 1, "Potion", ITEM_CLASS_ECORE,
                    "ec102", 0, SIN_SOUND_Armlet),
            new Item(sinEC1 | sin04, "鞘扼捞   蓖券", "EC104", ITEMSIZE * 2, ITEMSIZE * 1, "Potion", ITEM_CLASS_ECORE,
                    "ec102", 0, SIN_SOUND_Armlet),
            new Item(sinEC1 | sin05, "蜡聪柯   内绢", "EC105", ITEMSIZE * 2, ITEMSIZE * 1, "Potion", ITEM_CLASS_ECORE,
                    "ec102", 0, SIN_SOUND_Armlet),

            // 涅胶飘 酒捞袍
            new Item(sinQT1 | sin01, "傈诀酒捞袍", "QT101", ITEMSIZE * 2, ITEMSIZE * 2, "Quest", ITEM_CLASS_QUEST, "QT101",
                    0, SIN_SOUND_Armlet),
            new Item(sinQT1 | sin02, "傈诀酒捞袍", "QT102", ITEMSIZE * 2, ITEMSIZE * 2, "Quest", ITEM_CLASS_QUEST, "QT102",
                    0, SIN_SOUND_Armlet),
            new Item(sinQT1 | sin03, "傈诀酒捞袍", "QT103", ITEMSIZE * 2, ITEMSIZE * 2, "Quest", ITEM_CLASS_QUEST, "QT103",
                    0, SIN_SOUND_Armlet),

            // MakeResultItem
            new Item(sinQT1 | sin04, "肺锯力府", "QT104", ITEMSIZE * 2, ITEMSIZE * 2, "Make", ITEM_CLASS_QUEST, "QT104", 0,
                    SIN_SOUND_MAGICIAL),
            new Item(sinQT1 | sin05, "惯葛力", "QT105", ITEMSIZE * 2, ITEMSIZE * 2, "Make", ITEM_CLASS_QUEST, "QT105", 0,
                    SIN_SOUND_MAGICIAL),
            new Item(sinQT1 | sin06, "轨橇僵乓  ", "QT106", ITEMSIZE * 1, ITEMSIZE * 1, "Quest", ITEM_CLASS_QUEST, "QT106",
                    0, SIN_SOUND_SHELTOM),

            // LevelQuest
            new Item(sinQT1 | sin07, "肺捞飘扼", "QT107", ITEMSIZE * 2, ITEMSIZE * 2, "Quest", ITEM_CLASS_QUEST, "QT107", 0,
                    SIN_SOUND_MAGICIAL),
            new Item(sinQT1 | sin08, "漠府酒狼传拱", "QT108", ITEMSIZE * 2, ITEMSIZE * 2, "Quest", ITEM_CLASS_QUEST, "QT108",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinQT1 | sin09, "榜掸 轨橇", "QT109", ITEMSIZE * 1, ITEMSIZE * 1, "Quest", ITEM_CLASS_QUEST, "QT109",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinQT1 | sin10, "角滚 轨橇", "QT110", ITEMSIZE * 1, ITEMSIZE * 1, "Quest", ITEM_CLASS_QUEST, "QT110",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinQT1 | sin11, "宏沸令 轨橇", "QT111", ITEMSIZE * 1, ITEMSIZE * 1, "Quest", ITEM_CLASS_QUEST, "QT111",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinQT1 | sin12, "眠玫辑", "QT112", ITEMSIZE * 2, ITEMSIZE * 2, "Quest", ITEM_CLASS_QUEST, "QT112", 0,
                    SIN_SOUND_Armlet),
            new Item(sinQT1 | sin13, "肺凯酒鼓房", "QT113", ITEMSIZE * 1, ITEMSIZE * 1, "Quest", ITEM_CLASS_QUEST, "QT113",
                    0, SIN_SOUND_RING),

            new Item(sinQT1 | sin14, "阜措荤帕", "QT114", ITEMSIZE * 1, ITEMSIZE * 2, "Quest", ITEM_CLASS_QUEST, "QT114", 0,
                    SIN_SOUND_SHELTOM),
            new Item(sinQT1 | sin15, "积农覆 纳劳", "QT115", ITEMSIZE * 2, ITEMSIZE * 2, "Quest", ITEM_CLASS_QUEST, "QT115",
                    0, SIN_SOUND_Armlet),
            new Item(sinQT1 | sin16, "决橇狼 噶摹", "QT116", ITEMSIZE * 2, ITEMSIZE * 2, "Quest", ITEM_CLASS_QUEST, "QT116",
                    0, SIN_SOUND_RING),

            // 捞亥飘 酒捞袍 (价祈)
            new Item(sinSP1 | sin01, "累篮 价祈", "SP101", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP101",
                    0, SIN_SOUND_Armlet),
            new Item(sinSP1 | sin02, "奴   价祈", "SP102", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP102",
                    0, SIN_SOUND_Armlet),
            new Item(sinSP1 | sin03, "伙拌帕", "SP103", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP103", 0,
                    SIN_SOUND_Armlet),
            // pluto 急拱惑磊
            new Item(sinSP1 | sin05, "急拱惑磊1", "SP105", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "SP105",
                    0, SIN_SOUND_Armlet),
            new Item(sinSP1 | sin06, "急拱惑磊2", "SP106", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "SP105",
                    0, SIN_SOUND_Armlet),
            new Item(sinSP1 | sin07, "急拱惑磊3", "SP107", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "SP105",
                    0, SIN_SOUND_Armlet),
            new Item(sinSP1 | sin08, "急拱惑磊4", "SP108", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "SP105",
                    0, SIN_SOUND_Armlet),
            new Item(sinSP1 | sin09, "急拱惑磊5", "SP109", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "SP105",
                    0, SIN_SOUND_Armlet),
            new Item(sinSP1 | sin10, "急拱惑磊6", "SP110", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "SP105",
                    0, SIN_SOUND_Armlet),
            // 荐冠 酒捞袍 眠啊
            new Item(sinSP1 | sin15, "荐冠", "SP115", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP115", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin16, "目敲傅", "SP116", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP116", 0,
                    SIN_SOUND_Armlet),

            // 冠犁盔 - 广窍疵狼 家盔捞亥飘
            new Item(sinSP1 | sin26, "喊", "SP126", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP126", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin27, "P", "SP127", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP127", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin28, "R", "SP128", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP128", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin29, "I", "SP129", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP129", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin30, "S", "SP130", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP130", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin31, "T", "SP131", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP131", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin32, "O", "SP132", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP132", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin33, "N", "SP133", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP133", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin34, "龋尔捞 母蕉", "SP134", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "SP134",
                    0, SIN_SOUND_Armlet),
            new Item(sinSP1 | sin35, "檬妮复", "SP135", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP135", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin36, "牡叼", "SP136", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP136", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin37, "厚秒", "SP137", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP137", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin38, "俊皋饿靛", "SP138", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP138", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin39, "墨扼狼 传拱", "SP139", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP139",
                    0, SIN_SOUND_Armlet),
            new Item(sinSP1 | sin40, "绵备傍 器记", "SP140", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP140", 0,
                    SIN_SOUND_Armlet),

            new Item(sinSP1 | sin42, "荐冠", "SP142", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SP142", 0,
                    SIN_SOUND_Armlet),

            // 厘喊 - 康拳 趋捧
            new Item(sinSP1 | sin60, "康", "SP160", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP160", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin61, "拳", "SP161", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP161", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin62, "趋", "SP162", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP162", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSP1 | sin63, "捧", "SP163", ITEMSIZE, ITEMSIZE, "Event", ITEM_CLASS_ECORE, "SP163", 0,
                    SIN_SOUND_Armlet),

            new Item(sinGP1 | sin01, "龋乔	  ", "GP101", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP101", 0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin02, "醛绊喉赴 ", "GP102", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin03, "叼内捞   ", "GP103", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin04, "官帮     ", "GP104", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin05, "庆靛目磐 ", "GP105", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin06, "颇捞帮   ", "GP106", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin07, "欧龋乔   ", "GP107", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin08, "擎农     ", "GP108", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin09, "罚待     ", "GP109", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL), // 罚待 农府胶呕
            new Item(sinGP1 | sin10, "努罚     ", "GP110", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL), // 努罚 农府胶呕
            new Item(sinGP1 | sin11, "昆       ", "GP111", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP101", 0, SIN_SOUND_MAGICIAL), // 努罚 农府胶呕
            new Item(sinGP1 | sin12, "促农胶蒲磐", "GP112", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL), // 努罚 农府胶呕
            new Item(sinGP1 | sin13, "酒捞攫啊靛", "GP113", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL), // 努罚 农府胶呕
            new Item(sinGP1 | sin14, "府墨福掸 刮捍措", "GP114", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP101", 0, SIN_SOUND_MAGICIAL), // 努罚 农府胶呕
            new Item(sinGP1 | sin15, "府墨福掸 版厚措", "GP115", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP101", 0, SIN_SOUND_MAGICIAL), // 努罚 农府胶呕
            new Item(sinGP1 | sin16, "喉饭胶空惫 荐厚措", "GP116", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP101", 0, SIN_SOUND_MAGICIAL), // 努罚 农府胶呕
            new Item(sinGP1 | sin17, "胶奶饭沛 农府胶呕", "GP117", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP101", 0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin18, "霸捞酒胶 农府胶呕", "GP118", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP101", 0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin19, "牢其福唱 农府胶呕", "GP119", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP101", 0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin20, "劳胶飘覆 农府胶呕", "GP120", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP101", 0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin21, "付骇 农府胶呕", "GP121", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP1 | sin22, "啊叼救 叼官牢", "GP122", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP101",
                    0, SIN_SOUND_MAGICIAL),

            // 厘喊 - 家匡胶沛
            new Item(sinGP2 | sin01, "弊赴 家匡胶沛", "GP201", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP201",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP2 | sin02, "炕肺快 家匡胶沛", "GP202", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP202", 0, SIN_SOUND_MAGICIAL),
            new Item(sinGP2 | sin03, "喉风 家匡胶沛", "GP203", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP203",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP2 | sin04, "付哩鸥 家匡胶沛", "GP204", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP204", 0, SIN_SOUND_MAGICIAL),
            new Item(sinGP2 | sin05, "轿捞攫 家匡胶沛", "GP205", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP205", 0, SIN_SOUND_MAGICIAL),
            new Item(sinGP2 | sin06, "官捞棵房 家匡胶沛", "GP206", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP206", 0, SIN_SOUND_MAGICIAL),
            new Item(sinGP2 | sin07, "饭靛 家匡胶沛", "GP207", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP207",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP2 | sin08, "喉发 家匡胶沛", "GP208", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "GP208",
                    0, SIN_SOUND_MAGICIAL),
            new Item(sinGP2 | sin09, "敲贰萍逞 家匡胶沛", "GP209", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "GP209", 0, SIN_SOUND_MAGICIAL),

            new Item(sinQW1 | sin01, "喇1	          ", "QW101", ITEMSIZE * 2, ITEMSIZE * 2, "Wing", ITEM_CLASS_ECORE,
                    "QW101", 0, SIN_SOUND_MAGICIAL), // 皋呕
            new Item(sinQW1 | sin02, "喇2		      ", "QW102", ITEMSIZE * 2, ITEMSIZE * 2, "Wing", ITEM_CLASS_ECORE,
                    "QW102", 0, SIN_SOUND_MAGICIAL), // 角滚
            new Item(sinQW1 | sin03, "喇3			  ", "QW103", ITEMSIZE * 2, ITEMSIZE * 2, "Wing", ITEM_CLASS_ECORE,
                    "QW103", 0, SIN_SOUND_MAGICIAL), // 榜靛
            new Item(sinQW1 | sin04, "喇4			  ", "QW104", ITEMSIZE * 2, ITEMSIZE * 2, "Wing", ITEM_CLASS_ECORE,
                    "QW104", 0, SIN_SOUND_MAGICIAL), // 促捞酒
            new Item(sinQW1 | sin05, "喇5			  ", "QW105", ITEMSIZE * 2, ITEMSIZE * 2, "Wing", ITEM_CLASS_ECORE,
                    "QW105", 0, SIN_SOUND_MAGICIAL), // 纳捞酒胶
            new Item(sinQW1 | sin06, "喇6			  ", "QW106", ITEMSIZE * 2, ITEMSIZE * 2, "Wing", ITEM_CLASS_ECORE,
                    "QW106", 0, SIN_SOUND_MAGICIAL), // 劳胶飘覆喇

            // Make Item (哭率)
            new Item(sinMA1 | sin01, "蜡府捍           ", "MA101", ITEMSIZE * 2, ITEMSIZE * 2, "Make", ITEM_CLASS_QUEST,
                    "MA101", 0, SIN_SOUND_MAGICIAL),

            // Make Item (坷弗率)
            new Item(sinMA2 | sin01, "国曹             ", "MA201", ITEMSIZE * 1, ITEMSIZE * 1, "Make", ITEM_CLASS_QUEST,
                    "MA201", 0, SIN_SOUND_POTION),
            new Item(sinMA2 | sin02, "八篮扁抚         ", "MA202", ITEMSIZE * 1, ITEMSIZE * 1, "Make", ITEM_CLASS_QUEST,
                    "MA202", 0, SIN_SOUND_POTION),

            new Item(sinGF1 | sin01, "喊惑前鼻", "GF101", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_QUEST, "GF101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinGF1 | sin02, "官骇惑前鼻", "GF102", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_QUEST, "GF102",
                    0, SIN_SOUND_Armlet),
            new Item(sinGF1 | sin03, "备固龋格吧捞1", "GF103", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_QUEST, "GF103",
                    0, SIN_SOUND_Armlet),
            new Item(sinGF1 | sin04, "备固龋格吧捞2", "GF104", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_QUEST, "GF104",
                    0, SIN_SOUND_Armlet),
            new Item(sinGF1 | sin05, "蝴唱绰 啊风", "GF105", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_QUEST, "GF105",
                    0, SIN_SOUND_Armlet),
            new Item(sinGF1 | sin06, "馆娄   啊风", "GF106", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_QUEST, "GF106",
                    0, SIN_SOUND_Armlet),

            // 厘喊 - 炼荤盔阑 茫酒扼
            new Item(sinGF1 | sin07, "唱牢酒鼓房", "GF107", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_QUEST, "GF107",
                    0, SIN_SOUND_Armlet),
            new Item(sinGF1 | sin08, "抛老酒鼓房", "GF108", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_QUEST, "GF108",
                    0, SIN_SOUND_Armlet),

            // 开败款 柳咀
            new Item(sinGF1 | sin02, "开败款 柳咀", "GF102", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_QUEST, "GF102",
                    0, SIN_SOUND_POTION),

            // 酒捞袍 欺榴 嘎眠扁 捞亥飘 (场朝锭波沥 汗林赣聪 牢郸胶 框瘤捞搁救凳)
            new Item(sinPZ1 | sin00, "汗林赣聪", "PZ100", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "PZ100", 0,
                    SIN_SOUND_Armlet),

            // Sod2 惯积酒捞袍 (牢亥配府肺 甸绢坷瘤臼绊 角H栏肺 荤侩等促)
            new Item(sinSD2 | sin01, "气藕", "SD201", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SD201", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSD2 | sin02, "矫拌", "SD202", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SD202", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSD2 | sin03, "酒捞胶农覆", "SD203", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SD203",
                    0, SIN_SOUND_Armlet),
            new Item(sinSD2 | sin04, "配尝牢屈", "SD204", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SD204", 0,
                    SIN_SOUND_Armlet),
            new Item(sinSD2 | sin05, "崔狼 荐沥备", "SD205", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SD205",
                    0, SIN_SOUND_Armlet),
            new Item(sinSD2 | sin06, "怕剧狼 荐沥备", "SD206", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SD206",
                    0, SIN_SOUND_Armlet),
            new Item(sinSD2 | sin07, "玫傍狼 荐沥备", "SD207", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "SD207",
                    0, SIN_SOUND_Armlet),

            new Item(sinBS1 | sin01, "骇扼配胶沛(家)", "BS101", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BS101", 0, SIN_SOUND_SHELTOM),
            new Item(sinBS1 | sin02, "骇扼配胶沛(吝)", "BS102", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BS102", 0, SIN_SOUND_SHELTOM),
            new Item(sinBS1 | sin03, "骇扼配胶沛(措)", "BS103", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BS103", 0, SIN_SOUND_SHELTOM),

            // 傍己傈 惯积 酒捞袍(胶农费)
            new Item(sinBC1 | sin01, "酒鸥唱矫酒", "BC101", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC101",
                    0, SIN_SOUND_Armlet),
            new Item(sinBC1 | sin02, "单甸府 俊瘤", "BC102", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC101",
                    0, SIN_SOUND_Armlet),
            new Item(sinBC1 | sin03, "绢海老 坷宏 捞海捞靛", "BC103", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "BC101", 0, SIN_SOUND_Armlet),
            new Item(sinBC1 | sin04, "杭胶磐 府目滚府", "BC104", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "BC101", 0, SIN_SOUND_Armlet),
            new Item(sinBC1 | sin05, "府胶配饭捞记", "BC105", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC101",
                    0, SIN_SOUND_Armlet),
            new Item(sinBC1 | sin06, "叼颇捞攫胶 胶沛", "BC106", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "BC102", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin07, "叼颇捞攫胶 胶沛", "BC107", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "BC102", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin08, "叼颇捞攫胶 胶沛", "BC108", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "BC102", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin09, "付捞飘 胶沛", "BC109", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC102",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin10, "付捞飘 胶沛", "BC110", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC102",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin11, "付捞飘 胶沛", "BC111", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC102",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin12, "付捞飘 胶沛", "BC112", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC102",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin13, "付捞飘 胶沛", "BC113", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC102",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin14, "付捞飘 胶沛", "BC114", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC102",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin15, "付捞飘 胶沛", "BC115", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC102",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin16, "付捞飘 胶沛", "BC116", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "BC102",
                    0, SIN_SOUND_SHELTOM),

            new Item(sinBC1 | sin21, "积疙仿 何胶磐(1H)", "BC121", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC121", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin22, "积疙仿 何胶磐(3H)", "BC122", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC122", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin23, "积疙仿 何胶磐(1Day)", "BC123", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC123", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin24, "扁仿 何胶磐(1H)", "BC124", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC124", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin25, "扁仿 何胶磐(3H)", "BC125", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC125", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin26, "扁仿 何胶磐(1Day)", "BC126", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC126", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin27, "辟仿 何胶磐(1H)", "BC127", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC127", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin28, "辟仿 何胶磐(3H)", "BC128", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC128", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin29, "辟仿 何胶磐(1Day)", "BC129", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC129", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin30, "胶懦 掉饭捞(1H)", "BC130", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC130", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin31, "胶懦 掉饭捞(3H)", "BC131", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC131", 0, SIN_SOUND_SHELTOM),
            new Item(sinBC1 | sin32, "胶懦 掉饭捞(1Day)", "BC132", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE,
                    "BC132", 0, SIN_SOUND_SHELTOM),

            // 橇府固决 何盒 蜡丰拳
            // 酒捞袍==========================================================================================
            new Item(sinBI1 | sin01, "喉风 胶沛", "BI101", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI101",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin02, "饭靛 胶沛", "BI102", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI102",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin03, "弊赴 胶沛", "BI103", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI103",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin04, "何劝林巩辑", "BI104", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI104",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin05, "捞磐澄 扼捞橇", "BI105", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI105", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin06, "其捞撇 俊瘤", "BI106", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI106", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin07, "绢滚飘 胶农费", "BI107", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI107", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin08, "炮饭器飘 内绢", "BI108", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI108", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin09, "倔奴捞 拱距", "BI109", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI109", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin10, "俊捞隆 胶沛", "BI110", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI110", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin11, "内欺 坷绢", "BI111", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI111",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin12, "结靛 酒捞令(1Day)", "BI112", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI112", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin13, "版氰摹刘啊 器记(1Day)", "BI113", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI113", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin14, "结靛 酒捞令(7Day)", "BI114", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI114", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin15, "版氰摹刘啊 器记(7Day)", "BI115", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI115", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin16, "庆绢凭飘 器记(A屈)", "BI116", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI116", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin17, "庆绢凭飘 器记(B屈)", "BI117", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI117", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin18, "庆绢凭飘 器记(C屈)", "BI118", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI118", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin19, "轨乔腐 目胶峭(15盒)", "BI119", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI119", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin20, "轨乔腐 目胶峭(30盒)", "BI120", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI120", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin21, "付唱 府瞒隆 器记(15盒)", "BI121", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI121", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin22, "付唱 府瞒隆 器记(30盒)", "BI122", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI122", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin23, "气 磷", "BI123", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI123",
                    0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin24, "版氰摹刘啊 器记(50% 1Day)", "BI124", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI124", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin25, "版氰摹刘啊 器记(50% 7Day)", "BI125", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI125", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin26, "付捞飘 坷宏 酒溃(7Day)", "BI126", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI126", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin27, "付捞飘 坷宏 酒溃(30Day)", "BI127", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI127", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin28, "付唱 府掂胶 器记(1Day)", "BI128", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI128", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin29, "付唱 府掂胶 器记(7Day)", "BI129", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI129", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin30, "付捞飘 坷宏 酒溃2(7Day)", "BI130", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI130", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin31, "付捞飘 坷宏 酒溃2(30Day)", "BI131", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI131", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin32, "乔葱胶脐(1Day)", "BI132", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI132", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin33, "乔葱胶脐(7Day)", "BI133", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI132", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin34, "乔葱胶脐(3H)", "BI134", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI132", 0, SIN_SOUND_POTION),

            new Item(sinBI1 | sin36, "俊捞隆 付胶磐(A)", "BI136", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI136", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin37, "俊捞隆 付胶磐(B)", "BI137", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI137", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin38, "俊捞隆 付胶磐(C)", "BI138", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI138", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin39, "胶懦 付胶磐(1瞒)", "BI139", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI139", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin40, "胶懦 付胶磐(2瞒)", "BI140", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI140", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin41, "胶懦 付胶磐(3瞒)", "BI141", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI141", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin42, "捞悼 惑痢", "BI142", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI142",
                    0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin43, "版氰摹刘啊 器记(100% 1Day)", "BI143", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI143", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin44, "版氰摹刘啊 器记(100% 7Day)", "BI144", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI144", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin45, "塞 胶沛", "BI145", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI145",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin46, "沥脚 胶沛", "BI146", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI146",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin47, "犁瓷 胶沛", "BI147", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI147",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin48, "刮酶己 胶沛", "BI148", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI148", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin49, "扒碍 胶沛", "BI149", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE, "BI149",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin50, "版氰摹刘啊 器记(100% 30Day)", "BI150", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI150", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin51, "乔葱胶脐(30Day)", "BI151", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI151", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin52, "抛府(30Day)", "BI152", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI152", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin53, "耻矫胶(30Day)", "BI153", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI153", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin54, "捞坷(30Day)", "BI154", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI154", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin55, "公飘(30Day)", "BI155", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI155", 0, SIN_SOUND_POTION),

            new Item(sinBI1 | sin60, "郡歹 内欺 坷绢", "BI160", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI160", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin61, "酱欺 俊捞隆 胶沛", "BI161", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI161", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin62, "俊捞隆 付胶磐(D)", "BI162", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI162", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin63, "俊捞隆 付胶磐(E)", "BI163", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI163", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin64, "俊捞隆 付胶磐(F)", "BI164", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI164", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin65, "抛府(7Day)", "BI165", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI165", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin66, "耻矫胶(7Day)", "BI166", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI166", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin67, "捞坷(7Day)", "BI167", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI167", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin68, "公飘(7Day)", "BI168", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI168", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin69, "抛府(1Day)", "BI169", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI169", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin70, "耻矫胶(1Day)", "BI170", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI170", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin71, "捞坷(1Day)", "BI171", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI171", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin72, "公飘(1Day)", "BI172", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI172", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin73, "抛府(1H)", "BI173", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI173", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin74, "耻矫胶(1H)", "BI174", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI174", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin75, "捞坷(1H)", "BI175", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI175", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin76, "公飘(1H)", "BI176", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI176", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin77, "乔葱胶脐(1H)", "BI177", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI177", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin78, "结靛 酒捞令(1H)", "BI178", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI178", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin79, "版氰摹刘啊 器记(1H)", "BI179", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI179", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin80, "版氰摹 2硅 刘啊距(1H)", "BI180", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI180", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin81, "轨乔腐 目胶峭(1H)", "BI181", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI181", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin82, "付唱 府瞒隆 器记(1H)", "BI182", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI182", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin83, "付唱 府掂胶 器记(1H)", "BI183", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI183", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin84, "弊扼厚萍 胶沛", "BI184", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI184", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin85, "酱其府绢 内欺坷绢", "BI185", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI185", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin86, "酱欺 轨乔腐 目胶峭(1H)", "BI186", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI186", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin87, "酱欺 轨乔腐 目胶峭(3H)", "BI187", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI187", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin88, "酱欺 轨乔腐 目胶峭(1Day)", "BI188", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI188", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin89, "雇胶媚 府悸 胶沛", "BI189", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI189", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin90, "府胶棋 胶沛", "BI190", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI190", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin91, "辟仿 府掂胶 器记(1Day)", "BI191", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI191", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin92, "辟仿 府掂胶 器记(7Day)", "BI192", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI192", 0, SIN_SOUND_POTION),
            new Item(sinBI1 | sin93, "鞘靛 内绢(1Day)", "BI193", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI193", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI1 | sin94, "鞘靛 内绢(7Day)", "BI194", ITEMSIZE * 2, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI194", 0, SIN_SOUND_SHELTOM),

            // ========= 菩虐瘤 某浆
            // 酒捞袍============己辟眠啊060515=====================================================================

            new Item(sinBI2 | sin01, "Bronze Package(3H)", "BI201", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI201", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin02, "Bronze Package(1Day)", "BI202", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI202", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin03, "Bronze Package(7Day)", "BI203", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI203", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin04, "Bronze Package(30Day)", "BI204", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI204", 0, SIN_SOUND_SHELTOM),

            new Item(sinBI2 | sin05, "Siver Package(3H)", "BI205", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI205", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin06, "Siver Package(1Day)", "BI206", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI206", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin07, "Siver Package(7Day)", "BI207", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI207", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin08, "Siver Package(30Day)", "BI208", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI208", 0, SIN_SOUND_SHELTOM),

            new Item(sinBI2 | sin09, "Gold Package(3H)", "BI209", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI209", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin10, "Gold Package(1Day)", "BI210", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI210", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin11, "Gold Package(7Day)", "BI211", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI211", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin12, "Gold Package(30Day)", "BI212", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI212", 0, SIN_SOUND_SHELTOM),

            // ===========2瞒 庆绢 器记 ================己辟眠啊060524
            // ========================================================================

            new Item(sinBI2 | sin13, "庆绢凭飘 器记(D屈)", "BI213", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI213", 0, SIN_SOUND_POTION),
            new Item(sinBI2 | sin14, "庆绢凭飘 器记(E屈)", "BI214", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI214", 0, SIN_SOUND_POTION),
            new Item(sinBI2 | sin15, "庆绢凭飘 器记(F屈)", "BI215", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI215", 0, SIN_SOUND_POTION),
            new Item(sinBI2 | sin16, "庆绢凭飘 器记(G屈)", "BI216", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI216", 0, SIN_SOUND_POTION),
            new Item(sinBI2 | sin17, "庆绢凭飘 器记(H屈)", "BI217", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI217", 0, SIN_SOUND_POTION),

            // ===========3瞒 庆绢 器记 ================己辟眠啊060809
            // ========================================================================

            new Item(sinBI2 | sin18, "庆绢凭飘 器记(I屈)", "BI218", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI218", 0, SIN_SOUND_POTION),
            new Item(sinBI2 | sin19, "庆绢凭飘 器记(J屈)", "BI219", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI219", 0, SIN_SOUND_POTION),
            new Item(sinBI2 | sin20, "庆绢凭飘 器记(K屈)", "BI220", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI220", 0, SIN_SOUND_POTION),
            new Item(sinBI2 | sin21, "庆绢凭飘 器记(L屈)", "BI221", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI221", 0, SIN_SOUND_POTION),
            new Item(sinBI2 | sin22, "庆绢凭飘 器记(M屈)", "BI222", ITEMSIZE * 1, ITEMSIZE * 1, "Premium", ITEM_CLASS_ECORE,
                    "BI222", 0, SIN_SOUND_POTION),
            // pluto 眠啊 某浆 酒捞袍
            new Item(sinBI2 | sin23, "Superior Package(3H)", "BI223", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI223", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin24, "Superior Package(1Day)", "BI224", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI224", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin25, "Superior Package(7Day)", "BI225", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI225", 0, SIN_SOUND_SHELTOM),

            new Item(sinBI2 | sin26, "Bronze Package2(3H)", "BI226", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI226", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin27, "Bronze Package2(1Day)", "BI227", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI227", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin28, "Bronze Package2(7Day)", "BI228", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI228", 0, SIN_SOUND_SHELTOM),

            new Item(sinBI2 | sin29, "Siver Package2(3H)", "BI229", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI229", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin30, "Siver Package2(1Day)", "BI230", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI230", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin31, "Siver Package2(7Day)", "BI231", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI231", 0, SIN_SOUND_SHELTOM),

            new Item(sinBI2 | sin32, "Gold Package2(3H)", "BI232", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI232", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin33, "Gold Package2(1Day)", "BI233", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI233", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin34, "Gold Package2(7Day)", "BI234", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI234", 0, SIN_SOUND_SHELTOM),

            new Item(sinBI2 | sin35, "Superior Package2(3H)", "BI235", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI235", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin36, "Superior Package2(1Day)", "BI236", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI236", 0, SIN_SOUND_SHELTOM),
            new Item(sinBI2 | sin37, "Superior Package2(7Day)", "BI237", ITEMSIZE * 1, ITEMSIZE * 1, "Premium",
                    ITEM_CLASS_ECORE, "BI237", 0, SIN_SOUND_SHELTOM),

            // 蜡聪农
            new Item(sinOR2 | sin05, "惯坊配 傅", "OR205", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_RING,
                    "or205", 0, SIN_SOUND_RING),

            // 公扁幅 欺榴
            new Item(sinPZ1 | sin01, "欺榴1", "PZ101", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ1 | sin02, "欺榴2", "PZ102", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ1 | sin03, "欺榴3", "PZ103", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ1 | sin04, "欺榴4", "PZ104", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ1 | sin05, "欺榴5", "PZ105", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ1 | sin06, "欺榴6", "PZ106", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ1 | sin07, "欺榴7", "PZ107", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ1 | sin08, "欺榴8", "PZ108", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),

            // 规绢备 欺榴
            new Item(sinPZ2 | sin01, "欺榴1", "PZ201", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ2 | sin02, "欺榴2", "PZ202", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ2 | sin03, "欺榴3", "PZ203", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ2 | sin04, "欺榴4", "PZ204", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ2 | sin05, "欺榴5", "PZ205", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ2 | sin06, "欺榴6", "PZ206", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ2 | sin07, "欺榴7", "PZ207", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinPZ2 | sin08, "欺榴8", "PZ208", ITEMSIZE * 2, ITEMSIZE * 1, "Event", ITEM_CLASS_ECORE, "PZ101", 0,
                    SIN_SOUND_Armlet),

            // 惯坊鸥牢单捞 檬妮复 & 拳捞飘单捞 荤帕
            new Item(sinCH1 | sin01, "檬妮房1", "CH101", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "CH101", 0,
                    SIN_SOUND_Armlet),
            new Item(sinCH1 | sin02, "檬妮房2", "CH102", ITEMSIZE * 2, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "CH102", 0,
                    SIN_SOUND_Armlet),
            new Item(sinCH1 | sin03, "荤帕1", "CH103", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "CH103", 0,
                    SIN_SOUND_Armlet),
            new Item(sinCH1 | sin04, "荤帕2", "CH104", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "CH104", 0,
                    SIN_SOUND_Armlet),

            // Seel (酒捞袍 犁备己)
            new Item(sinSE1 | sin01, "力扼", "SE101", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SEEL, "SE101",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinSE1 | sin02, "聪捞靛", "SE102", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SEEL, "SE102",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinSE1 | sin03, "瘤仟", "SE103", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SEEL, "SE103",
                    0, SIN_SOUND_SHELTOM),
            // 冠犁盔 - 抛捞客令 玖 眠啊
            new Item(sinSE1 | sin04, "抛捞客令", "SE104", ITEMSIZE * 1, ITEMSIZE * 1, "Accessory", ITEM_CLASS_SEEL, "SE104",
                    0, SIN_SOUND_SHELTOM),

            new Item(sinPR1 | sin01, "焊扼蝴 堡籍", "PR101", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR101",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR1 | sin02, "篮蝴 堡籍", "PR102", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR102", 0,
                    SIN_SOUND_SHELTOM),
            new Item(sinPR1 | sin03, "陛蝴 堡籍", "PR103", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR103", 0,
                    SIN_SOUND_SHELTOM),
            new Item(sinPR1 | sin04, "窍疵蝴 堡籍", "PR104", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR104",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR1 | sin05, "巢蝴 堡籍", "PR105", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR105", 0,
                    SIN_SOUND_SHELTOM),
            new Item(sinPR1 | sin06, "林炔蝴 堡籍", "PR106", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR106",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR1 | sin07, "河篮蝴 堡籍", "PR107", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR107",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR1 | sin08, "檬废蝴 堡籍", "PR108", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR108",
                    0, SIN_SOUND_SHELTOM),

            new Item(sinPR2 | sin01, "焊扼蝴 荐沥", "PR201", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR201",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR2 | sin02, "篮蝴 荐沥", "PR202", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR202", 0,
                    SIN_SOUND_SHELTOM),
            new Item(sinPR2 | sin03, "陛蝴 荐沥", "PR203", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR203", 0,
                    SIN_SOUND_SHELTOM),
            new Item(sinPR2 | sin04, "窍疵蝴 荐沥", "PR204", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR204",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR2 | sin05, "巢蝴 荐沥", "PR205", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR205", 0,
                    SIN_SOUND_SHELTOM),
            new Item(sinPR2 | sin06, "林炔蝴 荐沥", "PR206", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR206",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR2 | sin07, "河篮蝴 荐沥", "PR207", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR207",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR2 | sin08, "檬废蝴 荐沥", "PR208", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR208",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR2 | sin09, "传狼 搬沥", "PR209", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR209", 0,
                    SIN_SOUND_SHELTOM), // 厘喊
            new Item(sinPR2 | sin10, "胶畴快敲扼况", "PR210", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR210",
                    0, SIN_SOUND_SHELTOM), // 厘喊
            new Item(sinPR2 | sin11, "窍踞 传拱", "PR211", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR211", 0,
                    SIN_SOUND_SHELTOM), // 厘喊
            new Item(sinPR2 | sin12, "踌郊 荐沥", "PR212", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR212", 0,
                    SIN_SOUND_SHELTOM), // 厘喊 - 措厘厘捞狼 去
            new Item(sinPR2 | sin13, "盔籍 炼阿", "PR213", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR213", 0,
                    SIN_SOUND_SHELTOM), // 厘喊 - 措厘厘捞狼 去
            new Item(sinPR2 | sin14, "八篮蝴 荐沥", "PR214", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR214",
                    0, SIN_SOUND_SHELTOM), // 厘喊 - 措厘厘捞狼 去

            new Item(sinPR3 | sin01, "焊扼蝴 烽(A)", "PR301", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR301",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR3 | sin02, "篮蝴 烽(A)", "PR302", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR302",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR3 | sin03, "陛蝴 烽(A)", "PR303", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR303",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR3 | sin04, "窍疵蝴 烽(A)", "PR304", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR304",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR3 | sin05, "巢蝴 烽(A)", "PR305", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR305",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR3 | sin06, "林炔蝴 烽(A)", "PR306", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR306",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR3 | sin07, "河篮蝴 烽(A)", "PR307", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR307",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR3 | sin08, "檬废蝴 烽(A)", "PR308", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR308",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR3 | sin09, "胶畴快 烽(A)", "PR309", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR309",
                    0, SIN_SOUND_SHELTOM), // 厘喊
            new Item(sinPR3 | sin10, "敲扼况 烽(A)", "PR310", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR310",
                    0, SIN_SOUND_SHELTOM), // 厘喊
            new Item(sinPR3 | sin11, "拳捞飘 烽(A)", "PR311", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR311",
                    0, SIN_SOUND_SHELTOM), // 厘喊
            new Item(sinPR3 | sin12, "老风怜 烽(A)", "PR312", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR312",
                    0, SIN_SOUND_SHELTOM), // 厘喊 - 措厘厘捞狼 去
            new Item(sinPR3 | sin13, "酒捞叼倔 烽(A)", "PR313", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL,
                    "PR313", 0, SIN_SOUND_SHELTOM), // 厘喊 - 措厘厘捞狼 去
            new Item(sinPR3 | sin14, "宏饭捞农 烽(A)", "PR314", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL,
                    "PR314", 0, SIN_SOUND_SHELTOM), // 厘喊 - 措厘厘捞狼 去

            new Item(sinPR4 | sin01, "焊扼蝴 烽(B)", "PR401", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR401",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR4 | sin02, "篮蝴 烽(B)", "PR402", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR402",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR4 | sin03, "陛蝴 烽(B)", "PR403", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR403",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR4 | sin04, "窍疵蝴 烽(B)", "PR404", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR404",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR4 | sin05, "巢蝴 烽(B)", "PR405", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR405",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR4 | sin06, "林炔蝴 烽(B)", "PR406", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR406",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR4 | sin07, "河篮蝴 烽(B)", "PR407", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR407",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR4 | sin08, "檬废蝴 烽(B)", "PR408", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR408",
                    0, SIN_SOUND_SHELTOM),
            new Item(sinPR4 | sin09, "胶畴快 烽(B)", "PR409", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR409",
                    0, SIN_SOUND_SHELTOM), // 厘喊
            new Item(sinPR4 | sin10, "敲扼况 烽(B)", "PR410", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR410",
                    0, SIN_SOUND_SHELTOM), // 厘喊
            new Item(sinPR4 | sin11, "拳捞飘 烽(B)", "PR411", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR411",
                    0, SIN_SOUND_SHELTOM), // 厘喊
            new Item(sinPR4 | sin12, "老风怜 烽(B)", "PR412", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL, "PR412",
                    0, SIN_SOUND_SHELTOM), // 厘喊 - 措厘厘捞狼 去
            new Item(sinPR4 | sin13, "酒捞叼倔 烽(B)", "PR413", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL,
                    "PR413", 0, SIN_SOUND_SHELTOM), // 厘喊 - 措厘厘捞狼 去
            new Item(sinPR4 | sin14, "宏饭捞农 烽(B)", "PR414", ITEMSIZE * 1, ITEMSIZE * 1, "Event", ITEM_CLASS_SEEL,
                    "PR414", 0, SIN_SOUND_SHELTOM), // 厘喊 - 措厘厘捞狼 去

            new Item(sinWR1 | sin01, "镭囚柳 公扁 力累辑", "WR101", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "WR101", 0, SIN_SOUND_SHELTOM),
            new Item(sinWR1 | sin02, "绊措狼 公扁 力累辑", "WR102", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "WR102", 0, SIN_SOUND_SHELTOM),
            new Item(sinWR1 | sin03, "措瘤狼 公扁 力累辑", "WR103", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "WR103", 0, SIN_SOUND_SHELTOM),
            new Item(sinWR1 | sin04, "绢狄狼 公扁 力累辑", "WR104", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "WR104", 0, SIN_SOUND_SHELTOM),
            new Item(sinWR1 | sin05, "拳堪狼 公扁 力累辑", "WR105", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "WR105", 0, SIN_SOUND_SHELTOM),
            new Item(sinWR1 | sin06, "官恩狼 公扁 力累辑", "WR106", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "WR106", 0, SIN_SOUND_SHELTOM),
            new Item(sinWR1 | sin07, "怕剧狼 公扁 力累辑", "WR107", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "WR107", 0, SIN_SOUND_SHELTOM),
            new Item(sinWR1 | sin08, "堡器茄 公扁 力累辑", "WR108", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "WR108", 0, SIN_SOUND_SHELTOM),
            new Item(sinWR1 | sin09, "玫惑狼 公扁 力累辑", "WR109", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "WR109", 0, SIN_SOUND_SHELTOM),

            new Item(sinDR1 | sin01, "镭囚柳 规绢备 力累辑", "DR101", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "DR101", 0, SIN_SOUND_SHELTOM),
            new Item(sinDR1 | sin02, "绊措狼 规绢备 力累辑", "DR102", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "DR102", 0, SIN_SOUND_SHELTOM),
            new Item(sinDR1 | sin03, "措瘤狼 规绢备 力累辑", "DR103", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "DR103", 0, SIN_SOUND_SHELTOM),
            new Item(sinDR1 | sin04, "绢狄狼 规绢备 力累辑", "DR104", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "DR104", 0, SIN_SOUND_SHELTOM),
            new Item(sinDR1 | sin05, "拳堪狼 规绢备 力累辑", "DR105", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "DR105", 0, SIN_SOUND_SHELTOM),
            new Item(sinDR1 | sin06, "官恩狼 规绢备 力累辑", "DR106", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "DR106", 0, SIN_SOUND_SHELTOM),
            new Item(sinDR1 | sin07, "怕剧狼 规绢备 力累辑", "DR107", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "DR107", 0, SIN_SOUND_SHELTOM),
            new Item(sinDR1 | sin08, "堡器茄 规绢备 力累辑", "DR108", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "DR108", 0, SIN_SOUND_SHELTOM),
            new Item(sinDR1 | sin09, "玫惑狼 规绢备 力累辑", "DR109", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE,
                    "DR109", 0, SIN_SOUND_SHELTOM),
            new Item(sinDR1 | sin10, "器汲狼 力累辑", "DR110", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "DR110",
                    0, SIN_SOUND_SHELTOM), // 厘喊
            new Item(sinDR1 | sin11, "扁撅狼 力累辑", "DR111", ITEMSIZE * 1, ITEMSIZE * 2, "Event", ITEM_CLASS_ECORE, "DR111",
                    0, SIN_SOUND_SHELTOM), // 厘喊 - 措厘厘捞狼 去

            // 捣 俩风 付瘤阜俊 持绢具茄促 (恐牢瘤绰 扁撅捞 救唱匙 ........)
            new Item(sinGG1 | sin01, "Gold", "GG101", ITEMSIZE * 1, ITEMSIZE * 1, "Gold", 0, "DRCOIN", 0,
                    SIN_SOUND_COIN),
            new Item(sinGG1 | sin02, "Exp", "GG102", ITEMSIZE * 1, ITEMSIZE * 1, "Exp", 0, "DRExp", 0,
                    SIN_SOUND_MAGICIAL), };
}
