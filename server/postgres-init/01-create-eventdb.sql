CREATE SCHEMA IF NOT EXISTS eventdb;

SET search_path TO eventdb, public;

-- 1. bellatra_monster
CREATE TABLE IF NOT EXISTS eventdb.bellatra_monster (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    round integer NOT NULL,
    monster1 varchar(32) NOT NULL,
    count1 integer NOT NULL,
    monster2 varchar(32) NOT NULL,
    count2 integer NOT NULL,
    monster3 varchar(32) NOT NULL,
    count3 integer NOT NULL,
    monster4 varchar(32) NOT NULL,
    count4 integer NOT NULL,
    boss varchar(32) NOT NULL,
    boss_appear integer NOT NULL,
    view_sight integer NOT NULL,
    start_round integer NOT NULL,
    gold integer NOT NULL,
    delay_round integer NOT NULL,
    percent_monsters integer NOT NULL,
    max_monsters integer NOT NULL
);

-- 2. bellatra_monster_debug_mode
CREATE TABLE IF NOT EXISTS eventdb.bellatra_monster_debug_mode (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    round integer NOT NULL,
    monster1 varchar(32) NOT NULL,
    count1 integer NOT NULL,
    monster2 varchar(32) NOT NULL,
    count2 integer NOT NULL,
    monster3 varchar(32) NOT NULL,
    count3 integer NOT NULL,
    monster4 varchar(32) NOT NULL,
    count4 integer NOT NULL,
    boss varchar(32) NOT NULL,
    boss_appear integer NOT NULL,
    view_sight integer NOT NULL,
    start_round integer NOT NULL,
    gold integer NOT NULL,
    delay_round integer NOT NULL,
    percent_monsters integer NOT NULL,
    max_monsters integer NOT NULL
);

-- 3. fury_arena_reward_tracker
CREATE TABLE IF NOT EXISTS eventdb.fury_arena_reward_tracker (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    fury_event_id integer NOT NULL,
    character_id integer NOT NULL
);

-- 4. wanted_moriph_drops
CREATE TABLE IF NOT EXISTS eventdb.wanted_moriph_drops (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    char_id integer NOT NULL,
    map_id integer NOT NULL,
    item_name varchar(32) NOT NULL,
    unix_time integer NOT NULL
);

-- 5. wanted_moriph_kills
CREATE TABLE IF NOT EXISTS eventdb.wanted_moriph_kills (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    char_id integer NOT NULL,
    map_id integer NOT NULL,
    unix_time integer NOT NULL
);

-- 6. wanted_wolf_drops
CREATE TABLE IF NOT EXISTS eventdb.wanted_wolf_drops (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    char_id integer NOT NULL,
    map_id integer NOT NULL,
    item_name varchar(32) NOT NULL,
    unix_time integer NOT NULL
);

-- 7. wanted_wolf_kills
CREATE TABLE IF NOT EXISTS eventdb.wanted_wolf_kills (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    char_id integer NOT NULL,
    map_id integer NOT NULL,
    unix_time integer NOT NULL
);