-- SkillDB: converted from server/mssql/SkillDB.sql
CREATE SCHEMA IF NOT EXISTS skilldb;

SET search_path TO skilldb, public;

-- AdventMigal
CREATE TABLE IF NOT EXISTS skilldb.advent_migal (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage integer NULL,
    duration integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Agony
CREATE TABLE IF NOT EXISTS skilldb.agony (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    hptaken integer NULL,
    mprecovery integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Alas
CREATE TABLE IF NOT EXISTS skilldb.alas (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    evasion integer NULL,
    duration integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ArrowofRage
CREATE TABLE IF NOT EXISTS skilldb.arrowof_rage (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- AssasinsEye
CREATE TABLE IF NOT EXISTS skilldb.assasins_eye (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    critical_damage integer NULL,
    critical_monster integer NULL,
    duration integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Automation
CREATE TABLE IF NOT EXISTS skilldb.automation (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    added_atk_spd integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Avalanche
CREATE TABLE IF NOT EXISTS skilldb.avalanche (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_atk_spd integer NULL,
    damage_boost integer NULL,
    numberof_arrows integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- AvengingCrash
CREATE TABLE IF NOT EXISTS skilldb.avenging_crash (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    atk_rtg_boost integer NULL,
    damage_boost integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Berserker
CREATE TABLE IF NOT EXISTS skilldb.berserker (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_atk_power integer NULL,
    absorption integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- BiggerSpear
CREATE TABLE IF NOT EXISTS skilldb.bigger_spear (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Blind
CREATE TABLE IF NOT EXISTS skilldb.blind (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    visibility integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- BombShot
CREATE TABLE IF NOT EXISTS skilldb.bomb_shot (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    damage_boost_vs_demons integer NULL,
    splash_dmg integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- BoneCrash
CREATE TABLE IF NOT EXISTS skilldb.bone_crash (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    damage_boost_vs_demons integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- BoostHealth
CREATE TABLE IF NOT EXISTS skilldb.boost_health (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_hp integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Brandish
CREATE TABLE IF NOT EXISTS skilldb.brandish (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- BrutalSwing
CREATE TABLE IF NOT EXISTS skilldb.brutal_swing (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    added_critical integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ChainLance
CREATE TABLE IF NOT EXISTS skilldb.chain_lance (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ChainLightning
CREATE TABLE IF NOT EXISTS skilldb.chain_lightning (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    lightning_damage integer NULL,
    bolts integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ChargingStrike
CREATE TABLE IF NOT EXISTS skilldb.charging_strike (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    charged_damage integer NULL,
    raise_speed integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ChasingHunt
CREATE TABLE IF NOT EXISTS skilldb.chasing_hunt (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    atk_pow integer NULL,
    magnetic_range integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Compulsion
CREATE TABLE IF NOT EXISTS skilldb.compulsion (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    extra_absorb integer NULL,
    magnetic_range integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Concentration
CREATE TABLE IF NOT EXISTS skilldb.concentration (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_atk_rtg integer NULL,
    duration integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- CriticalHit
CREATE TABLE IF NOT EXISTS skilldb.critical_hit (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    critical_damage integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- CriticalMastery
CREATE TABLE IF NOT EXISTS skilldb.critical_mastery (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_critical integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- CycloneStrike
CREATE TABLE IF NOT EXISTS skilldb.cyclone_strike (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    enemies integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- DancingSword
CREATE TABLE IF NOT EXISTS skilldb.dancing_sword (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    fire_damage integer NULL,
    ice_damage integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- DarkBolt
CREATE TABLE IF NOT EXISTS skilldb.dark_bolt (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- DarkWave
CREATE TABLE IF NOT EXISTS skilldb.dark_wave (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- DeathRay
CREATE TABLE IF NOT EXISTS skilldb.death_ray (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Destroyer
CREATE TABLE IF NOT EXISTS skilldb.destroyer (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    added_critical integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Diastrophism
CREATE TABLE IF NOT EXISTS skilldb.diastrophism (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- DionsEye
CREATE TABLE IF NOT EXISTS skilldb.dions_eye (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    weapon_attack_rating_boost integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Distortion
CREATE TABLE IF NOT EXISTS skilldb.distortion (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    speed_reduction integer NULL,
    damage_reduction integer NULL,
    duration integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- DivineLightning
CREATE TABLE IF NOT EXISTS skilldb.divine_lightning (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    bolts integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- DivinePiercing
CREATE TABLE IF NOT EXISTS skilldb.divine_piercing (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    numberof_hits integer NULL,
    added_critical integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- DivineShield
CREATE TABLE IF NOT EXISTS skilldb.divine_shield (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_block_rating integer NULL,
    absorb_life integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- DoubleCrash
CREATE TABLE IF NOT EXISTS skilldb.double_crash (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    added_critical integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- DrasticSpirit
CREATE TABLE IF NOT EXISTS skilldb.drastic_spirit (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    defense_rating_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ElementalShot
CREATE TABLE IF NOT EXISTS skilldb.elemental_shot (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    damage integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- EnchantWeapon
CREATE TABLE IF NOT EXISTS skilldb.enchant_weapon (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    fire_damage integer NULL,
    lightning_damage integer NULL,
    ice_damage integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- EnergyShield
CREATE TABLE IF NOT EXISTS skilldb.energy_shield (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_reduction integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- EvasionMastery
CREATE TABLE IF NOT EXISTS skilldb.evasion_mastery (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    evasion_rtg_increase integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Expansion
CREATE TABLE IF NOT EXISTS skilldb.expansion (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    weapon_size_increase integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Extinction
CREATE TABLE IF NOT EXISTS skilldb.extinction (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    success_rate integer NULL,
    hpreduction_vs_undead integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ExtremeRage
CREATE TABLE IF NOT EXISTS skilldb.extreme_rage (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ExtremeShield
CREATE TABLE IF NOT EXISTS skilldb.extreme_shield (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_block_rtg integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Falcon
CREATE TABLE IF NOT EXISTS skilldb.falcon (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    damage integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Farina
CREATE TABLE IF NOT EXISTS skilldb.farina (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_weapon_speed integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- FireAttribute
CREATE TABLE IF NOT EXISTS skilldb.fire_attribute (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_fire_resistance integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- FireBall
CREATE TABLE IF NOT EXISTS skilldb.fire_ball (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- FireBolt
CREATE TABLE IF NOT EXISTS skilldb.fire_bolt (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- FireElemental
CREATE TABLE IF NOT EXISTS skilldb.fire_elemental (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    attack_power integer NULL,
    attack_rating integer NULL,
    hp integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- FireJavelin
CREATE TABLE IF NOT EXISTS skilldb.fire_javelin (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- FlameWave
CREATE TABLE IF NOT EXISTS skilldb.flame_wave (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ForceofNature
CREATE TABLE IF NOT EXISTS skilldb.forceof_nature (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_atk_pow integer NULL,
    added_atk_rtg integer NULL,
    added_range integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- FrostJavelin
CREATE TABLE IF NOT EXISTS skilldb.frost_javelin (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_min integer NULL,
    damage_max integer NULL,
    enemy_speed_reduction integer NULL,
    freeze_time integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- FrostWind
CREATE TABLE IF NOT EXISTS skilldb.frost_wind (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- GlacialSpike
CREATE TABLE IF NOT EXISTS skilldb.glacial_spike (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_min integer NULL,
    damage_max integer NULL,
    area integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- GodlyShield
CREATE TABLE IF NOT EXISTS skilldb.godly_shield (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_absorption_rating integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- GodsBlessing
CREATE TABLE IF NOT EXISTS skilldb.gods_blessing (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_attack_power integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- GoldenFalcon
CREATE TABLE IF NOT EXISTS skilldb.golden_falcon (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    added_hp_recovery integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- GrandCross
CREATE TABLE IF NOT EXISTS skilldb.grand_cross (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_attack_rating integer NULL,
    damage_boost integer NULL,
    damage_boostvs_undead integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- GrandHealing
CREATE TABLE IF NOT EXISTS skilldb.grand_healing (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    hprestored integer NULL,
    party_range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- GrandSmash
CREATE TABLE IF NOT EXISTS skilldb.grand_smash (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_atk_rtg integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- GreatSmash
CREATE TABLE IF NOT EXISTS skilldb.great_smash (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_atk_rtg integer NULL,
    damage_boost integer NULL,
    added_atk_pow integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- GroundPike
CREATE TABLE IF NOT EXISTS skilldb.ground_pike (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_min integer NULL,
    damage_max integer NULL,
    freeze_time integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- GustSlash
CREATE TABLE IF NOT EXISTS skilldb.gust_slash (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- HallofValhalla
CREATE TABLE IF NOT EXISTS skilldb.hallof_valhalla (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_evasion_rating integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Haunt
CREATE TABLE IF NOT EXISTS skilldb.haunt (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    hpabsorption integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Healing
CREATE TABLE IF NOT EXISTS skilldb.healing (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    hprestored integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- HolyBody
CREATE TABLE IF NOT EXISTS skilldb.holy_body (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    absorption_rtg integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- HolyBolt
CREATE TABLE IF NOT EXISTS skilldb.holy_bolt (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- HolyIncantation
CREATE TABLE IF NOT EXISTS skilldb.holy_incantation (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    success_rate integer NULL,
    increase_undead_hp integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- HolyMind
CREATE TABLE IF NOT EXISTS skilldb.holy_mind (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    reduce_attack_power integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- HolyReflection
CREATE TABLE IF NOT EXISTS skilldb.holy_reflection (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    reflect integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- HolyValor
CREATE TABLE IF NOT EXISTS skilldb.holy_valor (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- IceAttribute
CREATE TABLE IF NOT EXISTS skilldb.ice_attribute (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_ice_resistance integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Impact
CREATE TABLE IF NOT EXISTS skilldb.impact (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_atk_rtg integer NULL,
    damage_boost integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Impulsion
CREATE TABLE IF NOT EXISTS skilldb.impulsion (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    numberof_sparks integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Judgement
CREATE TABLE IF NOT EXISTS skilldb.judgement (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- JumpingCrash
CREATE TABLE IF NOT EXISTS skilldb.jumping_crash (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    weapon_atk_rtg_boost integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- LightningJavelin
CREATE TABLE IF NOT EXISTS skilldb.lightning_javelin (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- MagneticSphere
CREATE TABLE IF NOT EXISTS skilldb.magnetic_sphere (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    sphere_dmg integer NULL,
    range integer NULL,
    attack_interval integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Maximize
CREATE TABLE IF NOT EXISTS skilldb.maximize (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    max_damage_boost integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- MechanicBomb
CREATE TABLE IF NOT EXISTS skilldb.mechanic_bomb (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    damage integer NULL,
    area_range integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- MechanicWeaponMastery
CREATE TABLE IF NOT EXISTS skilldb.mechanic_weapon_mastery (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    weapon_dmg_boost integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Meditation
CREATE TABLE IF NOT EXISTS skilldb.meditation (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_mprecovery integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- MeleeMastery
CREATE TABLE IF NOT EXISTS skilldb.melee_mastery (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    weapon_dmg_boost integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- MentalMastery
CREATE TABLE IF NOT EXISTS skilldb.mental_mastery (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    mpboost integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- MetalArmor
CREATE TABLE IF NOT EXISTS skilldb.metal_armor (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    armor_defense_rtg_boost integer NULL,
    duration integer NULL,
    chain_abs_pa integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- MetalGolem
CREATE TABLE IF NOT EXISTS skilldb.metal_golem (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    attack_power integer NULL,
    attack_rating integer NULL,
    defense integer NULL,
    hp integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    name varchar(100) NULL,
    duration integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Meteorite
CREATE TABLE IF NOT EXISTS skilldb.meteorite (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- MourningPray
CREATE TABLE IF NOT EXISTS skilldb.mourning_pray (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- MultiSpark
CREATE TABLE IF NOT EXISTS skilldb.multi_spark (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    damage integer NULL,
    numberof_sparks integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- NinjaShadow
CREATE TABLE IF NOT EXISTS skilldb.ninja_shadow (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- PerfectAim
CREATE TABLE IF NOT EXISTS skilldb.perfect_aim (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    weapon_atk_rate integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Perforation
CREATE TABLE IF NOT EXISTS skilldb.perforation (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_atk_range integer NULL,
    damage_boost integer NULL,
    added_critical integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- PhantomCall
CREATE TABLE IF NOT EXISTS skilldb.phantom_call (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- PhoenixShot
CREATE TABLE IF NOT EXISTS skilldb.phoenix_shot (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    reducedchargingtime integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- PhysicalAbsorption
CREATE TABLE IF NOT EXISTS skilldb.physical_absorption (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_absorb_rtg integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- PhysicalTraining
CREATE TABLE IF NOT EXISTS skilldb.physical_training (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    stamina_boost integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Piercing
CREATE TABLE IF NOT EXISTS skilldb.piercing (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- PikeWind
CREATE TABLE IF NOT EXISTS skilldb.pike_wind (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_min integer NULL,
    damage_max char(10) NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- PoisonAttribute
CREATE TABLE IF NOT EXISTS skilldb.poison_attribute (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_poison_resistance integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Polluted
CREATE TABLE IF NOT EXISTS skilldb.polluted (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    numberof_spears integer NULL,
    duration integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- RageofZecram
CREATE TABLE IF NOT EXISTS skilldb.rageof_zecram (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    area integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Rainmaker
CREATE TABLE IF NOT EXISTS skilldb.rainmaker (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_reduction integer NULL,
    duration integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Raving
CREATE TABLE IF NOT EXISTS skilldb.raving (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    numberof_hits integer NULL,
    hpreduction integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- RecallHestian
CREATE TABLE IF NOT EXISTS skilldb.recall_hestian (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    attack_power integer NULL,
    attack_rating integer NULL,
    defense integer NULL,
    hp integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    name varchar(100) NULL,
    duration integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- RecallWolverine
CREATE TABLE IF NOT EXISTS skilldb.recall_wolverine (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    attack_power integer NULL,
    attack_rating integer NULL,
    defense integer NULL,
    hp integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    name varchar(100) NULL,
    duration integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- RegenerationField
CREATE TABLE IF NOT EXISTS skilldb.regeneration_field (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_hprecovery integer NULL,
    added_mprecovery integer NULL,
    duration_seconds integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Resurrection
CREATE TABLE IF NOT EXISTS skilldb.resurrection (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    success_rate integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Roar
CREATE TABLE IF NOT EXISTS skilldb.roar (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    range integer NULL,
    stun_time integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- RunningHit
CREATE TABLE IF NOT EXISTS skilldb.running_hit (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ScoutHawk
CREATE TABLE IF NOT EXISTS skilldb.scout_hawk (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    atk_rtg_boost integer NULL,
    rotations integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Scratch
CREATE TABLE IF NOT EXISTS skilldb.scratch (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ShadowMaster
CREATE TABLE IF NOT EXISTS skilldb.shadow_master (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    numberof_hits integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ShieldStrike
CREATE TABLE IF NOT EXISTS skilldb.shield_strike (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_min integer NULL,
    damage_max integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ShootingMastery
CREATE TABLE IF NOT EXISTS skilldb.shooting_mastery (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_weapon_atk_pow integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SoreBlade
CREATE TABLE IF NOT EXISTS skilldb.sore_blade (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SoulShock
CREATE TABLE IF NOT EXISTS skilldb.soul_shock (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    range integer NULL,
    stun_time integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SoulSucker
CREATE TABLE IF NOT EXISTS skilldb.soul_sucker (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    hpabsorption integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Spark
CREATE TABLE IF NOT EXISTS skilldb.spark (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    spark_dmg integer NULL,
    area_range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SparkShield
CREATE TABLE IF NOT EXISTS skilldb.spark_shield (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    reflect_dmg integer NULL,
    added_defense_rtg integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SpiritElemental
CREATE TABLE IF NOT EXISTS skilldb.spirit_elemental (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SpiritualFlare
CREATE TABLE IF NOT EXISTS skilldb.spiritual_flare (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SpiritualManacle
CREATE TABLE IF NOT EXISTS skilldb.spiritual_manacle (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    stun_time integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SplitJavelin
CREATE TABLE IF NOT EXISTS skilldb.split_javelin (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    numberof_hits integer NULL,
    damage_boost integer NULL,
    atk_rtg_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Stinger
CREATE TABLE IF NOT EXISTS skilldb.stinger (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- StormJavelin
CREATE TABLE IF NOT EXISTS skilldb.storm_javelin (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SummonMuspell
CREATE TABLE IF NOT EXISTS skilldb.summon_muspell (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage integer NULL,
    duration integer NULL,
    absorbs_undead_damage integer NULL,
    added_evasion integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SwiftAxe
CREATE TABLE IF NOT EXISTS skilldb.swift_axe (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    weapon_atk_speed_boost integer NULL,
    duration integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SwordBlast
CREATE TABLE IF NOT EXISTS skilldb.sword_blast (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    static_damage integer NULL,
    damage_boost integer NULL,
    pushback_range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SwordMastery
CREATE TABLE IF NOT EXISTS skilldb.sword_mastery (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    weapon_damage_boost integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- SwordofJustice
CREATE TABLE IF NOT EXISTS skilldb.swordof_justice (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Teste
CREATE TABLE IF NOT EXISTS skilldb.teste (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    weapon_attack_rating_boost integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ThrowingMastery
CREATE TABLE IF NOT EXISTS skilldb.throwing_mastery (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    weapon_damage_boost integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Tornado
CREATE TABLE IF NOT EXISTS skilldb.tornado (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- TripleImpact
CREATE TABLE IF NOT EXISTS skilldb.triple_impact (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    numberof_hits integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- TriumphofValhalla
CREATE TABLE IF NOT EXISTS skilldb.triumphof_valhalla (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_max_atk_power integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- TwistJavelin
CREATE TABLE IF NOT EXISTS skilldb.twist_javelin (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    attack_rtg_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Vague
CREATE TABLE IF NOT EXISTS skilldb.vague (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    evasion integer NULL,
    duration integer NULL,
    mp_usage integer NULL,
    stm_usage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Vanish
CREATE TABLE IF NOT EXISTS skilldb.vanish (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    visibility integer NULL,
    duration integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Vengeance
CREATE TABLE IF NOT EXISTS skilldb.vengeance (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    added_range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- VenomSpear
CREATE TABLE IF NOT EXISTS skilldb.venom_spear (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    numberof_spears integer NULL,
    duration integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- VenomThorn
CREATE TABLE IF NOT EXISTS skilldb.venom_thorn (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- VigorBall
CREATE TABLE IF NOT EXISTS skilldb.vigor_ball (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- VirtualLife
CREATE TABLE IF NOT EXISTS skilldb.virtual_life (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    hpboost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Watornado
CREATE TABLE IF NOT EXISTS skilldb.watornado (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    damage_boost integer NULL,
    range integer NULL,
    area integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- WeaponDefenseMastery
CREATE TABLE IF NOT EXISTS skilldb.weapon_defense_mastery (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_block_rtg integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- WindArrow
CREATE TABLE IF NOT EXISTS skilldb.wind_arrow (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_atk_speed integer NULL,
    damage_boost integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Windy
CREATE TABLE IF NOT EXISTS skilldb.windy (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    attack_rating_boost integer NULL,
    added_range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Wisp
CREATE TABLE IF NOT EXISTS skilldb.wisp (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    reduce_attack_power integer NULL,
    range integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Zenith
CREATE TABLE IF NOT EXISTS skilldb.zenith (
    id integer GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    skill_level integer NULL,
    added_elemental_resistance integer NULL,
    mpusage integer NULL,
    stmusage integer NULL,
    create_time timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP
);

