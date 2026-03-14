CREATE TABLE BBSMain(
	IDX integer NOT NULL,
	MIDX integer NOT NULL,
	Userid varchar(25) NOT NULL,
	WriteName varchar(100) NOT NULL,
	Title varchar(600) NOT NULL,
	Content text NOT NULL,
	SelServer integer NOT NULL,
	RegiDate timestamp without time zone NOT NULL,
	RegiIP char(15) NOT NULL,
	Hit integer NOT NULL,
	CountCom integer NOT NULL,
	NickName varchar(32) NULL
);
CREATE TABLE BBSSub(
	SIDX integer NOT NULL,
	MINDEX integer NOT NULL,
	Userid varchar(25) NOT NULL,
	WriteName varchar(100) NOT NULL,
	Content text NOT NULL,
	RegiDate timestamp without time zone NOT NULL,
	RegiIP char(15) NOT NULL,
	NickName varchar(32) NULL
);
CREATE TABLE BellatraPersonalScore(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	CharacterName varchar(32) NOT NULL,
	Kills integer NOT NULL,
	Score integer NOT NULL,
	Date varchar(50) NOT NULL
);
CREATE TABLE BellatraPersonalScoreNew(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharacterID integer NOT NULL,
	CharacterName varchar(32) NOT NULL,
	CharacterClass integer NOT NULL,
	CharacterLevel integer NOT NULL,
	Kills integer NOT NULL,
	Score integer NOT NULL,
	UnixTime integer NOT NULL,
	Date timestamp without time zone NOT NULL
);
CREATE TABLE BellatraTeamScore(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	CharacterName varchar(32) NOT NULL,
	JobCode integer NOT NULL,
	Level integer NOT NULL,
	ClanCode integer NOT NULL,
	Score integer NOT NULL,
	Kills integer NOT NULL,
	TotalPoint integer NOT NULL,
	TotalUser integer NOT NULL,
	SuccessUser integer NOT NULL,
	Code integer NOT NULL,
	Quake integer NOT NULL,
	StunSeal integer NOT NULL,
	FreezeSeal integer NOT NULL,
	RabieSeal integer NOT NULL,
	StygianSeal integer NOT NULL,
	GuardianSaintSeal integer NOT NULL,
	PointBag integer NOT NULL,
	Date varchar(50) NOT NULL
);
CREATE TABLE ChipLog(
	LgIDX integer NOT NULL,
	CIDX integer NOT NULL,
	CServer integer NOT NULL,
	Userid varchar(50) NOT NULL,
	Chname varchar(50) NOT NULL,
	Permi char(2) NOT NULL,
	RegiDate timestamp without time zone NOT NULL
);
CREATE TABLE CL(
	IDX integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	ClanName varchar(50) NOT NULL,
	Note text NOT NULL,
	NoteCnt integer NOT NULL,
	UserID varchar(50) NULL,
	ClanZang varchar(50) NOT NULL,
	Flag integer NOT NULL,
	MemCnt integer NOT NULL,
	MIconCnt integer NOT NULL,
	RegiDate timestamp without time zone NOT NULL,
	LimitDate timestamp without time zone NOT NULL,
	SodDate timestamp without time zone NULL,
	DelActive char(1) NOT NULL,
	PFlag integer NOT NULL,
	KFlag integer NOT NULL,
	Cpoint integer NULL,
	CWin integer NULL,
	CFail integer NULL,
	ClanMoney bigint NULL,
	CNFlag integer NULL,
	SiegeMoney bigint NULL
);
CREATE TABLE ClanHome(
	IDX integer NOT NULL,
	MIDX integer NOT NULL,
	SelServer integer NOT NULL,
	Intro varchar(300) NULL,
	Image varchar(50) NULL,
	Skin integer NULL,
	PrivHome integer NULL,
	PrivMem integer NULL,
	PrivBoard integer NULL
);
CREATE TABLE ClanList(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	ClanName varchar(32) NOT NULL,
	ClanLeader varchar(32) NOT NULL,
	Note varchar(50) NOT NULL,
	AccountName varchar(20) NOT NULL,
	MembersCount integer NOT NULL,
	IconID integer NOT NULL,
	RegisDate integer NOT NULL,
	LimitDate integer NOT NULL,
	DeleteActive integer NOT NULL,
	Flag integer NOT NULL,
	SiegeWarPoints integer NOT NULL,
	BellatraPoints integer NOT NULL,
	SiegeWarGold integer NOT NULL,
	BellatraGold integer NOT NULL,
	BellatraDate bigint NOT NULL,
	LoginMessage varchar(128) NOT NULL
);
CREATE TABLE ClanMainCharChangeLog(
	IDX integer NOT NULL,
	UserID varchar(50) NULL,
	BeforeCharName varchar(50) NULL,
	AfterCharName varchar(50) NULL,
	CServer integer NULL,
	RegiDate timestamp without time zone NULL
);
CREATE TABLE ClanMainDeleted(
	IDX integer NOT NULL,
	MIDX integer NOT NULL,
	ClanName varchar(50) NOT NULL,
	Userid varchar(50) NULL,
	ClanZang varchar(50) NOT NULL,
	Flag integer NOT NULL,
	MemCnt integer NOT NULL,
	MIConCnt integer NOT NULL,
	RegiDate timestamp without time zone NOT NULL,
	LimitDate timestamp without time zone NOT NULL,
	DelDate timestamp without time zone NOT NULL,
	DelActive char(1) NOT NULL,
	PFlag integer NOT NULL,
	KFlag integer NOT NULL,
	DelState char(1) NOT NULL,
	DelCase char(10) NOT NULL,
	Server integer NOT NULL
);
CREATE TABLE ClanMainView(
	IDX integer NOT NULL,
	ClanName varchar(50) NOT NULL,
	Note text NOT NULL,
	NoteCnt integer NOT NULL,
	UserID varchar(50) NULL,
	ClanZang varchar(50) NOT NULL,
	Flag integer NOT NULL,
	MemCnt integer NOT NULL,
	MIconCnt integer NOT NULL,
	RegiDate timestamp without time zone NOT NULL,
	LimitDate timestamp without time zone NOT NULL,
	DelActive char(1) NOT NULL,
	PFlag integer NOT NULL,
	KFlag integer NOT NULL,
	Cpoint integer NULL,
	CWin integer NULL,
	CFail integer NULL,
	ClanMoney bigint NULL,
	CNFlag integer NULL,
	SiegeMoney bigint NULL,
	Server varchar(1) NOT NULL
);
CREATE TABLE ClanMoneyLog(
	IDX integer NOT NULL,
	CIDX integer NULL,
	UserID varchar(50) NULL,
	chName varchar(50) NULL,
	ServerName varchar(50) NULL,
	Operator varchar(50) NULL,
	OperCode char(10) NULL,
	ClanMoney bigint NULL,
	RegistDay timestamp without time zone NULL,
	Note varchar(50) NULL
);
CREATE TABLE ClanSubCharChangeLog(
	IDX integer NOT NULL,
	UserID varchar(50) NULL,
	BeforeCharName varchar(50) NULL,
	AfterCharName varchar(50) NULL,
	CServer integer NULL,
	RegiDate timestamp without time zone NULL
);
CREATE TABLE ClanSubDeleted(
	IDX integer NOT NULL,
	MIDX integer NOT NULL,
	userid varchar(50) NOT NULL,
	ChName varchar(50) NOT NULL,
	ChType integer NULL,
	ChLv integer NULL,
	ClanName varchar(50) NULL,
	Permi char(2) NOT NULL,
	JoinDate timestamp without time zone NOT NULL,
	DelActive char(1) NOT NULL,
	PFlag integer NOT NULL,
	KFlag integer NOT NULL,
	DelDate timestamp without time zone NOT NULL,
	DelState char(1) NOT NULL,
	DelCase char(10) NULL,
	Server integer NOT NULL
);
CREATE TABLE ClanSubView(
	IDX integer NOT NULL,
	MIDX integer NOT NULL,
	userid varchar(50) NOT NULL,
	ChName varchar(50) NOT NULL,
	ChType integer NULL,
	ChLv integer NULL,
	ClanName varchar(50) NULL,
	Permi char(2) NOT NULL,
	JoinDate timestamp without time zone NOT NULL,
	DelActive char(1) NOT NULL,
	PFlag integer NOT NULL,
	KFlag integer NOT NULL,
	Server varchar(1) NOT NULL
);
CREATE TABLE ClanTicket(
	SNo integer NULL,
	ServerName varchar(50) NULL,
	MIDX integer NULL,
	ClanName varchar(50) NULL,
	ClanJang integer NULL,
	ClanImage varchar(50) NULL,
	UserID varchar(25) NULL,
	ChName varchar(50) NULL,
	GPCode varchar(20) NULL,
	LogonTime timestamp without time zone NULL,
	IP varchar(20) NULL,
	RNo integer NULL,
	Flag integer NULL
);
CREATE TABLE CT(
	SNo integer NULL,
	ServerName varchar(50) NULL,
	MIDX integer NULL,
	ClanName varchar(50) NULL,
	ClanJang integer NULL,
	ClanImage varchar(50) NULL,
	UserID varchar(25) NULL,
	ChName varchar(50) NULL,
	GPCode varchar(20) NULL,
	LogonTime timestamp without time zone NULL,
	IP varchar(20) NULL,
	RNo integer NULL,
	Flag integer NULL
);
CREATE TABLE GameNotice(
	UserID varchar(50) NULL,
	ChName varchar(50) NULL,
	Server integer NULL,
	PFlag integer NULL,
	Txt varchar(1000) NULL,
	Flag integer NULL
);
CREATE TABLE GameNoticeGroup(
	IDX integer NOT NULL,
	GroupCD integer NOT NULL,
	MainCD integer NOT NULL,
	DetailCD integer NOT NULL,
	Title varchar(50) NOT NULL,
	Content text NOT NULL,
	FromDay timestamp without time zone NOT NULL,
	ToDay timestamp without time zone NOT NULL,
	RegistDay timestamp without time zone NOT NULL,
	DelActive integer NOT NULL,
	Hit integer NOT NULL,
	Flag integer NULL
);
CREATE TABLE GameNoticePrivate(
	IDX integer NOT NULL,
	Userid varchar(50) NOT NULL,
	Title varchar(50) NOT NULL,
	Content text NOT NULL,
	FromDay timestamp without time zone NOT NULL,
	ToDay timestamp without time zone NOT NULL,
	RegistDay timestamp without time zone NOT NULL,
	DelActive integer NOT NULL,
	Hit integer NOT NULL,
	Flag integer NULL
);
CREATE TABLE LI(
	IMG integer NOT NULL,
	ID integer NOT NULL
);
CREATE TABLE Notice(
	IDX integer NOT NULL,
	MIDX integer NOT NULL,
	Userid varchar(25) NOT NULL,
	WriteName varchar(100) NOT NULL,
	Title varchar(600) NOT NULL,
	Content text NOT NULL,
	SelServer integer NOT NULL,
	RegiDate timestamp without time zone NOT NULL,
	RegiIP char(15) NOT NULL,
	Hit integer NOT NULL
);
CREATE TABLE PRBbsFile(
	IDX integer NOT NULL,
	MINDEX integer NOT NULL,
	FileName varchar(255) NOT NULL,
	FileSize varchar(100) NOT NULL,
	RegiDate timestamp without time zone NOT NULL
);
CREATE TABLE PRBBSMain(
	IDX integer NOT NULL,
	PMNo varchar(20) NOT NULL,
	Userid varchar(25) NOT NULL,
	Title varchar(600) NOT NULL,
	Content text NOT NULL,
	UserName varchar(100) NOT NULL,
	ClanIdx integer NOT NULL,
	SelServer integer NOT NULL,
	RegiDate timestamp without time zone NOT NULL,
	RegiIP char(15) NOT NULL,
	Hit integer NOT NULL,
	CountCom integer NOT NULL
);
CREATE TABLE PRBBSSub(
	SIDX integer NOT NULL,
	MINDEX integer NOT NULL,
	PMNo varchar(20) NOT NULL,
	userid varchar(25) NOT NULL,
	writename varchar(100) NOT NULL,
	Content text NOT NULL,
	RegiDate timestamp without time zone NOT NULL,
	RegiIP char(15) NOT NULL,
	UserName varchar(100) NOT NULL
);
CREATE TABLE SiegeClanList(
	IDX integer NOT NULL,
	UserID varchar(50) NOT NULL,
	CharName varchar(50) NOT NULL,
	ClanName varchar(50) NOT NULL,
	TaxRate integer NOT NULL,
	ServerName varchar(50) NOT NULL,
	Server integer NOT NULL,
	OperFrom timestamp without time zone NULL,
	OperTo timestamp without time zone NULL,
	RegistDay timestamp without time zone NOT NULL
);
CREATE TABLE SiegeCurrentList(
	IDX integer NOT NULL,
	CIDX integer NULL,
	UserID varchar(50) NULL,
	chName varchar(50) NULL,
	ServerName varchar(50) NULL,
	Operator varchar(50) NULL,
	OperCode char(10) NULL,
	SiegeMoney bigint NULL,
	RegistDay timestamp without time zone NULL
);
CREATE TABLE SiegeMoneyLog(
	IDX integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	CIDX integer NULL,
	UserID varchar(50) NULL,
	chName varchar(50) NULL,
	ServerName varchar(50) NULL,
	Operator varchar(50) NULL,
	OperCode char(10) NULL,
	SiegeMoney bigint NULL,
	RegistDay timestamp without time zone NULL
);
CREATE TABLE SiegeMoneyTax(
	DNo integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	IDX integer NULL,
	Mixing bigint NULL,
	Aging bigint NULL,
	Shop bigint NULL,
	Poison1 bigint NULL,
	Poison2 bigint NULL,
	Poison3 bigint NULL,
	Force bigint NULL,
	Warpgate bigint NULL,
	Skill bigint NULL,
	Total bigint NULL,
	Tax bigint NULL,
	ServerName varchar(50) NULL,
	RegistDay timestamp without time zone NULL
);
CREATE TABLE UL(
	IDX integer NOT NULL,
	MIDX integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	userid varchar(50) NOT NULL,
	ChName varchar(50) NOT NULL,
	ChType integer NULL,
	ChLv integer NULL,
	ClanName varchar(50) NULL,
	Permi char(2) NOT NULL,
	JoinDate timestamp without time zone NOT NULL,
	DelActive char(1) NOT NULL,
	PFlag integer NOT NULL,
	KFlag integer NOT NULL,
	MIconCnt integer NOT NULL
);
