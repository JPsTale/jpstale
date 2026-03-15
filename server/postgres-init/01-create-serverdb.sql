CREATE SCHEMA IF NOT EXISTS serverdb;

SET search_path TO serverdb, public;

-- 1. bellatra_reward
CREATE TABLE IF NOT EXISTS serverdb.bellatra_reward (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    item_code varchar(32) NOT NULL,
    quantity integer NOT NULL,
    percent integer NOT NULL
);

-- 2. bless_castle_settings
CREATE TABLE IF NOT EXISTS serverdb.bless_castle_settings (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    clan_id1 integer NOT NULL,
    clan_id2 integer NOT NULL,
    clan_id3 integer NOT NULL,
    tax integer NOT NULL,
    skill integer NOT NULL,
    tower1_type integer NOT NULL,
    tower2_type integer NOT NULL,
    tower3_type integer NOT NULL,
    tower4_type integer NOT NULL,
    tower5_type integer NOT NULL,
    tower6_type integer NOT NULL,
    guard1_amount integer NOT NULL,
    guard2_amount integer NOT NULL,
    guard3_amount integer NOT NULL
);

-- 3. command
CREATE TABLE IF NOT EXISTS serverdb.command (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    command_type_id integer NOT NULL,
    parameter1 varchar(64) NULL,
    parameter2 varchar(64) NULL,
    parameter3 varchar(64) NULL,
    date_processed timestamp without time zone NULL
);

-- 4. crash_data
CREATE TABLE IF NOT EXISTS serverdb.crash_data (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    ip varchar(16) NOT NULL,
    version integer NOT NULL,
    address integer NOT NULL,
    flags integer NOT NULL,
    code integer NOT NULL,
    eax integer NOT NULL,
    ecx integer NOT NULL,
    edx integer NOT NULL,
    ebx integer NOT NULL,
    esp integer NOT NULL,
    ebp integer NOT NULL,
    esi integer NOT NULL,
    edi integer NOT NULL,
    eip integer NOT NULL,
    date_received timestamp without time zone NOT NULL
);

-- 5. function_checksum_list
CREATE TABLE IF NOT EXISTS serverdb.function_checksum_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    size integer NOT NULL,
    address varchar(50) NOT NULL,
    checksum varchar(32) NOT NULL
);

-- 6. fury_arena
CREATE TABLE IF NOT EXISTS serverdb.fury_arena (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    item_code varchar(32) NOT NULL,
    percent integer NOT NULL,
    boss_id integer NOT NULL
);

-- 7. gm_command
CREATE TABLE IF NOT EXISTS serverdb.gm_command (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    command varchar(100) NOT NULL,
    unix_time integer NOT NULL,
    unix_time_to_execute integer NOT NULL,
    is_active integer NOT NULL,
    result integer NOT NULL
);

-- 8. maintenance
CREATE TABLE IF NOT EXISTS serverdb.maintenance (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    mode integer NOT NULL,
    ip varchar(32) NOT NULL,
    corno varchar(50) NULL
);

-- 9. message_login
CREATE TABLE IF NOT EXISTS serverdb.message_login (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    message varchar(128) NOT NULL
);

-- 10. metadata
CREATE TABLE IF NOT EXISTS serverdb.metadata (
    key varchar(30) NOT NULL PRIMARY KEY,
    value integer NOT NULL,
    is_public integer NOT NULL
);

-- 11. online_reward
CREATE TABLE IF NOT EXISTS serverdb.online_reward (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    item_code varchar(32) NOT NULL,
    quantity integer NOT NULL,
    percent integer NOT NULL
);

-- 12. post_box
CREATE TABLE IF NOT EXISTS serverdb.post_box (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    item varchar(32) NOT NULL,
    spec_or_count integer NOT NULL
);

-- 13. spawn_camera
CREATE TABLE IF NOT EXISTS serverdb.spawn_camera (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    map_number integer NOT NULL,
    spawn_x integer NOT NULL,
    spawn_y integer NOT NULL,
    spawn_z integer NOT NULL,
    cam_x_coord integer NOT NULL,
    cam_z_coord integer NOT NULL,
    cam_turn integer NOT NULL,
    cam_angle integer NOT NULL,
    cam_zoom integer NOT NULL,
    min_player_count integer NOT NULL,
    search_radius integer NOT NULL,
    spawn_type integer NOT NULL
);

-- 14. users_online
CREATE TABLE IF NOT EXISTS serverdb.users_online (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    account_name varchar(32) NOT NULL,
    character_name varchar(32) NOT NULL,
    ip varchar(32) NOT NULL,
    character_class integer NOT NULL,
    character_level integer NOT NULL,
    ticket integer NOT NULL,
    login_time timestamp without time zone NOT NULL
);

-- 15. window_cheat_list
CREATE TABLE IF NOT EXISTS serverdb.window_cheat_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    window_name varchar(64) NOT NULL
);