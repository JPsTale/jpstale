CREATE TABLE AccountLog(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	IP varchar(50) NOT NULL,
	AccountName varchar(32) NOT NULL,
	LogID integer NOT NULL,
	Description varchar(512) NOT NULL,
	Date timestamp without time zone NOT NULL,
	ServerID integer NOT NULL
);

CREATE TABLE AgingRecovery(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	CharacterID integer NOT NULL,
	Date timestamp without time zone NOT NULL,
	ItemName varchar(32) NOT NULL,
	AgeNumber integer NOT NULL,
	Code1 integer NOT NULL,
	Code2 integer NOT NULL,
	DateRecovered timestamp without time zone NULL
);

CREATE TABLE BellatraRewardLog(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	Name varchar(32) NOT NULL,
	ItemName varchar(32) NOT NULL,
	Quantity integer NOT NULL,
	Date timestamp without time zone NOT NULL
);

CREATE TABLE CharacterLog(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	IP varchar(50) NOT NULL,
	AccountName varchar(50) NOT NULL,
	LogID integer NOT NULL,
	Description varchar(256) NOT NULL,
	Date timestamp without time zone NOT NULL,
	ServerID integer NOT NULL
);

CREATE TABLE CheatLog(
	ID bigint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	IP varchar(20) NOT NULL,
	AccountName varchar(32) NOT NULL,
	Action integer NOT NULL,
	LogID integer NOT NULL,
	Description varchar(256) NOT NULL,
	Date timestamp without time zone NOT NULL,
	ServerID integer NOT NULL
);

CREATE TABLE CoinLog(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	Description varchar(256) NOT NULL,
	Date timestamp without time zone NOT NULL
);

CREATE TABLE Disconnects(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	IP varchar(32) NOT NULL,
	AccountName varchar(32) NOT NULL,
	NetServer integer NOT NULL,
	KeepAlive integer NOT NULL,
	ServerType varchar(32) NOT NULL,
	Location varchar(128) NOT NULL,
	ReturnAddress varchar(32) NOT NULL,
	ReturnAddressCall varchar(32) NOT NULL,
	Date timestamp without time zone NOT NULL
);
CREATE TABLE EventLog(
    ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharacterID integer NOT NULL,
	CharacterName varchar(32) NOT NULL,
	EventType integer NOT NULL,
	Value1 integer NOT NULL,
	Value2 integer NOT NULL,
	Value3 integer NOT NULL,
	Value4 integer NOT NULL,
	Date timestamp without time zone NOT NULL
);

CREATE TABLE FuryArenaLog(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	Description varchar(256) NOT NULL,
	Date timestamp without time zone NOT NULL
);

CREATE TABLE GoldLog(
	ID bigint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(50) NOT NULL,
	"Where" integer NOT NULL,
	Gold integer NOT NULL,
	InventoryGold integer NOT NULL,
	Str varchar(200) NOT NULL,
	Date timestamp without time zone NOT NULL,
	IsGameServer integer NOT NULL
);

CREATE TABLE InventoryItemLog(
	ID bigint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	UserID varchar(32) NOT NULL,
	CharName varchar(32) NOT NULL,
	Action integer NOT NULL,
	ItemName varchar(32) NOT NULL,
	ItemID integer NOT NULL,
	Code1 integer NOT NULL,
	Code2 integer NOT NULL,
	Date timestamp without time zone NOT NULL
);

CREATE TABLE ItemCreateLog(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	ItemID integer NOT NULL,
	Code1 integer NOT NULL,
	Code2 integer NOT NULL,
	Item bytea NOT NULL,
	Date timestamp without time zone NOT NULL
);

CREATE TABLE ItemLog(
	ID bigint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	IP varchar(20) NOT NULL,
	AccountName varchar(32) NOT NULL,
	LogID integer NOT NULL,
	Description varchar(256) NOT NULL,
	Code1 integer NOT NULL,
	Code2 integer NOT NULL,
	Date timestamp without time zone NOT NULL,
	ServerID integer NOT NULL
);

CREATE TABLE MutePlayerLog(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	CharacterName varchar(32) NOT NULL,
	UnixMuteStart integer NOT NULL,
	UnixMuteEnd integer NOT NULL,
	MuteCount integer NOT NULL,
	MuteReason varchar(50) NOT NULL,
	MutedBy varchar(32) NOT NULL
);

CREATE TABLE OnlineRewardLog(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NOT NULL,
	Name varchar(32) NOT NULL,
	ItemName varchar(32) NOT NULL,
	Quantity integer NOT NULL,
	Date timestamp without time zone NOT NULL
);

CREATE TABLE PostBoxLog(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	IP varchar(30) NOT NULL,
	AccountName varchar(32) NOT NULL,
	LogID integer NOT NULL,
	Description varchar(256) NOT NULL,
	Date timestamp without time zone NOT NULL,
	ServerID integer NOT NULL
);

CREATE TABLE RegisterLog(
    ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	account_name varchar(50) NULL,
	ip_address varchar(50) NULL,
	log_date varchar(50) NULL,
	email varchar(128) NULL,
	password varchar(50) NULL
);

CREATE TABLE ServerLog(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	Type integer NOT NULL,
	Server integer NOT NULL,
	Message varchar(150) NOT NULL,
	UnixTime integer NOT NULL,
	Date timestamp without time zone NOT NULL
);

CREATE TABLE UsersOnlineRecord(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	UsersOnlineSubServer1 integer NOT NULL,
	UsersOnlineSubServer2 integer NOT NULL,
	UsersOnlineSubServer3 integer NOT NULL,
	TotalUsersOnline integer NOT NULL,
	Date timestamp without time zone NOT NULL
);

CREATE TABLE WarehouseLog(
	ID bigint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	UserID varchar(32) NOT NULL,
	CharName varchar(32) NOT NULL,
	Action integer NOT NULL,
	ItemName varchar(32) NOT NULL,
	ItemID integer NOT NULL,
	Code1 integer NOT NULL,
	Code2 integer NOT NULL,
	Date timestamp without time zone NOT NULL
);

-- 为 CleanUpOldLogs 存储过程中涉及的表在 Date 列上创建索引，以加速删除操作
CREATE INDEX IF NOT EXISTS idx_disconnects_date ON Disconnects (Date);
CREATE INDEX IF NOT EXISTS idx_itemcreatelog_date ON ItemCreateLog (Date);
CREATE INDEX IF NOT EXISTS idx_itemlog_date ON ItemLog (Date);
CREATE INDEX IF NOT EXISTS idx_goldlog_date ON GoldLog (Date);
CREATE INDEX IF NOT EXISTS idx_serverlog_date ON ServerLog (Date);
CREATE INDEX IF NOT EXISTS idx_warehouselog_date ON WarehouseLog (Date);
CREATE INDEX IF NOT EXISTS idx_cheatlog_date ON CheatLog (Date);
CREATE INDEX IF NOT EXISTS idx_characterlog_date ON CharacterLog (Date);
CREATE INDEX IF NOT EXISTS idx_accountlog_date ON AccountLog (Date);
CREATE INDEX IF NOT EXISTS idx_coinlog_date ON CoinLog (Date);
CREATE INDEX IF NOT EXISTS idx_onlinerewardlog_date ON OnlineRewardLog (Date);

CREATE OR REPLACE PROCEDURE CleanUpOldLogs()
LANGUAGE plpgsql
AS $$
BEGIN
    -- 删除超过 1 个月的日志
    DELETE FROM Disconnects    WHERE Date < CURRENT_DATE - INTERVAL '1 month';
    DELETE FROM ItemCreateLog  WHERE Date < CURRENT_DATE - INTERVAL '1 month';
    DELETE FROM ItemLog        WHERE Date < CURRENT_DATE - INTERVAL '1 month';
    DELETE FROM GoldLog        WHERE Date < CURRENT_DATE - INTERVAL '1 month';
    DELETE FROM ServerLog      WHERE Date < CURRENT_DATE - INTERVAL '1 month';

    -- 删除超过 3 个月的日志
    DELETE FROM WarehouseLog   WHERE Date < CURRENT_DATE - INTERVAL '3 months';
    DELETE FROM CheatLog       WHERE Date < CURRENT_DATE - INTERVAL '3 months';
    DELETE FROM CharacterLog   WHERE Date < CURRENT_DATE - INTERVAL '3 months';
    DELETE FROM AccountLog     WHERE Date < CURRENT_DATE - INTERVAL '3 months';

    -- 删除超过 5 个月的日志
    DELETE FROM CoinLog         WHERE Date < CURRENT_DATE - INTERVAL '5 months';
    DELETE FROM OnlineRewardLog WHERE Date < CURRENT_DATE - INTERVAL '5 months';
END;
$$;