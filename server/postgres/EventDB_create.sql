
CREATE TABLE BellatraMonster(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	Round integer NOT NULL,
	Monster1 varchar(32) NOT NULL,
	Count1 integer NOT NULL,
	Monster2 varchar(32) NOT NULL,
	Count2 integer NOT NULL,
	Monster3 varchar(32) NOT NULL,
	Count3 integer NOT NULL,
	Monster4 varchar(32) NOT NULL,
	Count4 integer NOT NULL,
	Boss varchar(32) NOT NULL,
	BossAppear integer NOT NULL,
	ViewSight integer NOT NULL,
	StartRound integer NOT NULL,
	Gold integer NOT NULL,
	DelayRound integer NOT NULL,
	PercentMonsters integer NOT NULL,
	MaxMonsters integer NOT NULL,
);

CREATE TABLE BellatraMonsterDebugMode(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	Round integer NOT NULL,
	Monster1 varchar(32) NOT NULL,
	Count1 integer NOT NULL,
	Monster2 varchar(32) NOT NULL,
	Count2 integer NOT NULL,
	Monster3 varchar(32) NOT NULL,
	Count3 integer NOT NULL,
	Monster4 varchar(32) NOT NULL,
	Count4 integer NOT NULL,
	Boss varchar(32) NOT NULL,
	BossAppear integer NOT NULL,
	ViewSight integer NOT NULL,
	StartRound integer NOT NULL,
	Gold integer NOT NULL,
	DelayRound integer NOT NULL,
	PercentMonsters integer NOT NULL,
	MaxMonsters integer NOT NULL,
);

CREATE TABLE FuryArenaRewardTracker(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	FuryEventID integer NOT NULL,
	CharacterID integer NOT NULL,
);

CREATE TABLE WantedMoriphDrops(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharID integer NOT NULL,
	MapID integer NOT NULL,
	ItemName varchar(32) NOT NULL,
	UnixTime integer NOT NULL,
);

CREATE TABLE WantedMoriphKills(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharID integer NOT NULL,
	MapID integer NOT NULL,
	UnixTime integer NOT NULL,
);

CREATE TABLE WantedWolfDrops(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharID integer NOT NULL,
	MapID integer NOT NULL,
	ItemName varchar(32) NOT NULL,
	UnixTime integer NOT NULL,
);

CREATE TABLE WantedWolfKills(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharID integer NOT NULL,
	MapID integer NOT NULL,
	UnixTime integer NOT NULL,
);
