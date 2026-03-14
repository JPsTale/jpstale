-- 创建 schema
CREATE SCHEMA IF NOT EXISTS userdb;

SET search_path TO userdb, public;

-- 角色经验定义
CREATE TABLE userdb.character_exp_def (
    level integer NOT NULL,
    exp_required bigint NOT NULL
);

-- 角色信息
CREATE TABLE userdb.character_info (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    name varchar(32) NOT NULL,
    old_head varchar(64) NOT NULL,
    level integer NOT NULL,
    experience bigint NOT NULL,
    gold integer NOT NULL,
    job_code integer NOT NULL,
    clan_id integer NOT NULL,
    clan_permission integer NOT NULL,
    clan_leave_date integer NOT NULL,
    last_seen_date timestamp without time zone NOT NULL,
    bless_castle_score integer NOT NULL,
    fsp integer NOT NULL,
    last_stage integer NOT NULL,
    is_online integer NOT NULL,
    seasonal integer NOT NULL,
    gm_level integer NOT NULL,
    banned integer NOT NULL,
    title integer NULL,
    dialog_skin integer NULL,
    level_up_date timestamp without time zone NULL
);

-- 已删除角色信息
CREATE TABLE userdb.character_info_delete (
    id integer NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    name varchar(32) NOT NULL,
    old_head varchar(64) NOT NULL,
    level integer NOT NULL,
    experience bigint NOT NULL,
    gold integer NOT NULL,
    job_code integer NOT NULL,
    clan_id integer NOT NULL,
    clan_permission integer NOT NULL,
    clan_leave_date integer NOT NULL,
    last_seen_date varchar(50) NOT NULL,
    bless_castle_score integer NOT NULL,
    fsp integer NOT NULL,
    last_stage integer NOT NULL,
    is_online integer NOT NULL,
    seasonal integer NOT NULL,
    gm_level integer NOT NULL,
    banned integer NOT NULL,
    title integer NULL,
    dialog_skin integer NULL
);

-- 角色物品计时器
CREATE TABLE userdb.character_item_timer (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    character_id integer NOT NULL,
    character_name varchar(32) NOT NULL,
    item_timer_type integer NOT NULL,
    item_id integer NOT NULL,
    time_left integer NOT NULL,
    time_total integer NOT NULL
);

-- 角色击杀统计
CREATE TABLE userdb.character_monster_kill_tracker (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    character_id integer NOT NULL,
    monster_id integer NOT NULL,
    monster_name varchar(32) NOT NULL,
    kill_count integer NOT NULL
);

-- 角色PVP统计
CREATE TABLE userdb.character_pvp (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    character_name varchar(32) NOT NULL,
    kills integer NOT NULL,
    deaths integer NOT NULL,
    kill_streak integer NOT NULL,
    top_pvp integer NOT NULL
);

-- 角色任务
CREATE TABLE userdb.character_quest (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    quest_id integer NOT NULL,
    quest_reward_id integer NOT NULL,
    character_id integer NOT NULL,
    account_name varchar(32) NOT NULL,
    character_name varchar(32) NOT NULL,
    start_date timestamp without time zone NOT NULL,
    end_date timestamp without time zone NULL,
    monster_count varchar(64) NULL,
    item_count varchar(64) NULL,
    time_left integer NOT NULL,
    counter integer NULL
);

-- 角色称号列表
CREATE TABLE userdb.character_title_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    character_id integer NOT NULL,
    title_id integer NOT NULL,
    date_acquired timestamp without time zone NOT NULL
);

-- 职业定义
CREATE TABLE userdb.class_def (
    class_id integer NOT NULL PRIMARY KEY,
    class_name varchar(20) NOT NULL
);

-- 物品箱
CREATE TABLE userdb.item_box (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    item_code varchar(32) NOT NULL,
    item varchar(32) NULL,
    item_spec integer NOT NULL,
    coin_shop integer NOT NULL,
    has_item integer NULL,
    date_received timestamp without time zone NULL
);

-- 通知数据
CREATE TABLE userdb.notification_data (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    message varchar(100) NOT NULL,
    checked integer NOT NULL
);

-- 称号定义
CREATE TABLE userdb.title_def (
    title_id integer NOT NULL PRIMARY KEY,
    title_category varchar(16) NOT NULL,
    sub_category varchar(16) NULL,
    title varchar(21) NOT NULL,
    title_rarity smallint NOT NULL
);

-- 用户信息
CREATE TABLE userdb.user_info (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    password varchar(64) NOT NULL,
    regis_day varchar(50) NOT NULL,
    flag integer NOT NULL,
    active integer NOT NULL,
    active_code varchar(50) NOT NULL,
    coins integer NOT NULL,
    email varchar(150) NOT NULL,
    game_master_type integer NOT NULL,
    game_master_level integer NOT NULL,
    game_master_mac_address varchar(20) NOT NULL,
    coins_traded integer NOT NULL,
    ban_status integer NOT NULL,
    unban_date timestamp without time zone NULL,
    is_muted integer NOT NULL,
    mute_count integer NOT NULL,
    unmute_date timestamp without time zone NULL
);

CREATE OR REPLACE PROCEDURE userdb.give_wanted_moriph_titles_based_on_kills()
LANGUAGE plpgsql
AS $$
BEGIN
    DELETE FROM userdb.character_title_list WHERE title_id IN (50, 51, 52, 53, 54);

    INSERT INTO userdb.character_title_list (character_id, title_id, date_acquired)
    SELECT character_id, 50, CURRENT_TIMESTAMP
    FROM userdb.character_monster_kill_tracker
    WHERE monster_id = 1258 AND kill_count > 50;

    INSERT INTO userdb.character_title_list (character_id, title_id, date_acquired)
    SELECT character_id, 51, CURRENT_TIMESTAMP
    FROM userdb.character_monster_kill_tracker
    WHERE monster_id = 1258 AND kill_count > 250;

    INSERT INTO userdb.character_title_list (character_id, title_id, date_acquired)
    SELECT character_id, 52, CURRENT_TIMESTAMP
    FROM userdb.character_monster_kill_tracker
    WHERE monster_id = 1258 AND kill_count > 500;

    INSERT INTO userdb.character_title_list (character_id, title_id, date_acquired)
    SELECT character_id, 53, CURRENT_TIMESTAMP
    FROM userdb.character_monster_kill_tracker
    WHERE monster_id = 1258 AND kill_count > 1250;

    INSERT INTO userdb.character_title_list (character_id, title_id, date_acquired)
    SELECT character_id, 54, CURRENT_TIMESTAMP
    FROM userdb.character_monster_kill_tracker
    WHERE monster_id = 1258 AND kill_count > 2500;
END;
$$;

CREATE OR REPLACE PROCEDURE userdb.give_wanted_wolf_titles_based_on_kills()
LANGUAGE plpgsql
AS $$
BEGIN
    DELETE FROM userdb.character_title_list WHERE title_id IN (70, 71, 72, 73, 74);

    INSERT INTO userdb.character_title_list (character_id, title_id, date_acquired)
    SELECT character_id, 70, CURRENT_TIMESTAMP
    FROM userdb.character_monster_kill_tracker
    WHERE monster_id = 1253 AND kill_count > 50;

    INSERT INTO userdb.character_title_list (character_id, title_id, date_acquired)
    SELECT character_id, 71, CURRENT_TIMESTAMP
    FROM userdb.character_monster_kill_tracker
    WHERE monster_id = 1253 AND kill_count > 250;

    INSERT INTO userdb.character_title_list (character_id, title_id, date_acquired)
    SELECT character_id, 72, CURRENT_TIMESTAMP
    FROM userdb.character_monster_kill_tracker
    WHERE monster_id = 1253 AND kill_count > 500;

    INSERT INTO userdb.character_title_list (character_id, title_id, date_acquired)
    SELECT character_id, 73, CURRENT_TIMESTAMP
    FROM userdb.character_monster_kill_tracker
    WHERE monster_id = 1253 AND kill_count > 1250;

    INSERT INTO userdb.character_title_list (character_id, title_id, date_acquired)
    SELECT character_id, 74, CURRENT_TIMESTAMP
    FROM userdb.character_monster_kill_tracker
    WHERE monster_id = 1253 AND kill_count > 2500;
END;
$$;