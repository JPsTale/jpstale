DROP TABLE CharacterExpDef;
CREATE TABLE CharacterExpDef(
	Level integer NOT NULL,
	ExpRequired bigint NOT NULL
);

CREATE TABLE CharacterInfo(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	Name varchar(32) NOT NULL,
	OldHead varchar(64) NOT NULL,
	Level integer NOT NULL,
	Experience bigint NOT NULL,
	Gold integer NOT NULL,
	JobCode integer NOT NULL,
	ClanID integer NOT NULL,
	ClanPermission integer NOT NULL,
	ClanLeaveDate integer NOT NULL,
	LastSeenDate timestamp without time zone NOT NULL,
	BlessCastleScore integer NOT NULL,
	FSP integer NOT NULL,
	LastStage integer NOT NULL,
	IsOnline integer NOT NULL,
	Seasonal integer NOT NULL,
	GMLevel integer NOT NULL,
	Banned integer NOT NULL,
	Title integer NULL,
	DialogSkin integer NULL,
	LevelUpDate timestamp without time zone NULL
);

CREATE TABLE CharacterInfoDelete(
	ID integer NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	Name varchar(32) NOT NULL,
	OldHead varchar(64) NOT NULL,
	Level integer NOT NULL,
	Experience bigint NOT NULL,
	Gold integer NOT NULL,
	JobCode integer NOT NULL,
	ClanID integer NOT NULL,
	ClanPermission integer NOT NULL,
	ClanLeaveDate integer NOT NULL,
	LastSeenDate varchar(50) NOT NULL,
	BlessCastleScore integer NOT NULL,
	FSP integer NOT NULL,
	LastStage integer NOT NULL,
	IsOnline integer NOT NULL,
	Seasonal integer NOT NULL,
	GMLevel integer NOT NULL,
	Banned integer NOT NULL,
	Title integer NULL,
	DialogSkin integer NULL
);

CREATE TABLE CharacterItemTimer(
    ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharacterID integer NOT NULL,
	CharacterName varchar(32) NOT NULL,
	ItemTimerType integer NOT NULL,
	ItemID integer NOT NULL,
	TimeLeft integer NOT NULL,
	TimeTotal integer NOT NULL
);

CREATE TABLE CharacterMonsterKillTracker(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharacterID integer NOT NULL,
	MonsterID integer NOT NULL,
	MonsterName varchar(32) NOT NULL,
	KillCount integer NOT NULL
);

CREATE TABLE CharacterPvP(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharacterName varchar(32) NOT NULL,
	Kills integer NOT NULL,
	Deaths integer NOT NULL,
	KillStreak integer NOT NULL,
	TopPvP integer NOT NULL
);

CREATE TABLE CharacterQuest(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	QuestID integer NOT NULL,
	QuestRewardID integer NOT NULL,
	CharacterID integer NOT NULL,
	AccountName varchar(32) NOT NULL,
	CharacterName varchar(32) NOT NULL,
	StartDate timestamp without time zone NOT NULL,
	EndDate timestamp without time zone NULL,
	MonsterCount varchar(64) NULL,
	ItemCount varchar(64) NULL,
	TimeLeft integer NOT NULL,
	Counter integer NULL
);

CREATE TABLE CharacterTitleList(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharacterID integer NOT NULL,
	TitleID integer NOT NULL,
	DateAcquired timestamp without time zone NOT NULL
);

CREATE TABLE ClassDef(
	ClassID integer NOT NULL PRIMARY KEY,
	ClassName varchar(20) NOT NULL
);

CREATE TABLE ItemBox(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	ItemCode varchar(32) NOT NULL,
	Item varchar(32) NULL,
	ItemSpec integer NOT NULL,
	CoinShop integer NOT NULL,
	HasItem integer NULL,
	DateReceived timestamp without time zone NULL
);

CREATE TABLE NotificationData(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	Message varchar(100) NOT NULL,
	Checked integer NOT NULL
);

CREATE TABLE TitleDef(
	TitleID integer NOT NULL PRIMARY KEY,
	TitleCategory varchar(16) NOT NULL,
	SubCategory varchar(16) NULL,
	Title varchar(21) NOT NULL,
	TitleRarity smallint NOT NULL
);
CREATE TABLE UserInfo(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	Password varchar(64) NOT NULL,
	RegisDay varchar(50) NOT NULL,
	Flag integer NOT NULL,
	Active integer NOT NULL,
	ActiveCode varchar(50) NOT NULL,
	Coins integer NOT NULL,
	Email varchar(150) NOT NULL,
	GameMasterType integer NOT NULL,
	GameMasterLevel integer NOT NULL,
	GameMasterMacAddress varchar(20) NOT NULL,
	CoinsTraded integer NOT NULL,
	BanStatus integer NOT NULL,
	UnbanDate timestamp without time zone NULL,
	IsMuted integer NOT NULL,
	MuteCount integer NOT NULL,
	UnmuteDate timestamp without time zone NULL
);

-- 存储过程：根据莫里普（MonsterID=1258）击杀数授予称号（50~54）
CREATE OR REPLACE PROCEDURE public.GiveWantedMoriphTitlesBasedOnKills()
LANGUAGE plpgsql
AS $$
BEGIN
    -- 清除旧的称号记录
    DELETE FROM public.CharacterTitleList WHERE titleid IN (50, 51, 52, 53, 54);

    -- 插入各档位称号
    INSERT INTO public.CharacterTitleList (characterid, titleid, dateacquired)
    SELECT characterid, 50, CURRENT_TIMESTAMP
    FROM public.CharacterMonsterKillTracker
    WHERE monsterid = 1258 AND killcount > 50;

    INSERT INTO public.CharacterTitleList (characterid, titleid, dateacquired)
    SELECT characterid, 51, CURRENT_TIMESTAMP
    FROM public.CharacterMonsterKillTracker
    WHERE monsterid = 1258 AND killcount > 250;

    INSERT INTO public.CharacterTitleList (characterid, titleid, dateacquired)
    SELECT characterid, 52, CURRENT_TIMESTAMP
    FROM public.CharacterMonsterKillTracker
    WHERE monsterid = 1258 AND killcount > 500;

    INSERT INTO public.CharacterTitleList (characterid, titleid, dateacquired)
    SELECT characterid, 53, CURRENT_TIMESTAMP
    FROM public.CharacterMonsterKillTracker
    WHERE monsterid = 1258 AND killcount > 1250;

    INSERT INTO public.CharacterTitleList (characterid, titleid, dateacquired)
    SELECT characterid, 54, CURRENT_TIMESTAMP
    FROM public.CharacterMonsterKillTracker
    WHERE monsterid = 1258 AND killcount > 2500;
END;
$$;

-- 存储过程：根据狼（MonsterID=1253）击杀数授予称号（70~74）
CREATE OR REPLACE PROCEDURE public.GiveWantedWolfTitlesBasedOnKills()
LANGUAGE plpgsql
AS $$
BEGIN
    -- 清除旧的称号记录
    DELETE FROM public.CharacterTitleList WHERE titleid IN (70, 71, 72, 73, 74);

    -- 插入各档位称号
    INSERT INTO public.CharacterTitleList (characterid, titleid, dateacquired)
    SELECT characterid, 70, CURRENT_TIMESTAMP
    FROM public.CharacterMonsterKillTracker
    WHERE monsterid = 1253 AND killcount > 50;

    INSERT INTO public.CharacterTitleList (characterid, titleid, dateacquired)
    SELECT characterid, 71, CURRENT_TIMESTAMP
    FROM public.CharacterMonsterKillTracker
    WHERE monsterid = 1253 AND killcount > 250;

    INSERT INTO public.CharacterTitleList (characterid, titleid, dateacquired)
    SELECT characterid, 72, CURRENT_TIMESTAMP
    FROM public.CharacterMonsterKillTracker
    WHERE monsterid = 1253 AND killcount > 500;

    INSERT INTO public.CharacterTitleList (characterid, titleid, dateacquired)
    SELECT characterid, 73, CURRENT_TIMESTAMP
    FROM public.CharacterMonsterKillTracker
    WHERE monsterid = 1253 AND killcount > 1250;

    INSERT INTO public.CharacterTitleList (characterid, titleid, dateacquired)
    SELECT characterid, 74, CURRENT_TIMESTAMP
    FROM public.CharacterMonsterKillTracker
    WHERE monsterid = 1253 AND killcount > 2500;
END;
$$;