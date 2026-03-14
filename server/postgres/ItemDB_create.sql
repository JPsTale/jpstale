CREATE TABLE Item(
	ID integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	CharcterID integer NOT NULL,
	Location integer NOT NULL,
	Data bytea NOT NULL,
	Header integer NOT NULL,
	Timestamp integer NOT NULL,
	Checksum integer NOT NULL,
	BackupHeader integer NOT NULL,
	BackupChecksum integer NOT NULL,
	Flags integer NOT NULL,
	CreateTime timestamp without time zone NOT NULL,
	DeleteTime timestamp without time zone NOT NULL
);

CREATE TABLE ItemBase(
	ItemBaseId integer NOT NULL PRIMARY KEY,
	ItemBaseName varchar(20) NOT NULL,
	ItemBaseHex bytea NOT NULL,
	ItemBaseAbbrv varchar(3) NULL
);

CREATE TABLE ItemCraftType(
	ItemCraftTypeId smallint NOT NULL PRIMARY KEY,
	ItemCraftTypeName varchar(15) NOT NULL
);

CREATE TABLE ItemDump(
	Id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
	AccountName varchar(32) NULL,
	CharName varchar(32) NULL,
	ItemName varchar(50) NOT NULL,
	ItemLevel integer NOT NULL,
	ItemId integer NOT NULL,
	ItemTypeId integer NOT NULL,
	ItemBaseId integer NOT NULL,
	ItemHeader integer NOT NULL,
	ItemChecksum integer NOT NULL,
	ItemBackupHeader integer NOT NULL,
	ItemBackupChecksum integer NOT NULL,
	MixEffect integer NOT NULL,
	MixID integer NOT NULL,
	AgeLevel integer NOT NULL,
	AttackRange integer NOT NULL,
	AttackSpeed integer NOT NULL,
	AttackRating integer NOT NULL,
	ATKPowMin smallint NOT NULL,
	ATKPowMax smallint NOT NULL,
	Critical integer NULL,
	Absorb double precision NOT NULL,
	Defense integer NOT NULL,
	Block double precision NOT NULL,
	Organic smallint NOT NULL,
	Fire smallint NOT NULL,
	Frost smallint NOT NULL,
	Lighting smallint NOT NULL,
	Poison smallint NOT NULL,
	StrengthReq integer NOT NULL,
	SpiritReq integer NOT NULL,
	TalentReq integer NOT NULL,
	AgilityReq integer NOT NULL,
	HealthReq integer NOT NULL,
	MPRegen double precision NOT NULL,
	HPRegen double precision NOT NULL,
	SPRegen double precision NOT NULL,
	AddHP double precision NOT NULL,
	AddMP double precision NOT NULL,
	AddSP double precision NOT NULL,
	ItemSpec integer NOT NULL,
	SpecAbsorb double precision NOT NULL,
	SpecDef integer NOT NULL,
	SpecBlockRating double precision NOT NULL,
	SpecAttackSpeed integer NOT NULL,
	SpecCritical integer NOT NULL,
	SpecAttackRatingDiv smallint NOT NULL,
	SpecAttackPowerDiv smallint NOT NULL,
	SpecMPRegen double precision NOT NULL,
	SpecHPRegen double precision NOT NULL,
	SpecSPRegen double precision NOT NULL,
	ItemUniqueID integer NOT NULL,
	SalePrice integer NOT NULL,
	CreatedDate integer NOT NULL
);

CREATE TABLE ItemType(
	ItemTypeId integer NOT NULL PRIMARY KEY,
	ItemTypeName varchar(20) NOT NULL,
	ItemTypeHex bytea NOT NULL,
	ItemTypeAbbrv varchar(3) NULL
);
