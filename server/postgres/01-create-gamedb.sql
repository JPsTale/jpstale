CREATE SCHEMA IF NOT EXISTS gamedb;

SET search_path TO gamedb, public;

-- 1. achievement_list
CREATE TABLE gamedb.achievement_list (
    id char(10) NULL
);

-- 2. action_field_settings
CREATE TABLE gamedb.action_field_settings (
    id char(10) NULL
);

-- 3. age_list
CREATE TABLE gamedb.age_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    age_number integer NOT NULL,
    fail_chance integer NOT NULL,
    plus2_chance integer NOT NULL,
    minus2_chance integer NOT NULL,
    minus1_chance integer NOT NULL,
    broken_chance integer NOT NULL,
    age_stone integer NOT NULL
);

-- 4. baseline_mod
CREATE TABLE gamedb.baseline_mod (
    class integer NOT NULL PRIMARY KEY,
    percent_baseline_strength integer NOT NULL,
    percent_baseline_spirit integer NOT NULL,
    percent_baseline_talent integer NOT NULL,
    percent_baseline_agility integer NOT NULL,
    percent_baseline_health integer NOT NULL
);

-- 5. character_class
CREATE TABLE gamedb.character_class (
    id integer NOT NULL,
    id2 integer NOT NULL,
    name varchar(32) NOT NULL,
    short_name varchar(8) NOT NULL
);

-- 6. cheat_exception_list
CREATE TABLE gamedb.cheat_exception_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    exception_name varchar(100) NULL
);

-- 7. cheat_list
CREATE TABLE gamedb.cheat_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    cheat_type integer NOT NULL,
    cheat_id integer NOT NULL,
    cheat_name varchar(64) NOT NULL,
    cheat_signature integer NOT NULL
);

-- 8. cheat_modules
CREATE TABLE gamedb.cheat_modules (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    module_name varchar(64) NOT NULL
);

-- 9. coin_shop
CREATE TABLE gamedb.coin_shop (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    name varchar(32) NOT NULL,
    message varchar(128) NOT NULL,
    discount integer NOT NULL,
    active integer NOT NULL
);

-- 10. coin_shop_item
CREATE TABLE gamedb.coin_shop_item (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    tab_id integer NOT NULL,
    name varchar(32) NOT NULL,
    description varchar(128) NOT NULL,
    code varchar(8) NOT NULL,
    image varchar(64) NOT NULL,
    value integer NOT NULL,
    discount integer NOT NULL,
    bulk integer NOT NULL,
    max_bulk integer NOT NULL,
    is_spec integer NOT NULL,
    is_quantity integer NOT NULL,
    disabled integer NOT NULL,
    list_order integer NOT NULL
);

-- 11. coin_shop_tab
CREATE TABLE gamedb.coin_shop_tab (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    coin_shop_id integer NOT NULL,
    name varchar(32) NOT NULL,
    parent_id integer NOT NULL,
    discount integer NOT NULL,
    bulk integer NOT NULL,
    max_bulk integer NOT NULL,
    list_order integer NOT NULL
);

-- 12. drop_item
CREATE TABLE gamedb.drop_item (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    drop_id integer NOT NULL,
    items varchar(512) NOT NULL,
    chance integer NOT NULL,
    gold_min integer NOT NULL,
    gold_max integer NOT NULL
);

-- 13. item_attribute
CREATE TABLE gamedb.item_attribute (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    code integer NOT NULL,
    name varchar(32) NOT NULL,
    before_value varchar(16) NULL,
    after_value varchar(16) NULL,
    before_value_spec varchar(16) NULL,
    after_value_spec varchar(16) NULL
);

-- 14. item_code
CREATE TABLE gamedb.item_code (
    code integer NOT NULL PRIMARY KEY,
    text varchar(16) NOT NULL
);

-- 15. item_fixes
CREATE TABLE gamedb.item_fixes (
    id integer NOT NULL PRIMARY KEY,
    name varchar(12) NOT NULL,
    min_level integer NOT NULL,
    max_level integer NOT NULL,
    min_rarity integer NOT NULL,
    max_rarity integer NOT NULL,
    is_prefix integer NOT NULL,
    is_suffix integer NOT NULL,
    chance integer NOT NULL,
    axes integer NOT NULL,
    bows integer NOT NULL,
    javelins integer NOT NULL,
    daggers integer NOT NULL,
    wands integer NOT NULL,
    scythes integer NOT NULL,
    swords integer NOT NULL,
    claws integer NOT NULL,
    hammers integer NOT NULL,
    phantoms integer NOT NULL,
    armors integer NOT NULL,
    robes integer NOT NULL,
    boots integer NOT NULL,
    gauntlets integer NOT NULL,
    bracelets integer NOT NULL,
    amulets integer NOT NULL,
    rings integer NOT NULL,
    shields integer NOT NULL,
    orbs integer NOT NULL,
    organic_min integer NOT NULL,
    organic_max integer NOT NULL,
    fire_min integer NOT NULL,
    fire_max integer NOT NULL,
    frost_min integer NOT NULL,
    frost_max integer NOT NULL,
    lightning_min integer NOT NULL,
    lightning_max integer NOT NULL,
    poison_min integer NOT NULL,
    poison_max integer NOT NULL,
    atk_pow_min integer NOT NULL,
    atk_pow_max integer NOT NULL,
    range_min integer NOT NULL,
    range_max integer NOT NULL,
    atk_rating_min integer NOT NULL,
    atk_rating_max integer NOT NULL,
    critical_min real NOT NULL,
    critical_max real NOT NULL,
    block_min real NOT NULL,
    block_max real NOT NULL,
    absorb_min real NOT NULL,
    absorb_max real NOT NULL,
    defense_min integer NOT NULL,
    defense_max integer NOT NULL,
    regeneration_hp_min real NOT NULL,
    regeneration_hp_max real NOT NULL,
    regeneration_mp_min real NOT NULL,
    regeneration_mp_max real NOT NULL,
    add_hp_min integer NOT NULL,
    add_hp_max integer NOT NULL,
    add_mp_min integer NOT NULL,
    add_mp_max integer NOT NULL,
    run_speed_min real NOT NULL,
    run_speed_max real NOT NULL
);

-- 16. item_list
CREATE TABLE gamedb.item_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    id_code integer NOT NULL,
    name varchar(50) NOT NULL,
    nullcode varchar(50) NOT NULL,
    code_img1 varchar(50) NOT NULL,
    code_img2 varchar(50) NOT NULL,
    width integer NOT NULL,
    height integer NOT NULL,
    drop_folder varchar(50) NOT NULL,
    class_item integer NOT NULL,
    model_position integer NOT NULL,
    sound integer NOT NULL,
    weapon_class integer NOT NULL,
    quest_id integer NOT NULL,
    quest_r integer NOT NULL,
    quest_g integer NOT NULL,
    quest_b integer NOT NULL,
    quest_transparency integer NOT NULL,
    quest_flashing_time integer NOT NULL,
    req_level integer NOT NULL,
    req_strengh integer NOT NULL,
    req_spirit integer NOT NULL,
    req_talent integer NOT NULL,
    req_agility integer NOT NULL,
    req_health integer NOT NULL,
    integrity_min integer NOT NULL,
    integrity_max integer NOT NULL,
    weight integer NOT NULL,
    price integer NOT NULL,
    organic_min integer NOT NULL,
    organic_max integer NOT NULL,
    fire_min integer NOT NULL,
    fire_max integer NOT NULL,
    frost_min integer NOT NULL,
    frost_max integer NOT NULL,
    lightning_min integer NOT NULL,
    lightning_max integer NOT NULL,
    poison_min integer NOT NULL,
    poison_max integer NOT NULL,
    atk_pow1_min integer NOT NULL,
    atk_pow1_max integer NOT NULL,
    atk_pow2_min integer NOT NULL,
    atk_pow2_max integer NOT NULL,
    range integer NOT NULL,
    atk_speed integer NOT NULL,
    atk_rating_min integer NOT NULL,
    atk_rating_max integer NOT NULL,
    critical integer NOT NULL,
    block_min real NOT NULL,
    block_max real NOT NULL,
    absorb_min real NOT NULL,
    absorb_max real NOT NULL,
    defense_min integer NOT NULL,
    defense_max integer NOT NULL,
    potion_space integer NOT NULL,
    potion_count integer NOT NULL,
    regeneration_hp_min real NOT NULL,
    regeneration_hp_max real NOT NULL,
    regeneration_mp_min real NOT NULL,
    regeneration_mp_max real NOT NULL,
    regeneration_stm_min real NOT NULL,
    regeneration_stm_max real NOT NULL,
    add_hp_min integer NOT NULL,
    add_hp_max integer NOT NULL,
    add_mp_min integer NOT NULL,
    add_mp_max integer NOT NULL,
    add_stm_min integer NOT NULL,
    add_stm_max integer NOT NULL,
    recovery_hp_min integer NOT NULL,
    recovery_hp_max integer NOT NULL,
    recovery_mp_min integer NOT NULL,
    recovery_mp_max integer NOT NULL,
    recovery_stm_min integer NOT NULL,
    recovery_stm_max integer NOT NULL,
    run_speed_min real NOT NULL,
    run_speed_max real NOT NULL,
    primary_spec integer NOT NULL,
    add_spec_class1 integer NOT NULL,
    add_spec_class2 integer NOT NULL,
    add_spec_class3 integer NOT NULL,
    add_spec_class4 integer NOT NULL,
    add_spec_class5 integer NOT NULL,
    add_spec_class6 integer NOT NULL,
    add_spec_class7 integer NOT NULL,
    add_spec_class8 integer NOT NULL,
    add_spec_class9 integer NOT NULL,
    add_spec_class10 integer NOT NULL,
    add_spec_class11 integer NOT NULL,
    add_spec_class12 integer NOT NULL,
    add_spec_run_speed_min real NOT NULL,
    add_spec_run_speed_max real NOT NULL,
    add_spec_absorb_min real NOT NULL,
    add_spec_absorb_max real NOT NULL,
    add_spec_defense_min integer NOT NULL,
    add_spec_defense_max integer NOT NULL,
    add_spec_atk_speed integer NOT NULL,
    add_spec_critical integer NOT NULL,
    add_spec_atk_power_min integer NOT NULL,
    add_spec_atk_power_max integer NOT NULL,
    add_spec_atk_rating_min integer NOT NULL,
    add_spec_atk_rating_max integer NOT NULL,
    add_spec_hp_regen real NOT NULL,
    add_spec_mp_regen_min real NOT NULL,
    add_spec_mp_regen_max real NOT NULL,
    add_spec_stm_regen real NOT NULL,
    add_spec_block real NOT NULL,
    add_spec_range integer NOT NULL,
    cannot_drop integer NOT NULL
);

-- 17. item_list_old
CREATE TABLE gamedb.item_list_old (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    id_code integer NOT NULL,
    name varchar(50) NOT NULL,
    nullcode varchar(50) NOT NULL,
    code_img1 varchar(50) NOT NULL,
    code_img2 varchar(50) NOT NULL,
    width integer NOT NULL,
    height integer NOT NULL,
    drop_folder varchar(50) NOT NULL,
    class_item integer NOT NULL,
    model_position integer NOT NULL,
    sound integer NOT NULL,
    weapon_class integer NOT NULL,
    quest_id integer NOT NULL,
    quest_r integer NOT NULL,
    quest_g integer NOT NULL,
    quest_b integer NOT NULL,
    quest_transparency integer NOT NULL,
    quest_flashing_time integer NOT NULL,
    req_level integer NOT NULL,
    req_strengh integer NOT NULL,
    req_spirit integer NOT NULL,
    req_talent integer NOT NULL,
    req_agility integer NOT NULL,
    req_health integer NOT NULL,
    integrity_min integer NOT NULL,
    integrity_max integer NOT NULL,
    weight integer NOT NULL,
    price integer NOT NULL,
    organic_min integer NOT NULL,
    organic_max integer NOT NULL,
    fire_min integer NOT NULL,
    fire_max integer NOT NULL,
    frost_min integer NOT NULL,
    frost_max integer NOT NULL,
    lightning_min integer NOT NULL,
    lightning_max integer NOT NULL,
    poison_min integer NOT NULL,
    poison_max integer NOT NULL,
    atk_pow1_min integer NOT NULL,
    atk_pow1_max integer NOT NULL,
    atk_pow2_min integer NOT NULL,
    atk_pow2_max integer NOT NULL,
    range integer NOT NULL,
    atk_speed integer NOT NULL,
    atk_rating_min integer NOT NULL,
    atk_rating_max integer NOT NULL,
    critical integer NOT NULL,
    block_min real NOT NULL,
    block_max real NOT NULL,
    absorb_min real NOT NULL,
    absorb_max real NOT NULL,
    defense_min integer NOT NULL,
    defense_max integer NOT NULL,
    potion_space integer NOT NULL,
    potion_count integer NOT NULL,
    regeneration_hp_min real NOT NULL,
    regeneration_hp_max real NOT NULL,
    regeneration_mp_min real NOT NULL,
    regeneration_mp_max real NOT NULL,
    regeneration_stm_min real NOT NULL,
    regeneration_stm_max real NOT NULL,
    add_hp_min integer NOT NULL,
    add_hp_max integer NOT NULL,
    add_mp_min integer NOT NULL,
    add_mp_max integer NOT NULL,
    add_stm_min integer NOT NULL,
    add_stm_max integer NOT NULL,
    recovery_hp_min integer NOT NULL,
    recovery_hp_max integer NOT NULL,
    recovery_mp_min integer NOT NULL,
    recovery_mp_max integer NOT NULL,
    recovery_stm_min integer NOT NULL,
    recovery_stm_max integer NOT NULL,
    run_speed_min real NOT NULL,
    run_speed_max real NOT NULL,
    primary_spec integer NOT NULL,
    add_spec_class1 integer NOT NULL,
    add_spec_class2 integer NOT NULL,
    add_spec_class3 integer NOT NULL,
    add_spec_class4 integer NOT NULL,
    add_spec_class5 integer NOT NULL,
    add_spec_class6 integer NOT NULL,
    add_spec_class7 integer NOT NULL,
    add_spec_class8 integer NOT NULL,
    add_spec_class9 integer NOT NULL,
    add_spec_class10 integer NOT NULL,
    add_spec_class11 integer NOT NULL,
    add_spec_class12 integer NOT NULL,
    add_spec_run_speed_min real NOT NULL,
    add_spec_run_speed_max real NOT NULL,
    add_spec_absorb_min real NOT NULL,
    add_spec_absorb_max real NOT NULL,
    add_spec_defense_min integer NOT NULL,
    add_spec_defense_max integer NOT NULL,
    add_spec_atk_speed integer NOT NULL,
    add_spec_critical integer NOT NULL,
    add_spec_atk_power_min integer NOT NULL,
    add_spec_atk_power_max integer NOT NULL,
    add_spec_atk_rating_min integer NOT NULL,
    add_spec_atk_rating_max integer NOT NULL,
    add_spec_hp_regen real NOT NULL,
    add_spec_mp_regen_min real NOT NULL,
    add_spec_mp_regen_max real NOT NULL,
    add_spec_stm_regen real NOT NULL,
    add_spec_block real NOT NULL,
    add_spec_range integer NOT NULL,
    cannot_drop integer NOT NULL
);

-- 18. item_spec
CREATE TABLE gamedb.item_spec (
    item_id integer NOT NULL,
    character_class_id integer NOT NULL,
    main_spec integer NOT NULL
);

-- 19. item_spec_mod
CREATE TABLE gamedb.item_spec_mod (
    add_spec_class01 integer NOT NULL PRIMARY KEY,
    add_spec_class02 integer NOT NULL,
    add_spec_class03 integer NOT NULL,
    add_spec_class04 integer NOT NULL,
    add_spec_class05 integer NOT NULL,
    add_spec_class06 integer NOT NULL,
    add_spec_class07 integer NOT NULL,
    add_spec_class08 integer NOT NULL,
    add_spec_class09 integer NOT NULL,
    add_spec_class10 integer NOT NULL,
    item_type varchar(12) NOT NULL,
    percent_req_strength integer NOT NULL,
    percent_req_spirit integer NOT NULL,
    percent_req_talent integer NOT NULL,
    percent_req_agility integer NOT NULL,
    percent_req_health integer NOT NULL
);

-- 20. item_sub_type
CREATE TABLE gamedb.item_sub_type (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    type_id integer NOT NULL,
    code integer NOT NULL,
    name varchar(32) NOT NULL
);

-- 21. item_type
CREATE TABLE gamedb.item_type (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    code integer NOT NULL,
    name varchar(32) NOT NULL
);

-- 22. item_value
CREATE TABLE gamedb.item_value (
    item_list_id integer NOT NULL,
    attribute_id integer NOT NULL,
    min_value double precision NOT NULL,
    max_value double precision NOT NULL,
    spec integer NOT NULL
);

-- 23. map_boss
CREATE TABLE gamedb.map_boss (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    map_id integer NOT NULL,
    boss_monster_id integer NOT NULL,
    minion_monster_id integer NOT NULL,
    minion_count integer NOT NULL
);

-- 24. map_boss_hour
CREATE TABLE gamedb.map_boss_hour (
    boss_id integer NOT NULL,
    hour integer NOT NULL
);

-- 25. map_indicator
CREATE TABLE gamedb.map_indicator (
    map_id integer NOT NULL,
    type integer NOT NULL,
    value integer NOT NULL,
    pos_x integer NOT NULL,
    pos_z integer NOT NULL,
    angle_y integer NOT NULL
);

-- 26. map_list
CREATE TABLE gamedb.map_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    name varchar(50) NULL,
    short_name varchar(50) NULL,
    type_map varchar(50) NULL,
    level_req integer NULL,
    pvp integer NULL,
    stage_file varchar(50) NULL
);

-- 27. map_monster
CREATE TABLE gamedb.map_monster (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    stage varchar(50) NULL,
    max_monsters integer NOT NULL,
    interval integer NOT NULL,
    max_enemy_flag integer NOT NULL,
    monster1 varchar(150) NULL,
    count1 integer NULL,
    monster2 varchar(150) NULL,
    count2 integer NULL,
    monster3 varchar(150) NULL,
    count3 integer NULL,
    monster4 varchar(150) NULL,
    count4 integer NULL,
    monster5 varchar(150) NULL,
    count5 integer NULL,
    monster6 varchar(150) NULL,
    count6 integer NULL,
    monster7 varchar(150) NULL,
    count7 integer NULL,
    monster8 varchar(150) NULL,
    count8 integer NULL,
    monster9 varchar(150) NULL,
    count9 integer NULL,
    monster10 varchar(150) NULL,
    count10 integer NULL,
    monster11 varchar(150) NULL,
    count11 integer NULL,
    monster12 varchar(150) NULL,
    count12 integer NULL,
    boss_monster1 varchar(150) NULL,
    hours_boss_monster1 varchar(150) NULL,
    sub_monster1 varchar(150) NULL,
    count_sub1 integer NULL,
    boss_monster2 varchar(150) NULL,
    hours_boss_monster2 varchar(150) NULL,
    sub_monster2 varchar(150) NULL,
    count_sub2 integer NULL,
    boss_monster3 varchar(150) NULL,
    hours_boss_monster3 varchar(150) NULL,
    sub_monster3 varchar(150) NULL,
    count_sub3 integer NULL
);

-- 28. map_npc
CREATE TABLE gamedb.map_npc (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    stage integer NOT NULL,
    x integer NOT NULL,
    y integer NOT NULL,
    z integer NOT NULL,
    angle integer NOT NULL,
    id_npc integer NOT NULL,
    enabled integer NOT NULL,
    only_gm integer NOT NULL
);

-- 29. map_spawn_point
CREATE TABLE gamedb.map_spawn_point (
    id integer NOT NULL PRIMARY KEY,
    stage integer NULL,
    x integer NULL,
    z integer NULL,
    description varchar(150) NULL
);

-- 30. map_type
CREATE TABLE gamedb.map_type (
    id integer NOT NULL,
    name varchar(64) NOT NULL
);

-- 31. mimic_spawn
CREATE TABLE gamedb.mimic_spawn (
    map_id integer NOT NULL,
    mimic_name integer NOT NULL,
    spawn_chance integer NOT NULL,
    min_delay_between_spawn integer NOT NULL
);

-- 32. mix_effect
CREATE TABLE gamedb.mix_effect (
    id smallint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    code integer NOT NULL,
    before_value varchar(16) NOT NULL,
    after_value varchar(16) NOT NULL
);

-- 33. mix_effect_type
CREATE TABLE gamedb.mix_effect_type (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    after_text varchar(16) NULL
);

-- 34. mix_item
CREATE TABLE gamedb.mix_item (
    id smallint GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    mix_id smallint NOT NULL,
    item_sub_type_id integer NOT NULL
);

-- 35. mix_list
CREATE TABLE gamedb.mix_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    mix_unique_id integer NOT NULL,
    group_mix_id integer NOT NULL,
    type_mix integer NOT NULL,
    type_mix_name varchar(20) NOT NULL,
    description varchar(150) NOT NULL,
    lucidy integer NOT NULL,
    sereneo integer NOT NULL,
    fadeo integer NOT NULL,
    sparky integer NOT NULL,
    raident integer NOT NULL,
    transparo integer NOT NULL,
    murky integer NOT NULL,
    devine integer NOT NULL,
    celesto integer NOT NULL,
    mirage integer NOT NULL,
    inferna integer NOT NULL,
    enigma integer NOT NULL,
    bellum integer NOT NULL,
    oredo integer NOT NULL,
    new_sheltom14 integer NULL,
    new_sheltom15 integer NULL,
    type_atributte integer NOT NULL,
    atributte real NOT NULL,
    per_atributte integer NOT NULL,
    type_atributte2 integer NOT NULL,
    atributte2 real NOT NULL,
    per_atributte2 integer NOT NULL,
    type_atributte3 integer NOT NULL,
    atributte3 real NOT NULL,
    per_atributte3 integer NOT NULL,
    type_atributte4 integer NOT NULL,
    atributte4 real NOT NULL,
    per_atributte4 integer NOT NULL,
    type_atributte5 integer NOT NULL,
    atributte5 real NOT NULL,
    per_atributte5 integer NOT NULL,
    type_atributte6 integer NOT NULL,
    atributte6 real NOT NULL,
    per_atributte6 integer NOT NULL,
    type_atributte7 integer NOT NULL,
    atributte7 real NOT NULL,
    per_atributte7 integer NOT NULL,
    type_atributte8 integer NOT NULL,
    atributte8 real NOT NULL,
    per_atributte8 integer NOT NULL
);

-- 36. mix_value
CREATE TABLE gamedb.mix_value (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    mix_id smallint NOT NULL,
    effect_id smallint NOT NULL,
    value double precision NOT NULL,
    effect_type_id integer NOT NULL
);

-- 37. model_animation_list
CREATE TABLE gamedb.model_animation_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    model_id integer NOT NULL,
    type integer NOT NULL,
    frame_begin integer NOT NULL,
    frame_end integer NOT NULL,
    frame_event1 integer NOT NULL,
    frame_event2 integer NOT NULL,
    frame_event3 integer NOT NULL,
    frame_event4 integer NOT NULL
);

-- 38. model_list
CREATE TABLE gamedb.model_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    model varchar(64) NOT NULL,
    width integer NOT NULL,
    height integer NOT NULL,
    death_model_id integer NOT NULL
);

-- 39. monster_effect
CREATE TABLE gamedb.monster_effect (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    code integer NOT NULL,
    name varchar(32) NOT NULL
);

-- 40. monster_list
CREATE TABLE gamedb.monster_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    name varchar(32) NULL,
    model_file varchar(64) NULL,
    level integer NULL,
    glow integer NULL,
    size real NULL,
    camera_y integer NULL,
    camera_z integer NULL,
    monster_id integer NULL,
    drop_is_public integer NULL,
    drop_quantity integer NULL,
    spawn_time varchar(50) NULL,
    spawn_min integer NULL,
    spawn_max integer NULL,
    inteligence integer NULL,
    monster_type varchar(30) NULL,
    view_sight integer NULL,
    hp integer NULL,
    exp varchar(50) NULL,
    special_skill_type varchar(50) NULL,
    special_skill_hit varchar(50) NULL,
    special_hit_rate integer NULL,
    special_hit_scope integer NULL,
    special_hit_power_min integer NULL,
    special_hit_power_max integer NULL,
    atk_pow_min integer NULL,
    atk_pow_max integer NULL,
    absorb integer NULL,
    stun_chance integer NOT NULL,
    block integer NULL,
    defense integer NULL,
    attack_speed integer NULL,
    attack_rating integer NULL,
    attack_range integer NULL,
    perfect_attack_rate integer NULL,
    size_shadow varchar(30) NULL,
    organic integer NULL,
    lightning integer NULL,
    ice integer NULL,
    fire integer NULL,
    poison integer NULL,
    magic integer NULL,
    property_mon varchar(30) NULL,
    move_speed integer NULL,
    potion_percent integer NULL,
    potions integer NULL,
    effect varchar(50) NULL,
    quest_item_drop varchar(50) NULL,
    quest_id integer NULL,
    quest_map integer NULL,
    stage varchar(50) NULL,
    health_point integer NULL
);

-- 41. npc_list
CREATE TABLE gamedb.npc_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    name varchar(64) NOT NULL,
    game_file varchar(250) NOT NULL,
    message1 varchar(250) NULL,
    message2 varchar(250) NULL,
    message3 varchar(250) NULL,
    message4 varchar(250) NULL,
    event_type integer NOT NULL,
    event_param integer NOT NULL,
    skill_quests integer NOT NULL,
    quest_id integer NOT NULL,
    quest_type_id integer NOT NULL,
    quest_type_sub_id integer NOT NULL,
    teleport_id integer NOT NULL,
    weapon_shop varchar(1024) NULL,
    defense_shop varchar(1024) NULL,
    misc_shop varchar(1024) NULL
);

-- 42. npc_message
CREATE TABLE gamedb.npc_message (
    npc_id integer NOT NULL,
    message varchar(128) NOT NULL
);

-- 43. pet_system
CREATE TABLE gamedb.pet_system (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    pet_owner_name varchar(32) NULL,
    pet_name varchar(32) NULL,
    pet_skin_id integer NOT NULL
);

-- 44. pet_system_skin
CREATE TABLE gamedb.pet_system_skin (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    pet_name_summon varchar(32) NOT NULL,
    pet_size double precision NULL,
    pet_rarity integer NOT NULL
);

-- 45. quest_event_list
CREATE TABLE gamedb.quest_event_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    quest_id integer NOT NULL,
    percent_increase_exp integer NOT NULL,
    drop_reduction integer NOT NULL
);

-- 46. quest_list
CREATE TABLE gamedb.quest_list (
    id integer NOT NULL PRIMARY KEY,
    name varchar(64) NOT NULL,
    short_description varchar(128) NOT NULL,
    description varchar(2048) NOT NULL,
    progress_text varchar(2048) NOT NULL,
    conclusion_text varchar(2048) NOT NULL,
    party integer NOT NULL,
    multiple integer NOT NULL,
    pvp integer NOT NULL,
    min_level integer NULL,
    max_level integer NULL,
    max_duration integer NULL,
    duration_type integer NULL,
    wait_time integer NULL,
    map_id varchar(64) NULL,
    monster_id varchar(64) NULL,
    required_items varchar(128) NULL,
    quest_type integer NOT NULL,
    required_quest_ids varchar(64) NULL,
    inclusion_quest_ids varchar(64) NULL,
    npc_id integer NOT NULL,
    progress_npc_id integer NOT NULL,
    conclusion_npc_id integer NOT NULL,
    auto_start_quest_id integer NULL,
    class_restriction varchar(32) NULL,
    area_type integer NULL,
    min_x integer NULL,
    max_x integer NULL,
    min_z integer NULL,
    max_z integer NULL,
    radius integer NULL
);

-- 47. quest_reward_list
CREATE TABLE gamedb.quest_reward_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    quest_id integer NOT NULL,
    name varchar(64) NULL,
    monster_quantities varchar(64) NULL,
    required_drop_quantities varchar(64) NULL,
    exp_reward bigint NOT NULL,
    exp_pot_bonus integer NOT NULL,
    exp_level_difference integer NOT NULL,
    item_reward_select integer NULL,
    items_reward varchar(128) NULL,
    items_reward_quantities varchar(64) NULL,
    extra_reward_type varchar(64) NULL,
    extra_reward_values varchar(64) NULL,
    time_multiplier integer NULL
);

-- 48. quest_swap_list
CREATE TABLE gamedb.quest_swap_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    quest_race1 integer NOT NULL,
    quest_race2 integer NOT NULL,
    quest_race3 integer NOT NULL
);

-- 49. quest_window_list
CREATE TABLE gamedb.quest_window_list (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    npc_id integer NOT NULL,
    quest_list_id varchar(255) NOT NULL,
    main_image varchar(255) NOT NULL,
    main_text varchar(255) NOT NULL
);

-- 50. rarity_chance
CREATE TABLE gamedb.rarity_chance (
    rarity_chance_group integer NOT NULL,
    rarity integer NOT NULL,
    chance integer NOT NULL
);

-- 51. rarity_chance_group
CREATE TABLE gamedb.rarity_chance_group (
    id integer NOT NULL PRIMARY KEY,
    min_level integer NOT NULL,
    max_level integer NOT NULL
);

-- 52. rarity_chance_mod
CREATE TABLE gamedb.rarity_chance_mod (
    type integer NOT NULL PRIMARY KEY,
    mod_common real NOT NULL,
    mod_uncommon real NOT NULL,
    mod_rare real NOT NULL,
    mod_epic real NOT NULL,
    mod_legendary real NOT NULL
);