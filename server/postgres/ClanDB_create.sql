-- 创建 clandb schema（如果不存在）
CREATE SCHEMA IF NOT EXISTS clandb;

-- 设置搜索路径（可选）
SET search_path TO clandb, public;

-- 1. bbs_main
CREATE TABLE clandb.bbs_main (
    idx integer NOT NULL,
    midx integer NOT NULL,
    user_id varchar(25) NOT NULL,
    write_name varchar(100) NOT NULL,
    title varchar(600) NOT NULL,
    content text NOT NULL,
    sel_server integer NOT NULL,
    regi_date timestamp without time zone NOT NULL,
    regi_ip char(15) NOT NULL,
    hit integer NOT NULL,
    count_com integer NOT NULL,
    nick_name varchar(32) NULL
);

-- 2. bbs_sub
CREATE TABLE clandb.bbs_sub (
    sidx integer NOT NULL,
    mindex integer NOT NULL,
    user_id varchar(25) NOT NULL,
    write_name varchar(100) NOT NULL,
    content text NOT NULL,
    regi_date timestamp without time zone NOT NULL,
    regi_ip char(15) NOT NULL,
    nick_name varchar(32) NULL
);

-- 3. bellatra_personal_score
CREATE TABLE clandb.bellatra_personal_score (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    character_name varchar(32) NOT NULL,
    kills integer NOT NULL,
    score integer NOT NULL,
    date varchar(50) NOT NULL
);

-- 4. bellatra_personal_score_new
CREATE TABLE clandb.bellatra_personal_score_new (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    character_id integer NOT NULL,
    character_name varchar(32) NOT NULL,
    character_class integer NOT NULL,
    character_level integer NOT NULL,
    kills integer NOT NULL,
    score integer NOT NULL,
    unix_time integer NOT NULL,
    date timestamp without time zone NOT NULL
);

-- 5. bellatra_team_score
CREATE TABLE clandb.bellatra_team_score (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    account_name varchar(32) NOT NULL,
    character_name varchar(32) NOT NULL,
    job_code integer NOT NULL,
    level integer NOT NULL,
    clan_code integer NOT NULL,
    score integer NOT NULL,
    kills integer NOT NULL,
    total_point integer NOT NULL,
    total_user integer NOT NULL,
    success_user integer NOT NULL,
    code integer NOT NULL,
    quake integer NOT NULL,
    stun_seal integer NOT NULL,
    freeze_seal integer NOT NULL,
    rabie_seal integer NOT NULL,
    stygian_seal integer NOT NULL,
    guardian_saint_seal integer NOT NULL,
    point_bag integer NOT NULL,
    date varchar(50) NOT NULL
);

-- 6. chip_log
CREATE TABLE clandb.chip_log (
    lg_idx integer NOT NULL,
    cidx integer NOT NULL,
    c_server integer NOT NULL,
    user_id varchar(50) NOT NULL,
    ch_name varchar(50) NOT NULL,
    permi char(2) NOT NULL,
    regi_date timestamp without time zone NOT NULL
);

-- 7. cl
CREATE TABLE clandb.cl (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    clan_name varchar(50) NOT NULL,
    note text NOT NULL,
    note_cnt integer NOT NULL,
    user_id varchar(50) NULL,
    clan_zang varchar(50) NOT NULL,
    flag integer NOT NULL,
    mem_cnt integer NOT NULL,
    m_icon_cnt integer NOT NULL,
    regi_date timestamp without time zone NOT NULL,
    limit_date timestamp without time zone NOT NULL,
    sod_date timestamp without time zone NULL,
    del_active char(1) NOT NULL,
    p_flag integer NOT NULL,
    k_flag integer NOT NULL,
    c_point integer NULL,
    c_win integer NULL,
    c_fail integer NULL,
    clan_money bigint NULL,
    cn_flag integer NULL,
    siege_money bigint NULL
);

-- 8. clan_home
CREATE TABLE clandb.clan_home (
    idx integer NOT NULL,
    midx integer NOT NULL,
    sel_server integer NOT NULL,
    intro varchar(300) NULL,
    image varchar(50) NULL,
    skin integer NULL,
    priv_home integer NULL,
    priv_mem integer NULL,
    priv_board integer NULL
);

-- 9. clan_list
CREATE TABLE clandb.clan_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    clan_name varchar(32) NOT NULL,
    clan_leader varchar(32) NOT NULL,
    note varchar(50) NOT NULL,
    account_name varchar(20) NOT NULL,
    members_count integer NOT NULL,
    icon_id integer NOT NULL,
    regis_date integer NOT NULL,
    limit_date integer NOT NULL,
    delete_active integer NOT NULL,
    flag integer NOT NULL,
    siege_war_points integer NOT NULL,
    bellatra_points integer NOT NULL,
    siege_war_gold integer NOT NULL,
    bellatra_gold integer NOT NULL,
    bellatra_date bigint NOT NULL,
    login_message varchar(128) NOT NULL
);

-- 10. clan_main_char_change_log
CREATE TABLE clandb.clan_main_char_change_log (
    idx integer NOT NULL,
    user_id varchar(50) NULL,
    before_char_name varchar(50) NULL,
    after_char_name varchar(50) NULL,
    c_server integer NULL,
    regi_date timestamp without time zone NULL
);

-- 11. clan_main_deleted
CREATE TABLE clandb.clan_main_deleted (
    idx integer NOT NULL,
    midx integer NOT NULL,
    clan_name varchar(50) NOT NULL,
    user_id varchar(50) NULL,
    clan_zang varchar(50) NOT NULL,
    flag integer NOT NULL,
    mem_cnt integer NOT NULL,
    m_icon_cnt integer NOT NULL,
    regi_date timestamp without time zone NOT NULL,
    limit_date timestamp without time zone NOT NULL,
    del_date timestamp without time zone NOT NULL,
    del_active char(1) NOT NULL,
    p_flag integer NOT NULL,
    k_flag integer NOT NULL,
    del_state char(1) NOT NULL,
    del_case char(10) NOT NULL,
    server integer NOT NULL
);

-- 12. clan_main_view
CREATE TABLE clandb.clan_main_view (
    idx integer NOT NULL,
    clan_name varchar(50) NOT NULL,
    note text NOT NULL,
    note_cnt integer NOT NULL,
    user_id varchar(50) NULL,
    clan_zang varchar(50) NOT NULL,
    flag integer NOT NULL,
    mem_cnt integer NOT NULL,
    m_icon_cnt integer NOT NULL,
    regi_date timestamp without time zone NOT NULL,
    limit_date timestamp without time zone NOT NULL,
    del_active char(1) NOT NULL,
    p_flag integer NOT NULL,
    k_flag integer NOT NULL,
    c_point integer NULL,
    c_win integer NULL,
    c_fail integer NULL,
    clan_money bigint NULL,
    cn_flag integer NULL,
    siege_money bigint NULL,
    server varchar(1) NOT NULL
);

-- 13. clan_money_log
CREATE TABLE clandb.clan_money_log (
    idx integer NOT NULL,
    cidx integer NULL,
    user_id varchar(50) NULL,
    ch_name varchar(50) NULL,
    server_name varchar(50) NULL,
    operator varchar(50) NULL,
    oper_code char(10) NULL,
    clan_money bigint NULL,
    regist_day timestamp without time zone NULL,
    note varchar(50) NULL
);

-- 14. clan_sub_char_change_log
CREATE TABLE clandb.clan_sub_char_change_log (
    idx integer NOT NULL,
    user_id varchar(50) NULL,
    before_char_name varchar(50) NULL,
    after_char_name varchar(50) NULL,
    c_server integer NULL,
    regi_date timestamp without time zone NULL
);

-- 15. clan_sub_deleted
CREATE TABLE clandb.clan_sub_deleted (
    idx integer NOT NULL,
    midx integer NOT NULL,
    user_id varchar(50) NOT NULL,
    ch_name varchar(50) NOT NULL,
    ch_type integer NULL,
    ch_lv integer NULL,
    clan_name varchar(50) NULL,
    permi char(2) NOT NULL,
    join_date timestamp without time zone NOT NULL,
    del_active char(1) NOT NULL,
    p_flag integer NOT NULL,
    k_flag integer NOT NULL,
    del_date timestamp without time zone NOT NULL,
    del_state char(1) NOT NULL,
    del_case char(10) NULL,
    server integer NOT NULL
);

-- 16. clan_sub_view
CREATE TABLE clandb.clan_sub_view (
    idx integer NOT NULL,
    midx integer NOT NULL,
    user_id varchar(50) NOT NULL,
    ch_name varchar(50) NOT NULL,
    ch_type integer NULL,
    ch_lv integer NULL,
    clan_name varchar(50) NULL,
    permi char(2) NOT NULL,
    join_date timestamp without time zone NOT NULL,
    del_active char(1) NOT NULL,
    p_flag integer NOT NULL,
    k_flag integer NOT NULL,
    server varchar(1) NOT NULL
);

-- 17. clan_ticket
CREATE TABLE clandb.clan_ticket (
    s_no integer NULL,
    server_name varchar(50) NULL,
    midx integer NULL,
    clan_name varchar(50) NULL,
    clan_jang integer NULL,
    clan_image varchar(50) NULL,
    user_id varchar(25) NULL,
    ch_name varchar(50) NULL,
    gp_code varchar(20) NULL,
    logon_time timestamp without time zone NULL,
    ip varchar(20) NULL,
    r_no integer NULL,
    flag integer NULL
);

-- 18. ct
CREATE TABLE clandb.ct (
    s_no integer NULL,
    server_name varchar(50) NULL,
    midx integer NULL,
    clan_name varchar(50) NULL,
    clan_jang integer NULL,
    clan_image varchar(50) NULL,
    user_id varchar(25) NULL,
    ch_name varchar(50) NULL,
    gp_code varchar(20) NULL,
    logon_time timestamp without time zone NULL,
    ip varchar(20) NULL,
    r_no integer NULL,
    flag integer NULL
);

-- 19. game_notice
CREATE TABLE clandb.game_notice (
    user_id varchar(50) NULL,
    ch_name varchar(50) NULL,
    server integer NULL,
    p_flag integer NULL,
    txt varchar(1000) NULL,
    flag integer NULL
);

-- 20. game_notice_group
CREATE TABLE clandb.game_notice_group (
    idx integer NOT NULL,
    group_cd integer NOT NULL,
    main_cd integer NOT NULL,
    detail_cd integer NOT NULL,
    title varchar(50) NOT NULL,
    content text NOT NULL,
    from_day timestamp without time zone NOT NULL,
    to_day timestamp without time zone NOT NULL,
    regist_day timestamp without time zone NOT NULL,
    del_active integer NOT NULL,
    hit integer NOT NULL,
    flag integer NULL
);

-- 21. game_notice_private
CREATE TABLE clandb.game_notice_private (
    idx integer NOT NULL,
    user_id varchar(50) NOT NULL,
    title varchar(50) NOT NULL,
    content text NOT NULL,
    from_day timestamp without time zone NOT NULL,
    to_day timestamp without time zone NOT NULL,
    regist_day timestamp without time zone NOT NULL,
    del_active integer NOT NULL,
    hit integer NOT NULL,
    flag integer NULL
);

-- 22. li
CREATE TABLE clandb.li (
    img integer NOT NULL,
    id integer NOT NULL
);

-- 23. notice
CREATE TABLE clandb.notice (
    idx integer NOT NULL,
    midx integer NOT NULL,
    user_id varchar(25) NOT NULL,
    write_name varchar(100) NOT NULL,
    title varchar(600) NOT NULL,
    content text NOT NULL,
    sel_server integer NOT NULL,
    regi_date timestamp without time zone NOT NULL,
    regi_ip char(15) NOT NULL,
    hit integer NOT NULL
);

-- 24. pr_bbs_file
CREATE TABLE clandb.pr_bbs_file (
    idx integer NOT NULL,
    mindex integer NOT NULL,
    file_name varchar(255) NOT NULL,
    file_size varchar(100) NOT NULL,
    regi_date timestamp without time zone NOT NULL
);

-- 25. pr_bbs_main
CREATE TABLE clandb.pr_bbs_main (
    idx integer NOT NULL,
    pm_no varchar(20) NOT NULL,
    user_id varchar(25) NOT NULL,
    title varchar(600) NOT NULL,
    content text NOT NULL,
    user_name varchar(100) NOT NULL,
    clan_idx integer NOT NULL,
    sel_server integer NOT NULL,
    regi_date timestamp without time zone NOT NULL,
    regi_ip char(15) NOT NULL,
    hit integer NOT NULL,
    count_com integer NOT NULL
);

-- 26. pr_bbs_sub
CREATE TABLE clandb.pr_bbs_sub (
    sidx integer NOT NULL,
    mindex integer NOT NULL,
    pm_no varchar(20) NOT NULL,
    user_id varchar(25) NOT NULL,
    write_name varchar(100) NOT NULL,
    content text NOT NULL,
    regi_date timestamp without time zone NOT NULL,
    regi_ip char(15) NOT NULL,
    user_name varchar(100) NOT NULL
);

-- 27. siege_clan_list
CREATE TABLE clandb.siege_clan_list (
    idx integer NOT NULL,
    user_id varchar(50) NOT NULL,
    char_name varchar(50) NOT NULL,
    clan_name varchar(50) NOT NULL,
    tax_rate integer NOT NULL,
    server_name varchar(50) NOT NULL,
    server integer NOT NULL,
    oper_from timestamp without time zone NULL,
    oper_to timestamp without time zone NULL,
    regist_day timestamp without time zone NOT NULL
);

-- 28. siege_current_list
CREATE TABLE clandb.siege_current_list (
    idx integer NOT NULL,
    cidx integer NULL,
    user_id varchar(50) NULL,
    ch_name varchar(50) NULL,
    server_name varchar(50) NULL,
    operator varchar(50) NULL,
    oper_code char(10) NULL,
    siege_money bigint NULL,
    regist_day timestamp without time zone NULL
);

-- 29. siege_money_log
CREATE TABLE clandb.siege_money_log (
    idx integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    cidx integer NULL,
    user_id varchar(50) NULL,
    ch_name varchar(50) NULL,
    server_name varchar(50) NULL,
    operator varchar(50) NULL,
    oper_code char(10) NULL,
    siege_money bigint NULL,
    regist_day timestamp without time zone NULL
);

-- 30. siege_money_tax
CREATE TABLE clandb.siege_money_tax (
    d_no integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    idx integer NULL,
    mixing bigint NULL,
    aging bigint NULL,
    shop bigint NULL,
    poison1 bigint NULL,
    poison2 bigint NULL,
    poison3 bigint NULL,
    force bigint NULL,
    warpgate bigint NULL,
    skill bigint NULL,
    total bigint NULL,
    tax bigint NULL,
    server_name varchar(50) NULL,
    regist_day timestamp without time zone NULL
);

-- 31. ul
CREATE TABLE clandb.ul (
    idx integer NOT NULL,
    midx integer GENERATED ALWAYS AS IDENTITY NOT NULL,
    user_id varchar(50) NOT NULL,
    ch_name varchar(50) NOT NULL,
    ch_type integer NULL,
    ch_lv integer NULL,
    clan_name varchar(50) NULL,
    permi char(2) NOT NULL,
    join_date timestamp without time zone NOT NULL,
    del_active char(1) NOT NULL,
    p_flag integer NOT NULL,
    k_flag integer NOT NULL,
    m_icon_cnt integer NOT NULL
);