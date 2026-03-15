CREATE SCHEMA IF NOT EXISTS itemdb;

SET search_path TO itemdb, public;

-- 物品表
CREATE TABLE itemdb.item (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    character_id integer NOT NULL,
    location integer NOT NULL,
    data bytea NOT NULL,
    header integer NOT NULL,
    timestamp integer NOT NULL,
    checksum integer NOT NULL,
    backup_header integer NOT NULL,
    backup_checksum integer NOT NULL,
    flags integer NOT NULL,
    create_time timestamp without time zone NOT NULL,
    delete_time timestamp without time zone NOT NULL
);

-- 物品基础定义
CREATE TABLE itemdb.item_base (
    item_base_id integer NOT NULL PRIMARY KEY,
    item_base_name varchar(20) NOT NULL,
    item_base_hex bytea NOT NULL,
    item_base_abbrv varchar(3) NULL
);

-- 物品制作类型
CREATE TABLE itemdb.item_craft_type (
    item_craft_type_id smallint NOT NULL PRIMARY KEY,
    item_craft_type_name varchar(15) NOT NULL
);

-- 物品转储日志
CREATE TABLE itemdb.item_dump (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NULL,
    char_name varchar(32) NULL,
    item_name varchar(50) NOT NULL,
    item_level integer NOT NULL,
    item_id integer NOT NULL,
    item_type_id integer NOT NULL,
    item_base_id integer NOT NULL,
    item_header integer NOT NULL,
    item_checksum integer NOT NULL,
    item_backup_header integer NOT NULL,
    item_backup_checksum integer NOT NULL,
    mix_effect integer NOT NULL,
    mix_id integer NOT NULL,
    age_level integer NOT NULL,
    attack_range integer NOT NULL,
    attack_speed integer NOT NULL,
    attack_rating integer NOT NULL,
    atk_pow_min smallint NOT NULL,
    atk_pow_max smallint NOT NULL,
    critical integer NULL,
    absorb double precision NOT NULL,
    defense integer NOT NULL,
    block double precision NOT NULL,
    organic smallint NOT NULL,
    fire smallint NOT NULL,
    frost smallint NOT NULL,
    lighting smallint NOT NULL,
    poison smallint NOT NULL,
    strength_req integer NOT NULL,
    spirit_req integer NOT NULL,
    talent_req integer NOT NULL,
    agility_req integer NOT NULL,
    health_req integer NOT NULL,
    mp_regen double precision NOT NULL,
    hp_regen double precision NOT NULL,
    sp_regen double precision NOT NULL,
    add_hp double precision NOT NULL,
    add_mp double precision NOT NULL,
    add_sp double precision NOT NULL,
    item_spec integer NOT NULL,
    spec_absorb double precision NOT NULL,
    spec_def integer NOT NULL,
    spec_block_rating double precision NOT NULL,
    spec_attack_speed integer NOT NULL,
    spec_critical integer NOT NULL,
    spec_attack_rating_div smallint NOT NULL,
    spec_attack_power_div smallint NOT NULL,
    spec_mp_regen double precision NOT NULL,
    spec_hp_regen double precision NOT NULL,
    spec_sp_regen double precision NOT NULL,
    item_unique_id integer NOT NULL,
    sale_price integer NOT NULL,
    created_date integer NOT NULL
);

-- 物品类型
CREATE TABLE itemdb.item_type (
    item_type_id integer NOT NULL PRIMARY KEY,
    item_type_name varchar(20) NOT NULL,
    item_type_hex bytea NOT NULL,
    item_type_abbrv varchar(3) NULL
);