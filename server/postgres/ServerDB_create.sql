-- Auto-converted from server\mssql\ServerDB.sql
-- 请在测试环境中验证类型、约束和序列设置是否符合预期。





CREATE ROLE db_table_spawn

CREATE TABLE BellatraReward(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	ItemCode varchar(32) NOT NULL,
	Quantity integer NOT NULL,
	Percent integer NOT NULL,
 CONSTRAINT PK_BellatraReward PRIMARY KEY(ID));
CREATE TABLE BlessCastleSettings(
	ClanID1 integer NOT NULL,
	ClanID2 integer NOT NULL,
	ClanID3 integer NOT NULL,
	Tax integer NOT NULL,
	Skill integer NOT NULL,
	Tower1Type integer NOT NULL,
	Tower2Type integer NOT NULL,
	Tower3Type integer NOT NULL,
	Tower4Type integer NOT NULL,
	Tower5Type integer NOT NULL,
	Tower6Type integer NOT NULL,
	Guard1Amount integer NOT NULL,
	Guard2Amount integer NOT NULL,
	Guard3Amount integer NOT NULL
);
CREATE TABLE Command(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	CommandTypeID integer NOT NULL,
	Parameter1 varchar(64) NULL,
	Parameter2 varchar(64) NULL,
	Parameter3 varchar(64) NULL,
	DateProcessed timestamp without time zone NULL,
 CONSTRAINT PK_Command PRIMARY KEY(ID));
CREATE TABLE CrashData(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	AccountName varchar(32) NOT NULL,
	IP varchar(16) NOT NULL,
	Version integer NOT NULL,
	Address integer NOT NULL,
	Flags integer NOT NULL,
	Code integer NOT NULL,
	EAX integer NOT NULL,
	ECX integer NOT NULL,
	EDX integer NOT NULL,
	EBX integer NOT NULL,
	ESP integer NOT NULL,
	EBP integer NOT NULL,
	ESI integer NOT NULL,
	EDI integer NOT NULL,
	EIP integer NOT NULL,
	DateReceived timestamp without time zone NOT NULL,
 CONSTRAINT PK_CrashData PRIMARY KEY(ID));
CREATE TABLE FunctionChecksumList(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	Size integer NOT NULL,
	Address varchar(50) NOT NULL,
	Checksum varchar(32) NOT NULL,
 CONSTRAINT PK_FunctionChecksumList PRIMARY KEY(ID));
CREATE TABLE FuryArena(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	ItemCode varchar(32) NOT NULL,
	Percent integer NOT NULL,
	BossID integer NOT NULL,
 CONSTRAINT PK_FuryArena PRIMARY KEY(ID));
CREATE TABLE GMCommand(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	AccountName varchar(32) NOT NULL,
	Command varchar(100) NOT NULL,
	UnixTime integer NOT NULL,
	UnixTimeToExecute integer NOT NULL,
	IsActive integer NOT NULL,
	Result integer NOT NULL,
 CONSTRAINT PK_GMCommand PRIMARY KEY(ID));
CREATE TABLE Maintenance(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	Mode integer NOT NULL,
	IP varchar(32) NOT NULL,
	Corno varchar(50) NULL,
 CONSTRAINT PK_Maintenance PRIMARY KEY(ID));
CREATE TABLE MessageLogin(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	Message varchar(128) NOT NULL,
 CONSTRAINT PK_MessageLogin PRIMARY KEY(ID));
CREATE TABLE Metadata(
	Key varchar(30) NOT NULL,
	Value integer NOT NULL,
	IsPublic integer NOT NULL,
 CONSTRAINT PK_Metadata PRIMARY KEY 
(
	Key 
)
);
CREATE TABLE OnlineReward(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	ItemCode varchar(32) NOT NULL,
	Quantity integer NOT NULL,
	Percent integer NOT NULL,
 CONSTRAINT PK_OnlineReward PRIMARY KEY(ID));
CREATE TABLE PostBox(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	AccountName varchar(32) NOT NULL,
	Item varchar(32) NOT NULL,
	SpecOrCount integer NOT NULL,
 CONSTRAINT PK_PostBox PRIMARY KEY(ID));
CREATE TABLE SpawnCamera(
	MapNumber integer NOT NULL,
	SpawnX integer NOT NULL,
	SpawnY integer NOT NULL,
	SpawnZ integer NOT NULL,
	CamXCoord integer NOT NULL,
	CamZCoord integer NOT NULL,
	CamTurn integer NOT NULL,
	CamAngle integer NOT NULL,
	CamZoom integer NOT NULL,
	MinPlayerCount integer NOT NULL,
	SearchRadius integer NOT NULL,
	SpawnType integer NOT NULL
);
CREATE TABLE UsersOnline(
	AccountName varchar(32) NOT NULL,
	CharacterName varchar(32) NOT NULL,
	IP varchar(32) NOT NULL,
	CharacterClass integer NOT NULL,
	CharacterLevel integer NOT NULL,
	Ticket integer NOT NULL,
	LoginTime timestamp without time zone NOT NULL
);
CREATE TABLE WindowCheatList(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL,
	WindowName varchar(64) NOT NULL,
 CONSTRAINT PK_WindowCheatList PRIMARY KEY(ID));
