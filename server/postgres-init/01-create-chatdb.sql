-- ChatDB: 兼容 C++ ChatServer 的聊天与 GM 指令日志
-- 对应 PristonTale-EU-main Server/chatserver.cpp 中的 PublicChat, ClanChat, PartyChat, TradeChat, PrivateChat, GameMasterCommand

CREATE SCHEMA IF NOT EXISTS chatdb;

SET search_path TO chatdb, public;

-- 1. public_chat: 地图公聊
-- INSERT INTO PublicChat([MapID],[CharacterName],[Message],[UnixTime])
CREATE TABLE IF NOT EXISTS chatdb.public_chat (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    map_id integer NOT NULL,
    character_name varchar(32) NOT NULL,
    message varchar(512) NOT NULL,
    unix_time integer NOT NULL
);

-- 2. game_master_command: GM 指令日志
-- INSERT INTO GameMasterCommand([IP],[CharacterName],[Command],[UnixTime])
CREATE TABLE IF NOT EXISTS chatdb.game_master_command (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    ip varchar(45) NOT NULL,
    character_name varchar(32) NOT NULL,
    command varchar(1024) NOT NULL,
    unix_time integer NOT NULL
);

-- 3. clan_chat: 公会聊天
-- INSERT INTO ClanChat([ClanID],[CharacterName],[Message],[UnixTime])
CREATE TABLE IF NOT EXISTS chatdb.clan_chat (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    clan_id integer NOT NULL,
    character_name varchar(32) NOT NULL,
    message varchar(512) NOT NULL,
    unix_time integer NOT NULL
);

-- 4. party_chat: 组队聊天
-- INSERT INTO PartyChat([CharacterName],[Message],[UnixTime])
CREATE TABLE IF NOT EXISTS chatdb.party_chat (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    character_name varchar(32) NOT NULL,
    message varchar(512) NOT NULL,
    unix_time integer NOT NULL
);

-- 5. trade_chat: 交易频道聊天
-- INSERT INTO TradeChat([CharacterName],[Message],[UnixTime])
CREATE TABLE IF NOT EXISTS chatdb.trade_chat (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    character_name varchar(32) NOT NULL,
    message varchar(512) NOT NULL,
    unix_time integer NOT NULL
);

-- 6. private_chat: 私聊
-- INSERT INTO PrivateChat([SenderName],[ReceiverName],[Message],[UnixTime])
CREATE TABLE IF NOT EXISTS chatdb.private_chat (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    sender_name varchar(32) NOT NULL,
    receiver_name varchar(32) NOT NULL,
    message varchar(512) NOT NULL,
    unix_time integer NOT NULL
);

-- 便于按时间清理或查询的索引
CREATE INDEX IF NOT EXISTS idx_public_chat_unix_time ON chatdb.public_chat (unix_time);
CREATE INDEX IF NOT EXISTS idx_game_master_command_unix_time ON chatdb.game_master_command (unix_time);
CREATE INDEX IF NOT EXISTS idx_clan_chat_unix_time ON chatdb.clan_chat (unix_time);
CREATE INDEX IF NOT EXISTS idx_party_chat_unix_time ON chatdb.party_chat (unix_time);
CREATE INDEX IF NOT EXISTS idx_trade_chat_unix_time ON chatdb.trade_chat (unix_time);
CREATE INDEX IF NOT EXISTS idx_private_chat_unix_time ON chatdb.private_chat (unix_time);
