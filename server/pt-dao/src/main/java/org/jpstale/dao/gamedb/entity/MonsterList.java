package org.jpstale.dao.gamedb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 *
 * @author pt-dao
 * @since 2026-03-15
 */
@Data
@TableName(schema = "gamedb", value = "monster_list")
public class MonsterList {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("model_file")
    private String modelFile;
    @TableField("level")
    private Integer level;
    @TableField("glow")
    private Integer glow;
    @TableField("size")
    private Double size;
    @TableField("camera_y")
    private Integer cameraY;
    @TableField("camera_z")
    private Integer cameraZ;
    @TableField("monster_id")
    private Integer monsterId;
    @TableField("drop_is_public")
    private Integer dropIsPublic;
    @TableField("drop_quantity")
    private Integer dropQuantity;
    @TableField("spawn_time")
    private String spawnTime;
    @TableField("spawn_min")
    private Integer spawnMin;
    @TableField("spawn_max")
    private Integer spawnMax;
    @TableField("inteligence")
    private Integer inteligence;
    @TableField("monster_type")
    private String monsterType;
    @TableField("view_sight")
    private Integer viewSight;
    @TableField("hp")
    private Integer hp;
    @TableField("exp")
    private String exp;
    @TableField("special_skill_type")
    private String specialSkillType;
    @TableField("special_skill_hit")
    private String specialSkillHit;
    @TableField("special_hit_rate")
    private Integer specialHitRate;
    @TableField("special_hit_scope")
    private Integer specialHitScope;
    @TableField("special_hit_power_min")
    private Integer specialHitPowerMin;
    @TableField("special_hit_power_max")
    private Integer specialHitPowerMax;
    @TableField("atk_pow_min")
    private Integer atkPowMin;
    @TableField("atk_pow_max")
    private Integer atkPowMax;
    @TableField("absorb")
    private Integer absorb;
    @TableField("stun_chance")
    private Integer stunChance;
    @TableField("block")
    private Integer block;
    @TableField("defense")
    private Integer defense;
    @TableField("attack_speed")
    private Integer attackSpeed;
    @TableField("attack_rating")
    private Integer attackRating;
    @TableField("attack_range")
    private Integer attackRange;
    @TableField("perfect_attack_rate")
    private Integer perfectAttackRate;
    @TableField("size_shadow")
    private String sizeShadow;
    @TableField("organic")
    private Integer organic;
    @TableField("lightning")
    private Integer lightning;
    @TableField("ice")
    private Integer ice;
    @TableField("fire")
    private Integer fire;
    @TableField("poison")
    private Integer poison;
    @TableField("magic")
    private Integer magic;
    @TableField("property_mon")
    private String propertyMon;
    @TableField("move_speed")
    private Integer moveSpeed;
    @TableField("potion_percent")
    private Integer potionPercent;
    @TableField("potions")
    private Integer potions;
    @TableField("effect")
    private String effect;
    @TableField("quest_item_drop")
    private String questItemDrop;
    @TableField("quest_id")
    private Integer questId;
    @TableField("quest_map")
    private Integer questMap;
    @TableField("stage")
    private String stage;
    @TableField("health_point")
    private Integer healthPoint;
}
