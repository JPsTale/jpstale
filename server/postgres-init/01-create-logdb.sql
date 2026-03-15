CREATE SCHEMA IF NOT EXISTS logdb;

SET search_path TO logdb, public;

-- 1. account_log
CREATE TABLE IF NOT EXISTS logdb.account_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    ip varchar(50) NOT NULL,
    account_name varchar(32) NOT NULL,
    log_id integer NOT NULL,
    description varchar(512) NOT NULL,
    date timestamp without time zone NOT NULL,
    server_id integer NOT NULL
);

-- 2. aging_recovery
CREATE TABLE IF NOT EXISTS logdb.aging_recovery (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    character_id integer NOT NULL,
    date timestamp without time zone NOT NULL,
    item_name varchar(32) NOT NULL,
    age_number integer NOT NULL,
    code1 integer NOT NULL,
    code2 integer NOT NULL,
    date_recovered timestamp without time zone NULL
);

-- 3. bellatra_reward_log
CREATE TABLE IF NOT EXISTS logdb.bellatra_reward_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    name varchar(32) NOT NULL,
    item_name varchar(32) NOT NULL,
    quantity integer NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 4. character_log
CREATE TABLE IF NOT EXISTS logdb.character_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    ip varchar(50) NOT NULL,
    account_name varchar(50) NOT NULL,
    log_id integer NOT NULL,
    description varchar(256) NOT NULL,
    date timestamp without time zone NOT NULL,
    server_id integer NOT NULL
);

-- 5. cheat_log
CREATE TABLE IF NOT EXISTS logdb.cheat_log (
    id bigint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    ip varchar(20) NOT NULL,
    account_name varchar(32) NOT NULL,
    action integer NOT NULL,
    log_id integer NOT NULL,
    description varchar(256) NOT NULL,
    date timestamp without time zone NOT NULL,
    server_id integer NOT NULL
);

-- 6. coin_log
CREATE TABLE IF NOT EXISTS logdb.coin_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    description varchar(256) NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 7. disconnects
CREATE TABLE IF NOT EXISTS logdb.disconnects (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    ip varchar(32) NOT NULL,
    account_name varchar(32) NOT NULL,
    net_server integer NOT NULL,
    keep_alive integer NOT NULL,
    server_type varchar(32) NOT NULL,
    location varchar(128) NOT NULL,
    return_address varchar(32) NOT NULL,
    return_address_call varchar(32) NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 8. event_log
CREATE TABLE IF NOT EXISTS logdb.event_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    character_id integer NOT NULL,
    character_name varchar(32) NOT NULL,
    event_type integer NOT NULL,
    value1 integer NOT NULL,
    value2 integer NOT NULL,
    value3 integer NOT NULL,
    value4 integer NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 9. fury_arena_log
CREATE TABLE IF NOT EXISTS logdb.fury_arena_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    description varchar(256) NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 10. gold_log
CREATE TABLE IF NOT EXISTS logdb.gold_log (
    id bigint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(50) NOT NULL,
    source integer NOT NULL,   -- 原 "Where" 字段，表示金币来源
    gold integer NOT NULL,
    inventory_gold integer NOT NULL,
    str varchar(200) NOT NULL,
    date timestamp without time zone NOT NULL,
    is_game_server integer NOT NULL
);

-- 11. inventory_item_log
CREATE TABLE IF NOT EXISTS logdb.inventory_item_log (
    id bigint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    user_id varchar(32) NOT NULL,
    char_name varchar(32) NOT NULL,
    action integer NOT NULL,
    item_name varchar(32) NOT NULL,
    item_id integer NOT NULL,
    code1 integer NOT NULL,
    code2 integer NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 12. item_create_log
CREATE TABLE IF NOT EXISTS logdb.item_create_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    item_id integer NOT NULL,
    code1 integer NOT NULL,
    code2 integer NOT NULL,
    item bytea NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 13. item_log
CREATE TABLE IF NOT EXISTS logdb.item_log (
    id bigint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    ip varchar(20) NOT NULL,
    account_name varchar(32) NOT NULL,
    log_id integer NOT NULL,
    description varchar(256) NOT NULL,
    code1 integer NOT NULL,
    code2 integer NOT NULL,
    date timestamp without time zone NOT NULL,
    server_id integer NOT NULL
);

-- 14. mute_player_log
CREATE TABLE IF NOT EXISTS logdb.mute_player_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    character_name varchar(32) NOT NULL,
    unix_mute_start integer NOT NULL,
    unix_mute_end integer NOT NULL,
    mute_count integer NOT NULL,
    mute_reason varchar(50) NOT NULL,
    muted_by varchar(32) NOT NULL
);

-- 15. online_reward_log
CREATE TABLE IF NOT EXISTS logdb.online_reward_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    name varchar(32) NOT NULL,
    item_name varchar(32) NOT NULL,
    quantity integer NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 16. post_box_log
CREATE TABLE IF NOT EXISTS logdb.post_box_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    ip varchar(30) NOT NULL,
    account_name varchar(32) NOT NULL,
    log_id integer NOT NULL,
    description varchar(256) NOT NULL,
    date timestamp without time zone NOT NULL,
    server_id integer NOT NULL
);

-- 17. register_log
CREATE TABLE IF NOT EXISTS logdb.register_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(50) NULL,
    ip_address varchar(50) NULL,
    log_date varchar(50) NULL,
    email varchar(128) NULL,
    password varchar(50) NULL
);

-- 18. server_log
CREATE TABLE IF NOT EXISTS logdb.server_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    type integer NOT NULL,
    server integer NOT NULL,
    message varchar(150) NOT NULL,
    unix_time integer NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 19. users_online_record
CREATE TABLE IF NOT EXISTS logdb.users_online_record (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    users_online_sub_server1 integer NOT NULL,
    users_online_sub_server2 integer NOT NULL,
    users_online_sub_server3 integer NOT NULL,
    total_users_online integer NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 20. warehouse_log
CREATE TABLE IF NOT EXISTS logdb.warehouse_log (
    id bigint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    user_id varchar(32) NOT NULL,
    char_name varchar(32) NOT NULL,
    action integer NOT NULL,
    item_name varchar(32) NOT NULL,
    item_id integer NOT NULL,
    code1 integer NOT NULL,
    code2 integer NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 21. event_kill_log: 活动击杀记录（C++ eventserver EventKillLog）
-- INSERT INTO EventKillLog (EventID, MapID, CharacterID, MonsterID, MonsterEffectID, DateTime)
CREATE TABLE IF NOT EXISTS logdb.event_kill_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    event_id integer NOT NULL,
    map_id integer NOT NULL,
    character_id integer NOT NULL,
    monster_id integer NOT NULL,
    monster_effect_id integer NOT NULL,
    date_time timestamp without time zone NOT NULL
);

-- 22. packet_log: 包统计日志（C++ socketserver PacketLog）
-- INSERT INTO PacketLog (ServerType, PacketID, TotalCount, TotalDurationMS, MinDurationMS, MaxDurationMS, DateTime)
CREATE TABLE IF NOT EXISTS logdb.packet_log (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    server_type integer NOT NULL,
    packet_id integer NOT NULL,
    total_count integer NOT NULL,
    total_duration_ms bigint NOT NULL,
    min_duration_ms integer NOT NULL,
    max_duration_ms integer NOT NULL,
    date_time timestamp without time zone NOT NULL
);

-- 为 CleanUpOldLogs 存储过程中涉及的表在 date 列上创建索引，以加速删除操作
CREATE INDEX IF NOT EXISTS idx_disconnects_date ON logdb.disconnects (date);
CREATE INDEX IF NOT EXISTS idx_item_create_log_date ON logdb.item_create_log (date);
CREATE INDEX IF NOT EXISTS idx_item_log_date ON logdb.item_log (date);
CREATE INDEX IF NOT EXISTS idx_gold_log_date ON logdb.gold_log (date);
CREATE INDEX IF NOT EXISTS idx_server_log_date ON logdb.server_log (date);
CREATE INDEX IF NOT EXISTS idx_warehouse_log_date ON logdb.warehouse_log (date);
CREATE INDEX IF NOT EXISTS idx_cheat_log_date ON logdb.cheat_log (date);
CREATE INDEX IF NOT EXISTS idx_character_log_date ON logdb.character_log (date);
CREATE INDEX IF NOT EXISTS idx_account_log_date ON logdb.account_log (date);
CREATE INDEX IF NOT EXISTS idx_coin_log_date ON logdb.coin_log (date);
CREATE INDEX IF NOT EXISTS idx_online_reward_log_date ON logdb.online_reward_log (date);
CREATE INDEX IF NOT EXISTS idx_event_kill_log_date_time ON logdb.event_kill_log (date_time);
CREATE INDEX IF NOT EXISTS idx_packet_log_date_time ON logdb.packet_log (date_time);

-- 存储过程：清理旧日志
CREATE OR REPLACE PROCEDURE logdb.clean_up_old_logs()
LANGUAGE plpgsql
AS $$
BEGIN
    -- 删除超过 1 个月的日志
    DELETE FROM logdb.disconnects         WHERE date < CURRENT_DATE - INTERVAL '1 month';
    DELETE FROM logdb.item_create_log     WHERE date < CURRENT_DATE - INTERVAL '1 month';
    DELETE FROM logdb.item_log            WHERE date < CURRENT_DATE - INTERVAL '1 month';
    DELETE FROM logdb.gold_log            WHERE date < CURRENT_DATE - INTERVAL '1 month';
    DELETE FROM logdb.server_log          WHERE date < CURRENT_DATE - INTERVAL '1 month';
    DELETE FROM logdb.event_kill_log      WHERE date_time < CURRENT_DATE - INTERVAL '1 month';
    DELETE FROM logdb.packet_log          WHERE date_time < CURRENT_DATE - INTERVAL '1 month';

    -- 删除超过 3 个月的日志
    DELETE FROM logdb.warehouse_log       WHERE date < CURRENT_DATE - INTERVAL '3 months';
    DELETE FROM logdb.cheat_log           WHERE date < CURRENT_DATE - INTERVAL '3 months';
    DELETE FROM logdb.character_log       WHERE date < CURRENT_DATE - INTERVAL '3 months';
    DELETE FROM logdb.account_log         WHERE date < CURRENT_DATE - INTERVAL '3 months';

    -- 删除超过 5 个月的日志
    DELETE FROM logdb.coin_log             WHERE date < CURRENT_DATE - INTERVAL '5 months';
    DELETE FROM logdb.online_reward_log    WHERE date < CURRENT_DATE - INTERVAL '5 months';
END;
$$;